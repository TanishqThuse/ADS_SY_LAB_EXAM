import java.util.LinkedList;
import java.util.Scanner;

public class PassengerQueue {

    private LinkedList<String> queue; // LinkedList to represent the queue

    // Constructor to initialize the queue
    public PassengerQueue() {
        queue = new LinkedList<>();
    }

    // Insert a new passenger at the rear of the queue
    public void insertPassenger(String passenger) {
        queue.addLast(passenger);
        System.out.println("Passenger " + passenger + " added to the queue.");
    }

    // Display the passenger at the front of the queue
    public void displayFrontPassenger() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty. No passengers to display.");
        } else {
            System.out.println("Passenger at the front: " + queue.getFirst());
        }
    }

    // Remove the passenger at the front of the queue
    public void removeFrontPassenger() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty. No passengers to remove.");
        } else {
            String removedPassenger = queue.removeFirst();
            System.out.println("Passenger " + removedPassenger + " has been removed from the queue.");
        }
    }

    // Display the number of passengers left in the queue
    public void displayPassengerCount() {
        System.out.println("Number of passengers left in the queue: " + queue.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerQueue passengerQueue = new PassengerQueue();
        
        while (true) {
            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("1. Insert a new passenger");
            System.out.println("2. Display the passenger at the front");
            System.out.println("3. Remove the passenger at the front");
            System.out.println("4. Display number of passengers left in the queue");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the new passenger: ");
                    String passengerName = scanner.nextLine();
                    passengerQueue.insertPassenger(passengerName);
                    break;
                case 2:
                    passengerQueue.displayFrontPassenger();
                    break;
                case 3:
                    passengerQueue.removeFrontPassenger();
                    break;
                case 4:
                    passengerQueue.displayPassengerCount();
                    break;
                case 5:
                    passengerQueue.displayPassengerCount(); // Display remaining passengers before exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
