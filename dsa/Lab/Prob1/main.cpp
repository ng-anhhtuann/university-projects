#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

void swap(int &a, int &b){
    int tmp = a;
    a = b;
    b = tmp;
}

void log(int a[], int n){
    for ( int i = 0; i < n; i++){
        cout << a[i] << " ";
    }
    cout << "\n";
}

int linearSearch(int a[], int n, int t){
    for ( int i = 0; i < n; i++){
        if (a[i] == t){
            return i;
        }
    }
    return -1;
}

int binarySearch(int a[], int n, int t){
    int l = n-1;
    int r = 0;
    while ( l < n){
        int m = (l+r)/2;
        if ( a[m] == t ) return m;
        if ( a[m] < t) l = m+1;
        if ( a[m] > t) r = m-1;
    }
    return -1;
}

void bubbleSort(int a[], int n){
    for ( int i = 0 ; i < n; i++){
        for ( int j = n-1; j >= i; j-- ){
            if ( a[j] < a[j-1]) {
                swap(a[j],a[j-1]);
            }
        }
    }
}

int main(){
    ifstream inp;
    inp.open("/Users/macad/Documents/University/6th term/Datastructure and Algorithm/Practice/Prob1/input.txt");

    int n;
    inp >> n;
    int a[n];
    
    for(int i = 0;i < n;i++) inp >> a[i];
    
    inp.close();
   
    int t;
    cout << "Nhap so can tim kiem: "; 
    cin >> t;

    string linearString = "Linear Search answer: ";
    string binaryString = "Binary Search answer: ";

    int linearAns = linearSearch(a,n,t);
    bubbleSort(a,n);
    log(a,n);
    int binaryAns = binarySearch(a,n,t);

    ofstream out;
    out.open("/Users/macad/Documents/University/6th term/Datastructure and Algorithm/Practice/Prob1/output.txt");
    out << linearString << linearAns << "\n";
    out << binaryString << binaryAns << "\n";

    out.close();
    return 0;
}
