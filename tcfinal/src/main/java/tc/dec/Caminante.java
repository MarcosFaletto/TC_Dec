package tc.dec;

import tc.dec.compiladorParser.*;
import java.util.*;

public class Caminante extends compiladorBaseVisitor<Void> {
    private TablaSimbolos tablaSimbolos = new TablaSimbolos();
    private List<String> codigoTresDirecciones = new ArrayList<>();
    private int tempCount = 0;

    @Override
    public Void visitPrograma(ProgramaContext ctx) {
        tablaSimbolos.addContexto(); // Asegurarse de que el contexto esté en la pila
        visitChildren(ctx); // Visitar todos los nodos hijos
        tablaSimbolos.delContexto(); // Salir del contexto después de procesar el programa
        return null;
    }
    /* */
    @Override
    public Void visitDeclaracion(DeclaracionContext ctx) {
        String nombre = ctx.param().ID().toString();            
        TipoDato tipo = tablaSimbolos.buscarTipoIdentificador(nombre);

        if (tipo != null) {
            Id id = new Id(nombre, tipo);
            if (tablaSimbolos.buscarIdentificadorLocal(id)!=null) {
                tablaSimbolos.addIdentificador(id);
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
        tablaSimbolos.addContexto();
        visitChildren(ctx); // Visitar todos los nodos hijos del bloque
        tablaSimbolos.delContexto();
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
