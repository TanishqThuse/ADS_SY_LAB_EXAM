class DoublyLinkedList {
    // Node class represents an element in the doubly linked list
    static class Node {
        int data;
        Node next;
        Node prev;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // Head of the list

    // Method to insert at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to insert at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Method to insert after a specified node
    public void insertAfterNode(int target, int data) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp != null) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
            newNode.prev = temp;
        } else {
            System.out.println("Node with value " + target + " not found.");
        }
    }

    // Method to delete the first node
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            if (head.next != null) {
                head.next.prev = null;
            }
            head = head.next;
        }
    }

    // Method to delete the last node
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            if (temp.prev != null) {
                temp.prev.next = null;
            } else {
                head = null; // If the list has only one element
            }
        }
    }

    // Method to delete a node after a specified node
    public void deleteAfterNode(int target) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp != null && temp.next != null) {
            Node nodeToDelete = temp.next;
            temp.next = nodeToDelete.next;
            if (nodeToDelete.next != null) {
                nodeToDelete.next.prev = temp;
            }
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
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to search an element in the list
    public void searchElement(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Element " + data + " found.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Element " + data + " not found.");
    }

    // Main method to test the doubly linked list and its operations
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

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
