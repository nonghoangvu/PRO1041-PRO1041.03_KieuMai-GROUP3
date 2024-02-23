/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.service;

import haladesign.config.JDBC_Connect;
import haladesign.model.HoaDonKhoa;
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
public class NhanVienServiceKhoa {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";
    
    public List<NhanVienKhoa> getNhanVien(){
        List<NhanVienKhoa> listNV = new ArrayList();
        sql = "select id, ho_ten from NhanVien";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                NhanVienKhoa nv = new NhanVienKhoa();
                nv.setId(rs.getInt(1));
                nv.setHoTen(rs.getString(2));
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
