package openclose;

public class Orden {

    public Envio envio;
    public double peso;
    public double precio;
    public int cantidad;
    public String nombre;


    public Orden(Envio envio, double peso, double precio, int cantidad, String nombre) {
        this.envio = envio;
        this.peso = peso;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }


    public double calcularCostoTotal() {
        switch (envio) {
            case TERRESTRE -> {
                double costoNeto = cantidad * precio;
                if (cantidad >= 100) {
                    return costoNeto;
                }
                double costoEnvio = cantidad * peso * 1.50;
                return Math.max(170, costoNeto + costoEnvio);
            }
            case MARITIMO -> {
                double costoNeto = cantidad * precio;
                double costoEnvio = cantidad * peso * 2.30;
                return Math.max(250, costoNeto + costoEnvio);
            }
            case AEREO -> {
                double costoNeto = cantidad * precio;
                double costoEnvio = cantidad * peso * 2.50;
                return Math.max(300, costoNeto + costoEnvio);
            }
            default -> throw new RuntimeException("Tipo de envio invalido");
        }
    }


    @Override
    public String toString() {
        return "Orden{" +
               "envio=" + envio +
               ", peso=" + peso +
               ", precio=" + precio +
               ", cantidad=" + cantidad +
               ", nombre='" + nombre + '\'' +
               '}';
    }
}
