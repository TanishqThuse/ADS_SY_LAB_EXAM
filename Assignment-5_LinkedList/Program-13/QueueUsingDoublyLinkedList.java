/**Q5) 13) Implement ADD and DELETE operations of QUEUE on Doubly linked
lists */

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

public class QueueUsingDoublyLinkedList {
    DoublyNode head, tail;

    // Constructor to initialize an empty queue
    public QueueUsingDoublyLinkedList() {
        head = tail = null;
    }

    // Add (Enqueue) operation: Add element at the rear of the queue
    public void enqueue(int data) {
        DoublyNode newNode = new DoublyNode(data);

        if (tail == null) {
            // If the queue is empty, the new node will be both the head and the tail
            head = tail = newNode;
        } else {
            // Add new node at the end (tail) of the queue
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;  // Update the tail to the new node
        }
        System.out.println(data + " enqueued to the queue");
    }

    // Delete (Dequeue) operation: Remove element from the front of the queue
    public void dequeue() {
        if (head == null) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        // If there is only one element in the queue
        if (head == tail) {
            head = tail = null;
        } else {
            // Move the head pointer to the next node
            head = head.next;
            head.prev = null;  // Set the prev pointer of the new head to null
        }
        System.out.println("Element dequeued from the queue");
    }

    // Display the elements of the queue
    public void display() {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }
        DoublyNode temp = head;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingDoublyLinkedList queue = new QueueUsingDoublyLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display(); // Queue: 10 20 30 40

        queue.dequeue();
        queue.display(); // Queue: 20 30 40

        queue.dequeue();
        queue.display(); // Queue: 30 40

        queue.dequeue();
        queue.dequeue();
        queue.display(); // Queue is empty
    }
}
