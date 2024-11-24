/*Q4) 14)There are 'n' number of soldiers surrounded by enemy. They are having
only one horse. They decided that one of them will go out and seek the
help from outside while others will hold on the post. To decide who will
go out to seek help they played a game. they stood in circular way and
select some random number 'm' which is smaller than 'n'. then they
selected a random person 'x' from which they start counting 'm'. after 'm'
number the person who is at that place will be out of the game i.e. he has
to wait at post only. Again they started the count 'm' from the next
person. this process will go on till one person remains. the last person is
the one who will go out with horse and seek the help from outside. Write
a program to simulate this situation.
 */

import java.util.LinkedList;
import java.util.Scanner;

public class JosephusProblem {

    // Function to solve Josephus Problem
    public static int josephus(int n, int m) {
        LinkedList<Integer> soldiers = new LinkedList<>();
        
        // Step 1: Fill the list with soldiers numbered from 1 to n
        for (int i = 1; i <= n; i++) {
            soldiers.add(i);
        }

        // Step 2: Eliminate soldiers every m-th position
        int index = 0; // Start from the first soldier
        while (soldiers.size() > 1) {
            // Find the index of the m-th soldier
            index = (index + m - 1) % soldiers.size(); 
            System.out.println("Soldier " + soldiers.get(index) + " is eliminated.");
            soldiers.remove(index); // Remove the soldier
        }

        // Step 3: The last remaining soldier
        return soldiers.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of soldiers (n): ");
        int n = sc.nextInt();
        
        System.out.print("Enter the step count (m): ");
        int m = sc.nextInt();
        
        // Solve the Josephus problem
        int result = josephus(n, m);
        
        System.out.println("The last soldier remaining is: " + result);
        sc.close();
    }
}
