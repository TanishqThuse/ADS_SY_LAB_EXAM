/**Q4) 13)Write a Program to implement multiple queue i.e. two queues using
array and perform following operations on it. A. Addq, B. Delq, C.
Display Queue */

import java.util.Scanner;

public class MultipleQueue {

    static class Queue {
        int[] arr;
        int front1, rear1, front2, rear2, size;

        public Queue(int size) {
            this.size = size;
            arr = new int[size];
            front1 = rear1 = -1;
            front2 = rear2 = size;
        }

        // Add element to Queue 1
        public void addq1(int item) {
            if (rear1 + 1 == front2) {
                System.out.println("Queue 1 is full!");
            } else {
                if (front1 == -1) {
                    front1 = 0;
                }
                rear1++;
                arr[rear1] = item;
            }
        }

        // Add element to Queue 2
        public void addq2(int item) {
            if (rear2 - 1 == rear1) {
                System.out.println("Queue 2 is full!");
            } else {
                if (front2 == size) {
                    front2 = size - 1;
                }
                rear2--;
                arr[rear2] = item;
            }
        }

        // Remove element from Queue 1
        public void delq1() {
            if (front1 == -1) {
                System.out.println("Queue 1 is empty!");
            } else {
                System.out.println("Deleted from Queue 1: " + arr[front1]);
                front1++;
                if (front1 > rear1) {
                    front1 = rear1 = -1;
                }
            }
        }

        // Remove element from Queue 2
        public void delq2() {
            if (front2 == size) {
                System.out.println("Queue 2 is empty!");
            } else {
                System.out.println("Deleted from Queue 2: " + arr[front2]);
                front2--;
                if (front2 < rear2) {
                    front2 = rear2 = size;
                }
            }
        }

        // Display elements of Queue 1
        public void displayQueue1() {
            if (front1 == -1) {
                System.out.println("Queue 1 is empty!");
            } else {
                System.out.print("Queue 1: ");
                for (int i = front1; i <= rear1; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }

        // Display elements of Queue 2
        public void displayQueue2() {
            if (front2 == size) {
                System.out.println("Queue 2 is empty!");
            } else {
                System.out.print("Queue 2: ");
                for (int i = front2; i < size; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a queue of size 10 for two queues
        Queue queue = new Queue(10);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add to Queue 1");
            System.out.println("2. Add to Queue 2");
            System.out.println("3. Remove from Queue 1");
            System.out.println("4. Remove from Queue 2");
            System.out.println("5. Display Queue 1");
            System.out.println("6. Display Queue 2");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item to add to Queue 1: ");
                    int item1 = sc.nextInt();
                    queue.addq1(item1);
                    break;

                case 2:
                    System.out.print("Enter item to add to Queue 2: ");
                    int item2 = sc.nextInt();
                    queue.addq2(item2);
                    break;

                case 3:
                    queue.delq1();
                    break;

                case 4:
                    queue.delq2();
                    break;

                case 5:
                    queue.displayQueue1();
                    break;

                case 6:
                    queue.displayQueue2();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
