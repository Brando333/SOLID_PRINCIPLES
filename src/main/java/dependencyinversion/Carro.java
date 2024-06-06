package dependencyinversion;

public class Carro {
    private CombustionMotor motorDeCombustion;

    public Carro() {
        this.motorDeCombustion = new CombustionMotor();
    }

    public void arrancar() {
        motorDeCombustion.encender();
    }

    public void frenar() {
        motorDeCombustion.reposar();
    }

    public void apagar() {
        motorDeCombustion.apagar();
    }
}
