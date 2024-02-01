/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.service;
import haladesign.config.JDBC_Connect;
import haladesign.model.HoaDon0;
import haladesign.model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class HoaDonService {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    
    public List<HoaDon0> getHoaDon(){
        List<HoaDon0> listHD = new ArrayList();
        sql = """
              select HoaDon.id, ho_ten, HoaDon.ngay_tao, HoaDon.trang_thai 
              from HoaDon join NhanVien on HoaDon.id_nhan_vien = NhanVien.id
              where HoaDon.trang_thai = N'Chờ thanh toán'""";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                HoaDon0 hd = new HoaDon0();
                hd.setId(rs.getInt(1));
                NhanVien nv = new NhanVien();
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
}
