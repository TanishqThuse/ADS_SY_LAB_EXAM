// Q5) 4) Write an Append() function that takes two lists, 'a' and 'b', appends 'b'
// onto the end of 'a', and then sets 'b' to NULL (since it is now trailing off
// the end of 'a')

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    // Append function to append list 'b' to list 'a'
    public static void append(ListNode a, ListNode b) {
        // If list 'a' is empty, just set 'a' to 'b'
        if (a == null) {
            a = b;
            return;
        }

        // Traverse list 'a' to find the last node
        ListNode current = a;
        while (current.next != null) {
            current = current.next;
        }

        // Append list 'b' to the end of list 'a'
        current.next = b;

        // Set 'b' to null
        b = null;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main function for testing the append operation
    public static void main(String[] args) {
        // Creating two linked lists: list a and list b
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(4);
        b.next = new ListNode(5);
        b.next.next = new ListNode(6);

        System.out.println("Original List a:");
        printList(a);

        System.out.println("Original List b:");
        printList(b);

        // Append list b to list a
        append(a, b);

        System.out.println("After appending b to a:");
        printList(a);

        // Print list b after appending (it should be null or empty)
        System.out.println("List b after append operation:");
        printList(b);  // Will print an empty list, as b is now null
    }
}

public class LinkedListAppend {

    // Append function to append list 'b' to list 'a'
    public static void append(ListNode a, ListNode b) {
        // If list 'a' is empty, just set 'a' to 'b'
        if (a == null) {
            a = b;
            return;
        }

        // Traverse list 'a' to find the last node
        ListNode current = a;
        while (current.next != null) {
            current = current.next;
        }

        // Append list 'b' to the end of list 'a'
        current.next = b;

        // Set 'b' to null
        b = null;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main function for testing the append operation
    public static void main(String[] args) {
        // Creating two linked lists: list a and list b
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(4);
        b.next = new ListNode(5);
        b.next.next = new ListNode(6);

        System.out.println("Original List a:");
        printList(a);

        System.out.println("Original List b:");
        printList(b);

        // Append list b to list a
        append(a, b);

        System.out.println("After appending b to a:");
        printList(a);

        // Print list b after appending (it should be null or empty)
        System.out.println("List b after append operation:");
        printList(b);  // Will print an empty list, as b is now null
    }
}
