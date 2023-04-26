#include <iostream>
#include <string>
#include <vector>

using namespace std;

class NhanVien {
private:
    string ten;
    int namSinh;
    string diaChi;
    string soDienThoai;
    string email;
    string ngayVaoLamViec;
    double heSoLuong;
    int soNgayNghi;

public:
    NhanVien(string ten, int namSinh, string diaChi, string soDienThoai, string email, string ngayVaoLamViec, double heSoLuong, int soNgayNghi) {
        this->ten = ten;
        this->namSinh = namSinh;
        this->diaChi = diaChi;
        this->soDienThoai = soDienThoai;
        this->email = email;
        this->ngayVaoLamViec = ngayVaoLamViec;
        this->heSoLuong = heSoLuong;
        this->soNgayNghi = soNgayNghi;
    }

    void tangHeSoLuong(double heSo) {
        this->heSoLuong += heSo;
    }

    void doiSoDienThoai(string soDienThoaiMoi) {
        this->soDienThoai = soDienThoaiMoi;
    }

    void xinNghiPhep(int soNgay) {
        this->soNgayNghi += soNgay;
    }

    string getTen() const {
        return ten;
    }

    int getNamSinh() const {
        return namSinh;
    }

    string getDiaChi() const {
        return diaChi;
    }

    double tinhLuong() const {
        return heSoLuong * 1000000;
    }

    void inThongTinChiTiet() const {
        cout << "Ten: " << ten << endl;
        cout << "Nam sinh: " << namSinh << endl;
        cout << "Dia chi: " << diaChi << endl;
        cout << "So dien thoai: " << soDienThoai << endl;
        cout << "Email: " << email << endl;
        cout << "Ngay vao lam viec: " << ngayVaoLamViec << endl;
        cout << "He so luong: " << heSoLuong << endl;
        cout << "So ngay nghi: " << soNgayNghi << endl;
        cout << "Luong: " << tinhLuong() << endl;
    }
};

int main(){
     vector<NhanVien> danhSachNhanVien;
    danhSachNhanVien.push_back(NhanVien("Nguyen Van A", 1990, "Ha Noi", "0987654321", "nva@gmail.com", "01/01/2010", 2.5, 5));
    danhSachNhanVien.push_back(NhanVien("Tran Thi B", 1995, "Ho Chi Minh", "0912345678", "ttb@gmail.com", "01/02/2010", 2.0, 3));
    danhSachNhanVien.push_back(NhanVien("Le Van C", 1988, "Da Nang", "0965432109", "lvc@gmail.com", "01/03/2010", 2.2, 2));
    danhSachNhanVien.push_back(NhanVien("Pham Thi D", 1992, "Hue", "0911111111", "ptd@gmail.com", "01/04/2010", 2.8, 1));
    danhSachNhanVien.push_back(NhanVien("Vo Van E", 1998, "Hai Phong", "0988888888", "vve@gmail.com", "01/05/2010", 2.4, 4));
    danhSachNhanVien.push_back(NhanVien("Dang Thi F", 1997, "Quang Ninh", "0934567890", "dtf@gmail.com", "01/06/2010", 2.3, 6));
    danhSachNhanVien.push_back(NhanVien("Do Van G", 1985, "Bac Giang", "0977777777", "dvg@gmail.com", "01/07/2010", 2.6, 0));
    danhSachNhanVien.push_back(NhanVien("Bui Thi H", 1994, "Thai Binh", "0944444444", "bth@gmail.com", "01/08/2010", 2.1, 3));
    danhSachNhanVien.push_back(NhanVien("Ngo Van I", 1993, "Nam Dinh", "0966666666", "nvi@gmail.com", "01/09/2010", 2.7, 2));
    danhSachNhanVien.push_back(NhanVien("Mai Thi K", 1996, "Hanoi", "0922222222", "mtk@gmail.com", "01/10/2010", 2.9, 1));

    
    cout << "Danh sach nhan vien: " << endl;
    for (int i = 0; i < danhSachNhanVien.size(); i++) {
        danhSachNhanVien[i].xinNghiPhep(2);
        danhSachNhanVien[i].inThongTinChiTiet();
        cout << "-----------------------------------------------------------" << endl;
    }

    return 0;
}