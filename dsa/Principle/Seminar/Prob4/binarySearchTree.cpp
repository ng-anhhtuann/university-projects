/**
 * @file binarySearchTree.cpp
 * @author ng-anhhtuann (github.com)
 * @brief 
 * @version 0.1
 * @date 2023-04-03
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <stdio.h>
#include <queue>
#include <iostream>

using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
};

struct Tree {
    Node* root;
};

Node* getNode(int value){
    Node* node = new Node;
    node->data = value;
    node->left = NULL;
    node->right = NULL;
    return node;
}
 
// Add node 
void addNode(Tree& tree, int value) {
    Node* newNode = getNode(value);
    if (tree.root == NULL) {
        tree.root = newNode;
        return;
    }
    Node* tmp = tree.root;
    while (true) {
        if (value < tmp->data) {
            if (tmp->left == NULL) {
                tmp->left = newNode;
                break;
            } else {
                tmp = tmp->left;
            }
        } else {
            if (tmp->right == NULL) {
                tmp->right = newNode;
                break;
            } else {
                tmp = tmp->right;
            }
        }
    }
}

// Traverse and print tree
void traverse(Node* root){
    if ( root == NULL ) return;
    traverse(root->left);
    cout << root->data << " ";
    traverse(root->right);
}

void createTree(Tree* tree, int n){
    cout << "Nhap gia tri tung phan tu: \n";
    for ( int i = 0 ; i < n ; i++){
        int tmp;
        cin >> tmp;
        addNode(*tree, tmp);
    }
}

void init(Node* root){
    root = NULL;
}

// Searching Node with value 
Node* search(Node* root, int x) {
    Node* tmp = root;
    while (tmp != NULL) {
        if (x == tmp->data) {
            return tmp;
        } else if (x < tmp->data) {
            tmp = tmp->left;
        } else {
            tmp = tmp->right;
        }
    }
    return NULL; 
}

// Delete Node and re-arrange the tree
void deleteNode(Node* root, int x) {
    Node* tmp = root;
    Node* parent = NULL;
    while (tmp != NULL && tmp->data != x) {
        parent = tmp;
        if (x < tmp->data) {
            tmp = tmp->left;
        } else {
            tmp = tmp->right;
        }
    }
    if (tmp == NULL) {
        return;
    }
    if (tmp->left == NULL) {
        Node* child = tmp->right;
        if (parent == NULL) {
            root = child;
        } else if (tmp == parent->left) {
            parent->left = child;
        } else {
            parent->right = child;
        }
        delete tmp;
    } else if (tmp->right == NULL) {
        Node* child = tmp->left;
        if (parent == NULL) {
            root = child;
        } else if (tmp == parent->left) {
            parent->left = child;
        } else {
            parent->right = child;
        }
        delete tmp;
    } else {
        Node* min = tmp->right;
        parent = tmp;
        while (min->left != NULL) {
            parent = min;
            min = min->left;
        }
        tmp->data = min->data;
        if (parent->left == min) {
            parent->left = min->right;
        } else {
            parent->right = min->right;
        }
        delete min;
    }
}

// Delete node and remove all child
void deleteNodeWithChild(Tree tree, int x){
    Node* tmp = tree.root;
    Node* parent = NULL;
    if ( tmp->data == x ){
        tree.root = NULL;
        return;
    }
    while (tmp != NULL) {
        if (x == tmp->data) {
            if (tmp->left != NULL) {
                tmp->left = NULL;
            }
            if (tmp->right != NULL) {
                tmp->right = NULL;
            }
            if (parent == NULL) {
                tree.root = NULL;
            } else if (parent->left == tmp) {
                parent->left = NULL;
            } else {
                parent->right = NULL;
            }
            delete tmp;
            return;
        } else if (x < tmp->data) {
            parent = tmp;
            tmp = tmp->left;
        } else {
            parent = tmp;
            tmp = tmp->right;
        }
    }
}

int main() {
    Tree* tree = new Tree; 
    init(tree->root);

    int n; 
    cout << "Nhap so luong phan tu: \n";
    cin >> n; 
    createTree(tree, n);

    cout << "\nCay nhi phan tim kiem vua tao: \n";
    traverse(tree->root);

    int node;
    cout << "\nNhap gia tri muon tim kiem: ";
    cin >> node;
    Node* searchNode = search(tree->root, node);
    cout << "Node vua tim kiem duoc:\n";
    traverse(searchNode);

    int val; 
    cout << "\nNhap gia tri data muon xoa trong cay: ";
    cin >> val;
    cout << "Cay nhi phan tim kiem sau khi xoa node " << val << " va cac con cua no:\n";
    deleteNodeWithChild(*tree,val);
    traverse(tree->root);

    int del; 
    cout << "\nNhap gia tri data muon xoa trong cay va sap xep lai cay: ";
    cin >> del;
    cout << "Cay nhi phan tim kiem sau khi xoa node " << del << " va sap xep lai vi tri cay:\n";
    deleteNode(tree->root,del);
    traverse(tree->root);

    delete tree;
}