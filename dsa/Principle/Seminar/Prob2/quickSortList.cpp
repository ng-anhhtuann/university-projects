/**
 * @file quickSortList.cpp
 * @author ng-anhhtuann (github.com)
 * @brief 
 * @version 0.1
 * @date 2023-03-21
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <iostream>

using namespace std;

struct Node {
    int data;
    Node* next;
};

class Stack {
public:
    Node* top; 

public:
    Stack() {
        top = nullptr;
    }
    void push(int value) {
        Node* newNode = new Node;
        newNode->data = value;
        newNode->next = top;
        top = newNode;
    }
    void pop() {
        if (isEmpty()) {
            throw "Stack is empty!";
        }
        Node* temp = top;
        top = top->next;
        delete temp;
    }
    Node* topNode() {
        if (isEmpty()) {
            throw "Stack is empty!";
        }
        Node* tmp = new Node();
        tmp->data = top->data;
        tmp->next = NULL;
        return tmp;
    }
    bool isEmpty() {
        return top == nullptr;
    }
    void print() {
        Node* tmp = top;
        while (tmp != nullptr) {
            cout << tmp->data << " ";
            tmp = tmp->next;
        }
        cout << endl;
    }
};

void addTail(Node** head, int data){
    Node* node = new Node();
    node->data = data;
    node->next = NULL;
    if (*head == NULL) {
        *head = node;
    } else {
        Node* tmp = *head;
        while (tmp->next != NULL) {
            tmp = tmp->next;
        }
        tmp->next = node;
    }
}

int count(Node** head){
    int size = 0;
    Node* tmp = *head;
    while (tmp != NULL){
        size++;
        tmp = tmp->next;
    }
    return size;
}

int get(Node** head, int pos){
    int cnt = 0;
    int size = count(head);
    if ( pos >= size ) throw "Out of bound";
    for ( Node* tmp = *head; cnt <= pos; tmp = tmp->next){
        if ( cnt == pos) return tmp->data;
        cnt++;
    }
    return -1;
}

void swapNodeAtIndex(Node** head, int i, int j) {
    if (*head == nullptr || i == j) {
        return;
    }
    Node* a = nullptr;
    Node* b = nullptr;
    Node* tmp = *head;
    int index = 0;
    while (tmp != nullptr) {
        if (index == i) {
            a = tmp;
        } else if (index == j) {
            b = tmp;
        }
        tmp = tmp->next;
        ++index;
    }
    if (a == nullptr || b == nullptr) {
        return;
    }
    int temp = a->data;
    a->data = b->data;
    b->data = temp;
}

void QuickSort(Node** head, int l, int r){
    Node* a = *head;
    Stack sl, sr;
    sl.push(l); sr.push(r);
    while (!sl.isEmpty()){
        l = sl.topNode()->data; sl.pop();
        r = sr.topNode()->data; sr.pop();
        int mid = (l+r)/2;
        int x = get(&a,mid);
        int i = l, j = r;
        while (i <= j){
            while(get(&a,i) < x) i++;
            while(get(&a,j) > x) j--;
            if (i <= j){
                if ( i < j ) swapNodeAtIndex(&a,i,j);
                i++; j--;
            }
        }
        if (l < j) {
            sl.push(l); sr.push(j);
        }
        if (i < r) {
            sl.push(i); sr.push(r);
        }
    }
    return;
}

void logNode(Node* head){
    Node* tmp = head;
    while (tmp != NULL){
        cout << tmp->data << " ";
        tmp = tmp->next;
    }
    cout << endl;
}

int main() {
    Node* head = NULL;
    addTail(&head, 5); 
    addTail(&head, 15); 
    addTail(&head, 18); 
    addTail(&head, 45); 
    addTail(&head, 2);
    addTail(&head, 18); 
    addTail(&head, 45); 
    addTail(&head, 2);
    int n = count(&head);

    cout << "Danh sach lien ket truoc khi sap xep: \n";
    logNode(head);
    QuickSort(&head,0,n-1);
    cout << "Danh sach lien ket sau khi sap xep: \n";
    logNode(head);

    return 0;
}
