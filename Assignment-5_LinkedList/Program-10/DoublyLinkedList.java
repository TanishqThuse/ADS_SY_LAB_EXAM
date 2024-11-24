/**Q5) 10)WAP to merge two sorted Doubly linked lists and display ther result. */

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

    // Method to merge two sorted doubly linked lists
    public static DoublyLinkedList mergeSortedLists(DoublyLinkedList list1, DoublyLinkedList list2) {
        DoublyLinkedList mergedList = new DoublyLinkedList();
        DoublyNode p1 = list1.head;
        DoublyNode p2 = list2.head;

        // Merge the two lists by comparing their nodes
        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                mergedList.insertAtEnd(p1.data);
                p1 = p1.next;
            } else {
                mergedList.insertAtEnd(p2.data);
                p2 = p2.next;
            }
        }

        // If there are remaining nodes in list1
        while (p1 != null) {
            mergedList.insertAtEnd(p1.data);
            p1 = p1.next;
        }

        // If there are remaining nodes in list2
        while (p2 != null) {
            mergedList.insertAtEnd(p2.data);
            p2 = p2.next;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();

        // Insert elements into the first list (sorted)
        list1.insertAtEnd(1);
        list1.insertAtEnd(3);
        list1.insertAtEnd(5);
        list1.insertAtEnd(7);

        // Insert elements into the second list (sorted)
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);

        System.out.println("List 1: ");
        list1.display();

        System.out.println("List 2: ");
        list2.display();

        // Merge the two sorted lists
        DoublyLinkedList mergedList = mergeSortedLists(list1, list2);

        System.out.println("Merged List: ");
        mergedList.display();
    }
}
