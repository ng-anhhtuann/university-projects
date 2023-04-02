#include <iostream>
#include <fstream>
#define in "/Users/macad/Documents/Projects/university/dsa/Lab/Prob5/input.txt"
#define out "/Users/macad/Documents/Projects/university/dsa/Lab/Prob5/output.txt"
using namespace std;

struct Node {
    int data;
    Node* next;
};

void addAtTail(Node** head, int data){
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

void printList(Node* head) {
    Node* current = head;
    while (current != NULL) {
        cout << current->data << " ";
        current = current->next;
    }
    cout << endl;
}

void selectionSort(Node **head) {
    Node *a = *head, *b, *min;
    if (a == NULL)
        return;
    while (a->next != NULL) {
        min = a;
        b = a->next;
        while (b != NULL) {
            if (b->data < min->data)
                min = b;
            b = b->next;
        }
        if (min != a) {
            int t = min->data;
            min->data = a->data;
            a->data = t;
        }
        a = a->next;
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
    
    Node* head = NULL;
    for ( int i = 0; i < n; i++){
        addAtTail(&head, a[i]);
    }
    cout << "Mang truoc khi sap xep: \n";
    printList(head);
    selectionSort(&head);
    cout << "Mang sau khi sap xep: \n";
    printList(head);
    
    ofstream fileOut(out);
    Node* tmp = head;
    while ( tmp != NULL ){
        fileOut << tmp->data << " ";
        tmp = tmp->next;
    }
    fileOut.close();
    return 0;
}