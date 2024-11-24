/**Q7) 16)Write a program to efficiently search a perticular employee record by
using Tree data structure. Also sort the data on emp­id in ascending
order.
 */

 import java.util.Scanner;

 class Employee {
     int empId;
     String name;
     String designation;
     double salary;
 
     // Constructor to initialize employee details
     public Employee(int empId, String name, String designation, double salary) {
         this.empId = empId;
         this.name = name;
         this.designation = designation;
         this.salary = salary;
     }
 
     // Display employee details
     public void displayEmployee() {
         System.out.println("Employee ID: " + empId + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary);
     }
 }
 
 class TreeNode {
     Employee employee;
     TreeNode left, right;
 
     // Constructor to create a new node with a given employee
     public TreeNode(Employee employee) {
         this.employee = employee;
         this.left = this.right = null;
     }
 }
 
 class EmployeeTree {
     private TreeNode root;
 
     // Constructor to initialize an empty tree
     public EmployeeTree() {
         root = null;
     }
 
     // Method to insert a new employee into the tree
     public void insertEmployee(Employee employee) {
         root = insertRecursive(root, employee);
     }
 
     // Recursive method to insert a new employee
     private TreeNode insertRecursive(TreeNode node, Employee employee) {
         if (node == null) {
             return new TreeNode(employee);
         }
 
         if (employee.empId < node.employee.empId) {
             node.left = insertRecursive(node.left, employee);
         } else if (employee.empId > node.employee.empId) {
             node.right = insertRecursive(node.right, employee);
         }
 
         return node;
     }
 
     // Method to search for an employee by emp-id
     public Employee searchEmployee(int empId) {
         return searchRecursive(root, empId);
     }
 
     // Recursive method to search for an employee by emp-id
     private Employee searchRecursive(TreeNode node, int empId) {
         if (node == null || node.employee.empId == empId) {
             return node != null ? node.employee : null;
         }
 
         if (empId < node.employee.empId) {
             return searchRecursive(node.left, empId);
         }
 
         return searchRecursive(node.right, empId);
     }
 
     // Method to list all employees in ascending order of emp-id
     public void listEmployeesInOrder() {
         listEmployeesRecursive(root);
     }
 
     // Recursive method for in-order traversal to print employees in ascending order of emp-id
     private void listEmployeesRecursive(TreeNode node) {
         if (node != null) {
             listEmployeesRecursive(node.left);
             node.employee.displayEmployee();
             listEmployeesRecursive(node.right);
         }
     }
 }
 
 public class EmployeeManagement {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         EmployeeTree tree = new EmployeeTree();
 
         // Adding employees to the tree
         tree.insertEmployee(new Employee(1001, "John Doe", "Manager", 50000));
         tree.insertEmployee(new Employee(1002, "Alice Smith", "Developer", 40000));
         tree.insertEmployee(new Employee(1003, "Bob Johnson", "Designer", 35000));
         tree.insertEmployee(new Employee(1004, "Charlie Brown", "Developer", 42000));
 
         // Search for an employee by emp-id
         System.out.print("Enter emp-id to search: ");
         int searchEmpId = scanner.nextInt();
         Employee foundEmployee = tree.searchEmployee(searchEmpId);
 
         if (foundEmployee != null) {
             System.out.println("Employee found:");
             foundEmployee.displayEmployee();
         } else {
             System.out.println("Employee with emp-id " + searchEmpId + " not found.");
         }
 
         // List all employees in ascending order of emp-id
         System.out.println("\nEmployees sorted by emp-id:");
         tree.listEmployeesInOrder();
 
         scanner.close();
     }
 }
 