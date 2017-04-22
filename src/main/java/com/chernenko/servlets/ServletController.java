package com.chernenko.servlets;

import com.chernenko.controller.MainController;
import com.chernenko.controller.abstractFactory.AbstractFactory;
import com.chernenko.controller.abstractFactory.ControllerFactory;
import com.chernenko.controller.abstractFactory.TypeFactory;
import com.chernenko.controller.factories.department.ActionDepartment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anton on 09.04.2017.
 */
public class ServletController extends HttpServlet {
    private static final String ACTION = "action";
    private static final String CREATE_DEPARTMENT = "createDepartment";
    private static final String DELETE_DEPARTMENT = "deleteDepartment";
    private static final String LIST_DEPARTMENTS = "listDepartments";
    private static final String CREATE_EMPLOYEE = "createEmployee";
    private static final String DELETE_EMPLOYEE = "deleteEmployee";
    private static final String EDIT_EMPLOYEE = "editEmployee";
    private static final String GET_EMPLOYEES = "getEmployees";

//    private static final String METHOD_GET = "get";
//    private static final String METHOD_POST = "post";

//    private DepartmentService departmentService;
//    private EmployeeService employeeService;

//    @Override
//    public void init() throws ServletException {
//        departmentService = new DepartmentServiceImpl();
//        employeeService = new EmployeeServiceImpl();
//    }

    private AbstractFactory departmentFactory;
    private AbstractFactory employeeFactory;

    private MainController createDepartment;
    private MainController listDepartments;
    private MainController deleteDepartment;

    private MainController createEmployee;
    private MainController editEmployee;
    private MainController listEmployees;
    private MainController deleteEmployee;

    @Override
    public void init() throws ServletException {
        departmentFactory = ControllerFactory.getFactory(TypeFactory.DEPARTMENT);
        employeeFactory = ControllerFactory.getFactory(TypeFactory.EMPLOYEE);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
//        RequestDispatcher rd1 = req.getRequestDispatcher("index.jsp");
//        rd1.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("DepartmentForm.jsp");
        rd.forward(request, response);
    }

    private void listDep(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        listDepartments = departmentFactory.getDepartmentController(ActionDepartment.listDepartments);
        listDepartments.doAction();
        request.setAttribute("departments", listDepartments);
        RequestDispatcher rd = request.getRequestDispatcher("DepartmentList.jsp");
        rd.forward(request, response);
    }

    private void createDep(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException {
        String departmentName = request.getParameter("departmentName");

//        Department department = new Department(departmentName);
        createDepartment = departmentFactory.getDepartmentController(ActionDepartment.createDepartment);
        createDepartment.doAction();
//        departmentService.insertDepartment(department);
        response.sendRedirect("list");
    }

    private void deleteDep(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException {
        String departmentName = request.getParameter("departmentName");

        deleteDepartment = departmentFactory.getDepartmentController(ActionDepartment.deleteDepartment);
        deleteDepartment.doAction();
        response.sendRedirect("list");
    }
}
