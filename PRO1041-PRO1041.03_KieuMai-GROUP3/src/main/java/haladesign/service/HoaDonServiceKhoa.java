/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.service;
import haladesign.config.JDBC_Connect;
import haladesign.model.HoaDonKhoa;
import haladesign.model.NhanVienKhoa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class HoaDonServiceKhoa {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    
    public List<HoaDonKhoa> getHoaDon(){
        List<HoaDonKhoa> listHD = new ArrayList();
        sql = """
              select HoaDon.id, ho_ten, HoaDon.ngay_tao, HoaDon.trang_thai 
              from HoaDon join NhanVien on HoaDon.id_nhan_vien = NhanVien.id
              where HoaDon.trang_thai = N'Chờ thanh toán'""";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                HoaDonKhoa hd = new HoaDonKhoa();
                hd.setId(rs.getInt(1));
                NhanVienKhoa nv = new NhanVienKhoa();
                nv.setHoTen(rs.getString(2));
                hd.setNv(nv);
                hd.setNgayTao(rs.getDate(3));
                hd.setTrangThai(rs.getString(4));
                listHD.add(hd);
            }
            return listHD;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int addHoaDon(){
        sql = "insert into HoaDon(id_nhan_vien, trang_thai) values(?, ?)";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, 1);
            ps.setObject(2, "Chờ thanh toán");
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int updateHoaDon(HoaDonKhoa hd, int id){
        sql = """
              update HoaDon set id_khach_hang = ?, trang_thai = ?, tong_gia_tri_hoa_don = ?,
              hinh_thuc_thanh_toan = ?, tien_dua = ?, tien_thua = ? where id = ?""";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getKh().getId());
            ps.setObject(2, hd.getTrangThai());
            ps.setObject(3, hd.getThanhTien());
            ps.setObject(4, hd.getHinhThuc());
            ps.setObject(5, hd.getTienDua());
            ps.setObject(6, hd.getTienThua());
            ps.setObject(7, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
