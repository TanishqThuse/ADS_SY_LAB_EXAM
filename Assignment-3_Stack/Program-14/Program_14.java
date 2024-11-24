/**Q3) 14)Normally we write our name in order of First name, Middle name and
Surname. We need to accept these three words in a single string. Write a
program to arrange these three words in order of Surname, First name
and Middle name using stack only.
 */

 import java.util.Stack;
 import java.util.Scanner;
 
 public class Program_14 {
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         // Accept the full name as a single string
         System.out.print("Enter your full name (First name, Middle name, Surname): ");
         String fullName = sc.nextLine();
 
         // Split the input into words
         String[] nameParts = fullName.split(" ");
         if (nameParts.length != 3) {
             System.out.println("Please enter exactly three words: First name, Middle name, and Surname.");
             return;
         }
 
         // Use a stack to reorder the names
         Stack<String> stack = new Stack<>();
         for (String name : nameParts) {
             stack.push(name);
         }
 
         // Retrieve the names in the desired order
         String surname = stack.pop();
         String middleName = stack.pop();
         String firstName = stack.pop();
 
         // Print the reordered name
         System.out.println("Reordered name: " + surname + " " + firstName + " " + middleName);
         sc.close();
     }
 }
 