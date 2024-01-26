/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.service;

import haladesign.config.JDBC_Connect;
import haladesign.model.Color;
import haladesign.model.HoaDon;
import haladesign.model.HoaDonChiTiet;
import haladesign.model.NhanVien;
import haladesign.model.SanPhamBienThe;
import haladesign.model.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonChiTietService {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    
    public List<HoaDonChiTiet> getHoaDon(int id){
        List<HoaDonChiTiet> listHDCT = new ArrayList();
        sql = """
              select HoaDonChiTiet.id, id_hoa_don, id_san_pham_chi_tiet, ten_bien_the, loai_mau, loai_size, HoaDonChiTiet.gia, HoaDonChiTiet.so_luong from HoaDonChiTiet 
              join SanPhamBienThe on HoaDonChiTiet.id_san_pham_chi_tiet = SanPhamBienThe.id
              join Color on SanPhamBienThe.id_color = Color.id
              join Size on SanPhamBienThe.id_size = Size.id
              where id_hoa_don = ?""";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setId(rs.getInt(1));
                hdct.setHd(new HoaDon(rs.getInt(2)));
                SanPhamBienThe spbt = new SanPhamBienThe();
                spbt.setId(rs.getLong(3));
                spbt.setTenBienThe(rs.getString(4));
                spbt.setColor(new Color(rs.getString(5)));
                spbt.setSize(new Size(rs.getString(6)));
                hdct.setGia(rs.getInt(7));
                hdct.setSp(spbt);
                hdct.setSoLuong(rs.getInt(8));
                listHDCT.add(hdct);
            }
            return listHDCT;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int addHoaDonChiTiet(HoaDonChiTiet hdct){
        sql = "insert into HoaDonChiTiet(id_hoa_don,id_san_pham_chi_tiet,so_luong,gia) values(?,?,?,?)";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hdct.getHd().getId());
            ps.setObject(2, hdct.getSp().getId());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getGia());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int updateHoaDonChiTiet(int idHD, long idSP, HoaDonChiTiet hdct){
        sql = "update HoaDonChiTiet set so_luong = ? where id_hoa_don = ? and id_san_pham_chi_tiet = ?";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hdct.getSoLuong());
            ps.setObject(2, idHD);
            ps.setObject(3, idSP);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int deleteHoaDonChiTiet(int idHD, long idSP){
        sql = "delete HoaDonChiTiet where id_hoa_don = ? and id_san_pham_chi_tiet = ?";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idHD);
            ps.setObject(2, idSP);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
