import java.util.Scanner;

public class MergeSort {
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

        // Perform Merge Sort
        mergeSort(array, 0, n - 1);

        // Output the sorted array
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // Merge Sort Function
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Merge Function
    public static void merge(int[] array, int left, int mid, int right) {
        // Sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        // Merge the temporary arrays
        int i = 0, j = 0;
        int k = left; // Initial index of merged subarray

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
