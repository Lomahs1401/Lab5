package com.example.lab5.repo;

import com.example.lab5.config.DBConnection;
import com.example.lab5.model.Department;
import com.example.lab5.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepo {
    public static final String GET_ALL_DEPARTMENTS = "SELECT * FROM department;";
    public static final String GET_DEPARTMENT_NAME_BY_ID = "SELECT name FROM department WHERE id = ?;";
    public static final String GET_DEPARTMENT_BY_ID = "SELECT * FROM department WHERE id = ?;";
    public static final String INSERT_NEW_DEPARTMENT = "INSERT INTO department(id, room, name) VALUES (?, ?, ?);";
    public static final String UPDATE_DEPARTMENT = "UPDATE department SET room = ?, name = ? WHERE id = ?;";

    public List<Department> getAllDepartments() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Department> departments = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_DEPARTMENTS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String room = resultSet.getString("room");
                String name = resultSet.getString("name");
                departments.add(new Department(id, room, name));
            }
            return departments;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                assert preparedStatement != null;
                assert resultSet != null;
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();
        }
    }

    public Department getDepartmentById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(GET_DEPARTMENT_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String room = resultSet.getString("room");
                String name = resultSet.getString("name");
                return new Department(id, room, name);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            assert resultSet != null;
            try {
                resultSet.close();
                preparedStatement.close();
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDepartmentNameById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(GET_DEPARTMENT_NAME_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            assert resultSet != null;
            try {
                resultSet.close();
                preparedStatement.close();
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean createDepartment(Department department) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_NEW_DEPARTMENT);
            preparedStatement.setInt(1, department.getId());
            preparedStatement.setString(2, department.getRoom());
            preparedStatement.setString(3, department.getName());
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

    public boolean updateDepartment(Department department) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT);
            preparedStatement.setString(1, department.getRoom());
            preparedStatement.setString(2, department.getName());
            preparedStatement.setInt(3, department.getId());
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
}
