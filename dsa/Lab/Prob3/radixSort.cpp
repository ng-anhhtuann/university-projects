#include <iostream>
#include <fstream>
#define in "/Users/macad/Documents/Projects/university/dsa/Lab/Prob3/input.txt"
#define out "/Users/macad/Documents/Projects/university/dsa/Lab/Prob3/output.txt"
using namespace std;

void log( int a[], int n){
    for ( int i = 0 ; i < n ; i++ ){
        cout << a[i] << " ";
    }
    cout << "\n" ;
}

int max(int a[], int n){
    int max = a[0];
    for (int i = 1; i < n; i++) if (a[i] > max) max = a[i];
    return max;
}

void dem(int a[], int n, int tmp){
    int phu[n];
    int dem[10] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    // đếm số lượng phần tử chữ số đang xét
    for (int i = 0; i < n; i++) {
        int radix = (a[i] / tmp) % 10;
        dem[radix]++;
    }
    // tính tần số liền kề trước
    for (int i = 1; i < 10; i++) dem[i] += dem[i - 1];
    /*đặt các phần tử  vào vị trí đúng cuả nó và giảm tần số đi 1 lần
    mảng count lúc này với các remainder tương ứng là vị trí của nó theo 0 -> 9 là index, value là tần số
    */
    for (int i = n - 1; i >= 0; i--) {
        int radix = (a[i] / tmp) % 10;
        phu[dem[radix] - 1] = a[i];
        dem[radix]--;
    }
    for (int i = 0; i < n; i++) a[i] = phu[i];
}

void radixSort(int a[], int n) {
    int m = max(a, n);
    for (int i = 1; m / i > 0; i *= 10) dem(a, n, i);
}

int main() {
    ifstream file(in);
    int n;
    file >> n;
    int a[n];
    for ( int i = 0; i< n ; i++){
        file >> a[i];
    }
    file.close();
    log(a,n);
    radixSort(a,n);
    log(a,n);
    ofstream fileOut(out);
    for ( int i = 0; i < n; i++){
        fileOut << a[i] << " ";
    }
    fileOut.close();
    return 0;
}