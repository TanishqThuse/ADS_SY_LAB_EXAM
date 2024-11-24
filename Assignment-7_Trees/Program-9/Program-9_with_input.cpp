/**Q7 ) 9) Write a Program to create a Binary Search Tree and perform following
nonrecursive operations on it. a. Preorder Traversal b. Inorder Traversal
c. Display Number of Leaf Nodes d. Mirror Image1 */

#include <iostream>
#include <stack>
#include <queue>

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

// B) Inorder traversal (non-recursive)
void inorder(Node* root) {
    if (!root) return;

    stack<Node*> s;
    Node* curr = root;

    cout << "Inorder Traversal: ";
    
    while (curr != nullptr || !s.empty()) {
        while (curr != nullptr) {
            s.push(curr);
            curr = curr->left;
        }

        curr = s.top();
        s.pop();

        cout << curr->data << " ";

        curr = curr->right;
    }
    
    cout << endl;
}

// C) Count leaf nodes
int countLeafNodes(Node* root) {
    if (!root) return 0;

    int count = 0;
    stack<Node*> s;
    s.push(root);

    while (!s.empty()) {
        Node* curr = s.top();
        s.pop();

        // Check if it's a leaf node
        if (!curr->left && !curr->right) {
            count++;
        }

        if (curr->right) {
            s.push(curr->right);
        }
        if (curr->left) {
            s.push(curr->left);
        }
    }
    
    return count;
}

// D) Generate mirror image of the tree
void mirror(Node* root) {
    if (!root) return;

    queue<Node*> q;
    q.push(root);

    while (!q.empty()) {
        Node* curr = q.front();
        q.pop();

        // Swap left and right children
        swap(curr->left, curr->right);

        if (curr->left) {
            q.push(curr->left);
        }
        if (curr->right) {
            q.push(curr->right);
        }
    }
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
    inorder(root);
    
    cout << "Number of Leaf Nodes: " << countLeafNodes(root) << endl;

    // Mirror the tree and display traversals again
    mirror(root);

    cout << "Preorder Traversal after Mirroring: ";
    preorder(root);
    
    cout << "Inorder Traversal after Mirroring: ";
    inorder(root);

    return 0;
}