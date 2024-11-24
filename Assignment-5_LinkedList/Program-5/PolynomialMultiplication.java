/*Q5) 5)WAP to perform Multiplication o f two polynomials using singly linked
list */

class Node {
    int coefficient;  // Coefficient of the term
    int exponent;     // Exponent of the term
    Node next;        // Next node in the linked list

    // Constructor
    Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

public class PolynomialMultiplication {

    // Function to multiply two polynomials
    public static Node multiplyPolynomials(Node poly1, Node poly2) {
        Node result = null; // Will hold the result of the multiplication

        // Traverse through each term of poly1
        for (Node p1 = poly1; p1 != null; p1 = p1.next) {
            // Multiply each term of poly1 with each term of poly2
            for (Node p2 = poly2; p2 != null; p2 = p2.next) {
                int coeff = p1.coefficient * p2.coefficient;
                int exp = p1.exponent + p2.exponent;

                // Add the resulting term to the result polynomial
                result = addTerm(result, coeff, exp);
            }
        }

        return result;
    }

    // Function to add a term to the polynomial (handles combining like terms)
    public static Node addTerm(Node head, int coeff, int exp) {
        // Create the new term
        Node newNode = new Node(coeff, exp);

        // If the list is empty, this is the first term
        if (head == null) {
            return newNode;
        }

        // Otherwise, find the correct position to insert the term
        Node current = head;
        Node prev = null;
        while (current != null && current.exponent > exp) {
            prev = current;
            current = current.next;
        }

        // If we found a matching exponent, add the coefficients
        if (current != null && current.exponent == exp) {
            current.coefficient += coeff;
            return head;
        }

        // Insert the new node in the list (sorted by exponent)
        if (prev == null) {
            newNode.next = head;
            head = newNode;
        } else {
            prev.next = newNode;
            newNode.next = current;
        }

        return head;
    }

    // Function to print the polynomial
    public static void printPolynomial(Node head) {
        Node current = head;
        while (current != null) {
            if (current.coefficient > 0 && current != head) {
                System.out.print(" + ");
            }
            System.out.print(current.coefficient + "x^" + current.exponent);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Representing polynomial 3x^2 + 2x + 5
        Node poly1 = new Node(3, 2); // 3x^2
        poly1.next = new Node(2, 1); // 2x
        poly1.next.next = new Node(5, 0); // 5

        // Representing polynomial x^2 + 1
        Node poly2 = new Node(1, 2); // x^2
        poly2.next = new Node(1, 0); // 1

        System.out.println("Polynomial 1:");
        printPolynomial(poly1);

        System.out.println("Polynomial 2:");
        printPolynomial(poly2);

        // Multiply the polynomials
        Node result = multiplyPolynomials(poly1, poly2);

        System.out.println("Result of Multiplication:");
        printPolynomial(result);
    }
}
