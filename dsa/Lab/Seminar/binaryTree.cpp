/**
 * @file binaryTree.cpp
 * @author ng-anhhtuann (github.com)
 * @brief 
 * @version 0.1
 * @date 2023-04-01
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <queue>
#include <iostream>
#include <string>
#include <regex>

using namespace std;

struct Node {
    string data;
    Node* left;
    Node* right;
};

struct Tree {
    Node* root;
};

Node* getNode(string value){
    Node* node = new Node;
    node->data = value;
    node->left = NULL;
    node->right = NULL;
    return node;
}

void addNode(Tree& tree, string n){
    Node* node = getNode(n);
    if ( tree.root == NULL ){
        tree.root = node;
        return;
    }
    queue<Node*> q;
    q.push(tree.root);
    while (!q.empty()){
        Node* tmp = q.front(); q.pop();
        if ( tmp->left == NULL ){
            tmp->left = node; return;
        } else {
            q.push(tmp->left);
        }
        if ( tmp->right == NULL ){
            tmp->right = node; return;
        } else {
            q.push(tmp->right);
        }
    }
}

void init(Node* root){
    root = NULL;
}

void traverse(Node* root){
    if ( root == NULL ) return;
    traverse(root->left);
    cout << root->data << " ";
    traverse(root->right);
}

bool isNumber(string& s) {
    regex e("^-?[0-9]+(.[0-9]+)?$");
    return regex_match(s, e);
}

bool isOperator(string& s) {
    return s == "+" || s == "-" || s == "*" || s == "/";
}

void createTree(Tree* tree, int n){
    cout << "Nhap gia tri tung phan tu: \n";
    for ( int i = 0 ; i < n ; i++){
        string tmp;
        cin >> tmp;
        while (!isOperator(tmp) && !isNumber(tmp)) {
            cout << "Nhap lap dang number hoac dang +*-/: ";
            cin >> tmp;
        }
        addNode(*tree, tmp);
    }
}

void expressionBuilder(Node* root, string& str) {
    if (root == nullptr) return;
    if (root->left != nullptr) {
        str += "(";
        expressionBuilder(root->left, str);
    }
    str += root->data;
    if (root->right != nullptr) {
        expressionBuilder(root->right, str);
        str += ")";
    }
}

void stringBuilder(Node* root, string& str) {
    if (root == nullptr) return;
    if (root->left != nullptr) stringBuilder(root->left, str);
    str += root->data + "_";
    if (root->right != nullptr) stringBuilder(root->right, str);
}

bool check(string& s) {
    int n = s.length();
    int i = 0;
    while (i < n){
        string curr, next;
        bool checkFirst = false;
        while ( s[i] != '_' && i < n) {
            if ( i == 0 ) checkFirst = true;
            curr += s[i];
            i++;
        }
        if ( checkFirst && isOperator(curr)) return false;
        if ( i == n-1 ) break;
        i++;
        while (s[i] != '_' && i < n){
            next += s[i];
            i++;
        }
        if ((isNumber(curr) && isNumber(next)) || (isOperator(curr) && isOperator(next))){
            return false;
        }
        i++;
    }
    return true;
}

double calculate(Node* root) {
    if (root == NULL) return 0;
    if (root->left == NULL && root->right == NULL) return stod(root->data);
    double left = calculate(root->left);
    double right = calculate(root->right);
    if (root->data == "+")
        return left + right;
    else if (root->data == "-")
        return left - right;
    else if (root->data == "*")
        return left * right;
    else if (root->data == "/")
        return left / right;
    return 0;
}

int main() {
    Tree* tree = new Tree; 
    init(tree->root);

    int n; 
    cout << "Nhap so luong phan tu: ";
    cin >> n; 
    createTree(tree, n);

    cout << "\nDuyet cay: \n\t";
    traverse(tree->root);
    cout << endl;

    string exp;
    expressionBuilder(tree->root, exp);
    cout << "Bieu thuc tu cay: \n\t" << exp << endl;

    string s; 
    stringBuilder(tree->root, s);
    if ( check(s)){
        double res = calculate(tree->root);
        cout << "\nGia tri bieu thuc: " << res << endl;
    } else {
        cout << "Bieu thuc khong hop le";
    }
    delete tree;
}