// Q5) 3) Write an iterative Reverse() function that reverses a list by rearranging
// all the .next pointers and the head pointer. Ideally, Reverse() should only
// need to make one pass of the list

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }

     // Iterative function to reverse the linked list
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;  // The previous node starts as null
        ListNode current = head;  // The current node starts as the head
        ListNode next = null;  // Temporary pointer to store the next node

        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev;  // Reverse the next pointer
            prev = current;  // Move prev to current
            current = next;  // Move current to next node
        }

        // At the end, prev will be the new head of the reversed list
        return prev;
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

    // Main function for testing the reversal
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Reverse the linked list
        head = reverse(head);

        System.out.println("Reversed List:");
        printList(head);
    }
}

public class LinkedListReversal {

    // Iterative function to reverse the linked list
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;  // The previous node starts as null
        ListNode current = head;  // The current node starts as the head
        ListNode next = null;  // Temporary pointer to store the next node

        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev;  // Reverse the next pointer
            prev = current;  // Move prev to current
            current = next;  // Move current to next node
        }

        // At the end, prev will be the new head of the reversed list
        return prev;
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

    // Main function for testing the reversal
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Reverse the linked list
        head = reverse(head);

        System.out.println("Reversed List:");
        printList(head);
    }
}
