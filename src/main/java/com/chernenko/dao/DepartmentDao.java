package com.chernenko.dao;

import com.chernenko.model.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anton on 02.04.2017.
 */
public interface DepartmentDao {
    boolean insertDepartment(Department department) throws SQLException;

    List<Department> listAllDepartments() throws SQLException;

    boolean deleteDepartment(Department department) throws SQLException;

}
