// Q5) 8)WAP to create doubly linked list and perform following operations on it.
//  Subjects & Assignments
//  Lists A) Insert (all cases) 2. Delete (all cases). 

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    DoublyNode head;

    // Method to insert at the beginning
    public void insertAtBeginning(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to insert at the end
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

    // Method to insert at a given position
    public void insertAtPosition(int data, int position) {
        DoublyNode newNode = new DoublyNode(data);
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        DoublyNode temp = head;
        int count = 0;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Method to delete at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Method to delete at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            DoublyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }
    }

    // Method to delete at a given position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            deleteAtBeginning();
            return;
        }

        DoublyNode temp = head;
        int count = 0;
        while (temp != null && count < position) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    // Method to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Inserting elements
        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtPosition(25, 2); // Inserting 25 at position 2 (index-based)

        System.out.println("Doubly Linked List after insertion:");
        list.display();

        // Deleting elements
        list.deleteAtBeginning();
        System.out.println("Doubly Linked List after deleting from the beginning:");
        list.display();

        list.deleteAtEnd();
        System.out.println("Doubly Linked List after deleting from the end:");
        list.display();

        list.deleteAtPosition(1); // Deleting from position 1 (index-based)
        System.out.println("Doubly Linked List after deleting from position 1:");
        list.display();
    }
}
