import java.util.Scanner;

public class SelectionSort {
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

        // Perform Selection Sort
        selectionSort(array);

        // Output the sorted array
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static void selectionSort(int[] array) {
        int n = array.length;

        // Outer loop for each position in the array
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the smallest element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the smallest element with the current element at position i
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
