/*Q5) 9)WAP to store at most 10 digit integer in a Doubly linked list and
perform arithmetic operations on it */

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    DoublyNode head;

    // Method to insert at the end of the doubly linked list
    public void insertAtEnd(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Method to display the list (the number stored in the list)
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to add two large numbers represented by doubly linked lists
    public static DoublyLinkedList add(DoublyLinkedList num1, DoublyLinkedList num2) {
        DoublyLinkedList result = new DoublyLinkedList();
        DoublyNode n1 = num1.head;
        DoublyNode n2 = num2.head;

        int carry = 0;
        while (n1 != null || n2 != null || carry != 0) {
            int sum = carry;
            if (n1 != null) {
                sum += n1.data;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.data;
                n2 = n2.next;
            }

            carry = sum / 10;
            result.insertAtEnd(sum % 10);
        }
        return result;
    }

    // Method to subtract two large numbers represented by doubly linked lists
    public static DoublyLinkedList subtract(DoublyLinkedList num1, DoublyLinkedList num2) {
        DoublyLinkedList result = new DoublyLinkedList();
        DoublyNode n1 = num1.head;
        DoublyNode n2 = num2.head;

        int borrow = 0;
        while (n1 != null || n2 != null) {
            int diff = borrow;
            if (n1 != null) {
                diff += n1.data;
                n1 = n1.next;
            }
            if (n2 != null) {
                diff -= n2.data;
                n2 = n2.next;
            }

            if (diff < 0) {
                diff += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }

            result.insertAtEnd(diff);
        }

        // Handling leading zeros in the result
        if (borrow != 0) {
            System.out.println("Subtraction Result is Negative, Invalid Operation");
        }
        return result;
    }

    // Method to multiply two large numbers represented by doubly linked lists
    public static DoublyLinkedList multiply(DoublyLinkedList num1, DoublyLinkedList num2) {
        DoublyLinkedList result = new DoublyLinkedList();

        // Convert doubly linked lists to numbers for multiplication
        long number1 = 0, number2 = 0;
        DoublyNode n1 = num1.head, n2 = num2.head;

        while (n1 != null) {
            number1 = number1 * 10 + n1.data;
            n1 = n1.next;
        }
        while (n2 != null) {
            number2 = number2 * 10 + n2.data;
            n2 = n2.next;
        }

        long product = number1 * number2;

        // Insert the result of multiplication into the doubly linked list
        while (product > 0) {
            result.insertAtEnd((int)(product % 10));
            product /= 10;
        }

        return result;
    }

    // Method to divide two large numbers represented by doubly linked lists
    public static DoublyLinkedList divide(DoublyLinkedList num1, DoublyLinkedList num2) {
        DoublyLinkedList result = new DoublyLinkedList();

        // Convert doubly linked lists to numbers for division
        long number1 = 0, number2 = 0;
        DoublyNode n1 = num1.head, n2 = num2.head;

        while (n1 != null) {
            number1 = number1 * 10 + n1.data;
            n1 = n1.next;
        }
        while (n2 != null) {
            number2 = number2 * 10 + n2.data;
            n2 = n2.next;
        }

        if (number2 == 0) {
            System.out.println("Error: Division by Zero");
            return result;
        }

        long quotient = number1 / number2;

        // Insert the result of division into the doubly linked list
        while (quotient > 0) {
            result.insertAtEnd((int)(quotient % 10));
            quotient /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        DoublyLinkedList num1 = new DoublyLinkedList();
        DoublyLinkedList num2 = new DoublyLinkedList();

        // Insert digits for num1 (example 1234567890)
        num1.insertAtEnd(1);
        num1.insertAtEnd(2);
        num1.insertAtEnd(3);
        num1.insertAtEnd(4);
        num1.insertAtEnd(5);
        num1.insertAtEnd(6);
        num1.insertAtEnd(7);
        num1.insertAtEnd(8);
        num1.insertAtEnd(9);
        num1.insertAtEnd(0);

        // Insert digits for num2 (example 9876543210)
        num2.insertAtEnd(9);
        num2.insertAtEnd(8);
        num2.insertAtEnd(7);
        num2.insertAtEnd(6);
        num2.insertAtEnd(5);
        num2.insertAtEnd(4);
        num2.insertAtEnd(3);
        num2.insertAtEnd(2);
        num2.insertAtEnd(1);
        num2.insertAtEnd(0);

        System.out.println("Number 1: ");
        num1.display();

        System.out.println("Number 2: ");
        num2.display();

        // Addition
        DoublyLinkedList additionResult = add(num1, num2);
        System.out.println("Addition Result: ");
        additionResult.display();

        // Subtraction
        DoublyLinkedList subtractionResult = subtract(num1, num2);
        System.out.println("Subtraction Result: ");
        subtractionResult.display();

        // Multiplication
        DoublyLinkedList multiplicationResult = multiply(num1, num2);
        System.out.println("Multiplication Result: ");
        multiplicationResult.display();

        // Division
        DoublyLinkedList divisionResult = divide(num1, num2);
        System.out.println("Division Result: ");
        divisionResult.display();
    }
}
