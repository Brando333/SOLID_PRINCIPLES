package singleresponsability;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        } catch (SQLException e) {
            e.printStackTrace();
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


}
