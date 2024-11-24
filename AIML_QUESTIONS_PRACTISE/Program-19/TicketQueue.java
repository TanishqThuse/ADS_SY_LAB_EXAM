import java.util.LinkedList;
import java.util.Queue;

public class TicketQueue {

    public static int timeToBuyTickets(int[] tickets, int k) {
        // Queue to store the person's index and their remaining tickets
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the queue with all people and their ticket counts
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(new int[] {i, tickets[i]});
        }
        
        int time = 0;
        
        // Process the queue
        while (!queue.isEmpty()) {
            int[] person = queue.poll();  // Get the person at the front of the queue
            int index = person[0];        // Person's original index
            int remainingTickets = person[1];  // Number of tickets the person needs to buy
            
            // One second passes as this person buys one ticket
            time++;
            
            // If the person still needs tickets, they go back to the end of the queue
            if (remainingTickets - 1 > 0) {
                queue.offer(new int[] {index, remainingTickets - 1});
            }
            
            // If this person is the one at index `k` and they have finished buying all tickets
            if (index == k && remainingTickets - 1 == 0) {
                break;  // We have found the time for person `k`
            }
        }
        
        return time;
    }

    public static void main(String[] args) {
        int[] tickets = {2, 3, 2};
        int k = 2;
        int result = timeToBuyTickets(tickets, k);
        System.out.println("Time taken for person " + k + " to finish buying tickets: " + result);
    }
}
