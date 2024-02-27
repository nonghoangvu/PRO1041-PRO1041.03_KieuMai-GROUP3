CREATE DATABASE HalaDesign
GO
USE HalaDesign
Go
CREATE TABLE [KhachHang] (
  [id]  INT IDENTITY(1,1) PRIMARY KEY,
  [ho_ten] nvarchar(255),
  [gioi_tinh] bit,
  [so_dien_thoai] nvarchar(255),
  [email] nvarchar(255),
  [diaChi] nvarchar(max),
  [ngay_tao] datetime DEFAULT (GETDATE()),
  [ngay_sua] datetime,
  [xoa_mem] int
)
GO
CREATE TABLE [SanPham] (
  [id] NCHAR(15) PRIMARY KEY,
  [ten_san_pham] NVARCHAR(MAX) NOT NULL,
  [mo_ta] NVARCHAR(MAX) NULL,
  [trang_thai] BIT DEFAULT 1,
  [ngay_tao] DATETIME DEFAULT (GETDATE()),
  [id_nhan_vien] INT
)
GO
CREATE TABLE [Size] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [loai_size] NVARCHAR(10) NOT NULL,
  [trang_thai] BIT DEFAULT 1,
  [ngay_tao] DATETIME DEFAULT (GETDATE())
)
GO
CREATE TABLE [Color] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [loai_mau] NVARCHAR(20) NOT NULL,
  [trang_thai] BIT DEFAULT 1,
  [ngay_tao] DATETIME DEFAULT (GETDATE())
)
GO
CREATE TABLE [ChatLieu] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [loai_chat_lieu] NVARCHAR(50) NOT NULL,
  [trang_thai] BIT DEFAULT 1,
  [ngay_tao] DATETIME DEFAULT (GETDATE())
)
GO
CREATE TABLE [SanPhamChiTiet] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [id_san_pham] NCHAR(15) NOT NULL,
  [ten_bien_the] NVARCHAR(MAX) NOT NULL,
  [id_size] INT,
  [id_color] INT,
  [id_chat_lieu] INT,
  [so_luong] INT DEFAULT 0,
  [gia] INT CHECK ([gia] >= 0) NOT NULL,
  [ngay_tao] DATETIME DEFAULT (GETDATE())
)
GO
GO
CREATE TABLE [QuyenHan] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [ten_quyen_han] NVARCHAR(MAX),
  [nhin_gia_von] BIT,
  [nhap_kho] BIT,
  [huy_don_hang] BIT,
  [sua_tt_khach_hang] BIT,
  [xem_bao_cao] BIT,
  [sua_quyen_han] BIT
)
GO
CREATE TABLE [NhanVien] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [ho_ten] NVARCHAR(100),
  [sdt] NCHAR(13),
  [email] NCHAR(255),
  [gioi_tinh] BIT,
  [ngay_sinh] DATE,
  [dia_chi] NVARCHAR(MAX),
  [mat_khau] NVARCHAR(MAX),
  [trang_thai] NVARCHAR(MAX),
  [ngay_tao] DATETIME DEFAULT (GETDATE()),
  [id_quyen_han] INT,
  [ghi_chu] NVARCHAR(MAX)
)
GO
CREATE TABLE [HoaDon] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [id_khach_hang] INT,
  [id_nhan_vien] INT,
  [trang_thai] NVARCHAR(100),
  [tong_gia_tri_hoa_don] INT,
  [hinh_thuc_thanh_toan] NVARCHAR(MAX),
  [ma_giao_dich] NVARCHAR(MAX),
  [tien_dua] INT,
  [tien_thua] INT,
  [ngay_tao] DATETIME DEFAULT (GETDATE()),
  [ngay_sua] DATETIME
)
GO
CREATE TABLE [HoaDonChiTiet] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [id_hoa_don] INT,
  [id_san_pham_chi_tiet] INT,
  [so_luong] INT,
  [gia] INT,
  [tong_tien] INT
)
GO
ALTER TABLE [NhanVien] ADD FOREIGN KEY ([id_quyen_han]) REFERENCES [QuyenHan] ([id])
GO
ALTER TABLE [SanPham] ADD FOREIGN KEY ([id_nhan_vien]) REFERENCES [NhanVien] ([id])
GO
ALTER TABLE [SanPhamChiTiet] ADD FOREIGN KEY ([id_san_pham]) REFERENCES [SanPham] ([id])
GO
ALTER TABLE [SanPhamChiTiet] ADD FOREIGN KEY ([id_size]) REFERENCES [Size] ([id])
GO
ALTER TABLE [SanPhamChiTiet] ADD FOREIGN KEY ([id_color]) REFERENCES [Color] ([id])
GO
ALTER TABLE [SanPhamChiTiet] ADD FOREIGN KEY ([id_chat_lieu]) REFERENCES [ChatLieu] ([id])
GO
ALTER TABLE [HoaDonChiTiet] ADD FOREIGN KEY ([id_hoa_don]) REFERENCES [HoaDon] ([id])
GO
ALTER TABLE [HoaDonChiTiet] ADD FOREIGN KEY ([id_san_pham_chi_tiet]) REFERENCES [SanPhamChiTiet] ([id])
GO
ALTER TABLE [HoaDon] ADD FOREIGN KEY ([id_khach_hang]) REFERENCES [KhachHang] ([id])
GO
ALTER TABLE [HoaDon] ADD FOREIGN KEY ([id_nhan_vien]) REFERENCES [NhanVien] ([id])
GO
-- INSERT DATA --
-- Quen Han --
INSERT INTO [QuyenHan] ([ten_quyen_han], [nhin_gia_von], [nhap_kho], [huy_don_hang], [sua_tt_khach_hang], [xem_bao_cao], [sua_quyen_han])
VALUES 
  (N'Chủ cửa hàng', 1, 1, 1, 1, 1,1),
  (N'Nhân viên bán hàng', 0,0,0,1,0,0),
  (N'Quản lý cửa hàng', 0, 1, 1, 1, 0,0);
GO
-- Nhan Vien --
INSERT INTO [NhanVien] ([ho_ten], [sdt], [email], [gioi_tinh], [ngay_sinh], [dia_chi], [mat_khau], [trang_thai], [id_quyen_han], [ghi_chu])
VALUES
  ('Nguyen Van A', '0123456789', 'nv_a@email.com', 1, '1990-01-15', '123 Main Street, City', 'password123', 'Deleted', 1, 'Ghi chú 1'),
  ('Tran Thi B', '0987654321', 'tt_b@email.com', 0, '1995-05-20', '456 Park Avenue, Town', 'securepass456', N'Đang nghỉ việc', 2, 'Ghi chú 2'),
  ('Le Van C', '0369871542', null, 1, null, null, null, N'Đã gửi lời mời', 2, 'Ghi chú 3'),
  ('Nong Hoang Vu', '0777049085', 'nonghoangvu04@gmail.com', 1, null, N'HaNoi', '123', N'Đang làm việc', 3, 'Ghi chú 3');
GO
-- Khach hang ---
INSERT INTO [KhachHang] ([ho_ten], [gioi_tinh], [so_dien_thoai], [email], [diaChi], [ngay_sua], [xoa_mem])
VALUES 
  (N'Hoang Quoc Binh', 1, N'0123456789', N'binhcute@example.com', N'123 Đường ABC, Quận XYZ, Thành phố HCM', GETDATE(), 0),
  (N'Nong Hoang Vu', 0, N'0987654321', N'vucute@example.com', N'456 Đường DEF, Quận UVW, Thành phố Hanoi', GETDATE(), 0),
  (N'Nguyen Thi Phuong Thao', 1, N'0369847521', N'levanc@example.com', N'789 Đường GHI, Quận JKL, Thành phố Danang', GETDATE(), 0);

-- Size --
INSERT INTO [Size] ([loai_size], [trang_thai])
VALUES ('S', 1), ('M', 1), ('L', 1), ('XL', 1), ('XXL', 1);
-- Color --
INSERT INTO [Color] ([loai_mau], [trang_thai])
VALUES (N'Cam', 1), (N'Hồng', 1), (N'Đỏ', 1);
-- ChatLieu--
INSERT INTO [ChatLieu] ([loai_chat_lieu], [trang_thai])
VALUES (N'Lace ', 1), (N'Cotton ', 1), (N'Lụa ', 1), (N'Polyester', 1);
-- San Pham --
INSERT INTO [SanPham] ([id], [ten_san_pham], [id_nhan_vien])
VALUES
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen', 1),
('HLD-02',  N'Bộ nhung Hàn Quốc cổ sen 02', 1),
('HLD-03',  N'Bộ nhung Hàn Quốc cổ sen 03', 1);
-- SanPhamChiTiet --
INSERT INTO [SanPhamChiTiet] ([id_san_pham], [ten_bien_the], [id_size], [id_color], [id_chat_lieu], [so_luong], [gia])
VALUES
('HLD-01', '[S-Cam-Lace]', 1, 1, 1, 110, 758000),
('HLD-01', '[XL-Cam-Cotton]', 4, 1, 2, 130, 758000),
('HLD-01', N'[XXL-Cam-Lụa]', 5, 1, 3, 140, 758000),
('HLD-01', '[M-Cam-Polyester]', 2, 1, 4, 120, 758000),
('HLD-01', '[L-Cam-Lace]', 3, 1, 1, 10, 758000),

('HLD-01', '[S-Hong-Lace]', 1, 2, 1, 120, 758000),
('HLD-01', '[XL-Hong-Cotton]', 4, 2, 2, 120, 758000),
('HLD-01', N'[XXL-Hong-Lụa]', 5, 2, 3, 160, 758000),
('HLD-01', '[M-Hong-Polyester]', 2, 2, 4, 133, 758000),
('HLD-01', '[L-Hong-Lace]', 3, 2, 1, 134, 758000),

('HLD-01', '[S-Do-Cotton]', 1, 3, 2, 134, 758000),
('HLD-01', N'[XL-Do-Lụa]', 4, 3, 3, 143, 758000),
('HLD-01', '[XXL-Do-Polyester]', 5, 3, 4, 134, 758000),
('HLD-01', '[M-Do-Lace]', 2, 3, 1, 100, 758000),
('HLD-01', '[L-Do-Cotton]', 3, 3, 2, 100, 758000)
GO
INSERT INTO HoaDon (id_khach_hang, id_nhan_vien, trang_thai, tong_gia_tri_hoa_don, hinh_thuc_thanh_toan, ma_giao_dich, tien_dua, tien_thua)
VALUES (1, 1, N'Chờ thanh toán', 758000, N'Chuyển khoản', null, 760000, 2000),
       (1, 2, N'Đã thanh toán', 1516000, N'Tiền mặt', null, 1516000, 0),
       (2, 3, N'Đã thanh toán', 1516000, N'Chuyển khoản', null, 1516000, 0),
	   (3, 2, N'Hủy', 1516000, N'Chuyển khoản', null, 1516000, 0),
	   (3, 1, N'Đã thanh toán', 1516000, N'Chuyển khoản', null, 1516000, 0)
GO
INSERT INTO HoaDon (id_khach_hang, id_nhan_vien, trang_thai, tong_gia_tri_hoa_don, hinh_thuc_thanh_toan, ma_giao_dich, tien_dua, tien_thua)
	VALUES (3, 2, N'Đã thanh toán', 1516000, N'Quẹt thẻ', null, 1516000, 0)
INSERT INTO HoaDon (id_khach_hang, id_nhan_vien, trang_thai, tong_gia_tri_hoa_don, hinh_thuc_thanh_toan, ma_giao_dich, tien_dua, tien_thua)
	VALUES (Null, 4, N'Hủy', 1516000, N'Quẹt thẻ', null, 1516000, 0)
INSERT INTO HoaDon (id_khach_hang, id_nhan_vien, trang_thai, tong_gia_tri_hoa_don, hinh_thuc_thanh_toan, ma_giao_dich, tien_dua, tien_thua)
	VALUES (Null, 2, N'Đã thanh toán', 1516000, N'Tiền mặt', null, 1516000, 0)
INSERT INTO HoaDon (id_khach_hang, id_nhan_vien, trang_thai, tong_gia_tri_hoa_don, hinh_thuc_thanh_toan, ma_giao_dich, tien_dua, tien_thua)
	VALUES (Null, 4, N'Đã thanh toán', 1516000, N'Chuyển khoản', null, 1516000, 0)
GO
INSERT INTO HoaDonChiTiet (id_hoa_don, id_san_pham_chi_tiet, so_luong, gia, tong_tien)
VALUES (1, 1, 1, 758000, 758000),
       (2, 5, 2, 758000, 1516000),
	   (3, 6, 1, 758000, 758000),
	   (3, 3, 1, 758000, 758000),
	   (4, 3, 1, 758000, 758000),
	   (5, 4, 3, 758000, 2274000 )
GO

INSERT INTO HoaDonChiTiet (id_hoa_don, id_san_pham_chi_tiet, so_luong, gia, tong_tien)
VALUES 
(8, 2, 1, 758000, 758000),
(8, 4, 3, 758000, 758000)

INSERT INTO HoaDonChiTiet (id_hoa_don, id_san_pham_chi_tiet, so_luong, gia, tong_tien)
VALUES 
(9, 2, 1, 758000, 758000),
(10, 4, 3, 758000, 758000)







-----TRUY VẤN CỦA MẠNH-------------------------------------------------------------------------
-- Query --
SELECT * FROM NhanVien
SELECT * FROM KhachHang
SELECT * FROM Size
SELECT * FROM COLOR
SELECT * FROM SanPham
SELECT * FROM [SanPhamChiTiet]
SELECT * FROM HoaDon
SELECT * FROM HoaDonChiTiet


--1. Thực hiện truy vấn danh sách hóa đơn ( MãHĐ + Ngày tạo hóa đơn + Tên KH ( truy từ ID bên java ) + Trạng thái hóa đơn + Phương thức thanh toán + Khách phải trả ) 
--getInvoiceList()
select hd.id as id_hoa_don , nv.ho_ten as ho_ten_nhan_vien , hd.ngay_tao , kh.ho_ten As ho_ten_khach_hang , hd.trang_thai , hd.hinh_thuc_thanh_toan ,SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don  	
from HoaDon hd 
left join KhachHang kh on hd.id_khach_hang = kh.id 
inner join NhanVien nv on nv.id = hd.id_nhan_vien
inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
where hd.trang_thai <> N'Chờ thanh toán'
GROUP BY hd.id, nv.ho_ten ,  hd.ngay_tao, kh.ho_ten, hd.trang_thai, hd.hinh_thuc_thanh_toan ;

--1. Truy vấn theo nhân viên phụ trách với hóa đơn đó.
select hd.id as id_hoa_don , nv.ho_ten as ho_ten_nhan_vien , hd.ngay_tao , kh.ho_ten As ho_ten_khach_hang , hd.trang_thai , hd.hinh_thuc_thanh_toan ,SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don  	
from HoaDon hd 
left join KhachHang kh on  kh.id  = hd.id_khach_hang 
inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
inner join NhanVien nv	on nv.id = hd.id_nhan_vien
where nv.id = 4 AND hd.trang_thai <> N'Chờ thanh toán'
GROUP BY hd.id, nv.ho_ten ,  hd.ngay_tao, kh.ho_ten, hd.trang_thai, hd.hinh_thuc_thanh_toan ;

--2. Truy vấn ListEmployee có tham gia tạo ít nhất 1 hđ.
select  nv.id As id_nhan_vien , nv.ho_ten As ho_ten_nhan_vien 
from NhanVien nv 
right join HoaDon hd on hd.id_nhan_vien = nv.id
where hd.trang_thai <> N'Chờ thanh toán'
Group by nv.id , nv.ho_ten

--1. Truy vấn hóa đơn theo trạng thái hóa đơn	 getInvoiceListByStatus
select hd.id as id_hoa_don , nv.ho_ten as ho_ten_nhan_vien , hd.ngay_tao , kh.ho_ten As ho_ten_khach_hang , hd.trang_thai , hd.hinh_thuc_thanh_toan ,SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don  	
from HoaDon hd 
left join KhachHang kh on hd.id_khach_hang = kh.id 
inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
inner join NhanVien nv	on nv.id = hd.id_nhan_vien
where hd.trang_thai = N'Hủy'
GROUP BY hd.id, nv.ho_ten ,  hd.ngay_tao, kh.ho_ten, hd.trang_thai, hd.hinh_thuc_thanh_toan;

--Truy vấn theo ngày tạo với format  
 SELECT hd.id AS id_hoa_don, nv.ho_ten as ho_ten_nhan_vien , CONVERT(VARCHAR(10), hd.ngay_tao, 120) AS ngay_tao,
kh.ho_ten AS ho_ten_khach_hang, hd.trang_thai, hd.hinh_thuc_thanh_toan,
SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don
FROM HoaDon hd
left JOIN KhachHang kh ON hd.id_khach_hang = kh.id
INNER JOIN HoaDonChiTiet hdct ON hdct.id_hoa_don = hd.id
inner join NhanVien nv	on nv.id = hd.id_nhan_vien
WHERE CONVERT(VARCHAR(10), hd.ngay_tao, 120)   = '2024-02-26' AND hd.trang_thai <> N'Chờ thanh toán'
GROUP BY
hd.id,  nv.ho_ten ,  CONVERT(VARCHAR(10), hd.ngay_tao, 120), kh.ho_ten, hd.trang_thai, 
hd.hinh_thuc_thanh_toan  ;


--Truy vấn UI HĐCT

--1. Truy vấn formHD dựa vào id
select hd.id as id_hoa_don , hd.hinh_thuc_thanh_toan ,
hd.trang_thai , kh.ho_ten as ho_ten_khach_hang , kh.so_dien_thoai , 
nv.ho_ten as ho_ten_nhan_vien  , hd.ngay_tao
from HoaDon hd
inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
LEFT join KhachHang kh on kh.id = hd.id_khach_hang 
inner join NhanVien nv on nv.id = hd.id_nhan_vien
where hd.id = 7
Group by hd.id , hd.hinh_thuc_thanh_toan , hd.trang_thai , kh.ho_ten, kh.so_dien_thoai , nv.ho_ten,
hd.ngay_tao 

--1. Truy vấn TTHD
--- Khách cần trả = tổng tiền - giảm giá(0đ) , tiền thừa = tiền khách đưa -  khách cần trả
select hd.id , SUM (hdct.so_luong) as tong_so_luong , SUM( hdct.tong_tien) as tong_tien_hang , hd.tien_dua, hd.tien_thua , hd.hinh_thuc_thanh_toan
from HoaDon hd 
inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
where hd.id = 5
GROUP by hd.id , hdct.so_luong , hdct.tong_tien , hd.tien_dua , hd.tien_thua  , hd.hinh_thuc_thanh_toan
--Tông tiền hàng  = Sum(hdct.tong_tien)

--- 1. Truy vấn thông tin sản phẩm mua trong hóa đơn
-- tên ảnh/ID sp / tên sp / giá gốc / số lượng SP  ,  tổng_tiền
select hd.id as id_hoa_don , spbt.id as id_san_pham_chi_tiet  , sp.ten_san_pham  , spbt.ten_bien_the , hdct.gia  , hdct.so_luong  , hdct.tong_tien
from HoaDon hd
inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
inner join SanPhamChiTiet spbt on spbt.id = hdct.id_san_pham_chi_tiet
inner join SanPham sp on sp.id = spbt.id_san_pham
where hd.id  = 5
group by hd.id , sp.ten_san_pham  , spbt.ten_bien_the, hdct.gia, hdct.so_luong
, spbt.id  , hdct.tong_tien;


--1. Truy vấn thông tin đầy đủ cho xuất File
-- Mã Hóa Đơn , ngày tạo , tên khách hàng , id_nhân viên , Tên NV , TTHĐ , HTTT 
select hd.id as id_hoa_don , hd.id_nhan_vien ,  hd.ngay_tao , 
kh.ho_ten As ho_ten_khach_hang , hd.trang_thai , hd.hinh_thuc_thanh_toan ,
SUM(hdct.tong_tien) AS tong_gia_tri_hoa_don  	
from HoaDon hd 
inner join KhachHang kh on hd.id_khach_hang = kh.id 
inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
where trang_thai <> N'Chờ thanh toán'
GROUP BY hd.id, hd.ngay_tao, kh.ho_ten, hd.trang_thai,
hd.hinh_thuc_thanh_toan,hd.id_nhan_vien 

SELECT * FROM HoaDon
SELECT * FROM HoaDonChiTiet
SELECT * FROM SanPham
SELECT * FROM SanPhamChiTiet

--Truy vấn ID_spct , SL của nó dựa vào ID_HĐCT (getDS_Product_update_SL)
select hdct.id_san_pham_chi_tiet , hdct.so_luong
from HoaDon hd
inner join HoaDonChiTiet hdct on hdct.id_hoa_don = hd.id
where hd.id = 3
---Hoàn lại SL spct có trog hóa đơn vào số lượng kho.(update_Prod_Quantity_By_IDPro)
update SanPhamChiTiet 
set so_luong = so_luong  +   1
where id = 5

update HoaDon
set trang_thai = N'Đã thanh toán'
where id = 2
--Cập nhật lại trạng thái hóa đơn. (update_Status_Invoice) 
SELECT * FROM NhanVien

SELECT spct.so_luong  FROM SanPhamChiTiet spct
where id = 5
select * from HoaDonChiTiet
where id = 3

--Case : Xóa hóa đơn 
-- Dùng để trog TH.
--Case1: KH chọn hàng mua + nv thêm nhầm spbt (size/color...) và in ra hóa đơn. --> cần xóa hóa đơn đó đi
--Case2: KH mua hàng + đã thanh toán : Nhưng quay lại khi biết mua nhầm spct (size/color...) --> cần xóa đơn đó đi vào tạo ra đơn mới. 
-----END TRUY VẤN CỦA MẠNH-------------------------------------------------------------------------