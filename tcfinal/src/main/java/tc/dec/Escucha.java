package tc.dec;

//import java.util.List;

import tc.dec.compiladorParser.*;

public class Escucha extends compiladorBaseListener {

    private final TablaSimbolos tablaSimbolos = TablaSimbolos.obtenerInstancia();
    private Contexto contextoActual;

    @Override
    public void enterPrograma(ProgramaContext ctx) {
        contextoActual = new Contexto(null); // Contexto global
    }

    @Override
    public void exitPrograma(ProgramaContext ctx) {
        /*List<Variable> variablesNoUsadas = tablaSimbolos.obtenerVariablesNoUsadas();
        System.out.println("Variables no usadas encontradas:");
        for (Variable variable : variablesNoUsadas) {
            System.out.println("Variable no usada: " + variable.getNombre());
            System.out.printf("Advertencia en línea %d: La variable '%s' fue declarada pero no usada.\n",
                    ctx.start.getLine(), variable.getNombre());
        }*/
    }
    

    @Override
    public void enterBloque(BloqueContext ctx) {
        tablaSimbolos.entrarNuevoContexto();
    }
    
    @Override
    public void exitBloque(BloqueContext ctx) {
        tablaSimbolos.salirDeContexto();
    }
    
    

    @Override
    public void exitDefinicion_funcion(Definicion_funcionContext ctx) {
        String nombreFuncion = ctx.ID().getText();
        TipoDato tipoRetorno = TipoDato.valueOf(ctx.tipo().getText().toUpperCase());

        if (tablaSimbolos.buscarFuncion(nombreFuncion) != null) {
            System.err.printf("Error semántico en línea %d: La función '%s' ya ha sido declarada.\n",
                    ctx.start.getLine(), nombreFuncion);
        } else {
            Funcion nuevaFuncion = new Funcion(nombreFuncion, tipoRetorno);
            tablaSimbolos.agregarFuncion(nuevaFuncion);
            contextoActual = new Contexto(contextoActual); // Crear un nuevo contexto para el cuerpo de la función

            if (ctx.parametros() != null) {
                for (ParametroContext parametro : ctx.parametros().parametro()) {
                    String nombreParametro = parametro.ID().getText();
                    TipoDato tipoParametro = TipoDato.valueOf(parametro.tipo().getText().toUpperCase());
                    Variable variableParametro = new Variable(nombreParametro, tipoParametro);
                    tablaSimbolos.agregarVariable(variableParametro, contextoActual);
                }
            }
        }

        contextoActual = contextoActual.getPadre(); // Salir del contexto de la función
    }

    @Override
    public void exitDeclaracion(DeclaracionContext ctx) {
        String nombre = ctx.ID().getText();
        String tipo = ctx.tipo() != null ? ctx.tipo().getText() : null;
    
        if (tipo != null) {
            if (tablaSimbolos.existeSimboloEnContextoActual(nombre)) {
                System.err.printf("Error semántico en línea %d:%d - La variable '%s' ya ha sido declarada en este contexto.\n",
                        ctx.start.getLine(), ctx.start.getCharPositionInLine(), nombre);
            } else {
                TipoDato tipoDato = TipoDato.valueOf(tipo.toUpperCase());
                Variable nuevaVariable = new Variable(nombre, tipoDato);
                tablaSimbolos.agregarVariable(nuevaVariable, contextoActual);
    
                if (ctx.expresion() != null) {
                    tablaSimbolos.marcarComoUsado(nombre, contextoActual);
                }
            }
        }
    }
    
    
    
    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        String nombre = ctx.ID().getText();
        TipoDato tipoValor = TipoDato.VOID;
    
        if (ctx.expresion() != null) {
            tipoValor = obtenerTipoDeExpresion(ctx.expresion().getText());
        } else if (ctx.llamada_funcion() != null) {
            tipoValor = obtenerTipoDeLlamadaFuncion(ctx.llamada_funcion());
        }
    
        Variable variable = tablaSimbolos.buscarVariable(nombre, contextoActual);
        if (variable == null) {
            System.err.printf("Error semántico en línea %d:%d - Identificador '%s' no declarado.\n",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine(), nombre);
        } else {
            tablaSimbolos.marcarComoUsado(nombre, contextoActual);
            tablaSimbolos.marcarComoInicializado(nombre, contextoActual);
    
            if (tipoValor == TipoDato.VOID) {
                System.err.printf("Error de tipo en línea %d:%d - Asignación incompatible: '%s' es de tipo '%s', pero se intenta asignar un valor de tipo 'VOID'.\n",
                        ctx.start.getLine(), ctx.start.getCharPositionInLine(), nombre, variable.getTipo());
            } else if (variable.getTipo() != tipoValor) {
                System.err.printf("Error de tipo en línea %d:%d - Asignación incompatible: '%s' es de tipo '%s', pero se intenta asignar un valor de tipo '%s'.\n",
                        ctx.start.getLine(), ctx.start.getCharPositionInLine(), nombre, variable.getTipo(), tipoValor);
            }
        }
    }
    
    public TipoDato obtenerTipoDeLlamadaFuncion(Llamada_funcionContext ctx) {
        Funcion funcion = tablaSimbolos.buscarFuncion(ctx.ID().getText());
        if (funcion != null) {
            return funcion.getTipo();
        }
        return TipoDato.VOID;
    }
    


    public TipoDato obtenerTipoDeExpresion(String valor) {
        if (valor.matches("-?\\d+")) {
            return TipoDato.INT;
        } else if (valor.matches("-?\\d+\\.\\d*")) {
            return TipoDato.FLOAT;
        } else if (valor.matches("-?\\d*\\.\\d+")) {
            return TipoDato.DOUBLE;
        } else if (valor.matches("'(.)'")) {
            return TipoDato.CHAR;
        } else if (valor.matches("\".*\"")) {
            return TipoDato.STRING;
        } else if (valor.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            Variable variable = tablaSimbolos.buscarVariable(valor, contextoActual);
            if (variable != null) {
                return variable.getTipo();
            } else {
                Funcion funcion = tablaSimbolos.buscarFuncion(valor);
                if (funcion != null) {
                    return funcion.getTipo();
                }
            }
        }
        return TipoDato.VOID; // Asumimos que variables no declaradas son de tipo VOID para simplificar
    }
}
