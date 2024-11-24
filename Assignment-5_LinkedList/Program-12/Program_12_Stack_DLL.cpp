/**Q5) 12) Implement Push and POP operations of STACK on Doubly linked lists */

#include <iostream>
using namespace std;

// Node structure for the doubly linked list
struct Node {
    int data;
    Node* next;
    Node* prev;

    Node(int item) {
        data = item;
        next = nullptr;
        prev = nullptr;
    }
};

// Class for the Stack
class Stack {
private:
    Node* top; // Pointer to the top of the stack

public:
    Stack() {
        top = nullptr; // Initialize the stack as empty
    }

    // Push operation
    void push(int key) {
        Node* newNode = new Node(key);
        if (top == nullptr) {
            top = newNode; // If stack is empty, set new node as top
        } else {
            newNode->prev = top; // Link new node with the current top
            top->next = newNode; // Link current top to new node
            top = newNode; // Update top to new node
        }
        cout << key << " pushed to stack.\n";
    }

    // Pop operation
    void pop() {
        if (top == nullptr) {
            cout << "Stack is empty. Cannot perform pop operation.\n";
            return;
        }
        cout << top->data << " popped from stack.\n";
        Node* temp = top;
        top = top->prev; // Move top pointer to the previous node
        if (top != nullptr) {
            top->next = nullptr; // Set next of new top to null
        }
        delete temp; // Free memory of popped node
    }

    // Find operation
    bool find(int key) {
        Node* current = top;
        while (current != nullptr) {
            if (current->data == key) {
                return true; // Key found in stack
            }
            current = current->prev; // Move to previous node
        }
        return false; // Key not found
    }

    // Show operation (display all elements)
    void show() {
        if (top == nullptr) {
            cout << "Stack is empty.\n";
            return;
        }
        cout << "Stack elements: ";
        Node* current = top;
        while (current != nullptr) {
            cout << current->data << " ";
            current = current->prev; // Move to previous node
        }
        cout << endl;
    }
};

int main() {
    Stack stack;
    
    while (true) {
        cout << "\nMenu:\n";
        cout << "1. Push\n";
        cout << "2. Pop\n";
        cout << "3. Find\n";
        cout << "4. Show\n";
        cout << "5. Exit\n";

        int choice;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: { // Push
                int value;
                cout << "Enter value to push: ";
                cin >> value;
                stack.push(value);
                break;
            }
            case 2: { // Pop
                stack.pop();
                break;
            }
            case 3: { // Find
                int value;
                cout << "Enter value to find: ";
                cin >> value;
                if (stack.find(value)) {
                    cout << value << " is found in the stack.\n";
                } else {
                    cout << value << " is not found in the stack.\n";
                }
                break;
            }
            case 4: { // Show
                stack.show();
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