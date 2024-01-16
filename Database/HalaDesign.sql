CREATE DATABASE HalaDesign
GO
USE HalaDesign
Go
CREATE TABLE [SanPham] (
  [id] NCHAR(8) PRIMARY KEY,
  [ten_san_pham] NVARCHAR(MAX) NOT NULL,
  [thuong_hieu] NVARCHAR(100) DEFAULT 'Hala Design',
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
CREATE TABLE [HinhAnh] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [url] NVARCHAR(MAX) NULL
)
GO
CREATE TABLE [SanPhamHinhAnh] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [id_san_pham_bien_the] INT NULL,
  [id_hinh_anh] INT NULL
)
GO
CREATE TABLE [SanPhamBienThe] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [id_san_pham] NCHAR(20) NOT NULL,
  [ten_bien_the] NVARCHAR(MAX) NOT NULL,
  [id_size] INT,
  [id_color] INT,
  [so_luong] INT DEFAULT 0,
  [gia] INT CHECK ([gia] >= 0) NOT NULL
)
GO
CREATE TABLE [NhanVien] (
  [id] INT IDENTITY(1,1) PRIMARY KEY,
  [ho_ten] NVARCHAR(100) NOT NULL,
  [role] BIT NOT NULL,
  [sdt] NCHAR(13) NULL,
  [email] NCHAR(255) NULL,
  [gioi_tinh] BIT NULL,
  [ngay_sinh] DATE NULL,
  [dia_chi] NVARCHAR(MAX) NULL,
  [password] NVARCHAR(MAX) NOT NULL,
  [trang_thai] BIT DEFAULT 1,
  [ngay_tao] DATETIME DEFAULT (GETDATE())
)
GO
ALTER TABLE [SanPham] ADD FOREIGN KEY ([id_nhan_vien]) REFERENCES [NhanVien] ([id])
GO
ALTER TABLE [SanPhamBienThe] ADD FOREIGN KEY ([id_san_pham]) REFERENCES [SanPham] ([id])
GO
ALTER TABLE [SanPhamBienThe] ADD FOREIGN KEY ([id_size]) REFERENCES [Size] ([id])
GO
ALTER TABLE [SanPhamBienThe] ADD FOREIGN KEY ([id_color]) REFERENCES [Color] ([id])
GO
ALTER TABLE [SanPhamHinhAnh] ADD FOREIGN KEY ([id_san_pham_bien_the]) REFERENCES [SanPhamBienThe] ([id])
GO
ALTER TABLE [SanPhamHinhAnh] ADD FOREIGN KEY ([id_hinh_anh]) REFERENCES [HinhAnh] ([id])
GO
-- INSERT DATA --
-- Nhan Vien --
INSERT INTO [NhanVien] ([ho_ten], [role], [gioi_tinh], [ngay_sinh], [password])
VALUES
('Admin', 1, 1, '2004-01-12', 'admin'),
(N'Nguyễn Văn A', 0, 0, '1995-05-05', 'password');
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
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [S-Cam]', 1, 1, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XL-Cam]', 4, 1, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XXL-Cam]', 5, 1, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [M-Cam]', 2, 1, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [L-Cam]', 3, 1, 100, 758000),

('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [S-Hong]', 1, 2, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XL-Hong]', 4, 2, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XXL-Hong]', 5, 2, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [M-Hong]', 2, 2, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [L-Hong]', 3, 2, 100, 758000),

('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [S-Do]', 1, 3, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XL-Do]', 4, 3, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [XXL-Do]', 5, 3, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [M-Do]', 2, 3, 100, 758000),
('HLD-01', N'Bộ nhung Hàn Quốc cổ sen [L-Do]', 3, 3, 100, 758000),

('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [S-Cam]', 1, 1, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XL-Cam]', 4, 1, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XXL-Cam]', 5, 1, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [M-Cam]', 2, 1, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [L-Cam]', 3, 1, 100, 758000),

('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [S-Hong]', 1, 2, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XL-Hong]', 4, 2, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XXL-Hong]', 5, 2, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [M-Hong]', 2, 2, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [L-Hong]', 3, 2, 100, 758000),

('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [S-Do]', 1, 3, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XL-Do]', 4, 3, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [XXL-Do]', 5, 3, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [M-Do]', 2, 3, 100, 758000),
('HLD-02', N'Bộ nhung Hàn Quốc cổ sen 02 [L-Do]', 3, 3, 100, 758000),

('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [S-Do]', 1, 3, 100, 758000),
('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [XL-Do]', 4, 3, 100, 758000),
('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [XXL-Do]', 5, 3, 100, 758000),
('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [M-Do]', 2, 3, 100, 758000),
('HLD-03', N'Bộ nhung Hàn Quốc cổ sen 03 [L-Do]', 3, 3, 100, 758000);

-- Hinh Anh --
INSERT INTO [HinhAnh] (url) VALUES('test.png'), ('test2.png'), ('test3.png'), ('test4.png');
-- San Pham Hinh Anh --
INSERT INTO [SanPhamHinhAnh] (id_san_pham_bien_the, id_hinh_anh) VALUES
(1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (7, 1), (8, 1), (9, 1), (10, 1), (11, 1), (12, 1), (13, 1),
(14, 1), (15, 1), (16, 1), (17, 1), (18, 1), (19, 1), (20, 1), (21, 1), (22, 1), (23, 1), (24, 1), (25, 1),
(26, 1), (27, 1), (28, 1), (29, 1), (30, 1), (31, 1), (32, 1), (33, 1), (34, 1), (35, 1)

INSERT INTO [SanPhamHinhAnh] (id_san_pham_bien_the, id_hinh_anh) VALUES
(5, 3),
(5, 3),
(5, 3)
-- Query --
SELECT * FROM NhanVien
SELECT * FROM Size
SELECT * FROM COLOR
SELECT * FROM SanPham
SELECT * FROM SanPhamBienThe
SELECT * FROM HinhAnh
SELECT * FROM SanPhamHinhAnh

SELECT SP.id,BT.id, SP.ten_san_pham, BT.ten_bien_the, SZ.loai_size, COL.loai_mau , HA.url
FROM SanPham SP
LEFT JOIN SanPhamBienThe BT ON BT.id_san_pham = SP.id
LEFT JOIN Size SZ ON SZ.id = BT.id_size
LEFT JOIN Color COL ON COL.id = BT.id_color
LEFT JOIN SanPhamHinhAnh SPHA ON SPHA.id_san_pham_bien_the = BT.id
LEFT JOIN HinhAnh HA ON HA.id = SPHA.id_hinh_anh
WHERE SP.id = 'HLD-01'