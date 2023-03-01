#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include <iostream>
using namespace std;
/*
Khai bao object student voi cac thuoc tinh phu hop <ten,dtb>
*/
class student {
public:
    string studentName;
    double studentAvg;
};
/*
Khai bao object classRoom voi cac thuoc tinh phu hop <ten,soluong,dsachSv>
*/
class classRoom {
public:
    string className;
    int classAmount;
    vector<student> classMember;
};

/*
Xuat ra man hinh thong tin lop hoc day du
*/

void logClassRoom(classRoom a){
    cout << "Lop " << a.className << " co " << a.classAmount << " sinh vien.\n";
    cout << "Cac sinh vien cua lop la: \n";
    vector<student> ds = a.classMember;
    for (student i : ds ){
        cout << "Ten: " << i.studentName << "\t Diem trung binh: " << i.studentAvg << "\n";
    }
}

/*
Xuat ra man hinh thong tin lop hoc rut gon
*/

void logClassRoomShorten(classRoom a, string standard){
    cout << "Lop " << a.className << " la lop co " << standard << " sinh vien nhat voi si so " << a.classAmount << " sinh vien.\n";
}

int classManagement(){
    int number; 
    vector<classRoom> arrOfClass;
    /*
    Vector chua cac lop co 5 hoc sinh DTB loai gioi
    */
    vector<classRoom> classHFGS;
    /*
    Bien max nhan so luong sinh vien nhieu nhat
    Object classHMS nhan du lieu lop hoc tuong ung
    */
    int max = 0;
    classRoom classHMS;
    /*
    Bien min nhan so luong sinh vien it nhat
    Object classHLS nhan du lieu lop hoc tuong ung
    */
    int min = 10000;
    classRoom classHLS;
    /*
    Object studentHMA la sinh vien co diem trung binh cao nhat
    Ten lop hoc tuong ung cua sinh vien do
    Diem so tuong ung cua sinh vien
    */
    student studentHMA;
    string classOfStudentHMA;
    double highestAvg = 0;  
    /*
    Object classHMGS la lop co so luong sv DTB gioi nhieu nhat
    Bien tmp de so sanh trong qua trinh chen du lieu
    */
    classRoom classHMGS;
    int tmp = 0;

    cout << "===================================================================\n";
    cout << "Nhap so luong lop hoc: "; cin >> number;
    cout << "Moi ban nhap cac thong tin can thiet cho mot lop hoc\n";
    /*
    Nhap vao danh sach cac lop voi thong tin nhu yeu cau
    */
    for ( int i = 0; i < number; i++ ){
        cout << "===================================================================\n";
        classRoom myClass;
        cout << "Ten lop:"; cin >> myClass.className; cout << "\n";
        cout << "Si so:"; cin >> myClass.classAmount; cout << "\n";
        cout << "Moi ban nhap cac thong tin cua " << myClass.classAmount << " sinh vien\n";

        if ( myClass.classAmount > max){
            max = myClass.classAmount;
            classHMS = myClass;
        } 
        if ( myClass.classAmount < min){
            min = myClass.classAmount;
            classHLS = myClass;
        } 

        vector<student> hs;
        int count = 0;
        for ( int j = 0 ; j < myClass.classAmount; j++){
            student student;

            cout << "Ten sinh vien thu " << j+1 << " la : "; cin >> student.studentName; cout << "\n";
            cout << "Diem trung binh cua sinh vien thu " << j+1 << " la : "; cin >> student.studentAvg; cout << "\n";
            while ( student.studentAvg > 10){
                cout << "Moi ban nhap lai diem cua sinh vien cho hop le: "; cout << "\n";
                cin >> student.studentAvg;
            }
            if (student.studentAvg >= 8) count++;
            if (student.studentAvg > highestAvg){
                highestAvg = student.studentAvg;
                studentHMA = student;
                classOfStudentHMA = myClass.className;
            } 
            hs.push_back(student);
        }
        myClass.classMember = hs; 
        if (count >= 5 ) classHFGS.push_back(myClass);
        if ( count >= tmp) {
            tmp = count;
            classHMGS = myClass;
        }
        arrOfClass.push_back(myClass);
    }

    /*
    Danh sach cac lop co tren 5 sinh vien co diem trung binh loai gioi
    */
    cout << "===================================================================\n";
    cout << "Cac lop co tren 5 sinh vien co DTB loai gioi la: \n";
    for ( classRoom i : classHFGS){
        logClassRoom(i);
    }
    /*
    Hien thi lop co nhieu va co it sinh vien nhat
    */
    cout << "===================================================================\n";
    logClassRoomShorten(classHLS, "it");
    cout << "===================================================================\n";
    logClassRoomShorten(classHMS, "nhieu");
    /*
    Hien thi sinh vien co diem trung binh cao nhat
    */
    cout << "===================================================================\n";
    cout << "Sinh vien co diem trung binh cao nhat la: " << studentHMA.studentName << " voi diem trung binh la " << studentHMA.studentAvg << " den tu lop " << classOfStudentHMA << " \n";
    /*
    Hien thi lop co so luong sinh vien dat DTB loai gioi nhieu nhat
    */
    cout << "===================================================================\n";
    cout << "Lop co so luong sinh vien dat DTB loai gioi nhieu nhat la " << classHMGS.className << " voi si so " << classHMGS.classAmount << "\nSo luong sinh vien duoc DTB loai gioi la " << tmp << "\n"; 
    cout << "===================================================================";
    return 0;
}