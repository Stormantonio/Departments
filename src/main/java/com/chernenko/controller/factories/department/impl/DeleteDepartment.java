package com.chernenko.controller.factories.department.impl;

import com.chernenko.controller.MainController;
import com.chernenko.model.Department;
import com.chernenko.services.DepartmentService;
import com.chernenko.services.impl.DepartmentServiceImpl;

import java.sql.SQLException;

/**
 * Created by Anton on 08.04.2017.
 */
public class DeleteDepartment implements MainController {
    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void doAction() throws SQLException {
        departmentService.deleteDepartment(new Department());
    }
}
