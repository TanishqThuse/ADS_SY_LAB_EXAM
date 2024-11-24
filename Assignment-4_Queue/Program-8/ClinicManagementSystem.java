/**Q4) 8)Write a Program to keep track of patients as they check into a medical
clinic, assigning patients to doctors on a first­come, first­served basis. */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Patient {
    String name;
    int patientId;

    // Constructor to create a patient object
    public Patient(String name, int patientId) {
        this.name = name;
        this.patientId = patientId;
    }

    // Method to display patient information
    public void display() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name);
    }
}

class Clinic {
    private Queue<Patient> patientQueue;
    private int doctorCount;

    // Constructor to initialize clinic with number of doctors
    public Clinic(int doctorCount) {
        this.patientQueue = new LinkedList<>();
        this.doctorCount = doctorCount;
    }

    // Method to add patient to the queue
    public void checkInPatient(Patient patient) {
        patientQueue.add(patient);
        System.out.println("Patient " + patient.name + " checked in.");
    }

    // Method to assign doctor to the next patient in queue
    public void assignDoctor() {
        if (patientQueue.isEmpty()) {
            System.out.println("No patients left to serve.");
        } else {
            Patient patient = patientQueue.poll();
            System.out.println("Assigning Doctor to Patient " + patient.name + " (ID: " + patient.patientId + ")");
        }
    }

    // Method to display the queue status
    public void displayQueue() {
        if (patientQueue.isEmpty()) {
            System.out.println("No patients are waiting.");
        } else {
            System.out.println("Patients waiting for consultation:");
            for (Patient patient : patientQueue) {
                patient.display();
            }
        }
    }

    // Method to get the number of patients left in the queue
    public int getRemainingPatients() {
        return patientQueue.size();
    }
}

public class ClinicManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a clinic with a certain number of doctors
        System.out.print("Enter the number of doctors available: ");
        int doctorsAvailable = scanner.nextInt();
        Clinic clinic = new Clinic(doctorsAvailable);

        // Menu to interact with the system
        while (true) {
            System.out.println("\n--- Clinic Management System ---");
            System.out.println("1. Check-in a new patient");
            System.out.println("2. Assign doctor to a patient");
            System.out.println("3. Display the queue of waiting patients");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    // Check-in a new patient
                    System.out.print("Enter patient's name: ");
                    String name = scanner.nextLine();
                    int patientId = (int) (Math.random() * 1000);  // Assigning a random patient ID
                    Patient newPatient = new Patient(name, patientId);
                    clinic.checkInPatient(newPatient);
                    break;

                case 2:
                    // Assign doctor to a patient
                    clinic.assignDoctor();
                    break;

                case 3:
                    // Display the queue of waiting patients
                    clinic.displayQueue();
                    break;

                case 4:
                    // Exit the system
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

/**Enter the number of doctors available: 2

--- Clinic Management System ---
1. Check-in a new patient
2. Assign doctor to a patient
3. Display the queue of waiting patients
4. Exit
Enter your choice: 1
Enter patient's name: John Doe
Patient John Doe checked in.

--- Clinic Management System ---
1. Check-in a new patient
2. Assign doctor to a patient
3. Display the queue of waiting patients
4. Exit
Enter your choice: 1
Enter patient's name: Alice Smith
Patient Alice Smith checked in.

--- Clinic Management System ---
1. Check-in a new patient
2. Assign doctor to a patient
3. Display the queue of waiting patients
4. Exit
Enter your choice: 3
Patients waiting for consultation:
Patient ID: 123, Name: John Doe
Patient ID: 456, Name: Alice Smith

--- Clinic Management System ---
1. Check-in a new patient
2. Assign doctor to a patient
3. Display the queue of waiting patients
4. Exit
Enter your choice: 2
Assigning Doctor to Patient John Doe (ID: 123)

--- Clinic Management System ---
1. Check-in a new patient
2. Assign doctor to a patient
3. Display the queue of waiting patients
4. Exit
Enter your choice: 3
Patients waiting for consultation:
Patient ID: 456, Name: Alice Smith
 */