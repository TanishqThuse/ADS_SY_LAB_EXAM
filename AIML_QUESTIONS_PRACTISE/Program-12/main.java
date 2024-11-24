class CircularSinglyLinkedList {
    // Node class represents an element in the circular singly linked list
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null; // Head of the list

    // Method to insert at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Points to itself
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Method to insert at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Points to itself
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Method to insert after a specified node
    public void insertAfterNode(int target, int data) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
            if (temp == head) break; // Circular condition
        }
        if (temp != null && temp.data == target) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("Node with value " + target + " not found.");
        }
    }

    // Method to delete the first node
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
        } else if (head.next == head) {
            head = null; // Only one node present
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head; // Update the last node's next to head
        }
    }

    // Method to delete the last node
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
        } else if (head.next == head) {
            head = null; // Only one node present
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            Node secondLast = head;
            while (secondLast.next != temp) {
                secondLast = secondLast.next;
            }
            secondLast.next = head;
        }
    }

    // Method to delete a node after a specified node
    public void deleteAfterNode(int target) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
            if (temp == head) break; // Circular condition
        }
        if (temp != null && temp.data == target && temp.next != head) {
            Node nodeToDelete = temp.next;
            temp.next = nodeToDelete.next;
        } else {
            System.out.println("Node with value " + target + " not found or no node to delete after it.");
        }
    }

    // Method to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    // Method to search an element in the list
    public void searchElement(int data) {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        do {
            if (temp.data == data) {
                System.out.println("Element " + data + " found.");
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Element " + data + " not found.");
    }

    // Main method to test the circular singly linked list and its operations
    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

        // Perform various operations
        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        list.insertAfterNode(20, 25);

        // Display the list after insertions
        System.out.println("List after insertions:");
        list.display();

        // Perform deletions
        list.deleteAtBeginning();
        list.deleteAtEnd();
        list.deleteAfterNode(20);

        // Display the list after deletions
        System.out.println("List after deletions:");
        list.display();

        // Search for an element
        list.searchElement(25);
        list.searchElement(50);
    }
}
