/**Q5) 14) Implement Insertion sort using Singly Linked List */

#include <iostream>

using namespace std;

// Node structure for the singly linked list
struct Node {
    int data;
    Node* next;

    Node(int item) {
        data = item;
        next = nullptr;
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
    }
}

// Function to perform insertion sort on the linked list
Node* insertionSort(Node* head) {
    // Create a new sorted (or empty) list
    Node* sorted = nullptr;

    // Traverse the given linked list and insert every node to sorted
    Node* current = head;
    while (current != nullptr) {
        // Store next for next iteration
        Node* next = current->next;

        // Insert current in sorted linked list
        if (sorted == nullptr || sorted->data >= current->data) {
            current->next = sorted; // Insert at the beginning
            sorted = current; // Update sorted to new head
        } else {
            Node* temp = sorted;
            while (temp->next != nullptr && temp->next->data < current->data) {
                temp = temp->next; // Find the position to insert
            }
            current->next = temp->next; // Insert in the middle or end
            temp->next = current;
        }
        
        // Move to the next node in the original list
        current = next;
    }
    
    return sorted; // Return the head of the sorted list
}

// Function to display the linked list
void display(Node* head) {
    while (head != nullptr) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    Node* head = nullptr; // Initialize empty linked list

    // Sample Input: Inserting values into the linked list
    cout << "Enter numbers to insert into the linked list (enter -1 to stop):" << endl;
    
    while (true) {
        int value;
        cin >> value;
        
        if (value == -1) break;  // Stop input on -1

        insert(head, value); // Insert value into linked list
    }

    cout << "Linked List before sorting:" << endl;
    display(head); // Display original linked list

    head = insertionSort(head); // Sort the linked list using insertion sort

    cout << "Linked List after sorting:" << endl;
    display(head); // Display sorted linked list

    return 0;
}