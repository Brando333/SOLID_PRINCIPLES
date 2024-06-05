package dependencyinversion;

public class App {
    public static void main(String... brando) {

        Car car = new Car();
        car.start();
        car.brake();
        car.turnOff();
    }

}
