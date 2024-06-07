package dependencyinversion;

public class App {
    public static void main(String... brando) {

        Motor motorHidraulico = new HidraulicMotor();

        Carro car = new Carro(motorHidraulico);
        car.arrancar();
        car.frenar();
        car.apagar();


    }

}
