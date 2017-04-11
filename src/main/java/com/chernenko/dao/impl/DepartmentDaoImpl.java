package com.chernenko.dao.impl;

import com.chernenko.util.ConnectData;
import com.chernenko.dao.DepartmentDao;
import com.chernenko.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 02.04.2017.
 */
public class DepartmentDaoImpl implements DepartmentDao {
    private ConnectData connectData = new ConnectData();
//    private String jdbcURL;
//    private String jdbcUsername;
//    private String jdbcPassword;
//    private Connection jdbcConnection;

//    public DepartmentDaoImpl() {
//    }

//    public DepartmentDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
//        this.jdbcURL = jdbcURL;
//        this.jdbcUsername = jdbcUsername;
//        this.jdbcPassword = jdbcPassword;
//    }

    /*protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }*/

    public boolean insertDepartment(Department department) throws SQLException {
        String sql = "INSERT INTO departments (department_name) VALUES (?)";
        connectData.connect();
//        connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
//        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.setString(1, department.getDepartmentName());

        boolean rowInserted = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
//        disconnect();
        return rowInserted;
    }

    public List<Department> listAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();

        String sql = "SELECT * FROM departments";
        connectData.connect();
//        connect();

        Statement statement = connectData.getJdbcConnection().createStatement();
//        Statement statement = jdbcConnection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            String departmentName = rs.getString("department_name");
            Department department = new Department();
            department.setDepartmentName(departmentName);
//            Department department = new Department(departmentName);
            departments.add(department);
        }

        rs.close();
        statement.close();
        connectData.disconnect();
//        disconnect();
        return departments;
    }

    public boolean deleteDepartment(Department department) throws SQLException {
        String sql = "DELETE FROM departments WHERE department_name = ?";
        connectData.connect();
//        connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
//        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.setString(1, department.getDepartmentName());

        boolean rowDeleted = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
//        disconnect();
        return rowDeleted;
    }
}
