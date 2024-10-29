package openclose;

public class EnvioAereo implements IEnvio {

    @Override
    public double getCosto(Orden orden) {
        double costoNeto = orden.cantidad * orden.precio;
        double costoEnvio = orden.cantidad * orden.peso * 2.50;
        return Math.max(300, costoNeto + costoEnvio);
    }
}
