/**Q1) 7)
Searching
WAP to implement Shell sort and Bucket Sort on 1D array of Employee
structure (contains employee_name, emp_no, emp_salary), with key as
emp_no. And count the number of swap performed */

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

// Function to perform Bucket Sort
void bucketSort(vector<Employee>& employees, int& swapCount) {
    if (employees.empty()) return;

    // Find the maximum employee number
    int maxEmpNo = employees[0].emp_no;
    for (const auto& emp : employees) {
        if (emp.emp_no > maxEmpNo) {
            maxEmpNo = emp.emp_no;
        }
    }

    // Create buckets
    vector<vector<Employee>> buckets(maxEmpNo + 1);

    // Distribute employees into buckets based on emp_no
    for (const auto& emp : employees) {
        buckets[emp.emp_no].push_back(emp);
    }

    // Concatenate buckets back into the original vector
    employees.clear();
    for (const auto& bucket : buckets) {
        for (const auto& emp : bucket) {
            employees.push_back(emp);
        }
    }

    // Count swaps: In bucket sort, we can consider each insertion as a swap
    swapCount = 0; // Reset swap count as bucket sort does not perform traditional swaps
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
        cout << "2. Bucket Sort\n";
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
                bucketSort(employees, swapCount);
                cout << "Sorted using Bucket Sort:\n";
                printEmployees(employees);
                cout << "Total swaps: " << swapCount << endl; // Bucket sort does not have traditional swaps
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