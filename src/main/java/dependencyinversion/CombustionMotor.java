package dependencyinversion;

public class CombustionMotor {

    void encender() {
        //SOME IMPLEMENTATION HERE
        System.out.println(this.getClass().getSimpleName() + " se encendio");
    }

    void reposar() {
        //SOME IMPLEMENTATION HERE
        System.out.println(this.getClass().getSimpleName() + " esta en reposo");

    }

    void apagar() {
        //SOME IMPLEMENTATION HERE
        System.out.println(this.getClass().getSimpleName() + " esta apagado");


    }
}
