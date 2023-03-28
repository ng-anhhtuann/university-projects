/**
 * @file doublyLinkedList.cpp
 * @author ng-anhhtuann (github.com)
 * @brief 
 * @version 0.1
 * @date 2023-03-27
 * 
 * @copyright Copyright (c) 2023
 * 
 */

#include <iostream>
using namespace std;

struct Node {
    int data;
    Node *prev;
    Node *next;
};

void insertNodeAtTail(Node** head, int data) {
    Node* newNode = new Node();
    newNode->data = data;
    newNode->prev = nullptr;
    newNode->next = nullptr;
    if (*head == nullptr) {
        *head = newNode;
    } else {
        Node* current = *head;
        while (current->next != nullptr) {
            current = current->next;
        }
        current->next = newNode;
        newNode->prev = current;
    }
}

int dataAtIndex(Node** head, int idx){
    int pos = 0;
    Node* tmp = *head;
    while ( pos != idx ){
        tmp=tmp->next;
        pos++;
    }
    return tmp->data;
}

void changeDataAtIndex(Node** head, int idx, int data){
    int pos = 0;
    Node* tmp = *head;
    while ( pos != idx ){
        tmp=tmp->next;
        pos++;
    }
    tmp->data = data;
}

void merge(Node** head, int l, int m, int r) {
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = r - m;
    Node *L = NULL, *R = NULL;
    for (i = 0; i < n1; i++) insertNodeAtTail(&L,dataAtIndex(head, l+i));
    for (j = 0; j < n2; j++) insertNodeAtTail(&R,dataAtIndex(head, m + 1 + j));
    i = 0; j = 0; k = l;
    while (i < n1 && j < n2) {
        if (dataAtIndex(&L,i) <= dataAtIndex(&R,j)) {
            changeDataAtIndex(head,k,dataAtIndex(&L,i));
            i++;
        } else {
            changeDataAtIndex(head,k,dataAtIndex(&R,j));
            j++;
        }
        k++;
    }
    while (i < n1) {
        changeDataAtIndex(head,k,dataAtIndex(&L,i));
        i++; k++;
    }
    while (j < n2) {
        changeDataAtIndex(head,k,dataAtIndex(&R,j));
        j++; k++;
    }
}

void mergeSort(Node** head, int n) {
    for (int i = 1; i <= n-1; i = 2*i) {
        for (int j = 0; j < n-1; j += 2*i) {
            int m = min(j + i - 1, n-1);
            int re = min(j + 2*i - 1, n-1);
            merge(head, j, m, re);
        }
    }
}

int sizeOfNode(Node** head){
    int res = 0;
    Node* tmp = *head;
    while (tmp != NULL){
        res++;
        tmp=tmp->next;
    }
    return res;
}

void log(Node* head) {
    Node* current = head;
    while (current != NULL) {
        cout << current->data << " ";
        current = current->next;
    }
    cout << endl;
}

int main() {
    Node* head = NULL;
    insertNodeAtTail(&head, 7);
    insertNodeAtTail(&head, 3);
    insertNodeAtTail(&head, 9);
    insertNodeAtTail(&head, 5);
    insertNodeAtTail(&head, 1);
    insertNodeAtTail(&head, 8);
    
    cout << "Danh sach truoc khi sort: \n";
    log(head);
    mergeSort(&head,sizeOfNode(&head));
    cout << "Danh sach sau khi sort: \n";
    log(head);
    return 0;
}