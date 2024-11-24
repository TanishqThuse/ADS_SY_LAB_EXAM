/*Q1) 4)WAP to implement Shell sort and Heap Sort on 1D array of Employee
structure (contains employee_name, emp_no, emp_salary), with key as
emp_no. And count the number of swap performed.
*/

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

struct Employee {
    string employee_name;
    int emp_no;
    float emp_salary;
};

// Function to perform Shell Sort
void shellSort(vector<Employee>& employees, int& swapCount) {
    size_t n = employees.size();
    for (size_t gap = n / 2; gap > 0; gap /= 2) {
        for (size_t i = gap; i < n; i++) {
            Employee temp = employees[i];
            size_t j;

            for (j = i; j >= gap && employees[j - gap].emp_no > temp.emp_no; j -= gap) {
                employees[j] = employees[j - gap];
                swapCount++;
            }
            employees[j] = temp;
        }
    }
}

// Function to heapify the subtree rooted at index i
void heapify(vector<Employee>& employees, int n, int i, int& swapCount) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // left child
    int right = 2 * i + 2; // right child

    // If left child is larger than root
    if (left < n && employees[left].emp_no > employees[largest].emp_no) {
        largest = left;
    }

    // If right child is larger than largest so far
    if (right < n && employees[right].emp_no > employees[largest].emp_no) {
        largest = right;
    }

    // If largest is not root
    if (largest != i) {
        swap(employees[i], employees[largest]);
        swapCount++;

        // Recursively heapify the affected sub-tree
        heapify(employees, n, largest, swapCount);
    }
}

// Function to perform Heap Sort
void heapSort(vector<Employee>& employees, int& swapCount) {
    size_t n = employees.size();

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(employees, n, i, swapCount);
    }

    // One by one extract an element from heap
    for (int i = n - 1; i >= 0; i--) {
        swap(employees[0], employees[i]);
        swapCount++;

        // Call max heapify on the reduced heap
        heapify(employees, i, 0, swapCount);
    }
}

void printEmployees(const vector<Employee>& employees) {
    for (const auto& emp : employees) {
        cout << "Name: " << emp.employee_name 
             << ", Emp No: " << emp.emp_no 
             << ", Salary: " << emp.emp_salary << endl;
    }
}

int main() {
    vector<Employee> employees;
    int n;

    cout << "Enter number of employees: ";
    cin >> n;

    for (int i = 0; i < n; i++) {
        Employee emp;
        cout << "Enter name, employee number and salary for employee " << (i + 1) << ": ";
        cin >> emp.employee_name >> emp.emp_no >> emp.emp_salary;
        employees.push_back(emp);
    }

    int choice;

    do {
        cout << "\nMenu:\n";
        cout << "1. Shell Sort\n";
        cout << "2. Heap Sort\n";
        cout << "3. Exit\n";
        cout << "Choose sorting algorithm: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                int swapCount = 0;
                shellSort(employees, swapCount);
                cout << "Sorted using Shell Sort:\n";
                printEmployees(employees);
                cout << "Total swaps: " << swapCount << endl;
                break;
            }
            case 2: {
                int swapCount = 0;
                heapSort(employees, swapCount);
                cout << "Sorted using Heap Sort:\n";
                printEmployees(employees);
                cout << "Total swaps: " << swapCount << endl;
                break;
            }
            case 3:
                cout << "Exiting...\n";
                break;
            default:
                cout << "Invalid choice! Please choose again.\n";
                break;
        }
    } while (choice != 3);

    return 0;
}