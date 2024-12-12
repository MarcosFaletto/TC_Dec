package tc.dec;

public class Id {
    protected String nombre;
    protected TipoDato tipo;
    protected boolean inicializado;
    protected boolean usado;

    public Id(String nombre, TipoDato tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.inicializado = false;
        this.usado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDato getTipo() {
        return tipo;
    }

    public boolean isInicializado() {
        return inicializado;
    }

    public void marcarComoInicializado() {
        this.inicializado = true;
    }

    public boolean isUsado() {
        return usado;
    }

    public void marcarComoUsado() {
        this.usado = true;
    }
}