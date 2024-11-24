import java.util.Stack;

public class Program_11_Stack_Simulation {

    public static void main(String[] args) {
        // Stack to keep track of room traversal
        Stack<Integer> roomStack = new Stack<>();
        int totalRooms = 5; // Total number of rooms

        // Step 1: Traverse forward from room 1 to room 5
        System.out.println("Moving forward through rooms:");
        for (int i = 1; i <= totalRooms; i++) {
            roomStack.push(i);
            System.out.println("Entered Room " + i);
        }

        // Step 2: At room 5, retrieve the decimal number
        int decimalNumber = 25; // Example decimal number in room 5
        System.out.println("Decimal number found in Room 5: " + decimalNumber);

        // Convert the decimal number to binary
        String binaryCode = Integer.toBinaryString(decimalNumber);
        System.out.println("Binary code to unlock the treasure: " + binaryCode);

        // Step 3: Traverse back from room 5 to room 1
        System.out.println("Moving backward through rooms:");
        while (!roomStack.isEmpty()) {
            int room = roomStack.pop();
            System.out.println("Exited Room " + room);
        }

        // Step 4: Unlock the treasure
        System.out.println("Treasure unlocked in Room 1 using code: " + binaryCode);
    }
}
