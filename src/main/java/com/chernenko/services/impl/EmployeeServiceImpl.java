package com.chernenko.services.impl;

import com.chernenko.dao.EmployeeDao;
import com.chernenko.dao.impl.EmployeeDaoImpl;
import com.chernenko.model.Employee;
import com.chernenko.services.EmployeeService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Anton on 09.04.2017.
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentName(String departmentName) throws SQLException {
        List<Employee> employees = employeeDao.getEmployeesByDepartmentName(departmentName);
        Collections.sort(employees, new Comparator<Employee>() {
            @Override // // TODO: 09.04.2017 доделать компаратор !!!
            public int compare(Employee o1, Employee o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        return employees;
    }

    @Override
    public void editEmployee(Employee employee) throws SQLException {
        employeeDao.editEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) throws SQLException {
        employeeDao.deleteEmployee(employee);
    }
}
