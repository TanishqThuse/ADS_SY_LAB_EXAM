/**Q5) 16)Write a RemoveDuplicates() function which takes a list sorted in
increasing order and deletes any duplicate nodes from the list. Ideally,
the list should only be traversed once */

class Node {
    int data;
    Node next;

    // Constructor to create a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicates {
    Node head;

    // Constructor to initialize an empty list
    public RemoveDuplicates() {
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

    // Function to remove duplicates from the sorted linked list
    public void removeDuplicates() {
        Node current = head;

        // Traverse the list until the second last node
        while (current != null && current.next != null) {
            // If current node's data equals next node's data, remove the next node
            if (current.data == current.next.data) {
                current.next = current.next.next; // Skip the next node (duplicate)
            } else {
                // Otherwise, move to the next node
                current = current.next;
            }
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
        RemoveDuplicates list = new RemoveDuplicates();

        // Adding elements to the list (with duplicates)
        list.append(1);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(4);
        list.append(4);
        list.append(5);

        System.out.println("Original List:");
        list.display();  // Output: 1 1 2 3 3 4 4 5

        // Removing duplicates
        list.removeDuplicates();

        System.out.println("List after removing duplicates:");
        list.display();  // Output: 1 2 3 4 5
    }
}
