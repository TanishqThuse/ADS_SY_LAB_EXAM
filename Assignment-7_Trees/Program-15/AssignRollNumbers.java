/**Q7) 15)Write a program, using trees, to assign the roll nos. to the students of
your class as per their previous years result. i.e topper will be roll no. 1 */

import java.util.*;

class Student {
    String name;
    int score;
    int rollNo;

    // Constructor to initialize student details
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        this.rollNo = -1;  // Initially, roll number is not assigned
    }

    // Display student details
    public void displayStudent() {
        System.out.println("Name: " + name + ", Score: " + score + ", Roll No: " + rollNo);
    }
}

class TreeNode {
    Student student;
    TreeNode left, right;

    // Constructor to create a new node with a given student
    public TreeNode(Student student) {
        this.student = student;
        this.left = this.right = null;
    }
}

class StudentTree {
    private TreeNode root;

    // Constructor to initialize an empty tree
    public StudentTree() {
        root = null;
    }

    // Method to insert a student into the tree based on score
    public void insertStudent(Student student) {
        root = insertRecursive(root, student);
    }

    // Recursive method to insert a student
    private TreeNode insertRecursive(TreeNode node, Student student) {
        if (node == null) {
            return new TreeNode(student);
        }

        if (student.score > node.student.score) {
            node.right = insertRecursive(node.right, student);
        } else if (student.score < node.student.score) {
            node.left = insertRecursive(node.left, student);
        }

        return node;
    }

    // Method to assign roll numbers to students in ascending order of their scores
    public void assignRollNumbers() {
        assignRollNumbersRecursive(root, new int[] {1});
    }

    // Recursive method to assign roll numbers using in-order traversal
    private void assignRollNumbersRecursive(TreeNode node, int[] rollCounter) {
        if (node != null) {
            // Visit left subtree
            assignRollNumbersRecursive(node.left, rollCounter);

            // Assign roll number
            node.student.rollNo = rollCounter[0]++;

            // Visit right subtree
            assignRollNumbersRecursive(node.right, rollCounter);
        }
    }

    // Method to list all students with their roll numbers
    public void listAllStudents() {
        listAllStudentsRecursive(root);
    }

    // Recursive method to display all students
    private void listAllStudentsRecursive(TreeNode node) {
        if (node != null) {
            listAllStudentsRecursive(node.left);
            node.student.displayStudent();
            listAllStudentsRecursive(node.right);
        }
    }
}

public class AssignRollNumbers {
    public static void main(String[] args) {
        StudentTree tree = new StudentTree();
        Scanner scanner = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Score: ");
            int score = scanner.nextInt();
            scanner.nextLine();  // Consume newline character
            Student student = new Student(name, score);
            tree.insertStudent(student);
        }

        // Assign roll numbers based on scores
        tree.assignRollNumbers();

        // List all students with roll numbers
        System.out.println("\nStudent details with assigned roll numbers:");
        tree.listAllStudents();

        scanner.close();
    }
}
