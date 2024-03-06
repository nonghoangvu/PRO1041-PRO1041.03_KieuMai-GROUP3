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
  [gia] BIGINT CHECK ([gia] >= 0) NOT NULL,
  [ngay_tao] DATETIME DEFAULT (GETDATE())
)
GO
CREATE TABLE [Account] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [ho_ten] NVARCHAR(100),
  [sdt] NCHAR(13),
  [email] NCHAR(255),
  [gioi_tinh] BIT,
  [ngay_sinh] DATE,
  [mat_khau] NVARCHAR(MAX),
  [trang_thai] NVARCHAR(MAX),
  [ngay_tao] DATETIME DEFAULT (GETDATE()),
  [ghi_chu] NVARCHAR(MAX)
)
GO
CREATE TABLE [HoaDon] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [id_khach_hang] INT,
  [id_nhan_vien] INT,
  [trang_thai] NVARCHAR(100),
  [tong_gia_tri_hoa_don] BIGINT,
  [hinh_thuc_thanh_toan] NVARCHAR(MAX),
  [ma_giao_dich] NVARCHAR(MAX),
  [tien_dua] BIGINT,
  [tien_thua] BIGINT,
  [ngay_tao] DATETIME DEFAULT (GETDATE()),
  [ngay_sua] DATETIME
)
GO
CREATE TABLE [HoaDonChiTiet] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [id_hoa_don] INT,
  [id_san_pham_chi_tiet] INT,
  [so_luong] INT,
  [gia] BIGINT,
  [tong_tien] BIGINT
)
GO
ALTER TABLE [SanPham] ADD FOREIGN KEY ([id_nhan_vien]) REFERENCES [Account] ([id])
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
ALTER TABLE [HoaDon] ADD FOREIGN KEY ([id_nhan_vien]) REFERENCES [Account] ([id])
GO
-- INSERT DATA --
-- Nhan Vien --
-- Khach hang ---
-- Size --
INSERT INTO [Size] ([loai_size], [trang_thai])
VALUES ('S', 1), ('M', 1), ('L', 1), ('XL', 1), ('XXL', 1);
-- Color --
INSERT INTO [Color] ([loai_mau], [trang_thai])
VALUES (N'Cam', 1), (N'Hồng', 1), (N'Đỏ', 1);
-- ChatLieu--
INSERT INTO [ChatLieu] ([loai_chat_lieu], [trang_thai])
VALUES (N'Lace ', 1), (N'Cotton ', 1), (N'Lụa ', 1), (N'Polyester', 1);