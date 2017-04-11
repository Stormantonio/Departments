package com.chernenko.services;

import com.chernenko.model.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anton on 09.04.2017.
 */
public interface EmployeeService {
    void insertEmployee(Employee employee) throws SQLException;

    List<Employee> getEmployeesByDepartmentName(String departmentName) throws SQLException;

    void editEmployee(Employee employee) throws SQLException;

    void deleteEmployee(Employee employee) throws SQLException;
}
