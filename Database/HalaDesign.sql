CREATE DATABASE HalaDesign
GO
USE HalaDesign
Go
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
CREATE TABLE [SanPhamBienThe] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [id_san_pham] NCHAR(15) NOT NULL,
  [ten_bien_the] NVARCHAR(MAX) NOT NULL,
  [id_size] INT,
  [id_color] INT,
  [so_luong] INT DEFAULT 0,
  [gia] INT CHECK ([gia] >= 0) NOT NULL,
  [hinhAnh] NVARCHAR(MAX)
)
GO
CREATE TABLE [QuyenHan] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [ten_quyen_han] NVARCHAR(MAX),
  [nhin_gia_von] BIT,
  [nhap_kho] BIT,
  [huy_don_hang] BIT,
  [sua_tt_khach_hang] BIT,
  [xem_bao_cao] BIT
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
ALTER TABLE [NhanVien] ADD FOREIGN KEY ([id_quyen_han]) REFERENCES [QuyenHan] ([id])
GO
ALTER TABLE [SanPham] ADD FOREIGN KEY ([id_nhan_vien]) REFERENCES [NhanVien] ([id])
GO
ALTER TABLE [SanPhamBienThe] ADD FOREIGN KEY ([id_san_pham]) REFERENCES [SanPham] ([id])
GO
ALTER TABLE [SanPhamBienThe] ADD FOREIGN KEY ([id_size]) REFERENCES [Size] ([id])
GO
ALTER TABLE [SanPhamBienThe] ADD FOREIGN KEY ([id_color]) REFERENCES [Color] ([id])
GO
-- INSERT DATA --
-- Quen Han --
INSERT INTO QuyenHan (ten_quyen_han, nhin_gia_von, nhap_kho, huy_don_hang, sua_tt_khach_hang, xem_bao_cao) VALUES
(N'Quyền 1', 1, 1, 0, 1, 1),
(N'Quyền 2', 0, 1, 1, 0, 1),
(N'Quyền 3', 1, 0, 1, 1, 0);
-- Nhan Vien --
INSERT INTO NhanVien (ho_ten, sdt, email, gioi_tinh, ngay_sinh, dia_chi, mat_khau, trang_thai, id_quyen_han) VALUES
(N'Nguyen Van A', '0123456789', 'nguyen.a@example.com', 1, '1990-01-01', N'123 Đường ABC, Quận XYZ', 'password123', 'Hoạt động', 1),
(N'Tran Thi B', '0987654321', 'tran.b@example.com', 0, '1995-05-15', N'456 Đường DEF, Quận LMN', 'pass456', N'Nghỉ làm', 2),
(N'Le Van C', '0112233445', 'le.c@example.com', 1, '1985-08-20', N'789 Đường GHI, Quận PQR', 'pass789', N'Hoạt động', 3);
-- Size --
INSERT INTO [Size] ([loai_size])
VALUES ('S'), ('M'), ('L'), ('XL'), ('XXL');
-- Color --
INSERT INTO [Color] ([loai_mau])
VALUES (N'Cam'), (N'Hồng'), (N'Đỏ');
-- San Pham --
INSERT INTO [SanPham] ([id], [ten_san_pham], [id_nhan_vien])
VALUES
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen', 1),
('HLD-02',  N'Bộ nhung Hàn Quốc cổ sen 02', 1),
('HLD-03',  N'Bộ nhung Hàn Quốc cổ sen 03', 1);
-- Bien The San Pham --
INSERT INTO [SanPhamBienThe] ([id_san_pham], [ten_bien_the], [id_size], [id_color], [so_luong], [gia])
VALUES
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [S-Cam]', 1, 1, 110, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XL-Cam]', 4, 1, 130, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XXL-Cam]', 5, 1, 140, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [M-Cam]', 2, 1, 120, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [L-Cam]', 3, 1, 10, 758000),

('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [S-Hong]', 1, 2, 120, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XL-Hong]', 4, 2, 120, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XXL-Hong]', 5, 2, 160, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [M-Hong]', 2, 2, 133, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [L-Hong]', 3, 2, 134, 758000),

('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [S-Do]', 1, 3, 134, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XL-Do]', 4, 3, 143, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XXL-Do]', 5, 3, 134, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [M-Do]', 2, 3, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [L-Do]', 3, 3, 100, 758000),

('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [S-Cam]', 1, 1, 34, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XL-Cam]', 4, 1, 34, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XXL-Cam]', 5, 1, 34, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [M-Cam]', 2, 1, 34, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [L-Cam]', 3, 1, 43, 758000),

('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [S-Hong]', 1, 2, 34, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XL-Hong]', 4, 2, 43, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XXL-Hong]', 5, 2, 11, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [M-Hong]', 2, 2, 43, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [L-Hong]', 3, 2, 43, 758000),

('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [S-Do]', 1, 3, 130, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XL-Do]', 4, 3, 320, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XXL-Do]', 5, 3, 20, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [M-Do]', 2, 3, 20, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [L-Do]', 3, 3, 10, 758000),

('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [S-Do]', 1, 3, 150, 758000),
('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [XL-Do]', 4, 3, 133, 758000),
('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [XXL-Do]', 5, 3, 134, 758000),
('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [M-Do]', 2, 3, 143, 758000),
('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [L-Do]', 3, 3, 1, 758000);
-- Query --
SELECT * FROM NhanVien
SELECT * FROM Size
SELECT * FROM COLOR
SELECT * FROM SanPham
SELECT * FROM SanPhamBienThe WHERE id_san_pham = 'HLD-03         '

SELECT SP.id,BT.id, SP.ten_san_pham, BT.ten_bien_the, SZ.loai_size, COL.loai_mau, BT.hinhAnh, BT.gia,BT.so_luong
FROM SanPham SP
INNER JOIN SanPhamBienThe BT ON BT.id_san_pham = SP.id
INNER JOIN Size SZ ON SZ.id = BT.id_size
INNER JOIN Color COL ON COL.id = BT.id_color
WHERE SP.id = 'HLD-9011146'

DROP TABLE [SanPhamBienThe];
DROP TABLE [Color];
DROP TABLE [Size];
DROP TABLE [SanPham];
DROP TABLE [QuyenHan];
DROP TABLE [NhanVien];
