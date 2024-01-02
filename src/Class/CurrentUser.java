/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author vuqua
 */
public class CurrentUser {
    private static CurrentUser instance;
    private String idUser;
    private String tenCongNhan;
    private String donVi;
    private String passWord;
    

    private CurrentUser() {
        // Hàm tạo private để ngăn việc khởi tạo từ bên ngoài
    }

    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTenCongNhan() {
        return tenCongNhan;
    }

    public void setTenCongNhan(String tenCongNhan) {
        this.tenCongNhan = tenCongNhan;
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
