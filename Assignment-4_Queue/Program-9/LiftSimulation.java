/**Q4) 9)There is a lift in our college. Students, staff and guest are utilizing it.
Students are using the lift when no staff is there. Whenever staff is in the
lift students are moving out of the lift. Whenever HOD's / Dean's /
Director want to use lift then staff are moving out of the lift. It means
every entity which is using the lift is having some priority. High priority
entity will be served first. Simulate this situation by using appropriate
queue.
 */

import java.util.PriorityQueue;
import java.util.Scanner;

// Enum to define the entity types
enum EntityType {
    STUDENT, STAFF, HOD_DEAN_DIRECTOR
}

// Person class to represent each entity
class Person implements Comparable<Person> {
    String name;
    EntityType type;
    int priority;

    // Constructor to create a person object with priority based on entity type
    public Person(String name, EntityType type) {
        this.name = name;
        this.type = type;

        // Assign priority based on entity type
        switch (type) {
            case STAFF:
                this.priority = 2; // Medium priority
                break;
            case HOD_DEAN_DIRECTOR:
                this.priority = 3; // High priority
                break;
            default:
                this.priority = 1; // Low priority for students
                break;
        }
    }

    // Method to display person information
    public void display() {
        System.out.println("Name: " + name + ", Type: " + type);
    }

    // Compare persons based on priority
    @Override
    public int compareTo(Person other) {
        return Integer.compare(other.priority, this.priority); // Reverse order for priority
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Person> liftQueue = new PriorityQueue<>(); // Priority queue for managing the lift

        // Menu for lift operations
        while (true) {
            System.out.println("\n--- Lift Simulation ---");
            System.out.println("1. Add a person to the lift");
            System.out.println("2. Serve the lift (process the next person)");
            System.out.println("3. Display the current queue");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    // Add a person to the lift
                    System.out.print("Enter person's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter person's type (STUDENT, STAFF, HOD_DEAN_DIRECTOR): ");
                    String typeStr = scanner.nextLine().toUpperCase();

                    EntityType type;
                    switch (typeStr) {
                        case "STAFF":
                            type = EntityType.STAFF;
                            break;
                        case "HOD_DEAN_DIRECTOR":
                            type = EntityType.HOD_DEAN_DIRECTOR;
                            break;
                        case "STUDENT":
                        default:
                            type = EntityType.STUDENT;
                            break;
                    }

                    Person person = new Person(name, type);
                    liftQueue.add(person);
                    System.out.println(person.name + " has entered the lift.");
                    break;

                case 2:
                    // Serve the lift by processing the next person in queue
                    if (liftQueue.isEmpty()) {
                        System.out.println("The lift is empty.");
                    } else {
                        Person nextPerson = liftQueue.poll(); // Remove the highest priority person
                        System.out.println("Serving " + nextPerson.name + " (" + nextPerson.type + ")");
                    }
                    break;

                case 3:
                    // Display the current queue of people in the lift
                    if (liftQueue.isEmpty()) {
                        System.out.println("The lift is empty.");
                    } else {
                        System.out.println("Current queue in the lift:");
                        for (Person personInLift : liftQueue) {
                            personInLift.display();
                        }
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting the lift simulation.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class LiftSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Person> liftQueue = new PriorityQueue<>(); // Priority queue for managing the lift

        // Menu for lift operations
        while (true) {
            System.out.println("\n--- Lift Simulation ---");
            System.out.println("1. Add a person to the lift");
            System.out.println("2. Serve the lift (process the next person)");
            System.out.println("3. Display the current queue");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    // Add a person to the lift
                    System.out.print("Enter person's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter person's type (STUDENT, STAFF, HOD_DEAN_DIRECTOR): ");
                    String typeStr = scanner.nextLine().toUpperCase();

                    EntityType type;
                    switch (typeStr) {
                        case "STAFF":
                            type = EntityType.STAFF;
                            break;
                        case "HOD_DEAN_DIRECTOR":
                            type = EntityType.HOD_DEAN_DIRECTOR;
                            break;
                        case "STUDENT":
                        default:
                            type = EntityType.STUDENT;
                            break;
                    }

                    Person person = new Person(name, type);
                    liftQueue.add(person);
                    System.out.println(person.name + " has entered the lift.");
                    break;

                case 2:
                    // Serve the lift by processing the next person in queue
                    if (liftQueue.isEmpty()) {
                        System.out.println("The lift is empty.");
                    } else {
                        Person nextPerson = liftQueue.poll(); // Remove the highest priority person
                        System.out.println("Serving " + nextPerson.name + " (" + nextPerson.type + ")");
                    }
                    break;

                case 3:
                    // Display the current queue of people in the lift
                    if (liftQueue.isEmpty()) {
                        System.out.println("The lift is empty.");
                    } else {
                        System.out.println("Current queue in the lift:");
                        for (Person personInLift : liftQueue) {
                            personInLift.display();
                        }
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting the lift simulation.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

/*--- Lift Simulation ---
1. Add a person to the lift
2. Serve the lift (process the next person)
3. Display the current queue
4. Exit
Enter your choice: 1
Enter person's name: John
Enter person's type (STUDENT, STAFF, HOD_DEAN_DIRECTOR): student
John has entered the lift.

--- Lift Simulation ---
1. Add a person to the lift
2. Serve the lift (process the next person)
3. Display the current queue
4. Exit
Enter your choice: 1
Enter person's name: Sarah
Enter person's type (STUDENT, STAFF, HOD_DEAN_DIRECTOR): staff
Sarah has entered the lift.

--- Lift Simulation ---
1. Add a person to the lift
2. Serve the lift (process the next person)
3. Display the current queue
4. Exit
Enter your choice: 1
Enter person's name: Dr. Smith
Enter person's type (STUDENT, STAFF, HOD_DEAN_DIRECTOR): hod_dean_director
Dr. Smith has entered the lift.

--- Lift Simulation ---
1. Add a person to the lift
2. Serve the lift (process the next person)
3. Display the current queue
4. Exit
Enter your choice: 3
Current queue in the lift:
Name: Dr. Smith, Type: HOD_DEAN_DIRECTOR
Name: Sarah, Type: STAFF
Name: John, Type: STUDENT

--- Lift Simulation ---
1. Add a person to the lift
2. Serve the lift (process the next person)
3. Display the current queue
4. Exit
Enter your choice: 2
Serving Dr. Smith (HOD_DEAN_DIRECTOR)

--- Lift Simulation ---
1. Add a person to the lift
2. Serve the lift (process the next person)
3. Display the current queue
4. Exit
Enter your choice: 2
Serving Sarah (STAFF)

--- Lift Simulation ---
1. Add a person to the lift
2. Serve the lift (process the next person)
3. Display the current queue
4. Exit
Enter your choice: 2
Serving John (STUDENT)
 */
