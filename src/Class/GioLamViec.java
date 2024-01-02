/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;
import java.sql.Time;
/**
 *
 * @author vuqua
 */
public class GioLamViec {
    private int idgio;
    private String tenGio;
    private Time thoiGianBatDau;
    private Time thoiGianKetThuc;

    public GioLamViec() {
    }

    public GioLamViec(int idgio, String tenGio, Time thoiGianBatDau, Time thoiGianKetThuc) {
        this.idgio = idgio;
        this.tenGio = tenGio;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public int getIdgio() {
        return idgio;
    }

    public void setIdgio(int idgio) {
        this.idgio = idgio;
    }

    public String getTenGio() {
        return tenGio;
    }

    public void setTenGio(String tenGio) {
        this.tenGio = tenGio;
    }

    public Time getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Time thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Time getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Time thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    
    
}
