package openclose;

public class EnvioTerrestre implements IEnvio {

    @Override
    public double getCosto(Orden orden) {

        double costoNeto = orden.cantidad * orden.precio;
        if (orden.cantidad >= 100) {
            return costoNeto;
        }
        double costoEnvio = orden.cantidad * orden.peso * 1.50;
        return Math.max(170, costoNeto + costoEnvio);

    }
}