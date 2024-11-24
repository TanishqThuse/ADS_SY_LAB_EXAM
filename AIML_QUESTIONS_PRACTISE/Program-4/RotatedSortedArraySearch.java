import java.util.Scanner;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Input the rotated sorted array
        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Input the target number
        System.out.print("Enter the number to search: ");
        int target = scanner.nextInt();

        // Find the index of the target
        int result = search(array, target);

        // Output the result
        if (result != -1) {
            System.out.println("The number is found at index: " + result);
        } else {
            System.out.println("The number is not found in the array.");
        }

        scanner.close();
    }

    public static int search(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is the target
            if (array[mid] == target) {
                return mid;
            }

            // Determine which part of the array is sorted
            if (array[left] <= array[mid]) { // Left part is sorted
                if (target >= array[left] && target < array[mid]) {
                    right = mid - 1; // Search in the left sorted part
                } else {
                    left = mid + 1; // Search in the right part
                }
            } else { // Right part is sorted
                if (target > array[mid] && target <= array[right]) {
                    left = mid + 1; // Search in the right sorted part
                } else {
                    right = mid - 1; // Search in the left part
                }
            }
        }

        // Target not found
        return -1;
    }
}
