/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.Worker;
import connect.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuqua
 */
public class WorkerDAOCa3 {
         public List<Worker> getAllWorkers(String idCongNhan) {
    List<Worker> workers = new ArrayList<>();

    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT * FROM Worker WHERE idca = 3 AND macongnhan = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idCongNhan);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Worker worker = new Worker();
                    worker.setMaCongNhan(resultSet.getString("macongnhan"));
                    worker.setTenCongNhan(resultSet.getString("tencongnhan"));
                    worker.setDonVi(resultSet.getString("donvi"));
                    worker.setNgayLam(resultSet.getDate("ngaylam"));
                    worker.setCheckIn(resultSet.getTime("checkin"));
                    worker.setCheckOut(resultSet.getTime("checkout"));
                    worker.setThoiGianLam(resultSet.getTime("thoigianlam"));
                    worker.setIdCa(resultSet.getInt("idca"));
                    worker.setPassWord(resultSet.getString("password"));
                    workers.add(worker);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return workers;
}

     public void insertWorker(Worker worker) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "INSERT INTO Worker (macongnhan, tencongnhan, donvi, ngaylam, checkin, idca, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, worker.getMaCongNhan());
                preparedStatement.setString(2, worker.getTenCongNhan());
                preparedStatement.setString(3, worker.getDonVi());
                preparedStatement.setDate(4, worker.getNgayLam());
                preparedStatement.setTime(5, worker.getCheckIn());
                preparedStatement.setInt(6, worker.getIdCa());
                preparedStatement.setString(7, worker.getPassWord());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần
        }
    }
        public void updateWorkerByDate(Worker worker) {
    try (Connection connection = DatabaseConnection.connect()) {
        String query = "UPDATE Worker SET checkout = ?, thoigianlam = ? WHERE ngaylam = ? AND macongnhan = ? AND idca = 3";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTime(1, worker.getCheckOut());
            preparedStatement.setTime(2, worker.getThoiGianLam());
            java.util.Date currentDate = new java.util.Date();
            preparedStatement.setDate(3, new Date(currentDate.getTime())); // Ngày hiện tại
            preparedStatement.setString(4, worker.getMaCongNhan()); // idcongnhan
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Xử lý lỗi nếu cần
    }
}

         public Worker getWorkerByCurrentDate(String idCongNhan) {
        try (Connection connection = DatabaseConnection.connect()) {
            java.util.Date currentDate = new java.util.Date();
            Date ngayLam = new Date(currentDate.getTime());

            String query = "SELECT * FROM Worker WHERE ngaylam = ? AND macongnhan = ? AND idca = 3";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDate(1, ngayLam);
                preparedStatement.setString(2, idCongNhan);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Worker worker = new Worker();
                        worker.setMaCongNhan(resultSet.getString("macongnhan"));
                        worker.setTenCongNhan(resultSet.getString("tencongnhan"));
                        worker.setDonVi(resultSet.getString("donvi"));
                        worker.setNgayLam(resultSet.getDate("ngaylam"));
                        worker.setCheckIn(resultSet.getTime("checkin"));
                        worker.setCheckOut(resultSet.getTime("checkout"));
                        worker.setThoiGianLam(resultSet.getTime("thoigianlam"));
                        worker.setIdCa(resultSet.getInt("idca"));
                        worker.setPassWord(resultSet.getString("password"));
                        return worker;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public boolean isDateExists(Date ngayLam, String idCongNhan) {
    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT * FROM Worker WHERE ngaylam = ? AND macongnhan = ? AND idca = 3";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, ngayLam);
            preparedStatement.setString(2, idCongNhan);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Trả về true nếu có dòng dữ liệu, ngược lại trả về false
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false; // Xử lý lỗi nếu cần
}


}
