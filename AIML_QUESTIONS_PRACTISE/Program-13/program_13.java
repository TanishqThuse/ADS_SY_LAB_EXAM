class CircularDoublyLinkedList {
    // Node class represents an element in the circular doubly linked list
    static class Node {
        int data;
        Node next;
        Node prev;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = this;
            this.prev = this;
        }
    }

    private Node head = null; // Head of the list

    // Method to insert at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head.prev;
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = last;
            last.next = newNode;
            head = newNode;
        }
    }

    // Method to insert at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Method to insert after a specified node
    public void insertAfterNode(int target, int data) {
        Node temp = head;
        do {
            if (temp.data == target) {
                Node newNode = new Node(data);
                Node nextNode = temp.next;
                temp.next = newNode;
                newNode.prev = temp;
                newNode.next = nextNode;
                nextNode.prev = newNode;
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Node with value " + target + " not found.");
    }

    // Method to delete the first node
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node last = head.prev;
            head = head.next;
            head.prev = last;
            last.next = head;
        }
    }

    // Method to delete the last node
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node last = head.prev;
            Node secondLast = last.prev;
            secondLast.next = head;
            head.prev = secondLast;
        }
    }

    // Method to delete a node after a specified node
    public void deleteAfterNode(int target) {
        Node temp = head;
        do {
            if (temp.data == target) {
                Node nodeToDelete = temp.next;
                if (nodeToDelete != head) {
                    Node nextNode = nodeToDelete.next;
                    temp.next = nextNode;
                    nextNode.prev = temp;
                } else {
                    System.out.println("No node to delete after this node.");
                }
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Node with value " + target + " not found.");
    }

    // Method to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
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

    // Main method to test the circular doubly linked list and its operations
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

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
