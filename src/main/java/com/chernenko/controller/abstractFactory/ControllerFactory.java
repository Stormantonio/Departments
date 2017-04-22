package com.chernenko.controller.abstractFactory;

import com.chernenko.controller.factories.department.DepartmentFactory;
import com.chernenko.controller.factories.employee.EmployeeFactory;

/**
 * Created by Anton on 16.04.2017.
 */
public class ControllerFactory {
    public static AbstractFactory getFactory(TypeFactory typeFactory) {
        AbstractFactory factory = null;
        switch (typeFactory) {
            case DEPARTMENT:
                factory = new DepartmentFactory();
                break;
            case EMPLOYEE:
                factory = new EmployeeFactory();
                break;
        }
        return factory;
    }
}
