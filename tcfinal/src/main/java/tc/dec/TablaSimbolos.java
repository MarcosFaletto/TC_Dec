package tc.dec;

import java.util.*;

public class TablaSimbolos {

    private List<Contexto> contextos;

    TablaSimbolos() {
        this.contextos = new ArrayList<>();
        this.contextos.add(new Contexto());
    }

    public void addContexto() {
        contextos.add(new Contexto());
    }

    public void delContexto() {
        if (contextos.size() > 1) {
            contextos.remove(contextos.size() - 1);
        }
    }

    public Id buscarIdentificador(Id id) {
        for (int i = contextos.size() - 1; i >= 0; i--) {
            Id identificador = contextos.get(i).buscarIdentificador(id);
            if (identificador != null) { 
                return identificador;
            }
        }
        return null;
    }

    public TipoDato buscarTipoIdentificador(String nombre) {
        Id id = new Id(nombre, null);
        
        for (int i = contextos.size() - 1; i >= 0; i--) {
            Id encontrado = contextos.get(i).buscarIdentificador(id);
            if (encontrado != null) {
                return encontrado.getTipo();
            }
        }
        
        return null;
    }

    
    public void identificadorInicializado(Id id) {
        for (int i = contextos.size() - 1; i >= 0; i--) {
            Id identificador = contextos.get(i).buscarIdentificador(id);
            if (identificador != null) {
                identificador.marcarComoInicializado();
                return;
            }
        }
    }

    public List<Contexto> getContextos() {
        return contextos;
    }
    

    public void identificadorUtilizado(Id id) {
        for (int i = contextos.size() - 1; i >= 0; i--) {
            Id identificador = contextos.get(i).buscarIdentificador(id);
            if (identificador != null) {
                identificador.marcarComoUsado();
                return;
            }
        }
    }


    public Id buscarIdentificadorLocal(Id id) {
        return contextos.get(contextos.size() - 1).buscarIdentificador(id);
    }

    public void addIdentificador(Id identificador) {
        contextos.get(contextos.size() - 1).agregarIdentificador(identificador);
    }
    
}
