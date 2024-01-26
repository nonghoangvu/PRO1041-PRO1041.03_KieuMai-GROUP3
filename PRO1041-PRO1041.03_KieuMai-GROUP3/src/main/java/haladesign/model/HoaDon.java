/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class HoaDon {
    private int id;
    private int kh;
    private NhanVien nv;
    private String trangThai;
    private double thanhTien;
    private double tienThua;
    private Date ngayTao;

    public HoaDon() {
    }

    public HoaDon(int id, int kh, NhanVien nv, String trangThai, double thanhTien, double tienThua, Date ngayTao) {
        this.id = id;
        this.kh = kh;
        this.nv = nv;
        this.trangThai = trangThai;
        this.thanhTien = thanhTien;
        this.tienThua = tienThua;
        this.ngayTao = ngayTao;
    }

    public HoaDon(NhanVien nv, String trangThai) {
        this.nv = nv;
        this.trangThai = trangThai;
    }

    public HoaDon(int id, NhanVien nv, String trangThai, Date ngayTao) {
        this.id = id;
        this.nv = nv;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }
    

    public HoaDon(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKh() {
        return kh;
    }

    public void setKh(int kh) {
        this.kh = kh;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getTienThua() {
        return tienThua;
    }

    public void setTienThua(double tienThua) {
        this.tienThua = tienThua;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    public Object[] dataHoaDon(){
        return new Object[]{
            this.id,
            this.nv.getFullName(),
            this.ngayTao,
            this.trangThai
        };
    }
}
