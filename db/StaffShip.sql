SELECT NhanVien.TenNhanVien, NhanVien.DiaChi, NhanVien.SoDienThoai, 
       COUNT(ChiTietHoaDon.SoLuong) AS TongSoSach, SUM(ChiTietHoaDon.ThanhTien) AS TongTienBan
FROM NhanVien
INNER JOIN HoaDon ON NhanVien.MaNhanVien = HoaDon.MaNhanVien
INNER JOIN ChiTietHoaDon ON HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon
GROUP BY NhanVien.TenNhanVien, NhanVien.DiaChi, NhanVien.SoDienThoai;
