/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.Worker;
import connect.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuqua
 */
public class QuanLyWorker {
    public List<Worker> getAllWorkers() {
    List<Worker> workers = new ArrayList<>();

    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT * FROM Worker";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

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
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return workers;
}
        public List<Worker> getWorkersByDonVi(String partialDonVi) {
    List<Worker> workers = new ArrayList<>();

    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT * FROM Worker WHERE donvi LIKE ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + partialDonVi + "%");

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

}
