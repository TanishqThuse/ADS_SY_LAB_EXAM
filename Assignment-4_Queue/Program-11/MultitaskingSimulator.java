/*Q4) 11) Write a Program to simulate the following situation. Computer is a
multitasking device. We need to download some document as well as
listen music and play game simultaneously. There is a system queue
which decides which task to be done first. Assume that for download
application priority is highest and game playing is having lowest
priority. After completion of one type of tasks like all download
operations then the second queue will be processed */

import java.util.LinkedList;
import java.util.Queue;

class Task {
    String name;
    int time;

    // Constructor to initialize task name and time required to complete the task
    public Task(String name, int time) {
        this.name = name;
        this.time = time;
    }
}

public class MultitaskingSimulator {

    public static void main(String[] args) {
        // Queues for each type of task
        Queue<Task> downloadQueue = new LinkedList<>();
        Queue<Task> musicQueue = new LinkedList<>();
        Queue<Task> gameQueue = new LinkedList<>();

        // Adding download tasks (highest priority)
        downloadQueue.add(new Task("Download Task 1", 10));
        downloadQueue.add(new Task("Download Task 2", 15));

        // Adding music listening tasks (medium priority)
        musicQueue.add(new Task("Music Task 1", 5));
        musicQueue.add(new Task("Music Task 2", 8));

        // Adding game playing tasks (lowest priority)
        gameQueue.add(new Task("Game Task 1", 15));
        gameQueue.add(new Task("Game Task 2", 20));

        // Simulate the multitasking process
        System.out.println("Starting task processing...");
        
        // Process download tasks first
        processTasks(downloadQueue, "Download");

        // Process music tasks next
        processTasks(musicQueue, "Music");

        // Finally, process game tasks
        processTasks(gameQueue, "Game");

        System.out.println("All tasks completed.");
    }

    // Method to process tasks from the given queue
    public static void processTasks(Queue<Task> queue, String taskType) {
        System.out.println("Processing " + taskType + " tasks...");
        
        while (!queue.isEmpty()) {
            Task currentTask = queue.poll(); // Remove the task from the queue
            System.out.println(currentTask.name + " is being processed for " + currentTask.time + " minutes.");
            // Simulate task completion by waiting for the task time (just printing the task details here)
            try {
                Thread.sleep(currentTask.time * 1000); // Simulate task processing time (in seconds)
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(currentTask.name + " completed.");
        }
        System.out.println(taskType + " tasks processing completed.");
    }
}

/*Starting task processing...
Processing Download tasks...
Download Task 1 is being processed for 10 minutes.
Download Task 1 completed.
Download Task 2 is being processed for 15 minutes.
Download Task 2 completed.
Download tasks processing completed.
Processing Music tasks...
Music Task 1 is being processed for 5 minutes.
Music Task 1 completed.
Music Task 2 is being processed for 8 minutes.
Music Task 2 completed.
Music tasks processing completed.
Processing Game tasks...
Game Task 1 is being processed for 15 minutes.
Game Task 1 completed.
Game Task 2 is being processed for 20 minutes.
Game Task 2 completed.
Game tasks processing completed.
All tasks completed.
 */
