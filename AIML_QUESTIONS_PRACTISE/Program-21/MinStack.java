public class MinStack {

    // Main stack to hold elements
    private java.util.Stack<Integer> stack;
    
    // Auxiliary stack to hold the minimums
    private java.util.Stack<Integer> minStack;

    // Constructor to initialize the stack
    public MinStack() {
        stack = new java.util.Stack<>();
        minStack = new java.util.Stack<>();
    }

    // Push an element onto the stack
    public void push(int val) {
        stack.push(val);
        
        // Push the minimum value onto the min stack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop the top element from the stack
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        
        // Pop from both stacks
        int poppedValue = stack.pop();
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get the top element of the stack
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new IllegalStateException("Stack is empty");
    }

    // Retrieve the minimum element in the stack
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new IllegalStateException("Stack is empty");
    }

    public static void main(String[] args) {
        // Testing the MinStack class
        MinStack minStack = new MinStack();
        minStack.push(5);
        System.out.println(minStack.getMin()); // 5
        minStack.push(3);
        System.out.println(minStack.getMin()); // 3
        minStack.push(7);
        System.out.println(minStack.getMin()); // 3
        minStack.pop();
        System.out.println(minStack.getMin()); // 3
        minStack.pop();
        System.out.println(minStack.getMin()); // 5
    }
}
