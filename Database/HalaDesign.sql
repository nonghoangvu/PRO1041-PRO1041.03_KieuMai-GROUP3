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
