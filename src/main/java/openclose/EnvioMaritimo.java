package openclose;

public class EnvioMaritimo implements IEnvio {


    @Override
    public double getCosto(Orden orden) {

        double costoNeto = orden.cantidad * orden.precio;
        double costoEnvio = orden.cantidad * orden.peso * 2.30;
        return Math.max(250, costoNeto + costoEnvio);

    }
}
