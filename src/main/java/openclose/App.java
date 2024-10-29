package openclose;

public class App {
    public static void main(String... brando) {
        IEnvio envio = new EnvioMaritimo();

        Orden orden = new Orden(envio, 0.08, 165, 1, "Micropocesador IntelCore i5");
        double costo = orden.calcularCostoTotal();
        System.out.println(orden);
        System.out.println(costo);
    }


}
