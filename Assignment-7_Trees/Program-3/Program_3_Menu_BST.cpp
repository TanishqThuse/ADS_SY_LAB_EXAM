/**Q7) 3) Write a program to illustrate operations on a BST holding numeric keys.
The menu must include: • Insert • Delete • Find • Show */

#include <iostream>
#include <queue>

using namespace std;

// Node structure for the BST
struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int item) {
        data = item;
        left = right = nullptr;
    }
};

// Function to insert a new node
Node* insert(Node* root, int key) {
    if (root == nullptr) {
        return new Node(key);
    }
    if (key < root->data) {
        root->left = insert(root->left, key);
    } else if (key > root->data) {
        root->right = insert(root->right, key);
    }
    return root;
}

// Function to delete a node
Node* deleteNode(Node* root, int key) {
    if (root == nullptr) return root;

    if (key < root->data) {
        root->left = deleteNode(root->left, key);
    } else if (key > root->data) {
        root->right = deleteNode(root->right, key);
    } else {
        // Node with only one child or no child
        if (root->left == nullptr) return root->right;
        else if (root->right == nullptr) return root->left;

        // Node with two children: Get the inorder successor (smallest in the right subtree)
        Node* temp = root->right;
        while (temp && temp->left != nullptr) {
            temp = temp->left;
        }
        root->data = temp->data; // Copy the inorder successor's value
        root->right = deleteNode(root->right, temp->data); // Delete the inorder successor
    }
    return root;
}

// Function to find a node
bool find(Node* root, int key) {
    if (root == nullptr) return false;

    if (key < root->data)
        return find(root->left, key);
    else if (key > root->data)
        return find(root->right, key);

    return true; // Key found
}

// Function to display the tree level-wise
void displayLevelOrder(Node* root) {
    if (root == nullptr) return;

    queue<Node*> q;
    q.push(root);

    while (!q.empty()) {
        Node* currentNode = q.front();
        q.pop();
        cout << currentNode->data << " ";

        if (currentNode->left != nullptr) q.push(currentNode->left);
        if (currentNode->right != nullptr) q.push(currentNode->right);
    }
    cout << endl;
}

int main() {
    Node* bstRoot = nullptr; // Initialize BST

    while (true) {
        cout << "\nMenu:\n";
        cout << "1. Insert\n";
        cout << "2. Delete\n";
        cout << "3. Find\n";
        cout << "4. Show\n";
        cout << "5. Exit\n";

        int choice;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: { // Insert
                int value;
                cout << "Enter value to insert: ";
                cin >> value;
                bstRoot = insert(bstRoot, value);
                break;
            }
            case 2: { // Delete
                int value;
                cout << "Enter value to delete: ";
                cin >> value;
                bstRoot = deleteNode(bstRoot, value);
                break;
            }
            case 3: { // Find
                int value;
                cout << "Enter value to find: ";
                cin >> value;
                if (find(bstRoot, value)) {
                    cout << value << " is found in the BST.\n";
                } else {
                    cout << value << " is not found in the BST.\n";
                }
                break;
            }
            case 4: { // Show
                cout << "Level order traversal of the BST:\n";
                displayLevelOrder(bstRoot);
                break;
            }
            case 5: { // Exit
                cout << "Exiting...\n";
                return 0; 
            }
            default:
                cout << "Invalid choice. Please try again.\n";
                break;
        }
    }

    return 0;
}

// Input example for testing:
// Menu:
// 1. Insert
// 2. Delete
// 3. Find
// 4. Show
// 5. Exit
// Enter your choice: 1
// Enter value to insert: 50
// Enter your choice: 1
// Enter value to insert: 30
// Enter your choice: 1
// Enter value to insert: 70
// Enter your choice: 4
// Level order traversal of the BST:
// 50 30 70 
// Enter your choice: 3
// Enter value to find: 30 
// Enter your choice: 2 
// Enter value to delete: 30 