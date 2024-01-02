/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Class.*;
import connect.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

/**
 *
 * @author vuqua
 */
public class QuanLyOfficer {
    public List<Officer> getAllOfficerExcel() {
    List<Officer> newWorkers = new ArrayList<>();

    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT * FROM Officer";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Officer newWorker = new Officer();
                newWorker.setMaNhanVien(resultSet.getString("manhanvien"));
                newWorker.setTenNhanVien(resultSet.getString("tennhanvien"));
                newWorker.setDonVi(resultSet.getString("donvi"));
                newWorker.setNgayLamViec(resultSet.getDate("ngaylamviec"));
                newWorker.setCheckIn(resultSet.getTime("checkin"));
                newWorker.setCheckOut(resultSet.getTime("checkout"));
                newWorker.setDiMuon(resultSet.getTime("dimuon"));
                newWorker.setVeSom(resultSet.getTime("vesom"));
                newWorker.setIdGio(resultSet.getInt("idgio"));
                newWorker.setStatus(resultSet.getInt("status"));
                newWorker.setPassWord(resultSet.getString("password"));
                newWorkers.add(newWorker);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return newWorkers;
}

public List<Officer> getOfficerByDonVi(String partialDonVi) {
    List<Officer> newWorkers = new ArrayList<>();

    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT * FROM Officer WHERE donvi LIKE ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + partialDonVi + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Officer newWorker = new Officer();
                    newWorker.setMaNhanVien(resultSet.getString("manhanvien"));
                    newWorker.setTenNhanVien(resultSet.getString("tennhanvien"));
                    newWorker.setDonVi(resultSet.getString("donvi"));
                    newWorker.setNgayLamViec(resultSet.getDate("ngaylamviec"));
                    newWorker.setCheckIn(resultSet.getTime("checkin"));
                    newWorker.setCheckOut(resultSet.getTime("checkout"));
                    newWorker.setDiMuon(resultSet.getTime("dimuon"));
                    newWorker.setVeSom(resultSet.getTime("vesom"));
                    newWorker.setIdGio(resultSet.getInt("idgio"));
                    newWorker.setStatus(resultSet.getInt("status"));
                    newWorker.setPassWord(resultSet.getString("password"));
                    newWorkers.add(newWorker);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return newWorkers;
}

public List<ThongKeChamCongOfficer> calculateChamCongInfoList(int year, int month, String tendonvi) {
    List<ThongKeChamCongOfficer> thongKeChamCongList = new ArrayList<>();

    try (Connection connection = DatabaseConnection.connect()) {
        // Lấy thông tin từ bảng Officer và JOIN với bảng khác nếu cần
        String query = "SELECT o.manhanvien, o.tennhanvien, COUNT(*) AS workingDaysCount, " +
                       "CONVERT(TIME, DATEADD(SECOND, SUM(DATEDIFF(SECOND, '00:00:00', o.dimuon)), '1900-01-01')) AS totalEarlyLeaveHours, " +
                       "CONVERT(TIME, DATEADD(SECOND, SUM(DATEDIFF(SECOND, '00:00:00', o.vesom)), '1900-01-01')) AS totalLateHours " +
                       "FROM Officer o " +
                       "WHERE MONTH(o.ngaylamviec) = ? AND YEAR(o.ngaylamviec) = ? AND o.donvi = ? " +
                       "GROUP BY o.manhanvien, o.tennhanvien";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, month);
            preparedStatement.setInt(2, year);
            preparedStatement.setString(3, tendonvi);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ThongKeChamCongOfficer thongKeChamCong = new ThongKeChamCongOfficer();
                    thongKeChamCong.setMaNhanVien(resultSet.getString("manhanvien"));
                    thongKeChamCong.setHoTen(resultSet.getString("tennhanvien"));
                    thongKeChamCong.setTongSoBuoiDiLam(String.valueOf(resultSet.getInt("workingDaysCount")));
                    thongKeChamCong.setTongSoGioDiMuon(resultSet.getTime("totalEarlyLeaveHours").toString());
                    thongKeChamCong.setTongSoGioVeSom(resultSet.getTime("totalLateHours").toString());
                    thongKeChamCong.setDonVi(tendonvi);

                    thongKeChamCongList.add(thongKeChamCong);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return thongKeChamCongList;
}


public List<ThongKeChamCongOfficer> calculateChamCongInfoListLoad() {
    List<ThongKeChamCongOfficer> thongKeChamCongList = new ArrayList<>();

    try (Connection connection = DatabaseConnection.connect()) {
        // Lấy thông tin từ bảng Officer và JOIN với bảng khác nếu cần
        String query = "SELECT o.manhanvien, o.tennhanvien, o.ngaylamviec, o.donvi, COUNT(*) AS workingDaysCount, " +
                       "CONVERT(TIME, DATEADD(SECOND, SUM(DATEDIFF(SECOND, '00:00:00', o.dimuon)), '1900-01-01')) AS totalEarlyLeaveHours, " +
                       "CONVERT(TIME, DATEADD(SECOND, SUM(DATEDIFF(SECOND, '00:00:00', o.vesom)), '1900-01-01')) AS totalLateHours " +
                       "FROM Officer o " +
                       "GROUP BY o.manhanvien, o.tennhanvien, o.ngaylamviec, o.donvi";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ThongKeChamCongOfficer thongKeChamCong = new ThongKeChamCongOfficer();
                    thongKeChamCong.setMaNhanVien(resultSet.getString("manhanvien"));
                    thongKeChamCong.setHoTen(resultSet.getString("tennhanvien"));
                    thongKeChamCong.setDonVi(resultSet.getString("donvi"));
                    thongKeChamCong.setThang(resultSet.getString("ngaylamviec"));
                    thongKeChamCong.setTongSoBuoiDiLam(String.valueOf(resultSet.getInt("workingDaysCount")));

                    // Check if the value is not null before invoking toString
                    Time earlyLeaveTime = resultSet.getTime("totalEarlyLeaveHours");
                    thongKeChamCong.setTongSoGioDiMuon(earlyLeaveTime != null ? earlyLeaveTime.toString() : "");

                    Time lateTime = resultSet.getTime("totalLateHours");
                    thongKeChamCong.setTongSoGioVeSom(lateTime != null ? lateTime.toString() : "");

                    thongKeChamCongList.add(thongKeChamCong);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return thongKeChamCongList;
}




    // ... (Các phương thức khác đã có)

    public int getWorkingDaysCount(String maNhanVien, String startDate, String endDate) {
        int workingDaysCount = 0;

        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT COUNT(DISTINCT ngaylamviec) FROM Officer WHERE manhanvien = ? AND ngaylamviec BETWEEN ? AND ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, maNhanVien);
                preparedStatement.setString(2, startDate);
                preparedStatement.setString(3, endDate);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        workingDaysCount = resultSet.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workingDaysCount;
    }

    public LocalTime getTotalVeSomHours(String maNhanVien, String startDate, String endDate) {
    LocalTime totalVeSomHours = LocalTime.of(0, 0);

    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(vesom))) FROM Officer WHERE manhanvien = ? AND ngaylamviec BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maNhanVien);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int totalSeconds = resultSet.getInt(1);
                    totalVeSomHours = LocalTime.ofSecondOfDay(totalSeconds);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return totalVeSomHours;
}


  public LocalTime getTotalEarlyLeaveHours(String maNhanVien, String startDate, String endDate) {
    LocalTime totalEarlyLeaveHours = LocalTime.of(0, 0);

    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(dimuon))) FROM Officer WHERE manhanvien = ? AND ngaylamviec BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maNhanVien);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    totalEarlyLeaveHours = LocalTime.parse(resultSet.getString(1));
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return totalEarlyLeaveHours;
}


}
