/**Q1) 10)WAP to implement Merge Sort and Heap Sort on 1D array of Faculty
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

// Function to merge two halves of the array
void merge(std::vector<Faculty>& arr, int left, int mid, int right, int& swapCount) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    std::vector<Faculty> L(n1);
    std::vector<Faculty> R(n2);

    // Copy data to temporary arrays L[] and R[]
    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];

    // Merge the temporary arrays back into arr[left..right]
    int i = 0; // Initial index of first sub-array
    int j = 0; // Initial index of second sub-array
    int k = left; // Initial index of merged sub-array

    while (i < n1 && j < n2) {
        if (L[i].faculty_ID <= R[j].faculty_ID) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
            swapCount++; // Increment swap count when an element from R is placed before L
        }
        k++;
    }

    // Copy the remaining elements of L[], if there are any
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    // Copy the remaining elements of R[], if there are any
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

// Function to implement Merge Sort
void mergeSort(std::vector<Faculty>& arr, int left, int right, int& swapCount) {
    if (left < right) {
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, swapCount);
        mergeSort(arr, mid + 1, right, swapCount);
        merge(arr, left, mid, right, swapCount);
    }
}

void heapify(std::vector<Faculty>& arr, int n, int i, int& swapCount) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // Left child
    int right = 2 * i + 2; // Right child

    // If left child is larger than root
    if (left < n && arr[left].faculty_ID > arr[largest].faculty_ID)
        largest = left;

    // If right child is larger than largest so far
    if (right < n && arr[right].faculty_ID > arr[largest].faculty_ID)
        largest = right;

    // If largest is not root
    if (largest != i) {
        std::swap(arr[i], arr[largest]);
        swapCount++;

        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest, swapCount);
    }
}

// Function to implement Heap Sort
void heapSort(std::vector<Faculty>& arr, int& swapCount) {
    int n = arr.size();

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i, swapCount);

    // One by one extract an element from heap
    for (int i = n - 1; i > 0; i--) {
        std::swap(arr[0], arr[i]);
        swapCount++;

        // Call max heapify on the reduced heap
        heapify(arr, i, 0, swapCount);
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

    std::cout << "\nChoose sorting algorithm:\n1. Merge Sort\n2. Heap Sort\n";
    std::cin >> choice;

    switch (choice) {
        case 1:
            swapCount = 0;
            mergeSort(faculties, 0, numFaculties - 1, swapCount);
            std::cout << "Sorted using Merge Sort with " << swapCount << " swaps:\n";
            break;
            
        case 2:
            swapCount = 0;
            heapSort(faculties, swapCount);
            std::cout << "Sorted using Heap Sort with " << swapCount << " swaps:\n";
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

/**Enter the number of faculties: 3
Enter details for faculty 1:
Name: Alice
Faculty ID: 3
Enter number of subject codes: 2
Subject Code 1: CS101
Subject Code 2: CS102
Enter number of class names: 2
Class Name 1: ClassA
Class Name 2: ClassB

Enter details for faculty 2:
Name: Bob
Faculty ID: 1
Enter number of subject codes: 1
Subject Code 1: CS201
Enter number of class names: 1
Class Name 1: ClassC

Enter details for faculty */