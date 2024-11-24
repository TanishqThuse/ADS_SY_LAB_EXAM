/**Q4) 17)There are 'n' number of soldiers surrounded by enemy. They are having
only one horse. They decided that one of them will go out and seek the
help from outside while others will hold on the post. To decide who will
go out to seek help they played a game. they stood in circular way and
select some random number 'm' which is smaller than 'n'. then they
selected a random person 'x' from which they start counting 'm'. after 'm'
number the person who is at that place will be out of the game i.e. he has
to wait at post only. Again they started the count 'm' from the next
person. this process will go on till one person remains. the last person is
the one who will go out with horse and seek the help from outside. Wirte
a program to simulate this situation. */

import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {

    // Function to simulate the Josephus problem
    public static int findSurvivor(int n, int m, int x) {
        // Create a list of soldiers (0 to n-1)
        ArrayList<Integer> soldiers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            soldiers.add(i);
        }

        // The current index of the soldier who is to be eliminated
        int currentIndex = x % n;  // Start counting from the given index x (mod n)

        // Loop until only one soldier remains
        while (soldiers.size() > 1) {
            // Calculate the index of the soldier to be eliminated (circular counting)
            currentIndex = (currentIndex + m - 1) % soldiers.size();  // m-1 because we start counting from the current position

            // Eliminate the soldier
            soldiers.remove(currentIndex);
        }

        // The last remaining soldier
        return soldiers.get(0);
    }

    public static void main(String[] args) {
        // Create a scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        
        // Read inputs for number of soldiers, step count, and starting index
        System.out.print("Enter the number of soldiers (n): ");
        int n = sc.nextInt();
        
        System.out.print("Enter the step count (m): ");
        int m = sc.nextInt();
        
        System.out.print("Enter the starting position (x): ");
        int x = sc.nextInt();

        // Find the soldier who will survive
        int survivor = findSurvivor(n, m, x);

        // Print the result (survivor's position)
        System.out.println("The soldier who will go out with the horse is at position: " + survivor);
        
        // Close the scanner
        sc.close();
    }
}
