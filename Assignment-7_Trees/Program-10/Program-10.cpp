/**Q7) 10) Write a Program to create a Binary Search Tree and perform following
nonrecursive operations on it. a. Preorder Traversal b. Postorder
Traversal c. Display total Number of Nodes d. Display Leaf nodes. */

#include <iostream>
#include <stack>
#include <vector>

using namespace std;

// Define the structure of a binary tree node
struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int value) {
        data = value;
        left = right = nullptr;
    }
};

// Function to insert a new node in the BST
Node* insert(Node* root, int value) {
    if (root == nullptr) {
        return new Node(value);
    }
    if (value < root->data) {
        root->left = insert(root->left, value);
    } else {
        root->right = insert(root->right, value);
    }
    return root;
}

// A) Preorder traversal (non-recursive)
void preorder(Node* root) {
    if (!root) return;

    stack<Node*> s;
    s.push(root);

    cout << "Preorder Traversal: ";
    while (!s.empty()) {
        Node* curr = s.top();
        s.pop();

        cout << curr->data << " ";

        // Push right first so that left is processed first
        if (curr->right) {
            s.push(curr->right);
        }
        if (curr->left) {
            s.push(curr->left);
        }
    }
    cout << endl;
}

// B) Postorder traversal (non-recursive)
void postorder(Node* root) {
    if (!root) return;

    stack<Node*> s1, s2;
    s1.push(root);

    while (!s1.empty()) {
        Node* curr = s1.top();
        s1.pop();
        s2.push(curr);

        // Push left and right children to the first stack
        if (curr->left) {
            s1.push(curr->left);
        }
        if (curr->right) {
            s1.push(curr->right);
        }
    }

    cout << "Postorder Traversal: ";
    while (!s2.empty()) {
        cout << s2.top()->data << " ";
        s2.pop();
    }
    cout << endl;
}

// C) Count total number of nodes
int countNodes(Node* root) {
    if (!root) return 0;

    int count = 0;
    stack<Node*> s;
    s.push(root);

    while (!s.empty()) {
        Node* curr = s.top();
        s.pop();
        count++;

        if (curr->right) {
            s.push(curr->right);
        }
        if (curr->left) {
            s.push(curr->left);
        }
    }

    return count;
}

// D) Display leaf nodes
void displayLeafNodes(Node* root) {
    if (!root) return;

    stack<Node*> s;
    s.push(root);

    cout << "Leaf Nodes: ";
    
    while (!s.empty()) {
        Node* curr = s.top();
        s.pop();

        // Check if it's a leaf node
        if (!curr->left && !curr->right) {
            cout << curr->data << " ";
        }

        if (curr->right) {
            s.push(curr->right);
        }
        if (curr->left) {
            s.push(curr->left);
        }
    }
    
    cout << endl;
}

// Main function to test the binary search tree
int main() {
    Node* root = nullptr;

    // Insert nodes into the BST
    root = insert(root, 5);
    insert(root, 3);
    insert(root, 7);
    insert(root, 2);
    insert(root, 4);
    insert(root, 6);
    insert(root, 8);

    // Perform operations
    preorder(root);
    postorder(root);

    cout << "Total Number of Nodes: " << countNodes(root) << endl;

    displayLeafNodes(root);

    return 0;
}