/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author vuqua
 */
public class CurrentNhanVien {
    private static CurrentNhanVien instance;
    private String manhanvien;
    private String tennhanvien;
    private String donVi;
    private String passWord;
    

    private CurrentNhanVien() {
        // Hàm tạo private để ngăn việc khởi tạo từ bên ngoài
    }

    public static CurrentNhanVien getInstance() {
        if (instance == null) {
            instance = new CurrentNhanVien();
        }
        return instance;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
}
