package com.chernenko.controller;

import com.chernenko.model.Department;
import com.chernenko.services.DepartmentService;
import com.chernenko.services.EmployeeService;
import com.chernenko.services.impl.DepartmentServiceImpl;
import com.chernenko.services.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

    private static final String METHOD_GET = "get";
    private static final String METHOD_POST = "post";

    private DepartmentService departmentService;
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        departmentService = new DepartmentServiceImpl();
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();

        switch (method) {
            case METHOD_GET:
                doGet(req, resp);
                break;
            case METHOD_POST:
                doPost(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Wrong method!");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertDepartment(req, resp);
                    break;
                case "/delete":
                    deleteDepartment(req, resp);
                    break;
                default:
                    listDepartment(req, resp);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void listDepartment(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        List<Department> departments = departmentService.listAllDepartments();
        request.setAttribute("departments", departments);
        RequestDispatcher rd = request.getRequestDispatcher("DepartmentList.jsp");
        rd.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("DepartmentForm.jsp");
        rd.forward(request, response);
    }

    private void insertDepartment(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException {
        String departmentName = request.getParameter("departmentName");

        Department department = new Department(departmentName);
        departmentService.insertDepartment(department);
        response.sendRedirect("list");
    }

    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException {
        String departmentName = request.getParameter("departmentName");

        Department department = new Department(departmentName);
        departmentService.deleteDepartment(department);
        response.sendRedirect("list");
    }
}
