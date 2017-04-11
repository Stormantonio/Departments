package com.chernenko.controller.employeeControllerImpl;

import com.chernenko.controller.MainController;
import com.chernenko.model.Employee;
import com.chernenko.services.EmployeeService;
import com.chernenko.services.impl.EmployeeServiceImpl;

import java.sql.SQLException;

/**
 * Created by Anton on 09.04.2017.
 */
public class EditEmployee implements MainController {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void doAction() throws SQLException {
        employeeService.editEmployee(new Employee());
    }
}
