import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        
        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Input target element
        System.out.print("Enter the target element to search: ");
        int target = scanner.nextInt();

        // Perform binary search
        int result = binarySearch(array, target);

        // Output result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }

        scanner.close();
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // To prevent overflow
            
            // Check if the target is at mid
            if (array[mid] == target) {
                return mid;
            }
            
            // If target is smaller, ignore the right half
            if (array[mid] > target) {
                right = mid - 1;
            } 
            // If target is larger, ignore the left half
            else {
                left = mid + 1;
            }
        }
        
        // Target not found
        return -1;
    }
}
