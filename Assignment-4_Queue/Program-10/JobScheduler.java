/**Q4) 10)Assume that there are three jobs to be done (J1, J2, J3) by using queue.
Each is requiring different time for processing i.e. (t1, t2, t3), which is
greater than fixed time quantum 'n'. After 'n' time the current job is
forcefully preempted/ stopped and remaining task of the current job is
added at last of the queue. then next job is taken for processing. */

import java.util.LinkedList;
import java.util.Queue;

class Job {
    String name;
    int remainingTime;

    // Constructor to initialize job name and remaining processing time
    public Job(String name, int remainingTime) {
        this.name = name;
        this.remainingTime = remainingTime;
    }

    public static void main(String[] args) {
        // Creating the jobs with their respective processing times
        Job j1 = new Job("J1", 10);
        Job j2 = new Job("J2", 20);
        Job j3 = new Job("J3", 15);

        // Define time quantum (n)
        int timeQuantum = 5;

        // Queue to hold the jobs
        Queue<Job> jobQueue = new LinkedList<>();
        jobQueue.add(j1);
        jobQueue.add(j2);
        jobQueue.add(j3);

        // Start processing the jobs
        while (!jobQueue.isEmpty()) {
            Job currentJob = jobQueue.poll();  // Remove the first job from the queue

            // Process the current job for the time quantum or remaining time (whichever is smaller)
            int timeToProcess = Math.min(currentJob.remainingTime, timeQuantum);
            currentJob.remainingTime -= timeToProcess;

            System.out.println(currentJob.name + " processed for " + timeToProcess + " units.");

            // If the job is not complete, re-add it to the queue with the remaining time
            if (currentJob.remainingTime > 0) {
                System.out.println(currentJob.name + " re-added to the queue with " + currentJob.remainingTime + " units remaining.");
                jobQueue.add(currentJob);
            } else {
                System.out.println(currentJob.name + " completed.");
            }

            // If the queue becomes empty, break the loop
            if (jobQueue.isEmpty()) {
                System.out.println("All jobs are completed.");
            }
        }
    }
}

public class JobScheduler {

    public static void main(String[] args) {
        // Creating the jobs with their respective processing times
        Job j1 = new Job("J1", 10);
        Job j2 = new Job("J2", 20);
        Job j3 = new Job("J3", 15);

        // Define time quantum (n)
        int timeQuantum = 5;

        // Queue to hold the jobs
        Queue<Job> jobQueue = new LinkedList<>();
        jobQueue.add(j1);
        jobQueue.add(j2);
        jobQueue.add(j3);

        // Start processing the jobs
        while (!jobQueue.isEmpty()) {
            Job currentJob = jobQueue.poll();  // Remove the first job from the queue

            // Process the current job for the time quantum or remaining time (whichever is smaller)
            int timeToProcess = Math.min(currentJob.remainingTime, timeQuantum);
            currentJob.remainingTime -= timeToProcess;

            System.out.println(currentJob.name + " processed for " + timeToProcess + " units.");

            // If the job is not complete, re-add it to the queue with the remaining time
            if (currentJob.remainingTime > 0) {
                System.out.println(currentJob.name + " re-added to the queue with " + currentJob.remainingTime + " units remaining.");
                jobQueue.add(currentJob);
            } else {
                System.out.println(currentJob.name + " completed.");
            }

            // If the queue becomes empty, break the loop
            if (jobQueue.isEmpty()) {
                System.out.println("All jobs are completed.");
            }
        }
    }
}
