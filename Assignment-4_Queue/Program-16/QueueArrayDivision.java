/**Q4) 16)Array is given of size 'n'. We need to divide this array in 'm' numbers.
After division each sub­array is treated as a queue. If a one queue
becomes full we should utilize the space of its next adjacent queue. Write a program to simulate above situation */

import java.util.LinkedList;
import java.util.Queue;

public class QueueArrayDivision {

    // Function to divide the array into 'm' queues
    public static void simulateQueueDivision(int[] arr, int n, int m) {
        // Calculate the approximate number of elements each queue can hold
        int capacityPerQueue = (int) Math.ceil((double) n / m);  // Ensures that the queues are evenly distributed

        // Create 'm' queues
        Queue<Integer>[] queues = new Queue[m];
        for (int i = 0; i < m; i++) {
            queues[i] = new LinkedList<>();
        }

        int currentQueue = 0;  // Pointer to track the current queue
        // Iterate through the array and distribute elements into the queues
        for (int i = 0; i < n; i++) {
            // If the current queue is full, move to the next queue
            if (queues[currentQueue].size() == capacityPerQueue) {
                currentQueue++;
            }
            // Add the element to the current queue
            queues[currentQueue].offer(arr[i]);
        }

        // Display the contents of each queue
        for (int i = 0; i < m; i++) {
            System.out.print("Queue " + (i + 1) + ": ");
            for (Integer num : queues[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example array and number of queues
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;  // Size of the array
        int m = 3;  // Number of queues

        // Simulate the queue division
        simulateQueueDivision(arr, n, m);
    }
}
