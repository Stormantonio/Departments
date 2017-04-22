package com.chernenko.controller.abstractFactory;

import com.chernenko.controller.MainController;
import com.chernenko.controller.factories.department.ActionDepartment;
import com.chernenko.controller.factories.employee.ActionEmployee;

/**
 * Created by Anton on 15.04.2017.
 */
public abstract class AbstractFactory {

    public abstract MainController getDepartmentController(ActionDepartment actionDepartment);

    public abstract MainController getEmployeeController(ActionEmployee actionEmployee);
}
