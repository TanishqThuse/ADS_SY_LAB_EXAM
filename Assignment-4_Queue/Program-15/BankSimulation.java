/**Q4) 15)Write a Program for A bank simulation of its teller operation to see how
waiting times would be affected by adding another teller */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
    int id;
    int arrivalTime;
    int serviceTime;
    
    public Customer(int id, int arrivalTime, int serviceTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
}

class Teller {
    int id;
    int timeRemaining;  // Time remaining for the current customer to be served.
    
    public Teller(int id) {
        this.id = id;
        this.timeRemaining = 0;
    }
    
    // Check if the teller is available
    public boolean isAvailable() {
        return timeRemaining == 0;
    }
    
    // Serve a customer
    public void serveCustomer(Customer customer) {
        this.timeRemaining = customer.serviceTime;
    }
    
    // Reduce time remaining (simulate passing time)
    public void passTime() {
        if (timeRemaining > 0) {
            timeRemaining--;
        }
    }
    
}

public class BankSimulation {

    public static void simulateBank(int numTellers, int numCustomers) {
        Queue<Customer> customerQueue = new LinkedList<>();
        
        // Initialize the customers with random service times (for simplicity, between 1 to 5)
        for (int i = 0; i < numCustomers; i++) {
            customerQueue.add(new Customer(i + 1, i * 3, 1 + (int)(Math.random() * 5)));
        }
        
        // Initialize tellers
        Teller[] tellers = new Teller[numTellers];
        for (int i = 0; i < numTellers; i++) {
            tellers[i] = new Teller(i + 1);
        }
        
        // Simulate the bank operations
        int currentTime = 0;
        int totalWaitingTime = 0;
        int customersServed = 0;

        while (!customerQueue.isEmpty() || customersServed < numCustomers) {
            // Assign customers to available tellers
            for (Teller teller : tellers) {
                if (teller.isAvailable() && !customerQueue.isEmpty()) {
                    Customer customer = customerQueue.poll();
                    totalWaitingTime += (currentTime - customer.arrivalTime);
                    teller.serveCustomer(customer);
                    System.out.println("Time " + currentTime + ": Teller " + teller.id + " is serving customer " + customer.id);
                    customersServed++;
                }
            }
            
            // Pass time (decrease time remaining for each teller)
            for (Teller teller : tellers) {
                teller.passTime();
            }
            
            // Move time forward
            currentTime++;
        }
        
        // Output the results
        System.out.println("Total waiting time: " + totalWaitingTime + " minutes");
        System.out.println("Average waiting time: " + (totalWaitingTime / numCustomers) + " minutes");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of tellers: ");
        int numTellers = sc.nextInt();
        
        System.out.print("Enter the number of customers: ");
        int numCustomers = sc.nextInt();
        
        // Run the simulation
        simulateBank(numTellers, numCustomers);
        
        sc.close();
    }
}
