/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connect.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Class.*;

/**
 *
 * @author vuqua
 */
public class LoginWorkerDAO {
    public static boolean checkLogin(String username, String password) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM Worker WHERE macongnhan = ? AND password = ?";
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
    public static Worker getInfoWorker(String manhanvien) {
        Worker khachHang = null;
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM Worker WHERE macongnhan = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, manhanvien);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        khachHang = new Worker();
                        khachHang.setMaCongNhan(resultSet.getString("macongnhan"));
                        khachHang.setTenCongNhan(resultSet.getString("tencongnhan"));
                        khachHang.setPassWord(resultSet.getString("password"));
                        khachHang.setDonVi(resultSet.getString("donvi"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần
        }
        return khachHang;
    }
}
