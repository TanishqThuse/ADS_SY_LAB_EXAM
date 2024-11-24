// /*Q5) 7)WAP to store at most 10 digit integer in a Singly linked list and perform
// arithmetic operations on it.
// */

import java.math.BigInteger;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node head;

    // Method to insert a digit at the end of the list
    public void insert(int digit) {
        Node newNode = new Node(digit);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to convert the linked list to a BigInteger
    public BigInteger toBigInteger() {
        Node temp = head;
        BigInteger num = BigInteger.ZERO;
        while (temp != null) {
            num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(temp.data));
            temp = temp.next;
        }
        return num;
    }

    // Method to display the number stored in the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create two linked lists to represent 10-digit numbers
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();

        // Insert digits for the first number (e.g., 1234567890)
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        list1.insert(5);
        list1.insert(6);
        list1.insert(7);
        list1.insert(8);
        list1.insert(9);
        list1.insert(0);

        // Insert digits for the second number (e.g., 9876543210)
        list2.insert(9);
        list2.insert(8);
        list2.insert(7);
        list2.insert(6);
        list2.insert(5);
        list2.insert(4);
        list2.insert(3);
        list2.insert(2);
        list2.insert(1);
        list2.insert(0);

        System.out.print("Number 1: ");
        list1.display(); // Display first number
        System.out.print("Number 2: ");
        list2.display(); // Display second number

        // Convert both linked lists to BigInteger
        BigInteger num1 = list1.toBigInteger();
        BigInteger num2 = list2.toBigInteger();

        // Perform addition
        BigInteger sum = num1.add(num2);
        System.out.println("Addition result: " + sum);

        // Perform subtraction
        BigInteger difference = num1.subtract(num2);
        System.out.println("Subtraction result: " + difference);

        // Perform multiplication
        BigInteger product = num1.multiply(num2);
        System.out.println("Multiplication result: " + product);

        // Perform division
        if (!num2.equals(BigInteger.ZERO)) {
            BigInteger quotient = num1.divide(num2);
            System.out.println("Division result: " + quotient);
        } else {
            System.out.println("Division by zero is not allowed");
        }
    }
}

public class SinglyLinkedList {
    Node head;

    // Method to insert a digit at the end of the list
    public void insert(int digit) {
        Node newNode = new Node(digit);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to convert the linked list to a BigInteger
    public BigInteger toBigInteger() {
        Node temp = head;
        BigInteger num = BigInteger.ZERO;
        while (temp != null) {
            num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(temp.data));
            temp = temp.next;
        }
        return num;
    }

    // Method to display the number stored in the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create two linked lists to represent 10-digit numbers
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();

        // Insert digits for the first number (e.g., 1234567890)
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        list1.insert(5);
        list1.insert(6);
        list1.insert(7);
        list1.insert(8);
        list1.insert(9);
        list1.insert(0);

        // Insert digits for the second number (e.g., 9876543210)
        list2.insert(9);
        list2.insert(8);
        list2.insert(7);
        list2.insert(6);
        list2.insert(5);
        list2.insert(4);
        list2.insert(3);
        list2.insert(2);
        list2.insert(1);
        list2.insert(0);

        System.out.print("Number 1: ");
        list1.display(); // Display first number
        System.out.print("Number 2: ");
        list2.display(); // Display second number

        // Convert both linked lists to BigInteger
        BigInteger num1 = list1.toBigInteger();
        BigInteger num2 = list2.toBigInteger();

        // Perform addition
        BigInteger sum = num1.add(num2);
        System.out.println("Addition result: " + sum);

        // Perform subtraction
        BigInteger difference = num1.subtract(num2);
        System.out.println("Subtraction result: " + difference);

        // Perform multiplication
        BigInteger product = num1.multiply(num2);
        System.out.println("Multiplication result: " + product);

        // Perform division
        if (!num2.equals(BigInteger.ZERO)) {
            BigInteger quotient = num1.divide(num2);
            System.out.println("Division result: " + quotient);
        } else {
            System.out.println("Division by zero is not allowed");
        }
    }
}

// class Node {
//     int data;
//     Node next;

//     Node(int data) {
//         this.data = data;
//         this.next = null;
//     }

//     Node head;

//     // Method to insert a digit at the end of the list
//     public void insert(int digit) {
//         Node newNode = new Node(digit);
//         if (head == null) {
//             head = newNode;
//         } else {
//             Node temp = head;
//             while (temp.next != null) {
//                 temp = temp.next;
//             }
//             temp.next = newNode;
//         }
//     }

//     // Method to convert the linked list to an integer
//     public long toNumber() {
//         Node temp = head;
//         long num = 0;
//         while (temp != null) {
//             num = num * 10 + temp.data;
//             temp = temp.next;
//         }
//         return num;
//     }

//     // Method to display the number stored in the linked list
//     public void display() {
//         Node temp = head;
//         while (temp != null) {
//             System.out.print(temp.data);
//             temp = temp.next;
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         // Create two linked lists to represent 10-digit numbers
//         SinglyLinkedList list1 = new SinglyLinkedList();
//         SinglyLinkedList list2 = new SinglyLinkedList();

//         // Insert digits for the first number (e.g., 1234567890)
//         list1.insert(1);
//         list1.insert(2);
//         list1.insert(3);
//         list1.insert(4);
//         list1.insert(5);
//         list1.insert(6);
//         list1.insert(7);
//         list1.insert(8);
//         list1.insert(9);
//         list1.insert(0);

//         // Insert digits for the second number (e.g., 9876543210)
//         list2.insert(9);
//         list2.insert(8);
//         list2.insert(7);
//         list2.insert(6);
//         list2.insert(5);
//         list2.insert(4);
//         list2.insert(3);
//         list2.insert(2);
//         list2.insert(1);
//         list2.insert(0);

//         System.out.print("Number 1: ");
//         list1.display(); // Display first number
//         System.out.print("Number 2: ");
//         list2.display(); // Display second number

//         // Perform addition
//         long sum = list1.toNumber() + list2.toNumber();
//         System.out.println("Addition result: " + sum);

//         // Perform subtraction
//         long difference = list1.toNumber() - list2.toNumber();
//         System.out.println("Subtraction result: " + difference);

//         // Perform multiplication
//         long product = list1.toNumber() * list2.toNumber();
//         System.out.println("Multiplication result: " + product);

//         // Perform division
//         if (list2.toNumber() != 0) {
//             long quotient = list1.toNumber() / list2.toNumber();
//             System.out.println("Division result: " + quotient);
//         } else {
//             System.out.println("Division by zero is not allowed");
//         }
//     }
// }

// public class SinglyLinkedList {
//     Node head;

//     // Method to insert a digit at the end of the list
//     public void insert(int digit) {
//         Node newNode = new Node(digit);
//         if (head == null) {
//             head = newNode;
//         } else {
//             Node temp = head;
//             while (temp.next != null) {
//                 temp = temp.next;
//             }
//             temp.next = newNode;
//         }
//     }

//     // Method to convert the linked list to an integer
//     public long toNumber() {
//         Node temp = head;
//         long num = 0;
//         while (temp != null) {
//             num = num * 10 + temp.data;
//             temp = temp.next;
//         }
//         return num;
//     }

//     // Method to display the number stored in the linked list
//     public void display() {
//         Node temp = head;
//         while (temp != null) {
//             System.out.print(temp.data);
//             temp = temp.next;
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         // Create two linked lists to represent 10-digit numbers
//         SinglyLinkedList list1 = new SinglyLinkedList();
//         SinglyLinkedList list2 = new SinglyLinkedList();

//         // Insert digits for the first number (e.g., 1234567890)
//         list1.insert(1);
//         list1.insert(2);
//         list1.insert(3);
//         list1.insert(4);
//         list1.insert(5);
//         list1.insert(6);
//         list1.insert(7);
//         list1.insert(8);
//         list1.insert(9);
//         list1.insert(0);

//         // Insert digits for the second number (e.g., 9876543210)
//         list2.insert(9);
//         list2.insert(8);
//         list2.insert(7);
//         list2.insert(6);
//         list2.insert(5);
//         list2.insert(4);
//         list2.insert(3);
//         list2.insert(2);
//         list2.insert(1);
//         list2.insert(0);

//         System.out.print("Number 1: ");
//         list1.display(); // Display first number
//         System.out.print("Number 2: ");
//         list2.display(); // Display second number

//         // Perform addition
//         long sum = list1.toNumber() + list2.toNumber();
//         System.out.println("Addition result: " + sum);

//         // Perform subtraction
//         long difference = list1.toNumber() - list2.toNumber();
//         System.out.println("Subtraction result: " + difference);

//         // Perform multiplication
//         long product = list1.toNumber() * list2.toNumber();
//         System.out.println("Multiplication result: " + product);

//         // Perform division
//         if (list2.toNumber() != 0) {
//             long quotient = list1.toNumber() / list2.toNumber();
//             System.out.println("Division result: " + quotient);
//         } else {
//             System.out.println("Division by zero is not allowed");
//         }
//     }
// }
