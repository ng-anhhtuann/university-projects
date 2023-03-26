SELECT Sach.TenSach, SUM(ChiTietNhapKho.SoLuong) AS TongSoSachNhapKho, SUM(ChiTietNhapKho.ThanhTien) AS TongTienNhapKho
FROM Sach
JOIN ChiTietNhapKho ON Sach.MaSach = ChiTietNhapKho.MaSach
GROUP BY Sach.MaSach;
