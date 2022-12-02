package com.example.lab5.service;

import com.example.lab5.model.Department;
import com.example.lab5.model.Employee;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
    String getDepartmentNameById(int id);
    boolean createDepartment(Department department);
    boolean updateDepartment(Department department);
}
