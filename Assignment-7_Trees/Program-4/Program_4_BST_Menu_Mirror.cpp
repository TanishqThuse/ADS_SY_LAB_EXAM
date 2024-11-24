/*Q7) 4) Write a program to illustrate operations on a BST holding numeric keys.
The menu must include: • Insert • Mirror Image • Find • Post order
(nonrecursive)*/

#include <iostream>
#include <stack>

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

// Function to find a node
bool find(Node* root, int key) {
    if (root == nullptr) return false;

    if (key < root->data)
        return find(root->left, key);
    else if (key > root->data)
        return find(root->right, key);

    return true; // Key found
}

// Function to create a mirror image of the tree
Node* mirror(Node* root) {
    if (root == nullptr) return nullptr;

    // Swap the left and right children
    Node* temp = root->left;
    root->left = mirror(root->right);
    root->right = mirror(temp);

    return root;
}

// Non-recursive post-order traversal
void postOrderNonRecursive(Node* root) {
    if (root == nullptr) return;

    stack<Node*> s1, s2;
    s1.push(root);

    // Push nodes to the second stack in reverse order
    while (!s1.empty()) {
        Node* currentNode = s1.top();
        s1.pop();
        s2.push(currentNode);

        // Push left and right children to the first stack
        if (currentNode->left != nullptr) s1.push(currentNode->left);
        if (currentNode->right != nullptr) s1.push(currentNode->right);
    }

    // Print nodes in post-order
    while (!s2.empty()) {
        cout << s2.top()->data << " ";
        s2.pop();
    }
    cout << endl;
}

int main() {
    Node* bstRoot = nullptr; // Initialize BST

    while (true) {
        cout << "\nMenu:\n";
        cout << "1. Insert\n";
        cout << "2. Mirror Image\n";
        cout << "3. Find\n";
        cout << "4. Post-order Traversal (Non-recursive)\n";
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
            case 2: { // Mirror Image
                bstRoot = mirror(bstRoot);
                cout << "The tree has been mirrored.\n";
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
            case 4: { // Post-order Traversal
                cout << "Post-order traversal of the BST:\n";
                postOrderNonRecursive(bstRoot);
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
// 2. Mirror Image
// 3. Find
// 4. Post-order Traversal (Non-recursive)
// 5. Exit
// Enter your choice: 1
// Enter value to insert: 50
// Enter your choice: 1
// Enter value to insert: 30
// Enter your choice: 1
// Enter value to insert: 70
// Enter your choice: 4
// Post-order traversal of the BST:
// 30 70 50 
// Enter your choice: 2 
// The tree has been mirrored.
// Enter your choice: 4 
// Post-order traversal of the BST:
// 50 30 70 