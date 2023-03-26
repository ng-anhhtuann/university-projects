SELECT KhachHang.TenKhachHang, KhachHang.Email, SUM(HoaDon.TongTien) AS TongTienTra
FROM HoaDon
JOIN KhachHang ON HoaDon.MaKhachHang = KhachHang.MaKhachHang
GROUP BY HoaDon.MaKhachHang;
