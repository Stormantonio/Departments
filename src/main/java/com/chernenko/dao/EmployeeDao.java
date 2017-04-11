package com.chernenko.dao;

import com.chernenko.model.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anton on 02.04.2017.
 */
public interface EmployeeDao {
    boolean insertEmployee(Employee employee) throws SQLException;

    List<Employee> getEmployeesByDepartmentName(String departmentName) throws SQLException;

    boolean editEmployee(Employee employee) throws SQLException;

    boolean deleteEmployee(Employee employee) throws SQLException;

}
