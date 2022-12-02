package com.example.lab5.repo;

import com.example.lab5.config.DBConnection;
import com.example.lab5.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    public static final String GET_ALL_EMPLOYEES = "SELECT * FROM employee;";
    public static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?;";
    public static final String INSERT_NEW_EMPLOYEE = "INSERT INTO employee(id, name, email, phone, address, departmentId, image) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_EMPLOYEE = "UPDATE employee SET name = ?, email = ?, phone = ?, " +
            "address = ?, departmentId = ?, image = ? WHERE id = ?;";
    public static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employee WHERE id = ?;";

    public List<Employee> getAllEmployees() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employees = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_EMPLOYEES);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int departmentId = resultSet.getInt("departmentId");
                String image = resultSet.getString("image");
                employees.add(new Employee(id, name, email, phone, address, departmentId, image));
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
                preparedStatement.close();
                DBConnection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public Employee getEmployeeById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(GET_EMPLOYEE_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int departmentId = resultSet.getInt("departmentId");
                String image = resultSet.getString("image");
                employee = new Employee(id, name, email, phone, address, departmentId, image);
            }
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
                preparedStatement.close();
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean createEmployee(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_NEW_EMPLOYEE);
            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setInt(6, employee.getDepartmentId());
            preparedStatement.setString(7, employee.getImage());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean updateEmployee(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setInt(5, employee.getDepartmentId());
            preparedStatement.setString(6, employee.getImage());
            preparedStatement.setString(7, employee.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean deleteEmployeeById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        boolean rowDeleted;
        try {
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
            preparedStatement.setString(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
            return rowDeleted;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();
        }
    }
}
