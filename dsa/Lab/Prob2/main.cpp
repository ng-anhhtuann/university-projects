#include <iostream>
#include <fstream>
#define in "/Users/macad/Documents/Projects/university/dsa/Lab/Prob2/input.txt"
#define out "/Users/macad/Documents/Projects/university/dsa/Lab/Prob2/output.txt"
using namespace std;

void log( int a[], int n){
    for ( int i = 0 ; i < n ; i++ ){
        cout << a[i] << " ";
    }
    cout << "\n" ;
}

void merge(int arr[], int o, int m, int r) {
    int i, j, k;
    int n1 = m - o + 1;
    int n2 = r - m;
 
    int L[n1], R[n2];
 
    for (i = 0; i < n1; i++)
        L[i] = arr[o + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1 + j];
 
    i = 0; j = 0; k = o;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        }
        else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
 
    while (i < n1) {
        arr[k] = L[i];
        i++; k++;
    }
    while (j < n2) {
        arr[k] = R[j];
        j++; k++;
    }
}
 
void mergeSort(int arr[], int n) {
    int curr_size;
    int left_start;

    for (curr_size = 1; curr_size <= n-1; curr_size = 2*curr_size) {
        for (left_start = 0; left_start < n-1; left_start += 2*curr_size) {
            int mid = min(left_start + curr_size - 1, n-1);
            int right_end = min(left_start + 2*curr_size - 1, n-1);
            merge(arr, left_start, mid, right_end);
        }
    }
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
    mergeSort(a,n);
    log(a,n);
    ofstream fileOut(out);
    for ( int i = 0; i < n; i++){
        fileOut << a[i] << " ";
    }
    fileOut.close();
    return 0;
}