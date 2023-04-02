/**
 * @file binarySearchTree.cpp
 * @author ng-anhhtuann (github.com)
 * @brief 
 * @version 0.1
 * @date 2023-04-01
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

Node* nodeByValue(int value){
    Node* node = new Node;
    node->data = value;
    node->left = NULL;
    node->right = NULL;
    return node;
}

// Add node for BST
// void addNode(Tree& tree, int value) {
//     Node* newNode = nodeByValue(value);
//     if (tree.root == NULL) {
//         tree.root = newNode;
//         return;
//     }
//     Node* tmp = tree.root;
//     while (true) {
//         if (value < tmp->data) {
//             if (tmp->left == NULL) {
//                 tmp->left = newNode;
//                 break;
//             } else {
//                 tmp = tmp->left;
//             }
//         } else {
//             if (tmp->right == NULL) {
//                 tmp->right = newNode;
//                 break;
//             } else {
//                 tmp = tmp->right;
//             }
//         }
//     }
// }

// Searching Node with value in BST
// Node* search(Tree tree, int x) {
//     Node* tmp = tree.root;
//     while (tmp != NULL) {
//         if (x == tmp->data) {
//             return tmp;
//         } else if (x < tmp->data) {
//             tmp = tmp->left;
//         } else {
//             tmp = tmp->right;
//         }
//     }
//     return NULL; 
// }

// Add node for BT
void addNode(Tree& tree, int value) {
    Node* newNode = nodeByValue(value);
    if (tree.root == NULL) {
        tree.root = newNode;
        return;
    }
    queue<Node*> q;
    q.push(tree.root);
    while (!q.empty()) {
        Node* tmp = q.front();
        q.pop();
        if (tmp->left == NULL) {
            tmp->left = newNode;
            return;
        } else {
            q.push(tmp->left);
        }
        if (tmp->right == NULL) {
            tmp->right = newNode;
            return;
        } else {
            q.push(tmp->right);
        }
    }
}

// Traverse from root to node same level from left side to right -> root first
void preOrder(Node* root){
    if ( root == NULL ) return;
    cout << root->data << " ";
    preOrder(root->left);
    preOrder(root->right);
}

// Traverse from left bottom side to parent then right, root is mid
void inOrder(Node* root){
    if ( root == NULL ) return;
    inOrder(root->left);
    cout << root->data << " ";
    inOrder(root->right);
}

// Traverse from bottom left level to bottom right level of node to parent node -> root last
void postOrder(Node* root){
    if ( root == NULL ) return;
    postOrder(root->left);
    postOrder(root->right);
    cout << root->data << " ";
}

// BFS for tree top level to bottom by row
void bfs(Node* root){
    queue<Node *> q;
    q.push(root);
    while (q.empty() == false) {
        Node *node = q.front();
        cout << node->data << " ";
        q.pop();
        if (node->left != NULL) q.push(node->left);
        if (node->right != NULL) q.push(node->right);
    }
}

int main() {
    Tree* tree = new Tree; tree->root = NULL;
    addNode(*tree,5);
    addNode(*tree,2);
    addNode(*tree,1);
    addNode(*tree,7);
    addNode(*tree,8);
    addNode(*tree,4);
    addNode(*tree,9);
    Node* root = tree->root;

    cout << "PreOrder for this tree: \n";
    preOrder(root);
    cout << "\nInOrder for this tree: \n";
    inOrder(root);
    cout << "\nPostOrder for this tree: \n";
    postOrder(root);
    cout << "\nBreadth First Search for this tree: \n";
    bfs(root);
    delete tree;
}