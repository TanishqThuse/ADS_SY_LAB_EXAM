/**Q4) 1)We Fly Anywhere Airlines (WFAA) is considering redesigning their
ticket counters for airline passengers. They would like to have two
separate waiting lines, one for regular customers and one for frequent
flyers. Assuming there is only one ticket agent available to serve all
passengers, they would like to determine the average waiting time for
both types of passengers using various strategies for taking passengers
from the waiting lines. WAP to simulate this situation.
 */

 import java.util.LinkedList;
 import java.util.Queue;
 import java.util.Random;
 
 public class AirlineTicketCounterSTL {
 
     public static void main(String[] args) {
         // Simulation parameters
         int simulationTime = 100; // Total simulation time in minutes
         int maxServiceTime = 5; // Max service time for a passenger
         double frequentFlyerProbability = 0.6; // Probability of a frequent flyer arriving
 
         Queue<Integer> regularQueue = new LinkedList<>(); // Arrival times for regular customers
         Queue<Integer> frequentFlyerQueue = new LinkedList<>(); // Arrival times for frequent flyers
         Queue<Integer> serviceTimes = new LinkedList<>(); // Service times for both queues
 
         Random random = new Random();
 
         // Variables for tracking waiting times
         int currentTime = 0;
         int totalRegularWaitTime = 0, totalFrequentFlyerWaitTime = 0;
         int servedRegular = 0, servedFrequentFlyers = 0;
 
         while (currentTime < simulationTime) {
             // Generate new passengers
             if (random.nextDouble() < frequentFlyerProbability) {
                 frequentFlyerQueue.add(currentTime);
                 serviceTimes.add(random.nextInt(maxServiceTime) + 1);
             } else {
                 regularQueue.add(currentTime);
                 serviceTimes.add(random.nextInt(maxServiceTime) + 1);
             }
 
             // Serve the next passenger
             if (!frequentFlyerQueue.isEmpty()) {
                 int arrivalTime = frequentFlyerQueue.poll();
                 int serviceTime = serviceTimes.poll();
                 totalFrequentFlyerWaitTime += currentTime - arrivalTime;
                 currentTime += serviceTime;
                 servedFrequentFlyers++;
             } else if (!regularQueue.isEmpty()) {
                 int arrivalTime = regularQueue.poll();
                 int serviceTime = serviceTimes.poll();
                 totalRegularWaitTime += currentTime - arrivalTime;
                 currentTime += serviceTime;
                 servedRegular++;
             } else {
                 // If no passengers, move to the next time step
                 currentTime++;
             }
         }
 
         // Calculate average waiting times
         double averageRegularWaitTime = (servedRegular == 0) ? 0 : (double) totalRegularWaitTime / servedRegular;
         double averageFrequentFlyerWaitTime = (servedFrequentFlyers == 0) ? 0 : (double) totalFrequentFlyerWaitTime / servedFrequentFlyers;
 
         // Display results
         System.out.println("Simulation Results:");
         System.out.println("Total Regular Customers Served: " + servedRegular);
         System.out.println("Total Frequent Flyers Served: " + servedFrequentFlyers);
         System.out.println("Average Waiting Time for Regular Customers: " + averageRegularWaitTime + " minutes");
         System.out.println("Average Waiting Time for Frequent Flyers: " + averageFrequentFlyerWaitTime + " minutes");
     }
 }
 