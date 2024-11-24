/**Q7) 11) Write a Program to create a Binary Search Tree and perform deletion of
a node from it. Also display the tree in nonrecursive postorder way. */

#include <iostream>
#include <stack>

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

// Function to find the minimum value node in the tree
Node* minValueNode(Node* node) {
    Node* current = node;
    while (current && current->left != nullptr) {
        current = current->left;
    }
    return current;
}

// Function to delete a node from the BST
Node* deleteNode(Node* root, int value) {
    if (root == nullptr) return root;

    if (value < root->data) {
        root->left = deleteNode(root->left, value);
    } else if (value > root->data) {
        root->right = deleteNode(root->right, value);
    } else { // Node with only one child or no child
        if (root->left == nullptr) {
            Node* temp = root->right;
            delete root;
            return temp;
        } else if (root->right == nullptr) {
            Node* temp = root->left;
            delete root;
            return temp;
        }

        // Node with two children: Get the inorder successor (smallest in the right subtree)
        Node* temp = minValueNode(root->right);
        root->data = temp->data; // Copy the inorder successor's content to this node
        root->right = deleteNode(root->right, temp->data); // Delete the inorder successor
    }
    return root;
}

// Non-recursive postorder traversal
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

    cout << "Initial Postorder Traversal:-\n";
    postorder(root);

    // Delete a node from the BST
    int keyToDelete = 3; // Example key to delete
    cout << "Deleting node with value: " << keyToDelete << endl;
    root = deleteNode(root, keyToDelete);

    cout << "Postorder Traversal after deletion:-\n";
    postorder(root);

    return 0;
}