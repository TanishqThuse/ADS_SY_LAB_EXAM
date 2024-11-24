import java.util.Scanner;

public class CircularQueue {
    
    private static final int MAX_SIZE = 5; // Size of the queue
    private int[] queue;
    private int front, rear;

    // Constructor to initialize the queue
    public CircularQueue() {
        queue = new int[MAX_SIZE];
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Insert an element into the queue
    public void insert(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot insert " + value);
        } else {
            if (front == -1) {  // First insertion
                front = 0;
            }
            rear = (rear + 1) % MAX_SIZE;  // Circular increment
            queue[rear] = value;
            System.out.println(value + " inserted into the queue.");
        }
    }

    // Delete an element from the queue
    public void delete() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot delete.");
        } else {
            System.out.println(queue[front] + " deleted from the queue.");
            if (front == rear) {  // Only one element in the queue
                front = rear = -1;
            } else {
                front = (front + 1) % MAX_SIZE;  // Circular increment
            }
        }
    }

    // Display the front element
    public void displayFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    // Display the rear element
    public void displayRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Rear element: " + queue[rear]);
        }
    }

    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            int i = front;
            while (i != rear) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % MAX_SIZE;
            }
            System.out.print(queue[rear] + "\n");
        }
    }

    // Main method to test the queue operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularQueue queue = new CircularQueue();

        while (true) {
            System.out.println("\nCircular Queue Operations Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display Front");
            System.out.println("4. Display Rear");
            System.out.println("5. Check if Queue is Full");
            System.out.println("6. Check if Queue is Empty");
            System.out.println("7. Display Queue");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    queue.insert(value);
                    break;
                case 2:
                    queue.delete();
                    break;
                case 3:
                    queue.displayFront();
                    break;
                case 4:
                    queue.displayRear();
                    break;
                case 5:
                    if (queue.isFull()) {
                        System.out.println("Queue is full.");
                    } else {
                        System.out.println("Queue is not full.");
                    }
                    break;
                case 6:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                case 7:
                    queue.display();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
