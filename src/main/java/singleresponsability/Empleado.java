package singleresponsability;

import java.sql.*;

public class Empleado {

    private String nombre;
    private String apellido;
    private int edad;
    private double salario;


    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int edad, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
    }

    public void agregarEmpleado() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741/defaultdb?user=avnadmin&password=AVNS_W-_wHM4NXXC31MfqtLG");

            PreparedStatement query = conexion.prepareStatement("insert into employee (name, lastName, age, salary) values(?,?,?,?)");

            query.setString(1, nombre);
            query.setString(2, apellido);
            query.setInt(3, edad);
            query.setDouble(4, salario);

            query.executeUpdate();

            System.out.println("Se a añadido al empleado "+ nombre);
            conexion.close();
            query.close();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
    }

    public void eliminarEmpleado(int id) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741/defaultdb?user=avnadmin&password=AVNS_W-_wHM4NXXC31MfqtLG");

            PreparedStatement preparedStatement = conexion.prepareStatement("delete from employee where id = ?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


            conexion.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void actualizarEmpleado(int id, String newName) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741/defaultdb?user=avnadmin&password=AVNS_W-_wHM4NXXC31MfqtLG");
            PreparedStatement query = conexion.prepareStatement("update employee set name = ? where id = ?");

            query.setString(1, newName);
            query.setInt(2, id);
            query.executeUpdate();
            conexion.close();
            query.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void mostrarEmpleados() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741/defaultdb?user=avnadmin&password=AVNS_W-_wHM4NXXC31MfqtLG");
            PreparedStatement query = conexion.prepareStatement("select * from employee");
            ResultSet resultado = query.executeQuery();


            while (resultado.next()) {
                Empleado empleado = new Empleado();

                String name = resultado.getString("name");
                String lastName = resultado.getString("lastName");
                int age = resultado.getInt("age");
                double salary = resultado.getDouble("salary");

                empleado.setNombre(name);
                empleado.setApellido(lastName);
                empleado.setEdad(age);
                empleado.setSalario(salary);

                System.out.println(empleado);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


    @Override
    public String toString() {
        return "Empleado" +
               "nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", edad=" + edad +
               ", salario=" + salario +
               '}';
    }
}
