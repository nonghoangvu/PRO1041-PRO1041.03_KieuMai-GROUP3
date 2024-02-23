/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.service;

import haladesign.config.JDBC_Connect;
import haladesign.model.KhachHang;
import haladesign.model.NhanVien;
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
    
    public List<KhachHang> getKhachHang(){
        List<KhachHang> listKH = new ArrayList();
        sql = "select id, ho_ten from KhachHang";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt(1));
                kh.setHo_ten(rs.getString(2));
                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int addKhachHang(KhachHang kh){
        sql = "insert into KhachHang (ho_ten) values(?)";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getHo_ten());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
