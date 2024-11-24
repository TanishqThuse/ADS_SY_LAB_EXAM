import java.util.Scanner;

class SinglyLinkedList {
    // Node class represents each element in the linked list
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head of the list

    // a) Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // b) Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // c) Insert after a specified node
    public void insertAfter(int key, int data) {
        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp != null) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("Node with value " + key + " not found.");
        }
    }

    // d) Delete at the beginning
    public void deleteAtBeginning() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("List is empty.");
        }
    }

    // e) Delete at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // f) Delete after a specified node
    public void deleteAfter(int key) {  
        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        } else if (temp != null) {
            System.out.println("No node exists after node with value " + key);
        } else {
            System.out.println("Node with value " + key + " not found.");
        }
    }

    // g) Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // h) Search for an element in the linked list
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Main method to test the Singly Linked List operations
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert after specified node");
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete after specified node");
            System.out.println("7. Display");
            System.out.println("8. Search an element");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert at the beginning: ");
                    int data1 = scanner.nextInt();
                    list.insertAtBeginning(data1);
                    break;
                case 2:
                    System.out.print("Enter the value to insert at the end: ");
                    int data2 = scanner.nextInt();
                    list.insertAtEnd(data2);
                    break;
                case 3:
                    System.out.print("Enter the value of the node after which to insert: ");
                    int key1 = scanner.nextInt();
                    System.out.print("Enter the value to insert: ");
                    int data3 = scanner.nextInt();
                    list.insertAfter(key1, data3);
                    break;
                case 4:
                    list.deleteAtBeginning();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter the value of the node after which to delete: ");
                    int key2 = scanner.nextInt();
                    list.deleteAfter(key2);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.print("Enter the value to search: ");
                    int key3 = scanner.nextInt();
                    if (list.search(key3)) {
                        System.out.println("Element found in the list.");
                    } else {
                        System.out.println("Element not found in the list.");
                    }
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
