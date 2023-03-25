CREATE TABLE Sach (
    MaSach INT PRIMARY KEY,
    TenSach VARCHAR(255),
    TacGia VARCHAR(255),
    NhaXuatBan VARCHAR(255),
    NgayXuatBan DATE,
    GiaBan FLOAT,
    SoLuongTon INT
);
CREATE TABLE KhachHang (
    MaKhachHang INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    TenKhachHang VARCHAR(255),
    DiaChi VARCHAR(255),
    Email VARCHAR(255),
    SoDienThoai VARCHAR(20)
);
CREATE TABLE NhanVien (
    MaNhanVien INT PRIMARY KEY,
    TenNhanVien VARCHAR(255),
    DiaChi VARCHAR(255),
    Email VARCHAR(255),
    SoDienThoai VARCHAR(20),
    ChucVu VARCHAR(255)
);
CREATE TABLE KhoSach (
    MaSach INT,
    ViTri VARCHAR(255),
    PRIMARY KEY (MaSach, ViTri),
    FOREIGN KEY (MaSach) REFERENCES Sach(MaSach)
);
CREATE TABLE NhaCungCap (
    MaNhaCungCap INT PRIMARY KEY,
    TenNhaCungCap VARCHAR(255),
    DiaChi VARCHAR(255),
    Email VARCHAR(255),
    SoDienThoai VARCHAR(20)
);
CREATE TABLE HoaDon (
    MaHoaDon INT PRIMARY KEY,
    MaKhachHang INT,
    NgayLap DATE,
    TongTien FLOAT,
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);
