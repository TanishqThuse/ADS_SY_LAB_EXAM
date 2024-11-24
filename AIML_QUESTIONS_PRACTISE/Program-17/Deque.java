import java.util.Scanner;

public class Deque {

    private static final int MAX_SIZE = 5; // Size of the deque
    private int[] deque;
    private int front, rear;

    // Constructor to initialize the deque
    public Deque() {
        deque = new int[MAX_SIZE];
        front = -1;
        rear = -1;
    }

    // Check if the deque is full
    public boolean isFull() {
        return (front == 0 && rear == MAX_SIZE - 1) || (front == rear + 1);
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Insert an element at the front of the deque
    public void insertFront(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert " + value + " at the front.");
        } else {
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (front == 0) {
                front = MAX_SIZE - 1; // Wrap around to the end of the deque
            } else {
                front = front - 1; // Decrement front index
            }
            deque[front] = value;
            System.out.println(value + " inserted at the front of the deque.");
        }
    }

    // Insert an element at the rear of the deque
    public void insertRear(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert " + value + " at the rear.");
        } else {
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (rear == MAX_SIZE - 1) {
                rear = 0; // Wrap around to the start of the deque
            } else {
                rear = rear + 1; // Increment rear index
            }
            deque[rear] = value;
            System.out.println(value + " inserted at the rear of the deque.");
        }
    }

    // Delete an element from the front of the deque
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from the front.");
        } else {
            System.out.println(deque[front] + " deleted from the front.");
            if (front == rear) {
                front = rear = -1; // Reset the deque if it's empty
            } else if (front == MAX_SIZE - 1) {
                front = 0; // Wrap around to the start of the deque
            } else {
                front = front + 1; // Increment front index
            }
        }
    }

    // Delete an element from the rear of the deque
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from the rear.");
        } else {
            System.out.println(deque[rear] + " deleted from the rear.");
            if (front == rear) {
                front = rear = -1; // Reset the deque if it's empty
            } else if (rear == 0) {
                rear = MAX_SIZE - 1; // Wrap around to the end of the deque
            } else {
                rear = rear - 1; // Decrement rear index
            }
        }
    }

    // Display the current state of the deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
        } else {
            System.out.print("Deque elements: ");
            int i = front;
            while (true) {
                System.out.print(deque[i] + " ");
                if (i == rear) {
                    break;
                }
                i = (i + 1) % MAX_SIZE; // Circular increment
            }
            System.out.println();
        }
    }

    // Main method to test the deque operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque deque = new Deque();

        while (true) {
            System.out.println("\nDeque Operations Menu:");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at Rear");
            System.out.println("3. Delete from Front");
            System.out.println("4. Delete from Rear");
            System.out.println("5. Display Deque");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at the front: ");
                    int frontValue = scanner.nextInt();
                    deque.insertFront(frontValue);
                    break;
                case 2:
                    System.out.print("Enter value to insert at the rear: ");
                    int rearValue = scanner.nextInt();
                    deque.insertRear(rearValue);
                    break;
                case 3:
                    deque.deleteFront();
                    break;
                case 4:
                    deque.deleteRear();
                    break;
                case 5:
                    deque.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
