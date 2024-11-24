/**Q4) 3) Queues
Array is given of size 'n'. We need to divide this array in 'm' numbers.
After division each subarray is treated as a queue. If a one queue
becomes full we should utilize the space of its next adjecent queue. Write a program to simulate above situation.
 */

import java.util.*;

public class QueueSimulation {

    // Method to simulate the division of an array into m queues
    public static void divideArrayIntoQueues(int[] arr, int m) {
        int n = arr.length;
        int capacity = n / m; // Base size for each queue
        int remainder = n % m; // Remaining elements to be distributed
        
        // Create m queues
        Queue<Integer>[] queues = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            queues[i] = new LinkedList<>();
        }

        int index = 0;
        for (int i = 0; i < m; i++) {
            // Calculate the actual size of the current queue
            int currentQueueSize = capacity + (i < remainder ? 1 : 0);
            
            // Add elements to the current queue
            for (int j = 0; j < currentQueueSize; j++) {
                if (index < n) {
                    queues[i].offer(arr[index++]);
                }
            }
        }

        // Print out the queues
        for (int i = 0; i < m; i++) {
            System.out.println("Queue " + (i + 1) + ": " + queues[i]);
        }
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int m = 3; // Number of queues

        // Call the method to divide the array into m queues
        divideArrayIntoQueues(arr, m);
    }
}
