/**Q4) 6)Write a Program to implement double ended queue where user can add
and remove the elements from both front and rear of the queue */

import java.util.Scanner;

public class Deque {
    private int[] deque;
    private int front, rear, size, capacity;

    // Constructor to initialize deque
    public Deque(int capacity) {
        this.capacity = capacity;
        this.deque = new int[capacity];
        this.front = -1;
        this.rear = 0;
        this.size = 0;
    }

    // Method to check if the deque is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add an element to the front of the deque
    public void addFront(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot add to front.");
        } else {
            if (front == -1) { // First element in deque
                front = 0;
                rear = 0;
            } else {
                front = (front - 1 + capacity) % capacity; // Circular move
            }
            deque[front] = value;
            size++;
        }
    }

    // Add an element to the rear of the deque
    public void addRear(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot add to rear.");
        } else {
            if (front == -1) { // First element in deque
                front = 0;
                rear = 0;
            } else {
                rear = (rear + 1) % capacity; // Circular move
            }
            deque[rear] = value;
            size++;
        }
    }

    // Remove an element from the front of the deque
    public void removeFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove from front.");
        } else {
            System.out.println("Removed from front: " + deque[front]);
            front = (front + 1) % capacity; // Circular move
            size--;
            if (size == 0) { // Reset for empty deque
                front = -1;
                rear = 0;
            }
        }
    }

    // Remove an element from the rear of the deque
    public void removeRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove from rear.");
        } else {
            System.out.println("Removed from rear: " + deque[rear]);
            rear = (rear - 1 + capacity) % capacity; // Circular move
            size--;
            if (size == 0) { // Reset for empty deque
                front = -1;
                rear = 0;
            }
        }
    }

    // Display the current elements in the deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
        } else {
            System.out.println("Deque elements: ");
            int i = front;
            for (int count = 0; count < size; count++) {
                System.out.print(deque[i] + " ");
                i = (i + 1) % capacity; // Circular move
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the deque: ");
        int capacity = scanner.nextInt();
        Deque deque = new Deque(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Front");
            System.out.println("2. Add Rear");
            System.out.println("3. Remove Front");
            System.out.println("4. Remove Rear");
            System.out.println("5. Display Deque");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to add at the front: ");
                    int valueFront = scanner.nextInt();
                    deque.addFront(valueFront);
                    break;
                case 2:
                    System.out.print("Enter the value to add at the rear: ");
                    int valueRear = scanner.nextInt();
                    deque.addRear(valueRear);
                    break;
                case 3:
                    deque.removeFront();
                    break;
                case 4:
                    deque.removeRear();
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

/**Enter the capacity of the deque: 5

Menu:
1. Add Front
2. Add Rear
3. Remove Front
4. Remove Rear
5. Display Deque
6. Exit
Enter your choice: 1
Enter the value to add at the front: 10

Menu:
1. Add Front
2. Add Rear
3. Remove Front
4. Remove Rear
5. Display Deque
6. Exit
Enter your choice: 2
Enter the value to add at the rear: 20

Menu:
1. Add Front
2. Add Rear
3. Remove Front
4. Remove Rear
5. Display Deque
6. Exit
Enter your choice: 5
Deque elements: 
10 20 

Menu:
1. Add Front
2. Add Rear
3. Remove Front
4. Remove Rear
5. Display Deque
6. Exit
Enter your choice: 3
Removed from front: 10

Menu:
1. Add Front
2. Add Rear
3. Remove Front
4. Remove Rear
5. Display Deque
6. Exit
Enter your choice: 5
Deque elements: 
20 
 */