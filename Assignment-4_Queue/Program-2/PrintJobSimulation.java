/**Q4) 2)An operating system assigns job to print queues based on the number of
07/11/2015 Subjects & Assignments
http://172.17.0.24/asportal/manageassign.php 4/8
4 2 Queues
pages to be printed (1 to 50 pages). You may assume that the system
printers are able to print 10 page per minute. Smaller print jobs are
printed before larger print jobs and print jobs are processed from a
single print queue implemented as a priority queue). The system
administrators would like to compare the time required to process a set
of print jobs using 1, 2, or 3 system printers. Write a program which
simulates processing 100 print jobs of varying lengths using either 1, 2,
or 3 printers. Assume that a print request is made every minute and that
the number of pages to print varies from 1 to 50 pages. To be fair, you
will need to process the same set of print jobs each time you add a
printer.The output from your program should indicate the order in which
the jobs were received, the order in which they were printed, and the
time required to process the set of print jobs. If more than one printer is
being used, indicate which printer each job was printed on */


import java.util.*;

public class PrintJobSimulation {

    static class PrintJob {
        int jobId;
        int pages; // Number of pages to print
        int arrivalTime; // The minute the job was requested

        PrintJob(int jobId, int pages, int arrivalTime) {
            this.jobId = jobId;
            this.pages = pages;
            this.arrivalTime = arrivalTime;
        }
    }

    static class Printer implements Comparable<Printer> {
        int printerId;
        int timeRemaining; // Time remaining before the printer is free

        Printer(int printerId) {
            this.printerId = printerId;
            this.timeRemaining = 0;
        }

        // Compare printers based on their availability (time remaining)
        @Override
        public int compareTo(Printer other) {
            return Integer.compare(this.timeRemaining, other.timeRemaining);
        }
    }

    public static void main(String[] args) {
        int numJobs = 100;
        int maxPages = 50;
        int printersCount = 3; // We can simulate with 1, 2, or 3 printers

        Random rand = new Random();
        PriorityQueue<PrintJob> printQueue = new PriorityQueue<>(Comparator.comparingInt(j -> j.pages)); // Priority queue for jobs
        List<Printer> printers = new ArrayList<>();

        // Initialize printers
        for (int i = 0; i < printersCount; i++) {
            printers.add(new Printer(i + 1));
        }

        // Generate jobs with random pages
        for (int i = 0; i < numJobs; i++) {
            int pages = rand.nextInt(maxPages) + 1; // Random pages between 1 to 50
            printQueue.add(new PrintJob(i + 1, pages, i)); // Job ID starts from 1
        }

        // Simulate printing
        int currentTime = 0;
        List<PrintJob> printedJobs = new ArrayList<>();
        PriorityQueue<Printer> printerQueue = new PriorityQueue<>(printers); // Queue to handle printer availability

        while (!printQueue.isEmpty() || !printerQueue.isEmpty()) {
            // Assign jobs to printers based on their availability
            while (!printQueue.isEmpty() && printerQueue.size() > 0) {
                PrintJob job = printQueue.poll();
                Printer availablePrinter = printerQueue.poll();
                int printTime = (int) Math.ceil((double) job.pages / 10); // 10 pages per minute
                availablePrinter.timeRemaining = currentTime + printTime;
                printedJobs.add(job);
                System.out.println("Job " + job.jobId + " (Pages: " + job.pages + ") printed on Printer " + availablePrinter.printerId + " at time: " + availablePrinter.timeRemaining);
                printerQueue.add(availablePrinter); // Re-add printer to queue after it has finished
            }

            // Increment time by 1 minute
            currentTime++;
        }

        // Output total processing time
        System.out.println("\nTotal time to process all jobs: " + currentTime + " minutes.");
    }
}
