#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

void swapNodes(Node* a, Node* b) {
    int temp = a->data;
    a->data = b->data;
    b->data = temp;
}

void interchangeSort(Node* head) {
    Node* p = head;
    while (p->next) {
        Node* q = p->next;
        while (q) {
            if (p->data > q->data) {
                swapNodes(p, q);
            }
            q = q->next;
        }
        p = p->next;
    }
}

void bubbleSort(Node* head) {
    bool swapped;
    Node* p;
    Node* q = NULL;
    do {
        swapped = false;
        p = head;
        while (p->next != q) {
            if (p->data > p->next->data) {
                swapNodes(p, p->next);
                swapped = true;
            }
            p = p->next;
        }
        q = p;
    } while (swapped);
}

void insertNodeAtTail(Node** head, int data) {
    Node* newNode = new Node();
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}

void insertNodeAtHead(Node** head, int data) {
    Node* newNode = new Node();
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}

void insertNodeAtIndex(Node** head, int index, int data) {
    Node* newNode = new Node();
    newNode->data = data;
    Node* currentNode = *head;
    for (int i = 0; i < index - 1; i++) {
        if (currentNode == NULL) {
            cerr << "Error: Index out of bounds" << endl;
            return;
        }
        currentNode = currentNode->next;
    }
    newNode->next = currentNode->next;
    currentNode->next = newNode;
}

void printList(Node* node) {
    while (node) {
        cout << node->data << " ";
        node = node->next;
    }
    cout << endl;
}

int main() {
    Node* head = NULL;
    insertNodeAtTail(&head, 5);
    insertNodeAtTail(&head, 3);
    insertNodeAtTail(&head, 8);
    insertNodeAtTail(&head, 1);
    insertNodeAtTail(&head, 6);

    cout << "Original List: ";
    printList(head);

    bubbleSort(head);

    cout << "Sorted List: ";
    printList(head);

    return 0;
}
