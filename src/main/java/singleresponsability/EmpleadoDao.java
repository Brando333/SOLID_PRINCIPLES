package singleresponsability;

import java.sql.*;

public class EmpleadoDao {

    private static Connection connection = DataConexion.getConnection();
    private Empleado empleado;

    public EmpleadoDao(Empleado empleado) {
        this.empleado = empleado;
    }

    public void agregarEmpleado() {
        try {
            PreparedStatement query = connection.prepareStatement("insert into employee (name, lastName, age, salary) values(?,?,?,?)");

            query.setString(1, empleado.getNombre());
            query.setString(2, empleado.getApellido());
            query.setInt(3, empleado.getEdad());
            query.setDouble(4, empleado.getSalario());

            query.executeUpdate();

            DataConexion.closeStatement(query);
            DataConexion.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public void eliminarEmpleado(int id) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741/defaultdb?user=avnadmin&password=AVNS_W-_wHM4NXXC31MfqtLG");
            PreparedStatement preparedStatement = conexion.prepareStatement("delete from employee where id = ?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            DataConexion.closeConnection(conexion);
            DataConexion.closeStatement(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }


    }

    public void actualizarEmpleado(int id, String newName) {
        try {

            PreparedStatement query = connection.prepareStatement("update employee set name = ? where id = ?");

            query.setString(1, newName);
            query.setInt(2, id);
            query.executeUpdate();

            DataConexion.closeConnection(connection);
            DataConexion.closeStatement(query);

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

    }

    public static void mostrarEmpleados() {
        try {

            PreparedStatement query = connection.prepareStatement("select * from employee");
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
            e.printStackTrace();
        }

    }
}
