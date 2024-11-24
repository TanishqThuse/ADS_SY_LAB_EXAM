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

    // Method to add a new node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev;  // Reverse the current node's pointer
            prev = current;       // Move prev and current one step forward
            current = next;
        }
        
        head = prev; // Update the head to the new first node
    }

    // Method to display the linked list
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

    // Main method to test the linked list and reversal
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Add some elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        
        // Display the original list
        System.out.println("Original Linked List:");
        list.display();
        
        // Reverse the linked list
        list.reverse();
        
        // Display the reversed list
        System.out.println("Reversed Linked List:");
        list.display();
    }
}
