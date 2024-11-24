/**Q5) 17)Write a SortedInsert() function which given a list that is sorted in
increasing order, and a single node, inserts the node into the correct
sorted position in the list. While Push() allocates a new node to add to
the list, SortedInsert() takes an existing node, and just rearranges
pointers to insert it into the list */

class Node {
    int data;
    Node next;

    // Constructor to create a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortedInsert {
    Node head;

    // Constructor to initialize an empty list
    public SortedInsert() {
        head = null;
    }

    // Function to add a node at the end of the list
    public void append(int data) {
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

    // Function to insert a node in sorted order
    public void sortedInsert(Node newNode) {
        // If the list is empty or the new node should be inserted at the beginning
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            // Traverse the list to find the correct position
            Node current = head;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            // Insert the new node after the current node
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Function to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortedInsert list = new SortedInsert();

        // Adding elements to the list (sorted)
        list.append(1);
        list.append(3);
        list.append(5);
        list.append(7);

        System.out.println("Original Sorted List:");
        list.display();  // Output: 1 3 5 7

        // Creating a new node to insert
        Node newNode = new Node(4);
        list.sortedInsert(newNode);  // Insert 4 into the sorted list

        System.out.println("List after Sorted Insert of 4:");
        list.display();  // Output: 1 3 4 5 7

        // Inserting a node at the beginning
        Node newNode2 = new Node(0);
        list.sortedInsert(newNode2);  // Insert 0 at the beginning

        System.out.println("List after Sorted Insert of 0:");
        list.display();  // Output: 0 1 3 4 5 7

        // Inserting a node at the end
        Node newNode3 = new Node(8);
        list.sortedInsert(newNode3);  // Insert 8 at the end

        System.out.println("List after Sorted Insert of 8:");
        list.display();  // Output: 0 1 3 4 5 7 8
    }
}
