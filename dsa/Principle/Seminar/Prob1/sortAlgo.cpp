/**
 * @file main.cpp
 * @author ng-anhhtuann (github)
 * @brief 
 * @version 0.1
 * @date 2023-03-19
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <iostream>
#include <string>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <chrono>
#include <time.h>

using namespace std;

int a[] = {1,5,2,3,25,1,3,5,6,34,2,3,7,345,123,5,42};
int b[] = {1,5,2,3,25,1,3,5,6,34,2,3,7,345,123,5,42};
int n = 17;

/**
 * @brief print array
 * 
 * @param a 
 * @param n 
 */

void log(int a[], int n){
    for ( int i = 0; i < n; i++ ){
        cout << a[i] << " ";
    }
    cout << endl;
}

/**
 * @brief swap a & b
 * 
 * @param a 
 * @param b 
 */

void swap(int &a,int &b){
    int tmp = a;
    a = b;
    b = tmp;
}

/**
 * @brief Merge array supports merge sort and natural merge sort
 * 
 * @param a 
 * @param o 
 * @param m 
 * @param r 
 */

void merge(int a[], int o, int m, int r) {
    int i, j, k;
    int n1 = m - o + 1;
    int n2 = r - m;
    int L[n1], R[n2];
    for (i = 0; i < n1; i++) L[i] = a[o + i];
    for (j = 0; j < n2; j++) R[j] = a[m + 1 + j];
    i = 0; j = 0; k = o;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            a[k] = L[i];
            i++;
        } else {
            a[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1) {
        a[k] = L[i];
        i++; k++;
    }
    while (j < n2) {
        a[k] = R[j];
        j++; k++;
    }
}

/**
 * @brief Merge sort without recursion
 * 
 * @param a 
 * @param n 
 */

void mergeSort(int a[], int n) {
    int size;
    int start;
    for (size = 1; size <= n-1; size = 2*size) {
        for (start = 0; start < n-1; start += 2*size) {
            int m = min(start + size - 1, n-1);
            int re = min(start + 2*size - 1, n-1);
            merge(a, start, m, re);
        }
    }
}

/**
 * @brief Merge array supports merge sort with log
 * 
 * @param a 
 * @param o 
 * @param m 
 * @param r 
 */

void mergeWithLog(int a[], int o, int m, int r) {
    int i, j, k;
    int n1 = m - o + 1;
    int n2 = r - m;
    int L[n1], R[n2];
    for (i = 0; i < n1; i++) L[i] = a[o + i];
    for (j = 0; j < n2; j++) R[j] = a[m + 1 + j];
    i = 0; j = 0; k = o;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            a[k] = L[i];
            i++;
        } else {
            a[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1) {
        a[k] = L[i];
        i++; k++;
    }
    while (j < n2) {
        a[k] = R[j];
        j++; k++;
    }
    cout << "Left arr: "; log(L,n1);
    cout << "Right arr: "; log(R,n2);
    cout << "Array: "; log(a,n);
    cout << "-------------------------------------------\n";
}

/**
 * @brief Merge sort without recursion with log
 * 
 * @param a 
 * @param n 
 */

void mergeSortWithLog(int a[], int n) {
    int size;
    int start;
    cout << "Thu tu mang moi lan merge: \n";
    for (size = 1; size <= n-1; size = 2*size) {
        for (start = 0; start < n-1; start += 2*size) {
            int m = min(start + size - 1, n-1);
            int re = min(start + 2*size - 1, n-1);
            mergeWithLog(a, start, m, re);
        }
    }
}


/**
 * @brief Natural merge sort
 * 
 * @param a 
 * @param n 
 */

void naturalMergeSort(int a[], int n) {
    bool check = true;
    int l = 0, r = 0, m = 0;
    cout << "Thu tu mang moi lan merge: \n";
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

/**
 * @brief Natural merge sort with log
 * 
 * @param a 
 * @param n 
 */

void naturalMergeSortWithLog(int a[], int n) {
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
                mergeWithLog(a, l, r - 1, m - 1);
                l = m;
                check = true;
            } else {
                l = r;
            }
        }
    }
}

/**
 * @brief Quick sort
 * 
 * @param a 
 * @param l 
 * @param r 
 */

void QuickSort(int a[], int l, int r){ 	
	int	i, j;
	if (l >= r)	return;
  	int x = a[(l+r)/2];
  	i = l; j = r;
  	 do{
     	while(a[i] < x) i++;
     	while(a[j] > x) j--;
     	if(i <= j) { 
			swap(a[i], a[j]);
       	i++ ; j--;
	 	}
	} while(i < j) ;
	if(l<j) QuickSort(a, l, j);
	if(i<r) QuickSort(a, i, r);
}

/**
 * @brief Quick sort with log
 * 
 * @param a 
 * @param l 
 * @param r 
 */

void QuickSortWithLog(int a[], int l, int r){ 	
	int	i, j;
	if (l >= r)	return;
  	int x = a[(l+r)/2];
  	i = l; j = r;
  	do{
     	while(a[i] < x) i++;
     	while(a[j] > x) j--;
     	if(i <= j) { 
			swap(a[i], a[j]);
       	i++ ; j--;
	 	}
	} while(i < j) ;
    cout << "Pivot: " << x << "\n";
    log(a,n);
    cout << "-------------------------------------------\n";
	if(l<j) QuickSortWithLog(a, l, j);
	if(i<r) QuickSortWithLog(a, i, r);
}


/**
 * @brief heapify creates max heap 
 * 
 * @param a 
 * @param n 
 * @param start 
 */

void heapify(int a[], int n, int start){
    int l = start*2+1;
    int r = start*2+2;
    int large = start;
    if ( l < n && a[l] > a[large]) large = l;
    if ( r < n && a[r] > a[large]) large = r;
    if (large != start){
        swap(a[large], a[start]);
        heapify(a,n,large);
    }
}

/**
 * @brief Heap sort
 * 
 * @param a 
 * @param n 
 */

void heapSort( int a[], int n){
    for ( int i = n/2-1; i >= 0; i--){
        heapify(a,n,i);
    }
    for ( int i = n-1; i >= 0; i--){
        swap(a[i], a[0]);
        heapify(a,i,0);
    }
}

/**
 * @brief heapify creates max heap 
 * 
 * @param a 
 * @param n 
 * @param start 
 */

void heapifyWithLog(int a[], int n, int start){
    int l = start*2+1;
    int r = start*2+2;
    int large = start;
    if ( l < n && a[l] > a[large]) large = l;
    if ( r < n && a[r] > a[large]) large = r;
    if (large != start){
        swap(a[large], a[start]);
        heapify(a,n,large);
    }
}

/**
 * @brief Heap sort
 * 
 * @param a 
 * @param n 
 */

void heapSortWithLog( int a[], int n){
    for ( int i = n/2-1; i >= 0; i--){
        heapify(a,n,i);
    }
    cout << "Mang sau khi tao max heap: ";
    log(a,n);
    cout << "Thu tu mang sau khi swap lan luot voi max heap: \n";
    for ( int i = n-1; i >= 0; i--){
        swap(a[i], a[0]);
        heapify(a,i,0);
        cout << "Max heap = " << a[0] << " \n";
        log(a,n);
        cout << "-------------------------------------------\n";
    }
}

/**
 * @brief Get the Max value in array
 * 
 * @param a 
 * @param n 
 * @return int 
 */

int getMax(int a[], int n)
{
    int max = a[0];
    for (int i = 1; i < n; i++){
        if (a[i] > max) max = a[i];
    }
    return max;
}

/**
 * @brief Counting sort of arr according to the digit represented by exp.
 * 
 * @param a 
 * @param n 
 * @param exp 
 */

void count(int a[], int n, int exp)
{
    int output[n];
    int i, count[10] = { 0 };
    // Calculate count of elements
    for (i = 0; i < n; i++) count[(a[i] / exp) % 10]++;
    // Calculate cumulative count
    for (i = 1; i < 10; i++) count[i] += count[i - 1];
    // Place the elements in sorted order
    for (i = n - 1; i >= 0; i--) {
        output[count[(a[i] / exp) % 10] - 1] = a[i];
        count[(a[i] / exp) % 10]--;
    }
    for (i = 0; i < n; i++) a[i] = output[i];
}

/**
 * @brief Radix sort
 * 
 * @param a 
 * @param n 
 */

void radixSort(int a[], int n) {
    int m = getMax(a, n);
    for (int i = 1; m / i > 0; i *= 10) count(a, n, i);
}

/**
 * @brief Counting sort of arr according to the digit represented by exp.
 * 
 * @param a 
 * @param n 
 * @param exp 
 */

void countWithLog(int a[], int n, int exp)
{
    int output[n];
    int i, count[10] = { 0 };
    // Calculate count of elements
    for (i = 0; i < n; i++) count[(a[i] / exp) % 10]++;
    // Calculate cumulative count
    for (i = 1; i < 10; i++) count[i] += count[i - 1];
    // Place the elements in sorted order
    for (i = n - 1; i >= 0; i--) {
        output[count[(a[i] / exp) % 10] - 1] = a[i];
        count[(a[i] / exp) % 10]--;
    }
    for (i = 0; i < n; i++) a[i] = output[i];
    cout << "Mang dem: ";
    log(count, 10);
    log(a,n);
    cout << "-------------------------------------------\n";
}

/**
 * @brief Radix sort
 * 
 * @param a 
 * @param n 
 */

void radixSortWithLog(int a[], int n) {
    int m = getMax(a, n);
    cout << "Gia tri lon nhat trong mang = " << m << endl;
    cout << "Mang sau moi lan thuc hien dem: \n";
    for (int i = 1; m / i > 0; i *= 10) countWithLog(a, n, i);
}

int main(){
    int sort;
    cout << "-------------------------------------------\n";
    cout << "(1) QuickSort \n";
    cout << "(2) MergeSort \n";
    cout << "(3) NaturalMergeSort \n";
    cout << "(4) HeapSort \n";
    cout << "(5) RadixSort \n";
    cout << "-------------------------------------------\n";
    cout << "Chon thuat toan muon dung de sap xep mang: ";
    cin >> sort;
    cout << "-------------------------------------------\n";
    while ( sort >= 6 || sort <= 0){
        cout << "Vui long nhap lai option tu 1 -> 5: ";
        cin >> sort;
        cout << "-------------------------------------------\n";
    }
    clock_t start = clock();
   
    switch (sort){
        case 1: {
            cout << "Thuat toan Quick Sort: \n"; 
            cout << "Mang truoc khi sap xep: "; log(a,n); 
            QuickSort(a,0,n-1); 
            int time = clock() - start;
            cout << "Thu tu mang moi lan swap vi tri pivot: \n";
            QuickSortWithLog(b,0,n-1); 
            cout << "Mang sau khi sap xep: ";
            log(a,n);
            cout << "Time complex: " << time << " ms\n";
            cout << "-------------------------------------------\n";
            break;
        }
        case 2: {
            cout << "Thuat toan Merge Sort: \n"; 
            cout << "Mang truoc khi sap xep: "; log(a,n); 
            mergeSort(a,n); 
            int time = clock() - start;
            mergeSortWithLog(b,n); 
            cout << "Mang sau khi sap xep: ";
            log(a,n);
            cout << "Time complex: " << time << " ms\n";
            cout << "-------------------------------------------\n";
            break;
        }
        case 3: {
            cout << "Thuat toan Natural Merge Sort: \n"; 
            cout << "Mang truoc khi sap xep: "; log(a,n); 
            naturalMergeSort(a,n); 
            int time = clock() - start;
            naturalMergeSortWithLog(b,n);
            cout << "Mang sau khi sap xep: ";
            log(a,n);
            cout << "Time complex: " << time << " ms\n";
            cout << "-------------------------------------------\n";
            break;
        }
        case 4: {
            cout << "Thuat toan Heap Sort: \n"; 
            cout << "Mang truoc khi sap xep: "; log(a,n);
            heapSort(a,n); 
            int time = clock() - start;
            heapSortWithLog(b,n); 
            cout << "Mang sau khi sap xep: ";
            log(a,n);
            cout << "Time complex: " << time << " ms\n";
            cout << "-------------------------------------------\n";
            break;
        }
        case 5: {
            cout << "Thuat toan Radix Sort: \n"; 
            cout << "Mang truoc khi sap xep: "; log(a,n); 
            radixSort(a,n); 
            int time = clock() - start;
            radixSortWithLog(b,n); 
            cout << "Mang sau khi sap xep: ";
            log(a,n);
            cout << "Time complex: " << time << " ms\n";
            cout << "-------------------------------------------\n";
            break;
        }
    }
    return 0;
}