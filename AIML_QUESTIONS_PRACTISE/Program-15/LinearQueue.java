import java.util.Scanner;

public class LinearQueue {
    
    // Define a maximum size for the queue
    private static final int MAX_SIZE = 5; // Adjust size as needed
    private int[] queue;
    private int front, rear;
    
    // Constructor to initialize the queue
    public LinearQueue() {
        queue = new int[MAX_SIZE];
        front = -1;
        rear = -1;
    }
    
    // Check if the queue is full
    public boolean isFull() {
        return rear == MAX_SIZE - 1;
    }
    
    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1 || front > rear;
    }
    
    // Insert an element into the queue
    public void insert(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot insert " + value);
        } else {
            if (front == -1) {
                front = 0; // First element being inserted
            }
            queue[++rear] = value;
            System.out.println(value + " inserted into the queue.");
        }
    }
    
    // Delete an element from the queue
    public void delete() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot delete.");
        } else {
            System.out.println(queue[front] + " deleted from the queue.");
            front++;
        }
    }
    
    // Peek the front element of the queue
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }
    
    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
    
    // Main method to test the queue operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinearQueue queue = new LinearQueue();
        
        while (true) {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Peek");
            System.out.println("4. Check if Queue is Full");
            System.out.println("5. Check if Queue is Empty");
            System.out.println("6. Display Queue");
            System.out.println("7. Exit");
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
                    queue.peek();
                    break;
                case 4:
                    if (queue.isFull()) {
                        System.out.println("Queue is full.");
                    } else {
                        System.out.println("Queue is not full.");
                    }
                    break;
                case 5:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                case 6:
                    queue.display();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
