package tc.dec;

import java.util.*;

public class Funcion extends Id {
    private List<TipoDato> args;

    public Funcion(String nombre, TipoDato tipo) {
        super(nombre, tipo);
        this.args = new ArrayList<>();
    }

    // Añadir un argumento a la lista de parámetros
    public void addArgumento(TipoDato tipo) {
        args.add(tipo);
    }

    // Obtener la lista de argumentos
    public List<TipoDato> getArgs() {
        return args;
    }
}