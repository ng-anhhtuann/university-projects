/**
 * @file shakerSort.cpp
 * @author ng-anhhtuann (github.com)
 * @brief 
 * @version 0.1
 * @date 2023-04-01
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

void insertNodeAtHead(Node** head, int data) {
    Node* newNode = new Node;
    newNode->data = data;
    newNode->next = (*head);
    newNode->prev = NULL;
    if ((*head) != NULL) {
        (*head)->prev = newNode;
    }
    (*head) = newNode;
}

void log(Node* head) {
    Node* tmp = head;
    while (tmp != NULL) {
        cout << tmp->data << " ";
        tmp = tmp->next;
    }
    cout << endl;
}

void swap(Node* a, Node* b) {
    int temp = a->data;
    a->data = b->data;
    b->data = temp;
}

void shakerSort(Node** head) {
    bool check = true;
    Node* tmp = *head;
    Node* right = NULL;
    Node* left = NULL;
    while (check) {
        check = false;
        while (tmp->next != right) {
            if (tmp->data > tmp->next->data) {
                swap(tmp, tmp->next);
                check = true;
            }
            tmp = tmp->next;
        }
        right = tmp; // limit of max right
        while (tmp->prev != left) {
            if (tmp->data < tmp->prev->data) {
                swap(tmp, tmp->prev);
                check = true;
            }
            tmp = tmp->prev;
        }
        left = tmp; // limit of min left
        tmp = *head;
    }
}

int main() {
    Node* head = NULL;
    insertNodeAtHead(&head, 1);
    insertNodeAtHead(&head, 3);
    insertNodeAtHead(&head, 9);
    insertNodeAtHead(&head, 5);
    insertNodeAtHead(&head, 7);
    insertNodeAtHead(&head, 8);

    cout << "Danh sach lien ket truoc khi sort: \n";
    log(head);
    shakerSort(&head);
    cout << "Danh sach lien ket sau khi sort: \n";
    log(head);
    return 0;
}