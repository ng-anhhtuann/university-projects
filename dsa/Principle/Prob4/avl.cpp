#include <iostream>

using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    int bal;
};

struct Tree {
    int count;
    Node* root;
};

// Function to create a new Node with a given value
Node* createNode(int value) {
    Node* newNode = new Node;
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->bal = 0;
    return newNode;
}

// Function to rotate a node to the left
Node* rotateLeft(Node* node) {
    Node* tmp = node->right;
    node->right = tmp->left;
    tmp->left = node;
    node->bal = node->bal - 1 - max(tmp->bal, 0);
    tmp->bal = tmp->bal - 1 + min(node->bal, 0);
    return tmp;
}

// Function to rotate a node to the right
Node* rotateRight(Node* node) {
    Node* tmp = node->left;
    node->left = tmp->right;
    tmp->right = node;
    node->bal = node->bal + 1 - min(tmp->bal, 0);
    tmp->bal = tmp->bal + 1 + max(node->bal, 0);
    return tmp;
}

// Function to balance the AVL tree
Node* balance(Node* node) {
    if (node->bal == -2) {
        if (node->left->bal == 1) {
            node->left = rotateLeft(node->left);
        }
        return rotateRight(node);
    }
    else if (node->bal == 2) {
        if (node->right->bal == -1) {
            node->right = rotateRight(node->right);
        }
        return rotateLeft(node);
    }
    return node;
}

// Function to add a value to the AVL tree
void addNode(Tree& tree, int value) {
    Node* newNode = createNode(value);
    if (tree.count == 0) {
        tree.root = newNode;
    } else {
        Node* tmp = tree.root;
        while (true) {
            if (value < tmp->data) {
                if (tmp->left == NULL) {
                    tmp->left = newNode;
                    break;
                }
                tmp = tmp->left;
            } else {
                if (tmp->right == NULL) {
                    tmp->right = newNode;
                    break;
                }
                tmp = tmp->right;
            }
        }
        tmp = balance(tmp);
    }
    tree.count++;
}

// Function to find a node with a given value in the AVL tree
Node* findNode(Node* node, int value) {
    if (node == NULL || node->data == value) {
        return node;
    } else if (value < node->data) {
        return findNode(node->left, value);
    } else {
        return findNode(node->right, value);
    }
}

// Function to delete a node with a given value from the AVL tree
Node* deleteNode(Node* node, int value) {
    if (node == NULL) {
        return NULL;
    }
    if (value < node->data) {
        node->left = deleteNode(node->left, value);
    } else if (value > node->data) {
        node->right = deleteNode(node->right, value);
    } else {
        if (node->left == NULL && node->right == NULL) {
            delete node;
            node = NULL;
        } else if (node->left == NULL) {
            Node* tmp = node;
            node = node->right;
            delete tmp;
        } else if (node->right == NULL) {
            Node* tmp = node;
            node = node->left;
            delete tmp;
        } else {
            Node* tmp = node->right;
            while (tmp->left != NULL) {
                tmp = tmp->left;
            }
            node->data = tmp->data;
            node->right = deleteNode(node->right, tmp->data);
        }
    }
    if (node == NULL) {
        return node;
    }
    node = balance(node);
    return node;
}

int main() {
    Tree tree;
    tree.count = 0;
    tree.root = NULL;

    addNode(tree, 10);
    addNode(tree, 5);
    addNode(tree, 15);
    addNode(tree, 3);
    addNode(tree, 7);
    addNode(tree, 12);
    addNode(tree, 17);

    Node* node = findNode(tree.root, 12);
    if (node != NULL) {
        cout << "Found node with value 12." << endl;
    }
    else {
        cout << "Could not find node with value 12." << endl;
    }

    node = findNode(tree.root, 20);
    if (node != NULL) {
        cout << "Found node with value 20." << endl;
    }
    else {
        cout << "Could not find node with value 20." << endl;
    }

    tree.root = deleteNode(tree.root, 7);
    tree.root = deleteNode(tree.root, 15);

    return 0;
}