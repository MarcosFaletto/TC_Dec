package tc.dec;


import java.util.*;


class Contexto {
    private Map<String, Id> identificadores;

    public Contexto() {
        this.identificadores = new HashMap<>();
    }

    public void agregarIdentificador(Id simbolo) {
        identificadores.put(simbolo.getNombre(), simbolo);
        System.out.println("AGREGUE: " + simbolo.getNombre());
    }

    public Id buscarIdentificador(Id id) {
        for (Id identificador : identificadores.values()) {
            if (identificador.getNombre().equals(id.getNombre())) {
                // Si el tipo es null, lo comparamos con el tipo del identificador, ya que es un tipo opcional
                if (id.getTipo() == null || identificador.getTipo().equals(id.getTipo())) {
                    return identificador;
                }
            }
        }
        return null;
    }

    public Map<String, Id> getIdentificadores() {
        return identificadores;
    }

}