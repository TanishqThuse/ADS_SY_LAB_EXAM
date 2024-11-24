/*Q5) 6)Consider a CopyList() function that takes a list and returns a complete
copy of that list. One pointer can iterate over the original list in the usual
way. Two other pointers can keep track of the new list: one head pointer,
and one tail pointer which always points to the last node in the new list */

class Node {
    int data;   // Data value of the node
    Node next;  // Reference to the next node

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CopyList {

    // Function to copy the original linked list
    public static Node copyList(Node head) {
        // If the original list is empty, return null
        if (head == null) {
            return null;
        }

        // Create the head pointer for the new list
        Node newHead = new Node(head.data);
        Node tail = newHead;  // Tail pointer, initially pointing to the new head

        // Pointer to traverse the original list
        Node current = head.next;

        // Traverse the original list and copy each node
        while (current != null) {
            // Create a new node with the data from the current node of the original list
            Node newNode = new Node(current.data);

            // Append the new node to the new list using the tail pointer
            tail.next = newNode;

            // Move the tail pointer to the newly added node
            tail = newNode;

            // Move the pointer to the next node in the original list
            current = current.next;
        }

        // Return the head of the new list
        return newHead;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating the original linked list: 1 -> 2 -> 3 -> 4 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        // Copy the list
        Node copiedList = copyList(head);

        System.out.println("Copied List:");
        printList(copiedList);
    }
}
