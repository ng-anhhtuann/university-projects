#include <iostream>
using namespace std;
struct Node {
    int data;
    Node *prev;
    Node *next;
};

void swap(Node* a, Node* b) {
    int temp = a->data;
    a->data = b->data;
    b->data = temp;
}

void shakerSort(Node** head) {
    bool swapped = true;
    Node* left = *head;
    Node* right = NULL;
    Node* last = NULL;
    while (swapped) {
        swapped = false;
        while (left->next != right) {
            if (left->data > left->next->data) {
                swap(left, left->next);
                swapped = true;
            }
            left = left->next;
        }
        right = left;
        while (left->prev != last) {
            if (left->data < left->prev->data) {
                swap(left, left->prev);
                swapped = true;
            }
            left = left->prev;
        }
        last = left;
        left = (*head);
    }
}

void merge(Node **head, Node *left, Node *right) {
    Node *tail = NULL;

    if (left->data <= right->data) {
        *head = left;
        left = left->next;
    } else {
        *head = right;
        right = right->next;
    }
    tail = *head;

    while (left != NULL && right != NULL) {
        if (left->data <= right->data) {
            tail->next = left;
            left->prev = tail;
            tail = left;
            left = left->next;
        } else {
            tail->next = right;
            right->prev = tail;
            tail = right;
            right = right->next;
        }
    }

    if (left == NULL) {
        tail->next = right;
        right->prev = tail;
    } else {
        tail->next = left;
        left->prev = tail;
    }
}

void mergeSort(Node **head) {
    Node *temp = *head, *left, *right;
    if (temp == NULL || temp->next == NULL)
        return;
    left = temp;
    right = temp->next;
    while (right != NULL) {
        right = right->next;
        if (right != NULL) {
            left = left->next;
            right = right->next;
        }
    }
    right = left->next;
    left->next = NULL;
    mergeSort(&temp);
    mergeSort(&right);
    merge(head, temp, right);
}

void insertNodeAtHead(Node** head_ref, int new_data) {
    Node* new_node = new Node;
    new_node->data = new_data;
    new_node->next = (*head_ref);
    new_node->prev = NULL;
    if ((*head_ref) != NULL) {
        (*head_ref)->prev = new_node;
    }
    (*head_ref) = new_node;
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
    insertNodeAtHead(&head, 1);
    insertNodeAtHead(&head, 3);
    insertNodeAtHead(&head, 9);
    insertNodeAtHead(&head, 5);
    insertNodeAtHead(&head, 7);
    insertNodeAtHead(&head, 8);

    log(head);
    return 0;
}