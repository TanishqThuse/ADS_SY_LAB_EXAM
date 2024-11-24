/**Q1) 8)Sorting Searching
WAP to implement Bubble sort and Heap Sort on 1D array of Employee
structure (contains employee_name, emp_no, emp_salary), with key as
emp_no. And count the number of swap performed */

#include <iostream>
#include <string>
#include <vector>

struct Employee {
    std::string employee_name;
    int emp_no;
    float emp_salary;
};

void bubbleSort(std::vector<Employee>& arr, int& swapCount) {
    int n = arr.size();
    for (int i = 0; i < n - 1; i++) {
        bool swapped = false; // Track if a swap occurred
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j].emp_no > arr[j + 1].emp_no) {
                std::swap(arr[j], arr[j + 1]);
                swapCount++;
                swapped = true;
            }
        }
        // If no swaps occurred, the array is sorted
        if (!swapped) break;
    }
}

void heapify(std::vector<Employee>& arr, int n, int i, int& swapCount) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // left child
    int right = 2 * i + 2; // right child

    // If left child is larger than root
    if (left < n && arr[left].emp_no > arr[largest].emp_no)
        largest = left;

    // If right child is larger than largest so far
    if (right < n && arr[right].emp_no > arr[largest].emp_no)
        largest = right;

    // If largest is not root
    if (largest != i) {
        std::swap(arr[i], arr[largest]);
        swapCount++;

        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest, swapCount);
    }
}

void heapSort(std::vector<Employee>& arr, int& swapCount) {
    int n = arr.size();

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i, swapCount);

    // One by one extract an element from heap
    for (int i = n - 1; i > 0; i--) {
        std::swap(arr[0], arr[i]);
        swapCount++;

        // call max heapify on the reduced heap
        heapify(arr, i, 0, swapCount);
    }
}

int main() {
    int numEmployees;

    std::cout << "Enter the number of employees: ";
    std::cin >> numEmployees;

    std::vector<Employee> employees(numEmployees);

    // Input employee details
    for (int i = 0; i < numEmployees; ++i) {
        std::cout << "Enter details for employee " << (i + 1) << ":\n";
        std::cout << "Name: ";
        std::cin >> employees[i].employee_name;
        std::cout << "Employee Number: ";
        std::cin >> employees[i].emp_no;
        std::cout << "Salary: ";
        std::cin >> employees[i].emp_salary;
    }

    int choice;
    int swapCount;

    std::cout << "\nChoose sorting algorithm:\n1. Bubble Sort\n2. Heap Sort\n";
    std::cin >> choice;

    switch (choice) {
        case 1:
            swapCount = 0;
            bubbleSort(employees, swapCount);
            std::cout << "Sorted using Bubble Sort with " << swapCount << " swaps:\n";
            break;
        case 2:
            swapCount = 0;
            heapSort(employees, swapCount);
            std::cout << "Sorted using Heap Sort with " << swapCount << " swaps:\n";
            break;
        default:
            std::cout << "Invalid choice.\n";
            return -1;
    }

    // Display sorted employees
    for (const auto& emp : employees) {
        std::cout << "Name: " << emp.employee_name 
                  << ", Emp No: " << emp.emp_no 
                  << ", Salary: " << emp.emp_salary << "\n";
    }

    return 0;
}