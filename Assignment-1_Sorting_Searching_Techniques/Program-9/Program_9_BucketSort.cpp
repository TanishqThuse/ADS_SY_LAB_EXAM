/**Q1) 9)WAP to implement Bucket Sort and Quick sort on 1D array of Faculty
structure (contains faculty_name, faculty_ID, subject_codes,
class_names), with key as faculty_ID. And count the number of swap
performed */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

struct Faculty {
    std::string faculty_name;
    int faculty_ID;
    std::vector<std::string> subject_codes;
    std::vector<std::string> class_names;
};

void bucketSort(std::vector<Faculty>& arr, int& swapCount) {
    const int bucketCount = 100; // Assuming faculty_ID is in the range of 0 to 99
    std::vector<std::vector<Faculty>> buckets(bucketCount);

    // Distribute faculty into buckets based on faculty_ID
    for (const auto& faculty : arr) {
        int bucketIndex = faculty.faculty_ID;
        buckets[bucketIndex].push_back(faculty);
    }

    // Sort individual buckets and count swaps
    for (auto& bucket : buckets) {
        if (bucket.size() > 1) {
            // Using insertion sort for simplicity within each bucket
            for (size_t i = 1; i < bucket.size(); i++) {
                Faculty key = bucket[i];
                size_t j = i - 1;

                while (j < bucket.size() && bucket[j].faculty_ID > key.faculty_ID) {
                    bucket[j + 1] = bucket[j];
                    swapCount++;
                    j--;
                }
                bucket[j + 1] = key;
            }
        }
    }

    // Concatenate sorted buckets back into the original array
    arr.clear();
    for (const auto& bucket : buckets) {
        for (const auto& faculty : bucket) {
            arr.push_back(faculty);
        }
    }
}

int partition(std::vector<Faculty>& arr, int low, int high, int& swapCount) {
    Faculty pivot = arr[high]; // Pivot element
    int i = low - 1; // Index of smaller element

    for (int j = low; j < high; j++) {
        if (arr[j].faculty_ID < pivot.faculty_ID) {
            i++;
            std::swap(arr[i], arr[j]);
            swapCount++;
        }
    }
    std::swap(arr[i + 1], arr[high]);
    swapCount++;
    return i + 1; // Return the partitioning index
}

void quickSort(std::vector<Faculty>& arr, int low, int high, int& swapCount) {
    if (low < high) {
        int pi = partition(arr, low, high, swapCount); // Partitioning index

        // Recursively sort elements before and after partition
        quickSort(arr, low, pi - 1, swapCount);
        quickSort(arr, pi + 1, high, swapCount);
    }
}

int main() {
    int numFaculties;

    std::cout << "Enter the number of faculties: ";
    std::cin >> numFaculties;

    std::vector<Faculty> faculties(numFaculties);

    // Input faculty details
    for (int i = 0; i < numFaculties; ++i) {
        std::cout << "Enter details for faculty " << (i + 1) << ":\n";
        std::cout << "Name: ";
        std::cin >> faculties[i].faculty_name;
        std::cout << "Faculty ID: ";
        std::cin >> faculties[i].faculty_ID;

        int numSubjects;
        std::cout << "Enter number of subject codes: ";
        std::cin >> numSubjects;
        faculties[i].subject_codes.resize(numSubjects);
        for (int j = 0; j < numSubjects; ++j) {
            std::cout << "Subject Code " << (j + 1) << ": ";
            std::cin >> faculties[i].subject_codes[j];
        }

        int numClasses;
        std::cout << "Enter number of class names: ";
        std::cin >> numClasses;
        faculties[i].class_names.resize(numClasses);
        for (int j = 0; j < numClasses; ++j) {
            std::cout << "Class Name " << (j + 1) << ": ";
            std::cin >> faculties[i].class_names[j];
        }
    }

    int choice;
    int swapCount;

    std::cout << "\nChoose sorting algorithm:\n1. Bucket Sort\n2. Quick Sort\n";
    std::cin >> choice;

    switch (choice) {
        case 1:
            swapCount = 0;
            bucketSort(faculties, swapCount);
            std::cout << "Sorted using Bucket Sort with " << swapCount << " swaps:\n";
            break;
        case 2:
            swapCount = 0;
            quickSort(faculties, 0, numFaculties - 1, swapCount);
            std::cout << "Sorted using Quick Sort with " << swapCount << " swaps:\n";
            break;
        default:
            std::cout << "Invalid choice.\n";
            return -1;
    }

    // Display sorted faculties
    for (const auto& fac : faculties) {
        std::cout << "Name: " << fac.faculty_name 
                  << ", Faculty ID: " << fac.faculty_ID 
                  << ", Subjects: ";
        
        for (const auto& code : fac.subject_codes)
            std::cout << code << " ";

        std::cout << ", Classes: ";
        
        for (const auto& className : fac.class_names)
            std::cout << className << " ";

        std::cout << "\n";
    }

    return 0;
}