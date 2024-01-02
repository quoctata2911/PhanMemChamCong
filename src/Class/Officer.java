/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author vuqua
 */
public class Officer {
    private String maNhanVien;
    private String tenNhanVien;
    private String donVi;
    private Date ngayLamViec;
    private Time checkIn;
    private Time checkOut;
    private Time diMuon;
    private Time veSom;
    private int idGio;
    private String tenGio;
    private int status;
    private String passWord;

    public Officer() {
    }

    public Officer(String maNhanVien, String tenNhanVien, String donVi, Date ngayLamViec, Time checkIn, Time checkOut, Time diMuon, Time veSom, int idGio, String tenGio, int status, String passWord) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.donVi = donVi;
        this.ngayLamViec = ngayLamViec;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.diMuon = diMuon;
        this.veSom = veSom;
        this.idGio = idGio;
        this.tenGio = tenGio;
        this.status = status;
        this.passWord = passWord;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Date getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(Date ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public Time getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Time checkIn) {
        this.checkIn = checkIn;
    }

    public Time getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Time checkOut) {
        this.checkOut = checkOut;
    }

    public Time getDiMuon() {
        return diMuon;
    }

    public void setDiMuon(Time diMuon) {
        this.diMuon = diMuon;
    }

    public Time getVeSom() {
        return veSom;
    }

    public void setVeSom(Time veSom) {
        this.veSom = veSom;
    }

    public int getIdGio() {
        return idGio;
    }

    public void setIdGio(int idGio) {
        this.idGio = idGio;
    }

    public String getTenGio() {
        return tenGio;
    }

    public void setTenGio(String tenGio) {
        this.tenGio = tenGio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
}
