public class PrintSubarrays {
    public static void main(String[] args) {
        int[] array = {1, 2, 3}; // Example input array
        
        System.out.println("All subarrays of the given array:");
        printAllSubarrays(array);
    }

    public static void printAllSubarrays(int[] array) {
        int n = array.length;
        
        // Outer loop for the start of the subarray
        for (int start = 0; start < n; start++) {
            // Inner loop for the end of the subarray
            for (int end = start; end < n; end++) {
                // Print the subarray from start to end
                System.out.print("[");
                for (int k = start; k <= end; k++) {
                    System.out.print(array[k]);
                    if (k < end) System.out.print(", ");
                }
                System.out.println("]");
            }
        }
    }
}
