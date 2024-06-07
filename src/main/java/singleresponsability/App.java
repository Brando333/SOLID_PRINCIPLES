package singleresponsability;

public class App {

    public static void main(String... brando) {

        Empleado emp = new Empleado();
        emp.setNombre("Salazar");
        emp.setApellido("Slitheryn");
        emp.setEdad(29);
        emp.setSalario(12000);

        emp.agregarEmpleado();

    }

}
