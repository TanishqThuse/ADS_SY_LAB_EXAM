/**Q3) 13)WAP to implement following by using stack. A. Factorial of a given
number B. Generation of Fibonacci series */

import java.util.Stack;

public class Program_13 {

    // Factorial using stack
    public static int factorialUsingStack(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
        }

        int factorial = 1;
        while (!stack.isEmpty()) {
            factorial *= stack.pop();
        }
        return factorial;
    }

    // Fibonacci series using stack
    public static void fibonacciUsingStack(int n) {
        if (n <= 0) {
            System.out.println("Invalid input for Fibonacci series!");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        // Initialize the first two numbers of Fibonacci series
        stack.push(0);
        stack.push(1);

        System.out.print("Fibonacci series: ");
        System.out.print(stack.get(0)); // Print the first number
        for (int i = 2; i < n; i++) {
            // Get the last two numbers from the stack
            int secondLast = stack.get(stack.size() - 2);
            int last = stack.peek();

            // Add the next Fibonacci number
            stack.push(secondLast + last);
        }

        // Print the Fibonacci series from the stack
        for (int num : stack) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int number = 5; // Example input for factorial
        System.out.println("Factorial of " + number + " is: " + factorialUsingStack(number));

        int fibonacciCount = 10; // Example input for Fibonacci series
        fibonacciUsingStack(fibonacciCount);
    }
}
