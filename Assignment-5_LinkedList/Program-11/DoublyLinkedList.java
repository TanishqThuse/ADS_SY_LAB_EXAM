/**Q5) 11)WAP to append one doubly linked list to a) the start of the Second list b)
the end of the second list. */

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    // Constructor to create a node with a given data
    DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    DoublyNode head;

    // Method to insert a node at the end of the list
    public void insertAtEnd(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Method to display the doubly linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to append one list to the start of the second list
    public static void appendToStart(DoublyLinkedList list1, DoublyLinkedList list2) {
        if (list1.head == null) {
            return; // If list1 is empty, do nothing
        }

        // Traverse to the last node of list1
        DoublyNode last = list1.head;
        while (last.next != null) {
            last = last.next;
        }

        // Set the last node's next to list2's head
        last.next = list2.head;
        if (list2.head != null) {
            list2.head.prev = last;
        }

        // Set list2's head to the first list's head
        list2.head = list1.head;
    }

    // Method to append one list to the end of the second list
    public static void appendToEnd(DoublyLinkedList list1, DoublyLinkedList list2) {
        if (list1.head == null) {
            return; // If list1 is empty, do nothing
        }

        // Traverse to the last node of list2
        DoublyNode last = list2.head;
        while (last != null && last.next != null) {
            last = last.next;
        }

        // Attach list1 to the end of list2
        if (last == null) {
            list2.head = list1.head;  // If list2 is empty, list1 becomes the new head
        } else {
            last.next = list1.head;
            list1.head.prev = last;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();

        // Insert elements into the first list
        list1.insertAtEnd(1);
        list1.insertAtEnd(3);
        list1.insertAtEnd(5);
        list1.insertAtEnd(7);

        // Insert elements into the second list
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);

        System.out.println("List 1: ");
        list1.display();

        System.out.println("List 2: ");
        list2.display();

        // Append list1 to the start of list2
        appendToStart(list1, list2);
        System.out.println("After appending List 1 to the start of List 2: ");
        list2.display();

        // Reset list2 for next operation
        list2 = new DoublyLinkedList();
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);

        // Append list1 to the end of list2
        appendToEnd(list1, list2);
        System.out.println("After appending List 1 to the end of List 2: ");
        list2.display();
    }
}
