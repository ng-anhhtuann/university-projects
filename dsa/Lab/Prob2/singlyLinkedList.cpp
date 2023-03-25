#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <stack>

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

void selectionSort(Node **head) {
    Node *nodeA = *head, *nodeB, *min;
    if (nodeA == NULL)
        return;
    while (nodeA->next != NULL) {
        min = nodeA;
        nodeB = nodeA->next;
        while (nodeB != NULL) {
            if (nodeB->data < min->data)
                min = nodeB;
            nodeB = nodeB->next;
        }
        if (min != nodeA) {
            int t = min->data;
            min->data = nodeA->data;
            nodeA->data = t;
        }
        nodeA = nodeA->next;
    }
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

Node* getLastNode(Node* head) {
    Node* current = head;
    while (current->next != NULL) {
        current = current->next;
    }
    return current;
}

void swap(Node* a, Node* b) {
    int temp = a->data;
    a->data = b->data;
    b->data = temp;
}

Node* partition(Node* head, Node* end, Node** newHead, Node** newEnd) {
    Node* pivot = end;
    Node* prev = NULL, *current = head, *tail = pivot;

    while (current != pivot) {
        if (current->data < pivot->data) {
            if (*newHead == NULL) {
                *newHead = current;
            }
            prev = current;
            current = current->next;
        }
        else {
            if (prev) {
                prev->next = current->next;
            }
            Node* temp = current->next;
            current->next = NULL;
            tail->next = current;
            tail = current;
            current = temp;
        }
    }

    if (*newHead == NULL) {
        *newHead = pivot;
    }
    *newEnd = tail;

    return pivot;
}

void quickSort(Node** head, Node* end) {
    if (*head == NULL || *head == end) {
        return;
    }

    Node* newHead = NULL, *newEnd = NULL;
    Node* pivot = partition(*head, end, &newHead, &newEnd);

    if (newHead != pivot) {
        Node* temp = newHead;
        while (temp->next != pivot) {
            temp = temp->next;
        }
        temp->next = NULL;
        quickSort(&newHead, temp);
        temp = getLastNode(newHead);
        temp->next = pivot;
    }
    quickSort(&pivot->next, newEnd);
}

void printList(Node* head) {
    Node* current = head;
    while (current != NULL) {
        cout << current->data << " ";
        current = current->next;
    }
    cout << endl;
}

void push(Node** head, int data) {
    Node* newNode = new Node;
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}

int main() {
    Node* head = NULL;
    push(&head, 5);
    push(&head, 20);
    push(&head, 4);
    push(&head, 3);
    push(&head, 30);

    cout << "Original Linked List: ";
    printList(head);
    interchangeSort(head);

    cout << "Sorted Linked List: ";
    printList(head);

    return 0;
}