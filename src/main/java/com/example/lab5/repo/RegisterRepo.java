package com.example.lab5.repo;

import com.example.lab5.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterRepo {
    public static final String CREATE_NEW_ACCOUNT = "INSERT INTO admin(username, password) VALUES (?, ?);";

    public boolean createNewAccount(String username, String password) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(CREATE_NEW_ACCOUNT);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            return preparedStatement.executeUpdate() == 1;
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
