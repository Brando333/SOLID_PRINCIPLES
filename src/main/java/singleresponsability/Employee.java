package singleresponsability;

import java.sql.*;

public class Employee {

    private String name;
    private String lastName;
    private int age;
    private double salary;


    public Employee() {
    }

    public Employee(String name, String lastName, int age, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void addEmployee() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741/defaultdb?user=avnadmin&password=AVNS_W-_wHM4NXXC31MfqtLG");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee (name, lastName, age, salary) values(?,?,?,?)");

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setDouble(4, salary);

            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteEmployee(int id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741/defaultdb?user=avnadmin&password=AVNS_W-_wHM4NXXC31MfqtLG");

            PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id = ?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void updateEmployeeName(int id, String newName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741/defaultdb?user=avnadmin&password=AVNS_W-_wHM4NXXC31MfqtLG");
            PreparedStatement preparedStatement = connection.prepareStatement("update employee set name = ? where id = ?");

            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void showEmployees() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741/defaultdb?user=avnadmin&password=AVNS_W-_wHM4NXXC31MfqtLG");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Employee employee = new Employee();

                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");

                employee.setName(name);
                employee.setLastName(lastName);
                employee.setAge(age);
                employee.setSalary(salary);

                System.out.println(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
               "name='" + name + '\'' +
               ", lastName='" + lastName + '\'' +
               ", age=" + age +
               ", salary=" + salary +
               '}';
    }
}
