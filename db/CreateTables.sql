CREATE TABLE Sach (
    MaSach INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    TenSach VARCHAR(255),
    TacGia VARCHAR(255),
    NhaXuatBan VARCHAR(255),
    GiaNhap FLOAT,
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
    MaNhanVien INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    TenNhanVien VARCHAR(255),
    DiaChi VARCHAR(255),
    Email VARCHAR(255),
    SoDienThoai VARCHAR(20),
    ChucVu VARCHAR(255)
);
CREATE TABLE NhapKho (
    MaNhapKho INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NgayNhapKho DATE,
    ThanhTien FLOAT
);
CREATE TABLE HoaDon (
    MaHoaDon INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    MaKhachHang INT,
    NgayLap DATE,
    TongTien FLOAT,
    MaNhanVien INT,
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);
CREATE TABLE ChiTietNhapKho (
    MaNhapKho INT NOT NULL,
    MaSach INT,
    SoLuong INT,
    DonGia FLOAT,
    ThanhTien FLOAT,
    FOREIGN KEY (MaSach) REFERENCES Sach(MaSach),
    FOREIGN KEY (MaNhapKho) REFERENCES NhapKho(MaNhapKho)
);
CREATE TABLE ChiTietHoaDon (
    MaHoaDon INT NOT NULL,
    MaSach INT,
    SoLuong INT,
    ThanhTien FLOAT,
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaSach) REFERENCES Sach(MaSach)
);

