//Q5) 1) Given a list, split it into two sublists — one for the front half, and one
// for the back half. If the number of elements is odd, the extra element
// should go in the front list. So FrontBackSplit() on the list {2, 3, 5, 7, 11}
// should yield the two lists {2, 3, 5} and {7, 11}. Getting this right for all
// the cases is harder than it looks. You should check your solution against
// a few cases (length = 2, length = 3, length=4) to make sure that the list
// gets split correctly near the short­list boundary conditions. If it works
// right for length=4, it probably works right for length=1000. You will
// probably need special case code to deal with the (length <2) cases

import java.util.ArrayList;
import java.util.List;

public class FrontBackSplit {

    public static List<List<Integer>> frontBackSplit(List<Integer> inputList) {
        List<List<Integer>> result = new ArrayList<>();

        // Handle special case for length < 2
        if (inputList.size() < 2) {
            result.add(new ArrayList<>(inputList));
            result.add(new ArrayList<>());
            return result;
        }

        // Calculate the split index
        int midIndex = (inputList.size() + 1) / 2;  // Ensure extra element goes to the front list

        // Create the front and back sublists
        List<Integer> frontList = new ArrayList<>(inputList.subList(0, midIndex));
        List<Integer> backList = new ArrayList<>(inputList.subList(midIndex, inputList.size()));

        // Add the sublists to the result
        result.add(frontList);
        result.add(backList);

        return result;
    }

    public static void main(String[] args) {
        // Test with various inputs
        List<Integer> testList1 = List.of(2, 3, 5, 7, 11);
        List<Integer> testList2 = List.of(1, 2);
        List<Integer> testList3 = List.of(1, 2, 3);
        List<Integer> testList4 = List.of(10, 20, 30, 40);

        System.out.println("Test 1: " + testList1);
        printFrontBackSplit(testList1);

        System.out.println("\nTest 2: " + testList2);
        printFrontBackSplit(testList2);

        System.out.println("\nTest 3: " + testList3);
        printFrontBackSplit(testList3);

        System.out.println("\nTest 4: " + testList4);
        printFrontBackSplit(testList4);
    }

    // Helper method to print the result of the split
    public static void printFrontBackSplit(List<Integer> inputList) {
        List<List<Integer>> result = frontBackSplit(inputList);
        System.out.println("Front list: " + result.get(0));
        System.out.println("Back list: " + result.get(1));
    }
}
