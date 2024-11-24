/*Q2) 6)WAP to simulate an application of Divide and Conquer methodology to
search minimum and maximum number simultaneously from a pool of
random numbers entered by the user using recursive function.
*/

#include <iostream>
#include <vector>
#include <limits> // For numeric_limits

using namespace std;

// Function to find minimum and maximum using Divide and Conquer
pair<int, int> findMinMax(const vector<int>& arr, int low, int high) {
    // Base case: if there's only one element
    if (low == high) {
        return make_pair(arr[low], arr[low]); // Return both min and max as the same element
    }

    // Base case: if there are two elements
    if (high == low + 1) {
        if (arr[low] < arr[high]) {
            return make_pair(arr[low], arr[high]);
        } else {
            return make_pair(arr[high], arr[low]);
        }
    }

    // Divide the array into two halves
    int mid = (low + high) / 2;

    // Recursively find min and max in both halves
    pair<int, int> leftMinMax = findMinMax(arr, low, mid);
    pair<int, int> rightMinMax = findMinMax(arr, mid + 1, high);

    // Combine results
    int overallMin = min(leftMinMax.first, rightMinMax.first);
    int overallMax = max(leftMinMax.second, rightMinMax.second);

    return make_pair(overallMin, overallMax);
}

int main() {
    int n;

    cout << "Enter the number of elements: ";
    cin >> n;

    vector<int> arr(n);

    // Input elements
    cout << "Enter " << n << " integers:\n";
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    // Find min and max using Divide and Conquer
    pair<int, int> result = findMinMax(arr, 0, n - 1);

    cout << "Minimum value: " << result.first << "\n";
    cout << "Maximum value: " << result.second << "\n";

    return 0;
}

/**
 * Enter the number of elements: 5
Enter 5 integers:
12 5 7 19 3

Minimum value: 3
Maximum value: 19
 */