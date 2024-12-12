package tc.dec;

import java.util.*;

public class TablaSimbolos {

    private static TablaSimbolos instancia;
    private final Deque<Contexto> pilaContextos;

    private TablaSimbolos() {
        pilaContextos = new ArrayDeque<>();
        pilaContextos.push(new Contexto(null)); // Contexto global inicial
    }

    public static TablaSimbolos obtenerInstancia() {
        if (instancia == null) {
            instancia = new TablaSimbolos();
        }
        return instancia;
    }

    public void agregarSimbolo(Id simbolo, Contexto contexto) {
        contexto.agregarSimbolo(simbolo);
    }

    public boolean existeSimboloEnContextoActual(String nombre) {
        Contexto contextoActual = pilaContextos.peek();
        return contextoActual != null && contextoActual.existeSimbolo(nombre);
    }

    public boolean existeSimbolo(String nombre) {
        for (Contexto contexto : pilaContextos) {
            if (contexto.existeSimbolo(nombre)) {
                return true;
            }
        }
        return false;
    }

    public Variable buscarVariable(String nombre, Contexto contexto) {
        Id simbolo = contexto.buscarSimbolo(nombre);
        if (simbolo instanceof Variable) {
            return (Variable) simbolo;
        }
        return null;
    }

    public Funcion buscarFuncion(String nombre) {
        for (Contexto contexto : pilaContextos) {
            Id simbolo = contexto.buscarSimbolo(nombre);
            if (simbolo instanceof Funcion) {
                return (Funcion) simbolo;
            }
        }
        return null;
    }



    public void agregarFuncion(Funcion funcion) {
        agregarSimbolo(funcion, pilaContextos.peek());
    }

    public void agregarVariable(Variable variable, Contexto contexto) {
        contexto.agregarSimbolo(variable);
    }
    
    public void marcarComoUsado(String nombre, Contexto contexto) {
        Variable variable = buscarVariable(nombre, contexto);
        if (variable != null) {
            variable.marcarComoUsado();
        }
    }
    
    public void marcarComoInicializado(String nombre, Contexto contexto) {
        Variable variable = buscarVariable(nombre, contexto);
        if (variable != null) {
            variable.marcarComoInicializado();
        }
    }
    

    public void entrarNuevoContexto() {
        pilaContextos.push(new Contexto(pilaContextos.peek()));
    }

    public void salirDeContexto() {
        pilaContextos.pop();}
        /*Contexto contextoActual = pilaContextos.pop();
        contextoActual.imprimirSimbolos(); // Llamar al método de impresión aquí
        List<Id> variablesDeclaradas = contextoActual.obtenerVariablesDeclaradas();
        for (Id variable : variablesDeclaradas) {
            System.out.println("Variable declarada: " + variable.getNombre());
        }
    }
    
    
    

    public List<Variable> obtenerVariablesNoUsadas() {
        List<Variable> noUsadas = new ArrayList<>();
        for (Contexto contexto : pilaContextos) {
            noUsadas.addAll(contexto.obtenerVariablesNoUsadas());
        }
        return noUsadas;
    }*/
    
}
