package tc.dec;

import java.util.HashSet;
import java.util.Set;

//import java.util.List;

import tc.dec.compiladorParser.*;

public class Escucha extends compiladorBaseListener {

    private TablaSimbolos tablaSimbolos = new TablaSimbolos();

    @Override
    public void exitPrograma(ProgramaContext ctx) {
        Set<Id> allIdentificadores = new HashSet<>();
        for (Contexto contexto : tablaSimbolos.getContextos()) {
            allIdentificadores.addAll(contexto.getIdentificadores().values());
        }

        // Verificar si han sido utilizados
        for (Id id : allIdentificadores) {
            System.out.println("Tabla de simbolos: ");
            System.out.println("Nombre: " + id.getNombre() + ", Tipo: " + id.getTipo());
        }

        // Verificar si han sido utilizados
        for (Id id : allIdentificadores) {
            if (!id.isUsado()) {
                System.err.printf("Error semántico en línea %d:%d - La variable '%s' no fue utilizada.\n",
                        ctx.start.getLine(), ctx.start.getCharPositionInLine(), id.getNombre());
            }
        }
        
        tablaSimbolos.delContexto();
    }
    

    @Override
    public void enterBloque(BloqueContext ctx) {
        tablaSimbolos.addContexto();
    }

    @Override
    public void exitBloque(BloqueContext ctx) {
        tablaSimbolos.delContexto();
    }

    @Override
    public void exitParam(ParamContext ctx){
        String tipoDatoStr = ctx.tipo().getText();
        TipoDato td;
        try {
            td = TipoDato.valueOf(tipoDatoStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return;
        }

        Id id = new Id(ctx.ID().toString(), td);

        if(tablaSimbolos.buscarIdentificadorLocal(id) == null){
            tablaSimbolos.addIdentificador(id);
        } else {
            System.err.printf("Error semántico en línea %d:%d - La variable '%s' ya ha sido declarada en este contexto.\n",
                        ctx.start.getLine(), ctx.start.getCharPositionInLine(), id.getNombre());
        }
    }

    @Override
    public void exitDeclaracion(DeclaracionContext ctx) {
        String nombre = ctx.param().ID().toString();            
        TipoDato tipo = tablaSimbolos.buscarTipoIdentificador(nombre);

        if (tipo != null) {
            Id id = new Id(nombre, tipo);
            tablaSimbolos.identificadorInicializado(id);
        }
    }
    
    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        String nombre = ctx.ID().getText();
        TipoDato tipo = tablaSimbolos.buscarTipoIdentificador(nombre);
        if(tipo!=null){
            Id id = new Id(nombre, tipo);
            tablaSimbolos.identificadorUtilizado(id);
        }else{
            System.err.printf("Error de tipo en línea %d:%d - Asignación incompatible: '%s' es de tipo '%s', pero se intenta asignar un valor de tipo '%s'.\n",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine(), nombre, tipo);
        }

    }
}
