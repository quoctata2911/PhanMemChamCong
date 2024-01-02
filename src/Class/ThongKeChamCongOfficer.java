/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author vuqua
 */
public class ThongKeChamCongOfficer {
    private String maNhanVien;
    private String hoTen;
    private String donVi;
    private String thang;
    private String tongSoBuoiDiLam;
    private String tongSoGioDiMuon;
    private String tongSoGioVeSom;

    public ThongKeChamCongOfficer() {
    }

    public ThongKeChamCongOfficer(String maNhanVien, String hoTen, String donVi, String thang, String tongSoBuoiDiLam, String tongSoGioDiMuon, String tongSoGioVeSom) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.donVi = donVi;
        this.thang = thang;
        this.tongSoBuoiDiLam = tongSoBuoiDiLam;
        this.tongSoGioDiMuon = tongSoGioDiMuon;
        this.tongSoGioVeSom = tongSoGioVeSom;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getTongSoBuoiDiLam() {
        return tongSoBuoiDiLam;
    }

    public void setTongSoBuoiDiLam(String tongSoBuoiDiLam) {
        this.tongSoBuoiDiLam = tongSoBuoiDiLam;
    }

    public String getTongSoGioDiMuon() {
        return tongSoGioDiMuon;
    }

    public void setTongSoGioDiMuon(String tongSoGioDiMuon) {
        this.tongSoGioDiMuon = tongSoGioDiMuon;
    }

    public String getTongSoGioVeSom() {
        return tongSoGioVeSom;
    }

    public void setTongSoGioVeSom(String tongSoGioVeSom) {
        this.tongSoGioVeSom = tongSoGioVeSom;
    }
    
}
