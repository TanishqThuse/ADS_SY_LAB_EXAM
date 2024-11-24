import java.util.ArrayList;
import java.util.Scanner;

public class Program_12 {
    static class Stack {
        ArrayList<Integer> elements;
        int maxSize;

        Stack(int maxSize) {
            this.maxSize = maxSize;
            this.elements = new ArrayList<>();
        }

        boolean isFull() {
            return elements.size() == maxSize;
        }

        boolean isEmpty() {
            return elements.isEmpty();
        }

        void push(int value) {
            elements.add(value);
        }

        int pop() {
            if (!isEmpty()) {
                return elements.remove(elements.size() - 1);
            }
            throw new IllegalStateException("Stack is empty!");
        }

        int size() {
            return elements.size();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size and elements
        System.out.print("Enter size of array (n): ");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.print("Enter elements of array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // Input number of stacks
        System.out.print("Enter number of stacks (m): ");
        int m = sc.nextInt();
        if (m <= 2 || m >= n) {
            System.out.println("Invalid number of stacks! (2 < m < n)");
            return;
        }

        // Calculate maximum size of each stack
        int baseSize = n / m;
        int extra = n % m; // Extra elements to distribute among first 'extra' stacks

        // Initialize stacks
        Stack[] stacks = new Stack[m];
        for (int i = 0; i < m; i++) {
            int stackSize = baseSize + (i < extra ? 1 : 0);
            stacks[i] = new Stack(stackSize);
        }

        // Fill the stacks
        int index = 0;
        for (int value : array) {
            while (index < m && stacks[index].isFull()) {
                index++;
            }
            if (index < m) {
                stacks[index].push(value);
            } else {
                System.out.println("All stacks are full!");
                break;
            }
        }

        // Print stacks
        System.out.println("\nStacks after filling:");
        for (int i = 0; i < m; i++) {
            System.out.println("Stack " + (i + 1) + ": " + stacks[i].elements);
        }

        // Simulate pop operation with overflow handling
        System.out.println("\nPerforming pop operations with overflow handling:");
        for (int i = 0; i < m; i++) {
            while (!stacks[i].isEmpty()) {
                System.out.println("Popped from Stack " + (i + 1) + ": " + stacks[i].pop());
            }
        }

        sc.close();
    }
}


/**Enter size of array (n): 10
Enter elements of array: 1 2 3 4 5 6 7 8 9 10
Enter number of stacks (m): 3
 */