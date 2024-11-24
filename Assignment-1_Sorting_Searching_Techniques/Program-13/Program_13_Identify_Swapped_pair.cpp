/**Q1) 13) Assume that an array A with n elements was sorted in an ascending
order, but two of its elements swapped their positions by a mistake while
maintaining the array. Write a code to identify the swapped pair of
elements and their positions in the asymptotically best possible time.
[Assume that all given elements are distinct integers.] */

#include <iostream>
#include <vector>

void findSwappedElements(const std::vector<int>& arr) {
    int n = arr.size();
    int first = -1, second = -1;

    // Traverse the array to find the first and second swapped elements
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            if (first == -1) {
                first = i; // First position where order is violated
            } else {
                second = i + 1; // Second position where order is violated
            }
        }
    }

    // If we found two positions, check if swapping them sorts the array
    if (first != -1 && second != -1) {
        std::swap(const_cast<int&>(arr[first]), const_cast<int&>(arr[second]));
        
        // Check if the array is sorted after swapping
        bool isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            std::cout << "Swapped elements: " << arr[first] << " and " << arr[second] << "\n";
            std::cout << "Positions: " << first + 1 << " and " << second + 1 << "\n"; // +1 for 1-based index
        } else {
            std::cout << "No valid swap found.\n";
        }
    } else if (first != -1) { // Only one position found
        std::cout << "Only one element out of order.\n";
    } else {
        std::cout << "Array is already sorted.\n";
    }
}

int main() {
    // Example input
    std::vector<int> arr = {0,2, 4, 3, 1}; // Example where total_swaps = -1 (cannot be solved)
    
    // Uncomment to test other cases:
    // std::vector<int> arr = {2, 3, 0, 5, 4, 1}; // Example where total_swaps = 3 (can be solved)
    // std::vector<int> arr = {0, 1, 2, 3, 4}; // Example where total_swaps = -1 (already sorted)

    findSwappedElements(arr);

    return 0;
}

/**
3
2
4
5
1 */