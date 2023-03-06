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

void QuickSort(int a[], int left, int right)
{ 	
	int	i, j;
	if (left >= right)	return;
  	double x = (a[left] + a[right])/2; 
  	i = left; j = right;
  	 do{
     	while(a[i] < x) i++;
     	while(a[j] > x) j--;
     	if(i <= j) { 
			Swap(a[i], a[j]);
       	i++ ; j--;
	 	}
	} while(i < j) ;
	if(left<j) QuickSort(a, left, j);
	if(i<right) QuickSort(a, i, right);
}
int main() {
    int n = 10;

    int a[] = {10, 17, 9, -33, 28, 4, 35, -10, 38, 7};//Random Array
    
    int b[] = {10, 9, 7, 5, 3, 1, -3, -5, -8, -17}; //Descending Sorted Array

    cout << "Array A before sort\n";
    log(a,n);
    cout << "Array A after quicksort: \n";
    QuickSort(a,0,n-1);
    log(a,n);

    cout << "Array B before sort\n";
    log(b,n);
    cout << "Array B after quicksort: \n";
    QuickSort(b,0,n-1);
    log(b,n);

    return 0;
}