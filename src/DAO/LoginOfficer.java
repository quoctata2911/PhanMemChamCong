/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.Officer;
import connect.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vuqua
 */
public class LoginOfficer {
    public boolean isNhanVienExists(String maNhanVien) {
    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT COUNT(*) AS count FROM Officer WHERE manhanvien = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maNhanVien);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0; 
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false; // Trong trường hợp xảy ra lỗi, trả về false để không đưa ra kết luận sai lầm
}
    
    public void register(Officer officer) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "INSERT INTO Officer (manhanvien, tennhanvien, donvi, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, officer.getMaNhanVien());
                preparedStatement.setString(2, officer.getTenNhanVien());
                preparedStatement.setString(3, officer.getDonVi());
                preparedStatement.setString(4, officer.getPassWord());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần
        }
    }
}
