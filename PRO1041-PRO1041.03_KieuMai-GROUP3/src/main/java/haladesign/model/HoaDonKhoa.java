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
public class HoaDonKhoa {
    private int id;
    private KhachHang kh;
    private NhanVien nv;
    private String trangThai;
    private double thanhTien;
    private String hinhThuc;
    private double tienDua;
    private double tienThua;
    private Date ngayTao;

    public HoaDonKhoa() {
    }

    public HoaDonKhoa(KhachHang kh, String trangThai, double thanhTien, String hinhThuc, double tienDua, double tienThua) {
        this.kh = kh;
        this.trangThai = trangThai;
        this.thanhTien = thanhTien;
        this.hinhThuc = hinhThuc;
        this.tienDua = tienDua;
        this.tienThua = tienThua;
    }

    public HoaDonKhoa(int id, KhachHang kh, NhanVien nv, String trangThai, double thanhTien, String hinhThuc, double tienDua, double tienThua, Date ngayTao) {
        this.id = id;
        this.kh = kh;
        this.nv = nv;
        this.trangThai = trangThai;
        this.thanhTien = thanhTien;
        this.hinhThuc = hinhThuc;
        this.tienDua = tienDua;
        this.tienThua = tienThua;
        this.ngayTao = ngayTao;
    }

    

    public HoaDonKhoa(NhanVien nv, String trangThai) {
        this.nv = nv;
        this.trangThai = trangThai;
    }

    public HoaDonKhoa(int id, NhanVien nv, String trangThai, Date ngayTao) {
        this.id = id;
        this.nv = nv;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }
    

    public HoaDonKhoa(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

   

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public double getTienDua() {
        return tienDua;
    }

    public void setTienDua(double tienDua) {
        this.tienDua = tienDua;
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
