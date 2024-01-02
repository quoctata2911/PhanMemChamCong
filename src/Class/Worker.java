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
public class Worker {
    private String maCongNhan;
    private String tenCongNhan;
    private String donVi;
    private Date ngayLam;
    private Time checkIn;
    private Time checkOut;
    private Time thoiGianLam;
    private int idCa;
    private String tenCa;
    private String passWord;

    public Worker() {
    }

    public Worker(String maCongNhan, String tenCongNhan, String donVi, Date ngayLam, Time checkIn, Time checkOut, Time thoiGianLam, int idCa, String passWord) {
        this.maCongNhan = maCongNhan;
        this.tenCongNhan = tenCongNhan;
        this.donVi = donVi;
        this.ngayLam = ngayLam;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.thoiGianLam = thoiGianLam;
        this.idCa = idCa;
        this.passWord = passWord;
    }

    public String getMaCongNhan() {
        return maCongNhan;
    }

    public void setMaCongNhan(String maCongNhan) {
        this.maCongNhan = maCongNhan;
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

    public Date getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(Date ngayLam) {
        this.ngayLam = ngayLam;
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

    public Time getThoiGianLam() {
        return thoiGianLam;
    }

    public void setThoiGianLam(Time thoiGianLam) {
        this.thoiGianLam = thoiGianLam;
    }

    public int getIdCa() {
        return idCa;
    }

    public void setIdCa(int idCa) {
        this.idCa = idCa;
    }

    public String getTenCa() {
        return tenCa;
    }

    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
    
}
