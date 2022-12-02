package com.example.lab5.repo;

import com.example.lab5.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepo {
    public static final String CHECK_ACCOUNT = "SELECT * FROM admin WHERE username = ? AND password = ?;";

    public boolean isExistAccount(String username, String password) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(CHECK_ACCOUNT);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();
        }
    }
}
