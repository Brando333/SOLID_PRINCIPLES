package dependencyinversion;

public class Car {
    private CombustionMotor combustionMotor;

    public Car() {
        this.combustionMotor = new CombustionMotor();
    }

    public void start() {
        combustionMotor.start();
    }

    public void brake() {
        combustionMotor.rest();
    }

    public void turnOff() {
        combustionMotor.turnOff();
    }
}
