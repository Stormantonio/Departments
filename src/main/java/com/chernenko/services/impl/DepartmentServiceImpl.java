package com.chernenko.services.impl;

import com.chernenko.dao.DepartmentDao;
import com.chernenko.dao.impl.DepartmentDaoImpl;
import com.chernenko.model.Department;
import com.chernenko.services.DepartmentService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anton on 09.04.2017.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public void insertDepartment(Department department) throws SQLException {
        departmentDao.insertDepartment(department);
    }

    @Override
    public List<Department> listAllDepartments() throws SQLException {
        List<Department> departments = departmentDao.listAllDepartments();
        Collections.sort(departments, (o1, o2) -> o1.getDepartmentName().compareTo(o2.getDepartmentName()));
        return departments;
    }

    @Override
    public void deleteDepartment(Department department) throws SQLException {
        departmentDao.deleteDepartment(department);
    }
}
