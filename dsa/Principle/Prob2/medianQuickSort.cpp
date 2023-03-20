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

void Swap(int &a,int &b){
    int tmp = a;
    a = b;
    b = tmp;
}

void QuickSort(int a[], int l, int r)
{ 	
	int	i, j;
	if (l >= r)	return;
  	double x = a[(l+r)/2]; 
  	i = l; j = r;
  	 do{
     	while(a[i] < x) i++;
     	while(a[j] > x) j--;
     	if(i <= j) { 
			Swap(a[i], a[j]);
       	i++ ; j--;
	 	}
	} while(i < j) ;
	if(l<j) QuickSort(a, l, j);
	if(i<r) QuickSort(a, i, r);
}
void heapify(int a[], int n, int start){
    int l = start*2+1;
    int r = start*2+2;
    int large = start;
    if ( l < n && a[l] > a[large]) large = l;
    if ( r < n && a[r] > a[large]) large = r;
    if (large != start){
        Swap(a[large], a[start]);
        heapify(a,n,large);
    }
}
void heap( int a[], int n){
    for ( int i = n/2-1; i >= 0; i--){
        heapify(a,n,i);
    }
    for ( int i = n-1; i >= 0; i--){
        Swap(a[i], a[0]);
        heapify(a,i,0);
    }
}
int main() {
    int n = 10;

    int a[] = {43, 44, 9, -25, 28, 3, 32, -10, 10, 0};//Random Array
    
    // int b[] = {10, 9, 7, 5, 3, 1, -3, -5, -8, -17}; //Descending Sorted Array

    cout << "Array A before sort\n";
    log(a,n);
    cout << "Array A after sort: \n";
    QuickSort(a,0,n-1);
    // heap(a, n);
    log(a,n);

    // cout << "Array B before sort\n";
    // log(b,n);
    // cout << "Array B after quicksort: \n";
    // QuickSort(b,0,n-1);
    // log(b,n);

    return 0;
}

