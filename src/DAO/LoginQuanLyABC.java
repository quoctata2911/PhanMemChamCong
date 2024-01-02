/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Class.QuanLy;
import connect.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author vuqua
 */
public class LoginQuanLyABC {
    public static boolean checkLogin(String username, String password) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM quanly WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Nếu có dữ liệu, đăng nhập thành công
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần
        }
        return false;
    }
}
