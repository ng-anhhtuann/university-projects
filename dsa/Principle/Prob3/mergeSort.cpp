/**
 * @file mergeSort.cpp
 * @author ng-anhhtuann (nguyenanhtuan1232@gmail.com)
 * @brief 
 * @version 0.1
 * @date 2023-03-14
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <iostream>
using namespace std;

void log(int a[], int n) {
    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

void merge(int a[], int l[], int r[], int m, int n) {
    int i = 0, j = 0, k = 0;
    while (i < m && j < n){
        if (l[i] < r[j]){
            a[k] = l[i];
            i++;
        } else {
            a[k] = r[j];
            j++;
        }
        k++;
    }
    while ( i < m ) {
        a[k] = l[i];
        i++; k++;
    }
    while ( j < n ){
        a[k] = r[j];
        j++; k++;
    }
}

void mergeSort(int a[], int n) {
    if (n < 2) return;
    int m = n/2;
    int l[m];
    int r[n-m];
    for ( int i = 0 ; i < m; i++) l[i] = a[i];
    for ( int i = m ; i < n; i++) r[i-m] = a[i];
    mergeSort(l,m); mergeSort(r,n-m);
    merge(a,l,r,m,n-m);
}

int main() {
    int n = 10;
    int a[] = {43, 44, 9, -25, 28, 3, 32, -10, 10, 0};
    cout << "Array A before sort\n";
    log(a,n);
    cout << "Array A after sort: \n";
    mergeSort(a,n);
    log(a,n);
    return 0;
}
