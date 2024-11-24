import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Input the array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Perform Insertion Sort
        insertionSort(array);

        // Output the sorted array
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        // Outer loop for each element in the array
        for (int i = 1; i < n; i++) {
            int key = array[i]; // Current element to be inserted
            int j = i - 1;

            // Shift elements of the sorted portion to the right to make space for the key
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Insert the key at the correct position
            array[j + 1] = key;
        }
    }
}
