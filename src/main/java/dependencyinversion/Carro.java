package dependencyinversion;

public class Carro {
    private Motor motor;

    public Carro(Motor motor) {
        this.motor = motor;
    }

    public void arrancar() {

        motor.encender();
    }

    public void frenar() {
        motor.reposar();
    }

    public void apagar() {
        motor.apagar();
    }
}
