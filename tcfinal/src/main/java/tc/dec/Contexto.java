package tc.dec;


import java.util.*;


class Contexto {
    private final Contexto padre;
    private final Map<String, Id> simbolos;

    public Contexto(Contexto padre) {
        this.padre = padre;
        this.simbolos = new HashMap<>();
    }

    public void agregarSimbolo(Id simbolo) {
        simbolos.put(simbolo.getNombre(), simbolo);
    }

    public boolean existeSimbolo(String nombre) {
        return simbolos.containsKey(nombre);
    }

    public Id buscarSimbolo(String nombre) {
        if (simbolos.containsKey(nombre)) {
            return simbolos.get(nombre);
        } else if (padre != null) {
            return padre.buscarSimbolo(nombre);
        }
        return null;
    }

    /*public List<Id> obtenerVariablesDeclaradas() {
        List<Id> variablesDeclaradas = new ArrayList<>();
        System.out.println("ESTOY");
        for (Map.Entry<String, Id> entry : simbolos.entrySet()) {
            Id simbolo = entry.getValue();
            if (simbolo instanceof Id variable) {
                variablesDeclaradas.add(variable);
            }
        }
        return variablesDeclaradas;
    }
    
    public void imprimirSimbolos() {
        System.out.println("Símbolos en el contexto:");
        for (Map.Entry<String, Id> entry : simbolos.entrySet()) {
            Id simbolo = entry.getValue();
            if (simbolo instanceof Variable variable) {
                System.out.println("Variable: " + variable.getNombre() + ", Tipo: " + variable.getTipo() + ", Usado: " + variable.isUsado());
            } else {
                System.out.println("Símbolo: " + simbolo.getNombre() + ", Tipo: " + simbolo.getClass().getSimpleName());
            }
        }
    }
    
    
    public List<Variable> obtenerVariablesNoUsadas() {
        List<Variable> noUsadas = new ArrayList<>();
        for (Id simbolo : simbolos.values()) {
            if (simbolo instanceof Variable variable) {
                if (!variable.isUsado()) {
                    noUsadas.add(variable);
                }
            }
        }
        return noUsadas;
    }*/

    public Contexto getPadre() {
        return padre;
    }
}