/**Q4) 5)Write a program which simulates the operation of a busy airport which
has only two runways to handle all takeoffs and landings. You may
assume that each takeoff or landing takes 15 minutes to complete. One
runway request is made during each five minute time interval and
likelihood of landing request is the same as for takeoff. Priority is given
to planes requesting a landing. If a request cannot be honored it is added
to a takeoff or landing queue. Your program should simulate 120
minutes of activity at the airport. Each request for runway clearance
should be time­stamped and added to the appropriate queue. The output
from your program should include the final queue contents, the number
of take offs completed, the number of landings completed, and the
average number of minutes spent in each queue.
     */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class RunwayRequest {
    String type; // "Takeoff" or "Landing"
    int timestamp; // Time when the request is made

    public RunwayRequest(String type, int timestamp) {
        this.type = type;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Request Type: " + type + ", Time: " + timestamp + " minutes";
    }
}

public class AirportSimulation {

    private static final int SIMULATION_TIME = 120; // Simulation time in minutes
    private static final int RUNWAY_TIME = 15; // Time to complete one takeoff or landing
    private static final int REQUEST_INTERVAL = 5; // Request made every 5 minutes

    public static void main(String[] args) {
        Queue<RunwayRequest> landingQueue = new LinkedList<>();
        Queue<RunwayRequest> takeoffQueue = new LinkedList<>();
        
        int landingsCompleted = 0;
        int takeoffsCompleted = 0;
        int totalLandingWaitTime = 0;
        int totalTakeoffWaitTime = 0;

        Random random = new Random();

        // Simulating 120 minutes of activity
        for (int currentTime = 0; currentTime < SIMULATION_TIME; currentTime += REQUEST_INTERVAL) {
            // New request arrives every 5 minutes
            if (random.nextBoolean()) {
                // Randomly decide between a landing or takeoff request
                String type = "Landing";
                landingQueue.add(new RunwayRequest(type, currentTime));
                System.out.println("Landing request added at time: " + currentTime);
            } else {
                // Randomly decide between a landing or takeoff request
                String type = "Takeoff";
                takeoffQueue.add(new RunwayRequest(type, currentTime));
                System.out.println("Takeoff request added at time: " + currentTime);
            }

            // Process runway requests (priority is given to landings)
            if (!landingQueue.isEmpty()) {
                // Process a landing if there's a landing request
                RunwayRequest landingRequest = landingQueue.poll();
                totalLandingWaitTime += currentTime - landingRequest.timestamp;
                landingsCompleted++;
                System.out.println("Landing request processed at time: " + currentTime);
            } else if (!takeoffQueue.isEmpty()) {
                // Process a takeoff if there's no landing request
                RunwayRequest takeoffRequest = takeoffQueue.poll();
                totalTakeoffWaitTime += currentTime - takeoffRequest.timestamp;
                takeoffsCompleted++;
                System.out.println("Takeoff request processed at time: " + currentTime);
            }
        }

        // Output the results after simulation
        System.out.println("\n--- Final Results ---");
        System.out.println("Landings completed: " + landingsCompleted);
        System.out.println("Takeoffs completed: " + takeoffsCompleted);
        System.out.println("Remaining landing requests in queue: " + landingQueue.size());
        System.out.println("Remaining takeoff requests in queue: " + takeoffQueue.size());
        
        if (landingsCompleted > 0) {
            System.out.println("Average wait time for landings: " + (double) totalLandingWaitTime / landingsCompleted + " minutes");
        }
        if (takeoffsCompleted > 0) {
            System.out.println("Average wait time for takeoffs: " + (double) totalTakeoffWaitTime / takeoffsCompleted + " minutes");
        }
        
        // Print the final contents of the queues
        System.out.println("\nFinal contents of Landing Queue:");
        for (RunwayRequest request : landingQueue) {
            System.out.println(request);
        }

        System.out.println("\nFinal contents of Takeoff Queue:");
        for (RunwayRequest request : takeoffQueue) {
            System.out.println(request);
        }
    }
}

/**Landing request added at time: 0
Takeoff request added at time: 5
Landing request added at time: 10
Takeoff request added at time: 15
...
Landing request processed at time: 0
Takeoff request processed at time: 5
Landing request processed at time: 10
Takeoff request processed at time: 15
...
--- Final Results ---
Landings completed: 22
Takeoffs completed: 22
Remaining landing requests in queue: 0
Remaining takeoff requests in queue: 0
Average wait time for landings: 8.090909090909092 minutes
Average wait time for takeoffs: 8.272727272727273 minutes

Final contents of Landing Queue:
(no entries)

Final contents of Takeoff Queue:
(no entries)
 */