package openclose;

public class Orden {

    public Envio envio;
    public double peso;
    public double precio;
    public int cantidad;


    public Orden(Envio envio, double peso, double precio, int cantidad) {
        this.envio = envio;
        this.peso = peso;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public double calcularCosto() {
        switch (envio) {
            case TERRESTRE -> {
                if (cantidad >= 100) {
                    return cantidad * precio;
                }
                return Math.max(100, cantidad * precio + (cantidad * peso * 1.50));
            }
            case MARITIMO -> {
                return Math.max(250, cantidad * precio + (cantidad * peso * 2.30));
            }
            case AEREO -> {
                return Math.max(300, cantidad * precio + (cantidad * peso * 3.00));
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
               '}';
    }
}
