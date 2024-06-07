package dependencyinversion;

public class HidraulicMotor implements Motor {

    @Override
    public void encender() {
        System.out.println(this.getClass().getSimpleName() + " se encendio");
    }

    @Override
    public void reposar() {
        System.out.println(this.getClass().getSimpleName() + " esta en reposo");
    }

    @Override
    public void apagar() {
        System.out.println(this.getClass().getSimpleName() + " se apago");
    }

}
