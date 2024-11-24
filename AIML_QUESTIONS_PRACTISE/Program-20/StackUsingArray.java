import java.util.Scanner;

public class StackUsingArray {

    // Declare a maximum size for the stack
    private int maxSize;
    private int top;
    private int[] stack;

    // Constructor to initialize the stack
    public StackUsingArray(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1; // Stack is initially empty
    }

    // Push operation: Add element to stack
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow! Cannot add more elements.");
        } else {
            stack[++top] = value;
            System.out.println("Pushed " + value + " to stack.");
        }
    }

    // Pop operation: Remove top element from stack
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! No element to pop.");
        } else {
            System.out.println("Popped " + stack[top--] + " from stack.");
        }
    }

    // Display operation: Display all elements in the stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // Peek operation: Display the top element without removing it
    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty. No top element.");
        } else {
            System.out.println("Top element is: " + stack[top]);
        }
    }

    // Stack Full operation: Check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Stack Empty operation: Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        StackUsingArray stack = new StackUsingArray(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("5. Check if stack is full");
            System.out.println("6. Check if stack is empty");
            System.out.println("7. Exit");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    stack.peek();
                    break;
                case 5:
                    if (stack.isFull()) {
                        System.out.println("Stack is full.");
                    } else {
                        System.out.println("Stack is not full.");
                    }
                    break;
                case 6:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
