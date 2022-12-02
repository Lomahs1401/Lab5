package com.example.lab5.service.impl;

import com.example.lab5.model.Department;
import com.example.lab5.model.Employee;
import com.example.lab5.repo.DepartmentRepo;
import com.example.lab5.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImpl() {
        this.departmentRepo = new DepartmentRepo();
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepo.getDepartmentById(id);
    }

    @Override
    public String getDepartmentNameById(int id) {
        return departmentRepo.getDepartmentNameById(id);
    }

    @Override
    public boolean createDepartment(Department department) {
        return departmentRepo.createDepartment(department);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return departmentRepo.updateDepartment(department);
    }
}
