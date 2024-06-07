package openclose;

public class App {
    public static void main(String... brando) {
        Orden orden = new Orden(Envio.TERRESTRE, 0.08, 165, 1, "Micropocesador IntelCore i5");
        double costo = orden.calcularCostoTotal();
        System.out.println(costo);




    }


}
