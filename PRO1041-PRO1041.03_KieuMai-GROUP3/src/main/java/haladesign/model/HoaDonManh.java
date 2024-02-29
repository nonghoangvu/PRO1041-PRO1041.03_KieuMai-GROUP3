package haladesign.model;

import java.util.Date;

public class HoaDonManh {
//HĐ

    private int id_hoa_don;
    private int id_khach_hang;
    private int id_nhan_vien;
    private String trang_thai_hoa_don; //Đã thanh toán/Chờ thanh toán/Hủy
    private Long tong_gia_tri_hoa_don; // sum ( sl * giá_bán ) 
    private String hinh_thuc_thanh_toan;//Chuyển khoản,Tiền mặt...
    private String ma_giao_dich;
    private Long tien_dua;//Tiền khách hàng đưa. 
    private Long tien_thua;//= tiền khác đưa - tổng giá trị hóa đơn.
    private Date ngay_tao_hoa_don;
    private Date ngay_sua_hoa_don;

//      HĐCT
    private int id_hoa_don_chi_tiet;
    private int id_san_pham_chi_tiet;// id_SPCT trong HĐCT
    private int so_luong; //SL spct mua trog HĐCT 
    private Long gia;//Giá mua của spct
    private Long tong_tien; // = Giá mua * SL ( của 1 spct ) trog 1 giỏ hàng

//  Ngoài luồng
    private String tenKhachHang;
    private String tenNhanVien;
    private String soDienThoaiKH;
    private Long tongTienHang;//Sum(hdct.tong_tien)
    private int tong_so_luong;//Tổng SLSP của 1 HĐ ( SUM(hdct.so_luong )) 

//    Ngoài luồng UI TTSP mua
    private String hinhAnh;
    private String ten_bien_the;
    private String ten_san_pham;

    public int getId_hoa_don() {
        return id_hoa_don;
    }

    public void setId_hoa_don(int id_hoa_don) {
        this.id_hoa_don = id_hoa_don;
    }

    public int getId_khach_hang() {
        return id_khach_hang;
    }

    public void setId_khach_hang(int id_khach_hang) {
        this.id_khach_hang = id_khach_hang;
    }

    public int getId_nhan_vien() {
        return id_nhan_vien;
    }

    public void setId_nhan_vien(int id_nhan_vien) {
        this.id_nhan_vien = id_nhan_vien;
    }

    public String getTrang_thai_hoa_don() {
        return trang_thai_hoa_don;
    }

    public void setTrang_thai_hoa_don(String trang_thai_hoa_don) {
        this.trang_thai_hoa_don = trang_thai_hoa_don;
    }

    public Long getTong_gia_tri_hoa_don() {
        return tong_gia_tri_hoa_don;
    }

    public void setTong_gia_tri_hoa_don(Long tong_gia_tri_hoa_don) {
        this.tong_gia_tri_hoa_don = tong_gia_tri_hoa_don;
    }

    public String getHinh_thuc_thanh_toan() {
        return hinh_thuc_thanh_toan;
    }

    public void setHinh_thuc_thanh_toan(String hinh_thuc_thanh_toan) {
        this.hinh_thuc_thanh_toan = hinh_thuc_thanh_toan;
    }

    public String getMa_giao_dich() {
        return ma_giao_dich;
    }

    public void setMa_giao_dich(String ma_giao_dich) {
        this.ma_giao_dich = ma_giao_dich;
    }

    public Long getTien_dua() {
        return tien_dua;
    }

    public void setTien_dua(Long tien_dua) {
        this.tien_dua = tien_dua;
    }

    public Long getTien_thua() {
        return tien_thua;
    }

    public void setTien_thua(Long tien_thua) {
        this.tien_thua = tien_thua;
    }

    public Date getNgay_tao_hoa_don() {
        return ngay_tao_hoa_don;
    }

    public void setNgay_tao_hoa_don(Date ngay_tao_hoa_don) {
        this.ngay_tao_hoa_don = ngay_tao_hoa_don;
    }

    public Date getNgay_sua_hoa_don() {
        return ngay_sua_hoa_don;
    }

    public void setNgay_sua_hoa_don(Date ngay_sua_hoa_don) {
        this.ngay_sua_hoa_don = ngay_sua_hoa_don;
    }

    public int getId_hoa_don_chi_tiet() {
        return id_hoa_don_chi_tiet;
    }

    public void setId_hoa_don_chi_tiet(int id_hoa_don_chi_tiet) {
        this.id_hoa_don_chi_tiet = id_hoa_don_chi_tiet;
    }

    public int getId_san_pham_chi_tiet() {
        return id_san_pham_chi_tiet;
    }

    public void setId_san_pham_chi_tiet(int id_san_pham_chi_tiet) {
        this.id_san_pham_chi_tiet = id_san_pham_chi_tiet;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public Long getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(Long tong_tien) {
        this.tong_tien = tong_tien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getSoDienThoaiKH() {
        return soDienThoaiKH;
    }

    public void setSoDienThoaiKH(String soDienThoaiKH) {
        this.soDienThoaiKH = soDienThoaiKH;
    }

    public Long getTongTienHang() {
        return tongTienHang;
    }

    public void setTongTienHang(Long tongTienHang) {
        this.tongTienHang = tongTienHang;
    }

    public int getTong_so_luong() {
        return tong_so_luong;
    }

    public void setTong_so_luong(int tong_so_luong) {
        this.tong_so_luong = tong_so_luong;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTen_bien_the() {
        return ten_bien_the;
    }

    public void setTen_bien_the(String ten_bien_the) {
        this.ten_bien_the = ten_bien_the;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

}
