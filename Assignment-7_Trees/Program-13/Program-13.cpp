/**Q7) 13)Write a Program to create a Binary Search Tree and display its mirror
image with and without disturbing the original tree. Also display height
of a tree using nonrecursion. */

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

// A) Inorder traversal (non-recursive)
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

// B) Preorder Traversal (non-recursive)
void preorder(Node* root) {
    if (!root) return;

    stack<Node*> s;
    s.push(root);

    cout << "Preorder Traversal: ";
    while (!s.empty()) {
        Node* curr = s.top();
        s.pop();

        cout << curr->data << " ";

        if (curr->right) s.push(curr->right);
        if (curr->left) s.push(curr->left);
    }
    cout << endl;
}

// C) Height of the tree (non-recursive)
int treeHeight(Node* root) {
    if (!root) return 0;

    int height = 0;
    queue<Node*> q;
    q.push(root);

    while (!q.empty()) {
        int size = q.size();
        height++;

        while (size--) {
            Node* curr = q.front();
            q.pop();

            if (curr->left) q.push(curr->left);
            if (curr->right) q.push(curr->right);
        }
    }
    return height;
}

// D) Find Maximum (non-recursive)
int findMax(Node* root) {
    int max = -1;
    if (!root) return max;

    stack<Node*> s;
    s.push(root);

    while (!s.empty()) {
        Node* curr = s.top();
        s.pop();

        if (curr->data > max) {
            max = curr->data;
        }

        if (curr->right) s.push(curr->right);
        if (curr->left) s.push(curr->left);
    }
    return max;
}

// Create a mirror image of the tree without disturbing the original tree
Node* createMirror(Node* root) {
    if (!root) return nullptr;

    Node* mirrorRoot = new Node(root->data);
    mirrorRoot->left = createMirror(root->right);
    mirrorRoot->right = createMirror(root->left);
    return mirrorRoot;
}

// Display the tree using preorder traversal for simplicity
void displayTree(Node* root) {
    preorder(root);
}

// Main function
int main() {
    // Create the binary tree
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
    root->right->left = new Node(6);
    root->right->right = new Node(7);

    // Perform operations
    cout << "A) Inorder Traversal:\n";
    inorder(root);

    cout << "\nB) Preorder Traversal:\n";
    preorder(root);

    cout << "C) Height of the tree: " << treeHeight(root) << endl;
    cout << "D) Maximum: " << findMax(root) << endl;

    // Create and display the mirror image
    Node* mirrorRoot = createMirror(root);
    cout << "\nMirror Image (Preorder Traversal):\n";
    displayTree(mirrorRoot);

    return 0;
}
