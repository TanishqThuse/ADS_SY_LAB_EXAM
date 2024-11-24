import java.util.Scanner;

public class BubbleSort {
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

        // Perform Bubble Sort
        bubbleSort(array);

        // Output the sorted array
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;

        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true; // Mark that a swap happened
                }
            }

            // If no swaps occurred, array is sorted
            if (!swapped) {
                break;
            }
        }
    }
}
