package openclose;

public class Orden {

    private IEnvio iEnvio;

    public double peso;
    public double precio;
    public int cantidad;
    public String nombre;


    public Orden(IEnvio envio, double peso, double precio, int cantidad, String nombre) {
        this.iEnvio = envio;
        this.peso = peso;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }


    public double calcularCostoTotal() {
        return iEnvio.getCosto(this);
    }


    @Override
    public String toString() {
        return "Orden{" +
                "envio=" + iEnvio.getClass().getSimpleName() +
                ", peso=" + peso +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
