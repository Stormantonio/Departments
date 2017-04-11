package com.chernenko.controller.departmentControllerImpl;

import com.chernenko.controller.MainController;
import com.chernenko.services.DepartmentService;
import com.chernenko.services.impl.DepartmentServiceImpl;

import java.sql.SQLException;

/**
 * Created by Anton on 08.04.2017.
 */
public class ListDepartments implements MainController {
    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void doAction() throws SQLException {
        departmentService.listAllDepartments();
    }
}
