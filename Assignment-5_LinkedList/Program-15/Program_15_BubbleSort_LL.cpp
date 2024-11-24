/*Q5) 15) Implement Bubble sort using Doubly Linked List*/

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

// Function to insert a new node at the end of the list
void insert(Node*& head, int data) {
    Node* newNode = new Node(data);
    if (head == nullptr) {
        head = newNode;
    } else {
        Node* temp = head;
        while (temp->next != nullptr) {
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->prev = temp; // Link the new node to the previous node
    }
}

// Function to perform bubble sort on the doubly linked list
void bubbleSort(Node*& head) {
    if (head == nullptr) return; // Check if the list is empty

    bool swapped;
    do {
        swapped = false;
        Node* current = head;

        while (current->next != nullptr) {
            if (current->data > current->next->data) {
                // Swap data between current and next node
                int temp = current->data;
                current->data = current->next->data;
                current->next->data = temp;

                swapped = true; // Set swapped to true
            }
            current = current->next; // Move to the next node
        }
    } while (swapped); // Repeat until no swaps occur
}

// Function to display the doubly linked list
void display(Node* head) {
    while (head != nullptr) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    Node* head = nullptr; // Initialize empty doubly linked list

    cout << "Enter numbers to insert into the doubly linked list (enter -1 to stop):" << endl;

    while (true) {
        int value;
        cin >> value;

        if (value == -1) break;  // Stop input on -1

        insert(head, value); // Insert value into doubly linked list
    }

    cout << "Doubly Linked List before sorting:" << endl;
    display(head); // Display original doubly linked list

    bubbleSort(head); // Sort the doubly linked list using bubble sort

    cout << "Doubly Linked List after sorting:" << endl;
    display(head); // Display sorted doubly linked list

    return 0;
}