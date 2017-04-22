package com.chernenko.controller.factories.department;

import com.chernenko.controller.abstractFactory.AbstractFactory;
import com.chernenko.controller.factories.employee.ActionEmployee;
import com.chernenko.controller.MainController;
import com.chernenko.controller.factories.department.impl.CreateDepartment;
import com.chernenko.controller.factories.department.impl.DeleteDepartment;
import com.chernenko.controller.factories.department.impl.ListDepartments;
import com.chernenko.controller.mapController.Storage;
import com.chernenko.controller.mapController.impl.StorageImpl;

/**
 * Created by Anton on 16.04.2017.
 */
public class DepartmentFactory extends AbstractFactory {
    private static Storage storage = new StorageImpl();

    static {
//        final String CREATE_DEPARTMENT = "/createDepartment";
//        final String LIST_DEPARTMENTS = "/listDepartments";
//        final String DELETE_DEPARTMENT = "/deleteDepartment";

        final ActionDepartment CREATE_DEPARTMENT = ActionDepartment.createDepartment;
        final ActionDepartment LIST_DEPARTMENTS = ActionDepartment.listDepartments;
        final ActionDepartment DELETE_DEPARTMENT = ActionDepartment.deleteDepartment;

        storage.clear();
        storage.add(CREATE_DEPARTMENT, new CreateDepartment());
        storage.add(LIST_DEPARTMENTS, new ListDepartments());
        storage.add(DELETE_DEPARTMENT, new DeleteDepartment());
    }

    @Override
    public MainController getDepartmentController(ActionDepartment actionDepartment) {
        return storage.get(actionDepartment.toString());
    }

    @Override
    public MainController getEmployeeController(ActionEmployee actionEmployee) {
        return null;
    }
}
