package com.chernenko.services;

import com.chernenko.model.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anton on 09.04.2017.
 */
public interface DepartmentService {
    void insertDepartment(Department department) throws SQLException;

    List<Department> listAllDepartments() throws SQLException;

    void deleteDepartment(Department department) throws SQLException;
}
