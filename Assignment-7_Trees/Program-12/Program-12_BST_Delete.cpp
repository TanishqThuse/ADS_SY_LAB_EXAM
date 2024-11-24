/*Q7) 12) Write a Program to create a Binary Search Tree and display it levelwise.
Also perform deletion of a node from it.*/

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

// Class for the Binary Search Tree
class BinarySearchTree {
public:
    Node* root;

    BinarySearchTree() {
        root = nullptr;
    }

    // Method to insert a new node
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new node
    Node* insertRec(Node* root, int key) {
        if (root == nullptr) {
            return new Node(key);
        }
        if (key < root->data) {
            root->left = insertRec(root->left, key);
        } else if (key > root->data) {
            root->right = insertRec(root->right, key);
        }
        return root;
    }

    // Method to delete a node
    void deleteNode(int key) {
        root = deleteRec(root, key);
    }

    // Recursive function to delete a node
    Node* deleteRec(Node* root, int key) {
        if (root == nullptr) return root;

        if (key < root->data) {
            root->left = deleteRec(root->left, key);
        } else if (key > root->data) {
            root->right = deleteRec(root->right, key);
        } else {
            // Node with only one child or no child
            if (root->left == nullptr) return root->right;
            else if (root->right == nullptr) return root->left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root->data = minValue(root->right);

            // Delete the inorder successor
            root->right = deleteRec(root->right, root->data);
        }
        return root;
    }

    // Function to find the minimum value in a tree
    int minValue(Node* node) {
        int minValue = node->data;
        while (node->left != nullptr) {
            minValue = node->left->data;
            node = node->left;
        }
        return minValue;
    }

    // Method to display the tree level-wise
    void displayLevelOrder() {
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
};

int main() {
    BinarySearchTree bst;

    // Sample Input:
    // Insert values into the BST
    cout << "Enter numbers to insert into the BST (enter -1 to stop):" << endl;
    
    while (true) {
        int value;
        cin >> value;
        
        if (value == -1) break;  // Stop input on -1

        bst.insert(value);
    }

    cout << "Level order traversal of the BST:" << endl;
    bst.displayLevelOrder();

    // Deletion of a node
    cout << "Enter a number to delete from the BST: ";
    int deleteValue;
    cin >> deleteValue;

    bst.deleteNode(deleteValue);

    cout << "Level order traversal after deletion:" << endl;
    bst.displayLevelOrder();

    return 0;
}

/*// Input example for testing:
// Enter numbers to insert into the BST (enter -1 to stop):
// 50
// 30
// 70
// 20
// 40
// 60
// 80
// -1
// Enter a number to delete from the BST: 30*/