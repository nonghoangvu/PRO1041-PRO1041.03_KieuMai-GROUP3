package haladesign.service;

import haladesign.config.utility.XDate;
import haladesign.model.HoaDonManh;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.JDBCHelper;

public class HoaDonService_manh {

    public List<HoaDonManh> getInvoiceList() {//1. bảng ds hóa đơn
        String sql = """
                select hd.id as id_hoa_don , nv.ho_ten as ho_ten_nhan_vien , hd.ngay_tao , kh.ho_ten As ho_ten_khach_hang , hd.trang_thai , hd.hinh_thuc_thanh_toan ,SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don  	
                from HoaDon hd 
                inner join KhachHang kh on hd.id_khach_hang = kh.id 
                inner join NhanVien nv on nv.id = hd.id_nhan_vien
                inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
                where hd.trang_thai <> N'Chờ thanh toán'
                GROUP BY hd.id, nv.ho_ten ,  hd.ngay_tao, kh.ho_ten, hd.trang_thai, hd.hinh_thuc_thanh_toan ;
                     """;
        List<HoaDonManh> listHD = selectBySQL(sql);
        return (!listHD.isEmpty() && listHD != null) ? listHD : null;
    }

    public List<HoaDonManh> getInvoiceListByStatus(String invoiceStatus) {
        String sql = """
                 select hd.id as id_hoa_don , nv.ho_ten as ho_ten_nhan_vien , hd.ngay_tao , kh.ho_ten As ho_ten_khach_hang , hd.trang_thai , hd.hinh_thuc_thanh_toan ,SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don  	
                 from HoaDon hd 
                 inner join KhachHang kh on hd.id_khach_hang = kh.id 
                 inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
                 inner join NhanVien nv	on nv.id = hd.id_nhan_vien
                 where hd.trang_thai = ? 
                 GROUP BY hd.id, nv.ho_ten ,  hd.ngay_tao, kh.ho_ten, hd.trang_thai, hd.hinh_thuc_thanh_toan ;
                     """;
        List<HoaDonManh> listHD = selectBySQL(sql, invoiceStatus);
        return (!listHD.isEmpty() && listHD != null) ? listHD : null;
    }

    public List<HoaDonManh> getListEmployee() {//Lấy listEmployee vs đk có quản lý 1 hóa đơn. 
        String sql = """
                    select  nv.id As id_nhan_vien , nv.ho_ten As ho_ten_nhan_vien 
                     from NhanVien nv 
                     right join HoaDon hd on hd.id_nhan_vien = nv.id
                     where hd.trang_thai <> N'Chờ thanh toán'
                     Group by nv.id , nv.ho_ten
                     """;
        List<HoaDonManh> listEmployee = selectBySQL(sql);
        return (!listEmployee.isEmpty() && listEmployee != null) ? listEmployee : null;
    }

    public List<HoaDonManh> getInvoicesByEmployeeID(int idEmployee) {//Truy vấn dshd theo nvPhuTrach
        String sql = """
                    select hd.id as id_hoa_don , nv.ho_ten as ho_ten_nhan_vien , hd.ngay_tao , kh.ho_ten As ho_ten_khach_hang , hd.trang_thai , hd.hinh_thuc_thanh_toan ,SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don  	
                     from HoaDon hd 
                     inner join KhachHang kh on  kh.id  = hd.id_khach_hang 
                     inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
                     inner join NhanVien nv	on nv.id = hd.id_nhan_vien
                     where nv.id = ? AND hd.trang_thai <> N'Chờ thanh toán'
                     GROUP BY hd.id, nv.ho_ten ,  hd.ngay_tao, kh.ho_ten, hd.trang_thai, hd.hinh_thuc_thanh_toan ;
                     """;

        List<HoaDonManh> listHD = selectBySQL(sql, idEmployee);
        return (!listHD.isEmpty() && listHD != null) ? listHD : null;
    }

    public List<HoaDonManh> getInvoiceListByCreationDate(String date) throws ParseException {//4h để fix =)) đcm cđ
        String sql = """
       SELECT hd.id AS id_hoa_don, nv.ho_ten as ho_ten_nhan_vien , CONVERT(VARCHAR(10), hd.ngay_tao, 120) AS ngay_tao,
       kh.ho_ten AS ho_ten_khach_hang, hd.trang_thai, hd.hinh_thuc_thanh_toan,
       SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don
       FROM HoaDon hd
       INNER JOIN KhachHang kh ON hd.id_khach_hang = kh.id
       INNER JOIN HoaDonChiTiet hdct ON hdct.id_hoa_don = hd.id
       inner join NhanVien nv	on nv.id = hd.id_nhan_vien
       WHERE CONVERT(VARCHAR(10), hd.ngay_tao, 120)   = ? AND hd.trang_thai <> N'Chờ thanh toán'
       GROUP BY
       hd.id,  nv.ho_ten ,  CONVERT(VARCHAR(10), hd.ngay_tao, 120), kh.ho_ten, hd.trang_thai, 
       hd.hinh_thuc_thanh_toan  ;
                       """;
        try {
            Date dateFormat1 = XDate.toDate(date, "E MMM dd HH:mm:ss zzz yyyy");//Tue Feb 20 02:11:38 ICT 2024
            String dateFormat2 = XDate.toString(dateFormat1, "yyyy-MM-dd");
            List<HoaDonManh> listHD = selectBySQL(sql, dateFormat2);
            return listHD;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(HoaDonService_manh.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    Truy vấn cho UI HĐCT
    public HoaDonManh getFormInvoice(String idInvoice) {
        String sql = """
                    select hd.id as id_hoa_don , hd.hinh_thuc_thanh_toan ,
                     hd.trang_thai , kh.ho_ten as ho_ten_khach_hang , kh.so_dien_thoai , 
                     nv.ho_ten as ho_ten_nhan_vien  , hd.ngay_tao
                     from HoaDon hd
                     inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
                     inner join KhachHang kh on kh.id = hd.id_khach_hang 
                     inner join NhanVien nv on nv.id = hd.id_nhan_vien
                     where hd.id = ? 
                     Group by hd.id , hd.hinh_thuc_thanh_toan , hd.trang_thai , kh.ho_ten, kh.so_dien_thoai , nv.ho_ten,
                     hd.ngay_tao  
                  """;
        List<HoaDonManh> listHDForm = selectBySQL(sql, idInvoice);
        HoaDonManh hd = listHDForm.get(0);
        return hd;
    }

    public HoaDonManh getHoaDonIn4(String idInvoice) {//Lấy tt in4 Invoice
        String sql = """
                     select hd.id , SUM (hdct.so_luong) as tong_so_luong , SUM( hdct.tong_tien) as tong_tien_hang , hd.tien_dua, hd.tien_thua , hd.hinh_thuc_thanh_toan
                     from HoaDon hd 
                     inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
                     where hd.id = ?
                     GROUP by hd.id , hdct.so_luong , hdct.tong_tien , hd.tien_dua , hd.tien_thua  , hd.hinh_thuc_thanh_toan """;
        HoaDonManh hd = selectBySQL(sql, idInvoice).get(0);
        return hd;
    }

    public List<HoaDonManh> getTTSPInInvoice(String idInvoice) {//Lấy in4 dssp trog hóa đơn.
        String sql = """
                   select hd.id as id_hoa_don , spbt.id as id_san_pham_chi_tiet  , spbt.hinhAnh , spbt.ten_bien_the , hdct.gia  , hdct.so_luong  , hdct.tong_tien
                   from HoaDon hd
                   inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
                   inner join SanPhamBienThe spbt on spbt.id = hdct.id_san_pham_chi_tiet
                   where hd.id  = ?
                   group by hd.id , spbt.hinhAnh, spbt.ten_bien_the, hdct.gia, hdct.so_luong
                   , spbt.id  , hdct.tong_tien;
                     """;
        List<HoaDonManh> dsspbtInInvoice = selectBySQL(sql, idInvoice);
        return (!dsspbtInInvoice.isEmpty() && dsspbtInInvoice != null) ? dsspbtInInvoice : null;
    }

    public List<HoaDonManh> getListInvoiceToExport() {
        String sql = """
                     select hd.id as id_hoa_don , hd.id_nhan_vien ,  hd.ngay_tao , 
                     kh.ho_ten As ho_ten_khach_hang , hd.trang_thai , hd.hinh_thuc_thanh_toan ,
                     SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don  \t
                     from HoaDon hd 
                     inner join KhachHang kh on hd.id_khach_hang = kh.id 
                     inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
                     where trang_thai <> N'Chờ thanh toán'
                     GROUP BY hd.id, hd.ngay_tao, kh.ho_ten, hd.trang_thai,
                     hd.hinh_thuc_thanh_toan,hd.id_nhan_vien""";
        List<HoaDonManh> listInvoiceToExport = selectBySQL(sql);
        return (!listInvoiceToExport.isEmpty() && listInvoiceToExport != null) ? listInvoiceToExport : null;
    }

    public List<HoaDonManh> selectBySQL(String sql, Object... args) {
        List<HoaDonManh> listHD = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JDBCHelper.query(sql, args); // Biến để lưu trữ ResultSet được trả về từ phương thức JDBCHelper.query.
            ResultSetMetaData rsmd = rs.getMetaData();
//          để lấy ResultSetMetaData của ResultSet.
//          ResultSetMetaData cung cấp thông tin về các cột trong ResultSet.
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                HoaDonManh hd = new HoaDonManh();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    switch (columnName) {// Gán giá trị cho các thuộc tính của HoaDon dựa trên tên cột
                        case "id_hoa_don" ->
                            hd.setId_hoa_don(rs.getInt(i));
                        case "id_khach_hang" ->
                            hd.setId_khach_hang(rs.getInt(i));
                        case "id_nhan_vien" ->
                            hd.setId_nhan_vien(rs.getInt(i));
                        case "trang_thai" ->
                            hd.setTrang_thai_hoa_don(rs.getString(i));
                        case "tong_gia_tri_hoa_don" ->
                            hd.setTong_gia_tri_hoa_don(rs.getFloat(i));
                        case "hinh_thuc_thanh_toan" ->
                            hd.setHinh_thuc_thanh_toan(rs.getString(i));
                        case "ma_giao_dich" ->
                            hd.setMa_giao_dich(rs.getString(i));
                        case "tien_dua" ->
                            hd.setTien_dua(rs.getFloat(i));
                        case "tien_thua" ->
                            hd.setTien_thua(rs.getFloat(i));
                        case "ngay_tao" ->
                            hd.setNgay_tao_hoa_don(rs.getDate(i));
                        case "ngay_sua_hoa_don" ->
                            hd.setNgay_sua_hoa_don(rs.getDate(i));
                        case "id_hoa_don_chi_tiet" ->
                            hd.setId_hoa_don_chi_tiet(rs.getInt(i));
                        case "id_san_pham_chi_tiet" ->
                            hd.setId_san_pham_chi_tiet(rs.getInt(i));
                        case "so_luong" ->//SL spct mua trog HĐCT 
                            hd.setSo_luong(rs.getInt(i));
                        case "gia" ->//Giá spbt
                            hd.setGia(rs.getFloat(i));
                        case "tong_tien" ->
                            hd.setTong_tien(rs.getFloat(i));
                        //Ngoài luồng
                        case "ho_ten_khach_hang" ->
                            hd.setTenKhachHang(rs.getString(i));
                        case "ho_ten_nhan_vien" ->
                            hd.setTenNhanVien(rs.getString(i));
                        case "so_dien_thoai" ->
                            hd.setSoDienThoaiKH(rs.getString(i));
                        case "tong_tien_hang" ->
                            hd.setTongTienHang(rs.getFloat(i));
                        case "tong_so_luong" ->
                            hd.setTong_so_luong(rs.getInt(i));
                        //UI dssp trog spbt
                        case "hinhAnh" ->//Ảnh SP
                            hd.setHinhAnh(rs.getString(i));
                        case "ten_bien_the" ->//Tên SP biến thể
                            hd.setTen_bien_the(rs.getString(i));
                    }
                    // Gán giá trị cho các thuộc tính của HoaDon dựa trên tên cột
                }
                listHD.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService_manh.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi truy vấn danh sách hóa đơn");
        } finally {
            try {
                if (rs != null) {
                    rs.close(); // Đóng ResultSet thủ công
                }
            } catch (SQLException ex) {
                // Xử lý lỗi nếu đóng ResultSet thất bại
            }
        }
        return listHD;
    }

}
