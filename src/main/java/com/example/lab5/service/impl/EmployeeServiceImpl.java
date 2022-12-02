package com.example.lab5.service.impl;

import com.example.lab5.model.Employee;
import com.example.lab5.repo.EmployeeRepo;
import com.example.lab5.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl() {
        this.employeeRepo = new EmployeeRepo();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepo.getEmployeeById(id);
    }

    @Override
    public boolean createEmployee(Employee employee) {
        return employeeRepo.createEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepo.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployeeById(String id) {
        return employeeRepo.deleteEmployeeById(id);
    }
}
