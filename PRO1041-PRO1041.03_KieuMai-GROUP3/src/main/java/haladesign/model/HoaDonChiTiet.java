/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.model;

import java.text.DecimalFormat;

/**
 *
 * @author ADMIN
 */
public class HoaDonChiTiet {
    private int id;
    private HoaDon hd;
    private SanPhamBienThe sp;
    private int soLuong;
    private double gia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int soLuong) {
        this.soLuong = soLuong;
    }

    public HoaDonChiTiet(int id, HoaDon hd, SanPhamBienThe sp, int soLuong, double gia) {
        this.id = id;
        this.hd = hd;
        this.sp = sp;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public HoaDonChiTiet(HoaDon hd, SanPhamBienThe sp, int soLuong) {
        this.hd = hd;
        this.sp = sp;
        this.soLuong = soLuong;
    }

    public HoaDonChiTiet(HoaDon hd, SanPhamBienThe sp, int soLuong, double gia) {
        this.hd = hd;
        this.sp = sp;
        this.soLuong = soLuong;
        this.gia = gia;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public SanPhamBienThe getSp() {
        return sp;
    }

    public void setSp(SanPhamBienThe sp) {
        this.sp = sp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    public String tongTien(){
        double tongTien = this.soLuong * this.gia;
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        String decimalString = decimalFormat.format(tongTien);
        return decimalString;
    }
    public Object[] dataHoaDonChiTiet(){
        return new Object[]{
            this.sp.getTenBienThe(),
            this.sp.getSize(),
            this.sp.getColor(),
            this.soLuong,
            this.gia,
            this.tongTien()
        };
    }
}
