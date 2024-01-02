/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.GioLamViec;
import Class.Officer;
import connect.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vuqua
 */
public class NhanVienCaChieuDAO {
     public List<Officer> getAllNhanVien(String idNhanVien) {
    List<Officer> nhanViens = new ArrayList<>();

    try (Connection connection = DatabaseConnection.connect()) {
        String query = "SELECT * FROM Officer WHERE idgio = 2 AND manhanvien = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idNhanVien);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Officer nhanVien = new Officer();
                    nhanVien.setMaNhanVien(resultSet.getString("manhanvien"));
                    nhanVien.setTenNhanVien(resultSet.getString("tennhanvien"));
                    nhanVien.setDonVi(resultSet.getString("donvi"));
                    nhanVien.setNgayLamViec(resultSet.getDate("ngaylamviec"));
                    nhanVien.setCheckIn(resultSet.getTime("checkin"));
                    nhanVien.setCheckOut(resultSet.getTime("checkout"));
                    nhanVien.setDiMuon(resultSet.getTime("dimuon"));
                    nhanVien.setVeSom(resultSet.getTime("vesom"));
                    nhanVien.setIdGio(resultSet.getInt("idgio"));
                    nhanVien.setStatus(resultSet.getInt("status"));
                    nhanVien.setPassWord(resultSet.getString("password"));
                    nhanViens.add(nhanVien);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return nhanViens;
}
     public static boolean checkLogin(String username, String password) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM Officer WHERE manhanvien = ? AND password = ?";
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
    public static Officer getInfoOfficer(String manhanvien) {
        Officer khachHang = null;
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM Officer WHERE manhanvien = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, manhanvien);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        khachHang = new Officer();
                        khachHang.setMaNhanVien(resultSet.getString("manhanvien"));
                        khachHang.setTenNhanVien(resultSet.getString("tennhanvien"));
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
    public GioLamViec getGioLamViecById(int idGio) {
        GioLamViec gioLamViec = null;

        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM giolamviec WHERE idgio = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idGio);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        gioLamViec = new GioLamViec();
                        gioLamViec.setIdgio(resultSet.getInt("idgio"));
                        gioLamViec.setTenGio(resultSet.getString("tenGio"));
                        gioLamViec.setThoiGianBatDau(resultSet.getTime("thoiGianBatDau"));
                        gioLamViec.setThoiGianKetThuc(resultSet.getTime("thoiGianKetThuc"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gioLamViec;
    }
    
    public void insertNhanVien(Officer nhanVien) {
    try (Connection connection = DatabaseConnection.connect()) {
        // Kiểm tra xem bản ghi đã tồn tại hay chưa
        if (!isNhanVienExist(connection, nhanVien.getNgayLamViec(), nhanVien.getMaNhanVien(), nhanVien.getIdGio())) {
            String query = "INSERT INTO Officer (manhanvien, tennhanvien, donvi, ngaylamviec, checkin, dimuon, idgio, password, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nhanVien.getMaNhanVien());
                preparedStatement.setString(2, nhanVien.getTenNhanVien());
                preparedStatement.setString(3, nhanVien.getDonVi());
                preparedStatement.setDate(4, nhanVien.getNgayLamViec());
                preparedStatement.setTime(5, nhanVien.getCheckIn());
                preparedStatement.setTime(6, nhanVien.getDiMuon());
                preparedStatement.setInt(7, nhanVien.getIdGio());
                preparedStatement.setString(8, nhanVien.getPassWord());
                preparedStatement.setInt(9, nhanVien.getStatus());
                preparedStatement.executeUpdate();
            }
        } else {
            // Bản ghi đã tồn tại, thực hiện xử lý hoặc thông báo lỗi tùy ý
            JOptionPane.showMessageDialog(null, "Đã checkin rồi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Xử lý lỗi nếu cần (ví dụ: hiển thị thông báo lỗi)
    }
}

// Hàm kiểm tra xem một bản ghi có tồn tại hay không
private boolean isNhanVienExist(Connection connection, Date ngayLamViec, String maNhanVien, int idGio) throws SQLException {
    String query = "SELECT COUNT(*) FROM Officer WHERE ngaylamviec = ? AND manhanvien = ? AND idgio = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setDate(1, ngayLamViec);
        preparedStatement.setString(2, maNhanVien);
        preparedStatement.setInt(3, idGio);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Trả về true nếu có ít nhất một bản ghi tồn tại
            }
        }
    }
    return false;
}

    
    public void updateNhanVien(Officer nhanVien) {
    try (Connection connection = DatabaseConnection.connect()) {
        // Kiểm tra xem trường checkout đã có giá trị hay chưa
        if (!isCheckoutExist(connection, nhanVien.getNgayLamViec(), nhanVien.getMaNhanVien(), nhanVien.getIdGio())) {
            String query = "UPDATE Officer SET checkout = ?, vesom = ?, status = ? WHERE ngaylamviec = ? AND manhanvien = ? AND idgio = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setTime(1, nhanVien.getCheckOut());
                preparedStatement.setTime(2, nhanVien.getVeSom());
                preparedStatement.setInt(3, nhanVien.getStatus());
                preparedStatement.setDate(4, nhanVien.getNgayLamViec());
                preparedStatement.setString(5, nhanVien.getMaNhanVien());
                preparedStatement.setInt(6, nhanVien.getIdGio());
                preparedStatement.executeUpdate();

                // Thông báo thành công
                JOptionPane.showMessageDialog(null, "Checkout thành công!");
            }
        } else {
            // Trường checkout đã có giá trị, thông báo lỗi
            JOptionPane.showMessageDialog(null, "Đã checkout ca sáng ngày hôm nay rồi", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Xử lý lỗi nếu cần (ví dụ: hiển thị thông báo lỗi)
        JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật thông tin nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}

private boolean isCheckoutExist(Connection connection, Date ngayLam, String maNhanVien, int idGio) throws SQLException {
    String query = "SELECT COUNT(*) FROM Officer WHERE ngaylamviec = ? AND manhanvien = ? AND idgio = ? AND checkout IS NOT NULL";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setDate(1, ngayLam);
        preparedStatement.setString(2, maNhanVien);
        preparedStatement.setInt(3, idGio);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    }
    return false;
}



}
