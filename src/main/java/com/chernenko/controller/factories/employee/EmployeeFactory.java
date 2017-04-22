package com.chernenko.controller.factories.employee;

import com.chernenko.controller.abstractFactory.AbstractFactory;
import com.chernenko.controller.MainController;
import com.chernenko.controller.factories.department.ActionDepartment;
import com.chernenko.controller.factories.employee.impl.CreateEmployee;
import com.chernenko.controller.factories.employee.impl.DeleteEmployee;
import com.chernenko.controller.factories.employee.impl.EditEmployee;
import com.chernenko.controller.factories.employee.impl.GetEmployeeByDepartmentName;
import com.chernenko.controller.mapController.Storage;
import com.chernenko.controller.mapController.impl.StorageImpl;

/**
 * Created by Anton on 16.04.2017.
 */
public class EmployeeFactory extends AbstractFactory {
    private static Storage storage = new StorageImpl();

    static {
//        final String CREATE_EMPLOYEE = "/createEmployee";
//        final String EDIT_EMPLOYEE = "/editEmployee";
//        final String LIST_EMPLOYEES = "/listEmployees";
//        final String DELETE_EMPLOYEE = "/deleteEmployee";

        final ActionEmployee CREATE_EMPLOYEE = ActionEmployee.createEmployee;
        final ActionEmployee EDIT_EMPLOYEE = ActionEmployee.editEmployee;
        final ActionEmployee LIST_EMPLOYEES = ActionEmployee.listEmployees;
        final ActionEmployee DELETE_EMPLOYEE = ActionEmployee.deleteEmployee;

        storage.clear();
        storage.add(CREATE_EMPLOYEE, new CreateEmployee());
        storage.add(EDIT_EMPLOYEE, new EditEmployee());
        storage.add(LIST_EMPLOYEES, new GetEmployeeByDepartmentName());
        storage.add(DELETE_EMPLOYEE, new DeleteEmployee());
    }


    @Override
    public MainController getDepartmentController(ActionDepartment actionDepartment) {
        return null;
    }

    @Override
    public MainController getEmployeeController(ActionEmployee actionEmployee) {
        return storage.get(actionEmployee.toString());
    }
}