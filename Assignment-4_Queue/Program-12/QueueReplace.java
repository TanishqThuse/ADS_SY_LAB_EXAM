/**Q4) 12) Write an algorithm Replace that takes a queue and two item. If the first
item is in the queue, replace it with the second item, leaving the rest of
the queue unchanged */

import java.util.LinkedList;
import java.util.Queue;

public class QueueReplace {
    
    // Method to replace an item in the queue with another item
    public static Queue<Integer> replace(Queue<Integer> queue, int oldItem, int newItem) {
        int size = queue.size();
        
        // Iterate through the queue
        for (int i = 0; i < size; i++) {
            int item = queue.poll();  // Dequeue the front element
            
            if (item == oldItem) {  // Check if it matches the item to be replaced
                queue.offer(newItem);  // Enqueue the new item
                return queue;  // Stop after replacing the first occurrence
            }
            
            queue.offer(item);  // Otherwise, re-enqueue the item
        }
        
        return queue;  // Return the queue after attempting to replace oldItem
    }
    
    // Main method to test the replace function
    public static void main(String[] args) {
        // Create a queue and add elements
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        
        // Old item to replace and new item to insert
        int oldItem = 30;
        int newItem = 35;
        
        // Print original queue
        System.out.println("Original Queue: " + queue);
        
        // Call the replace method
        queue = replace(queue, oldItem, newItem);
        
        // Print modified queue
        System.out.println("Modified Queue: " + queue);
    }
}
