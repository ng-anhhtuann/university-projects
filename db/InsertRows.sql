INSERT INTO Sach (TenSach, TacGia, NhaXuatBan, GiaNhap, GiaBan, SoLuongTon) VALUES
('Harry Potter và Hòn Đá Phù Thủy', 'J.K. Rowling', 'NXB Trẻ', 150000, 200000, 100),
('Đắc Nhân Tâm', 'Dale Carnegie', 'NXB Thanh Niên', 100000, 150000, 50),
('Cafe Cùng Tony', 'Tony Buổi Sáng', 'NXB Trẻ', 75000, 100000, 80),
('Đi Tìm Lẽ Sống', 'Đỗ Phước Tiến', 'NXB Văn Học', 85000, 120000, 120);

INSERT INTO KhachHang (TenKhachHang, DiaChi, Email, SoDienThoai) VALUES
('Nguyễn Văn A', '12 Nguyễn Văn A, Quận 1, TP.HCM', 'nguyenvana@gmail.com', '0901234567'),
('Trần Thị B', '25 Trần Quốc Thảo, Quận 3, TP.HCM', 'tranthib@gmail.com', '0902345678'),
('Lê Văn C', '49 Lê Lợi, Quận Gò Vấp, TP.HCM', 'levanc@gmail.com', '0903456789');

INSERT INTO NhanVien (TenNhanVien, DiaChi, Email, SoDienThoai, ChucVu) VALUES
('Nguyễn D', '123 Lê Lợi, Quận 1, TP.HCM', 'nguyenthid@gmail.com', '0904567890', 'Nhân viên bán hàng'),
('Trần Văn E', '456 Nguyễn Văn Linh, Quận 7, TP.HCM', 'tranvane@gmail.com', '0905678901', 'Quản lý kho'),
('Trần Phương', '5/1 NKKN, Quận 3, TP.HCM', 'tranf@gmail.com', '0905677351', 'Bảo vệ');
INSERT INTO NhapKho (NgayNhapKho, ThanhTien) VALUES
('2022-01-01', 1200000),
('2022-02-15', 1500000);

INSERT INTO HoaDon (MaKhachHang, NgayLap, TongTien, MaNhanVien) VALUES
(1, '2022-03-01', 250000, 1),
(2, '2022-03-02', 400000, 1),
(3, '2022-03-03', 300000, 1),
(2, '2022-03-04', 500000, 2);

INSERT INTO ChiTietNhapKho (MaNhapKho, MaSach, SoLuong, DonGia, ThanhTien) VALUES
(1, 1, 10, 100000, 1000000),
(1, 2, 5, 80000, 400000),
(2, 1, 15, 100000, 1500000),
(2, 3, 10, 70000, 700000);

INSERT INTO ChiTietHoaDon (MaHoaDon, MaSach, SoLuong, ThanhTien) VALUES
(1, 1, 2, 400000),
(1, 3, 3, 300000),
(2, 2, 2, 300000),
(2, 3, 4, 400000),
(3, 1, 3, 300000),
(4, 4, 4, 480000);























