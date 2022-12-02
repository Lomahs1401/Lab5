package com.example.lab5.service;

import com.example.lab5.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    boolean createEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployeeById(String id);
}
