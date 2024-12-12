package tc.dec;

import tc.dec.compiladorParser.*;
import java.util.*;

public class Caminante extends compiladorBaseVisitor<Void> {
    private final TablaSimbolos tablaSimbolos = TablaSimbolos.obtenerInstancia();
    private List<String> codigoTresDirecciones = new ArrayList<>();
    private int tempCount = 0;
    private Contexto contextoActual; // Definir contextoActual

    @Override
    public Void visitPrograma(ProgramaContext ctx) {
        contextoActual = new Contexto(null); // Contexto global
        tablaSimbolos.entrarNuevoContexto(); // Asegurarse de que el contexto esté en la pila
        visitChildren(ctx); // Visitar todos los nodos hijos
        tablaSimbolos.salirDeContexto(); // Salir del contexto después de procesar el programa
        return null;
    }

    @Override
    public Void visitDeclaracion(DeclaracionContext ctx) {
        String nombre = ctx.ID().getText();
        String tipo = ctx.tipo() != null ? ctx.tipo().getText() : null;

        if (tipo != null) {
            if (!tablaSimbolos.existeSimboloEnContextoActual(nombre)) {
                TipoDato tipoDato = TipoDato.valueOf(tipo.toUpperCase());
                Variable nuevaVariable = new Variable(nombre, tipoDato);
                tablaSimbolos.agregarVariable(nuevaVariable, contextoActual);

                if (ctx.expresion() != null) {
                    String valor = ctx.expresion().getText();
                    codigoTresDirecciones.add(nombre + " = " + valor);
                }
            }
        }
        return null;
    }

    @Override
    public Void visitAsignacion(AsignacionContext ctx) {
        String nombre = ctx.ID().getText();
        String valor = null;

        if (ctx.expresion() != null) {
            valor = ctx.expresion().getText();
        } else if (ctx.llamada_funcion() != null) {
            valor = ctx.llamada_funcion().getText();
        }

        if (valor != null) {
            String temporal = nuevoTemporal();
            codigoTresDirecciones.add(temporal + " = " + valor);
            codigoTresDirecciones.add(nombre + " = " + temporal);
        } else {
            // Manejar el caso donde no hay expresión ni llamada a función
            System.err.printf("Error semántico en línea %d:%d - Asignación a '%s' no tiene valor.\n",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine(), nombre);
        }

        return null;
    }

    @Override
    public Void visitBloque(BloqueContext ctx) {
        tablaSimbolos.entrarNuevoContexto();
        visitChildren(ctx); // Visitar todos los nodos hijos del bloque
        tablaSimbolos.salirDeContexto();
        return null;
    }

    public List<String> getCodigoTresDirecciones() {
        return codigoTresDirecciones;
    }

    private String nuevoTemporal() {
        tempCount++;
        return "t" + tempCount;
    }
}
