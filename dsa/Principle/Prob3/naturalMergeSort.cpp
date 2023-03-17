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

#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

void log(int a[], int n) {
    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

void merge(int a[], int l, int m, int r) {
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = r - m;
    int L[n1], R[n2];
    for (i = 0; i < n1; i++) L[i] = a[l + i];
    for (j = 0; j < n2; j++) R[j] = a[m + 1 + j];
    i = 0;
    j = 0;
    k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            a[k] = L[i];
            i++;
        }
        else {
            a[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1) {
        a[k] = L[i];
        i++;
        k++;
    }
    while (j < n2) {
        a[k] = R[j];
        j++;
        k++;
    }
}

void naturalMergeSort(int a[], int n) {
    bool check = true;
    int l = 0, r = 0, m = 0;
    while (check) {
        check = false;
        l = 0;
        while (l < n) {
            r = l + 1;
            while (r < n && a[r] >= a[r-1]) {
                r++;
            }
            if (r < n) {
                m = r + 1;
                while (m < n && a[m] >= a[m-1]) {
                    m++;
                }
                merge(a, l, r - 1, m - 1);
                l = m;
                check = true;
            } else {
                l = r;
            }
        }
    }
}

int main() {
    int n = 10;
    int a[] = {43, 44, 9, -25, 28, 3, 32, -10, 10, 0};
    cout << "aay A before sort\n";
    log(a,n);
    cout << "aay A after sort: \n";
    naturalMergeSort(a,n);
    log(a,n);
    return 0;
}

