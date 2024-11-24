/*Q4) 4)Write a menu­driven program that maintains a queue of passengers
waiting to see a ticket agent. The program user should be able to insert a
new passenger at the rear of the queue, display the passenger at the front
of the queue, or remove the passenger at the front of the queue. The
program will display the number of passengers left in the queue just
before it terminates. */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Passenger {
    String name;

    // Constructor to initialize the passenger's name
    public Passenger(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class TicketQueueSystem {

    public static void main(String[] args) {
        // Queue to store passengers
        Queue<Passenger> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            // Displaying the menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add new passenger to the queue");
            System.out.println("2. Display the passenger at the front of the queue");
            System.out.println("3. Remove the passenger at the front of the queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    // Add a new passenger to the queue
                    System.out.print("Enter the name of the passenger: ");
                    String name = scanner.nextLine();
                    Passenger passenger = new Passenger(name);
                    queue.add(passenger);
                    System.out.println("Passenger " + name + " added to the queue.");
                    break;
                
                case 2:
                    // Display the passenger at the front of the queue
                    if (queue.isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        System.out.println("The passenger at the front of the queue is: " + queue.peek());
                    }
                    break;
                
                case 3:
                    // Remove the passenger at the front of the queue
                    if (queue.isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        Passenger removedPassenger = queue.poll();
                        System.out.println("Passenger " + removedPassenger + " has been removed from the queue.");
                    }
                    break;
                
                case 4:
                    // Exit the program and display the number of passengers left
                    System.out.println("Exiting the program...");
                    System.out.println("Number of passengers left in the queue: " + queue.size());
                    break;
                
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

/*Menu:
1. Add new passenger to the queue
2. Display the passenger at the front of the queue
3. Remove the passenger at the front of the queue
4. Exit
Enter your choice: 1
Enter the name of the passenger: John
Passenger John added to the queue.

Menu:
1. Add new passenger to the queue
2. Display the passenger at the front of the queue
3. Remove the passenger at the front of the queue
4. Exit
Enter your choice: 1
Enter the name of the passenger: Alice
Passenger Alice added to the queue.

Menu:
1. Add new passenger to the queue
2. Display the passenger at the front of the queue
3. Remove the passenger at the front of the queue
4. Exit
Enter your choice: 2
The passenger at the front of the queue is: John

Menu:
1. Add new passenger to the queue
2. Display the passenger at the front of the queue
3. Remove the passenger at the front of the queue
4. Exit
Enter your choice: 3
Passenger John has been removed from the queue.

Menu:
1. Add new passenger to the queue
2. Display the passenger at the front of the queue
3. Remove the passenger at the front of the queue
4. Exit
Enter your choice: 4
Exiting the program...
Number of passengers left in the queue: 1
 */