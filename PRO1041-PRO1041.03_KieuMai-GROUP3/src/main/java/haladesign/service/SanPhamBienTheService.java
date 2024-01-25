/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.service;

import haladesign.config.JDBC_Connect;
import haladesign.model.Color;
import haladesign.model.SanPhamBienThe;
import haladesign.model.Size;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class SanPhamBienTheService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";
    public List<SanPhamBienThe> getSanPham(){
        List<SanPhamBienThe> listBT = new ArrayList<>();
        sql = """
              select SanPhamBienThe.id, ten_bien_the, loai_size, loai_mau, so_luong, gia, hinhAnh 
              from SanPhamBienThe
              join SanPham on SanPhamBienThe.id_san_pham = SanPham.id
              join Color on SanPhamBienThe.id_color = Color.id
              join Size on SanPhamBienThe.id_size = Size.id""";
        try {
            con = JDBC_Connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                SanPhamBienThe spbt = new SanPhamBienThe();
                spbt.setId(rs.getLong(1));
                spbt.setTenBienThe(rs.getString(2));
                spbt.setSize(new Size(rs.getString(3)));
                spbt.setColor(new Color(rs.getString(4)));
                spbt.setSoLuong(rs.getInt(5));
                spbt.setGia(rs.getInt(6));
                spbt.setHinhAnh(rs.getString(7));
                listBT.add(spbt);
            }
            return listBT;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
