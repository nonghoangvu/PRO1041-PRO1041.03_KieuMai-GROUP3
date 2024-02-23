/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.service;

import haladesign.config.JDBC_Connect;
import haladesign.model.KhachHangKhoa;
import haladesign.model.NhanVienKhoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class KhachHangServiceKhoa {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    
    public List<KhachHangKhoa> getKhachHang(){
        List<KhachHangKhoa> listKH = new ArrayList();
        sql = "select id, ho_ten from KhachHang";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                KhachHangKhoa kh = new KhachHangKhoa();
                kh.setId(rs.getInt(1));
                kh.setHoTen(rs.getString(2));
                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int addKhachHang(KhachHangKhoa kh){
        sql = "insert into KhachHang (ho_ten) values(?)";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getHoTen());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
