import java.util.ArrayList;
import java.util.List;

public class PrintSubsequences {
    public static void main(String[] args) {
        int[] array = {1, 2, 3}; // Example input array

        System.out.println("All subsequences of the given array:");
        List<List<Integer>> subsequences = generateSubsequences(array);
        
        // Print all subsequences
        for (List<Integer> subsequence : subsequences) {
            System.out.println(subsequence);
        }
    }

    public static List<List<Integer>> generateSubsequences(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        generate(array, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generate(int[] array, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == array.length) {
            // Base case: Add the current subsequence to the result
            result.add(new ArrayList<>(current));
            return;
        }

        // Include the current element
        current.add(array[index]);
        generate(array, index + 1, current, result);

        // Exclude the current element
        current.remove(current.size() - 1);
        generate(array, index + 1, current, result);
    }
}
