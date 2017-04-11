package com.chernenko.dao.impl;

import com.chernenko.util.ConnectData;
import com.chernenko.dao.EmployeeDao;
import com.chernenko.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 02.04.2017.
 */
public class EmployeeDaoImpl implements EmployeeDao {
//    private String jdbcURL;
//    private String jdbcUsername;
//    private String jdbcPassword;
//    private Connection jdbcConnection;
//
//    public EmployeeDaoImpl() {
//    }
//
//    public EmployeeDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
//        this.jdbcURL = jdbcURL;
//        this.jdbcUsername = jdbcUsername;
//        this.jdbcPassword = jdbcPassword;
//    }
//
//    protected void connect() throws SQLException {
//        if (jdbcConnection == null || jdbcConnection.isClosed()) {
//            try {
//                Class.forName("org.postgresql.Driver");
//            } catch (ClassNotFoundException e) {
//                throw new SQLException(e);
//            }
//            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        }
//    }
//
//    protected void disconnect() throws SQLException {
//        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
//            jdbcConnection.close();
//        }
//    }

    private ConnectData connectData = new ConnectData();

    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {

        String sql = "INSERT INTO employees (name, surname, birth_date, salary, email, department) VALUES (?,?,?,?,?,?)";
        connectData.connect();
//        connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
//        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getSurname());
        ps.setDate(3, Date.valueOf(employee.getBirthDate()));
//        ps.setDate(3, (Date) employee.getBirthDate());
        ps.setDouble(4, employee.getSalary());
        ps.setString(5, employee.getEmail());
        ps.setString(6, employee.getDepartment().getDepartmentName());

        boolean rowInserted = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
//        disconnect();
        return rowInserted;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentName(String departmentName) throws SQLException {

        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE department=?";
        connectData.connect();
//        connect();
        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
//        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.setString(1, departmentName);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            Date birthDate = rs.getDate("birth_date");
            Double salary = rs.getDouble("salary");
            String email = rs.getString("email");
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSurname(surname);
            employee.setBirthDate(birthDate.toLocalDate());
            employee.setSalary(salary);
            employee.setEmail(email);
//            Employee employee = new Employee(name, surname, birthDate.toLocalDate(), salary, email);
            employees.add(employee);
        }
        rs.close();
        ps.close();
        connectData.disconnect();
//        disconnect();
        return employees;
    }

    @Override
    public boolean editEmployee(Employee employee) throws SQLException {

        String sql = "UPDATE employees SET name=?,surname=?,birth_date=?,salary=?,department=? WHERE email=?;";
        connectData.connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getSurname());
        ps.setDate(3, Date.valueOf(employee.getBirthDate()));
        ps.setDouble(4, employee.getSalary());
        ps.setString(5, employee.getDepartment().getDepartmentName());
        ps.setString(6, employee.getEmail());
        boolean rowEdited = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
        return rowEdited;
    }

    @Override
    public boolean deleteEmployee(Employee employee) throws SQLException {

        String sql = "DELETE FROM employees WHERE email=?";
        connectData.connect();
//        connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
//        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.setString(1, employee.getEmail());

        boolean rowDeleted = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
//        disconnect();
        return rowDeleted;
    }
}
