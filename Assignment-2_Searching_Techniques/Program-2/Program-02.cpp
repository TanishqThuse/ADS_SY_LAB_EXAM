/**Q2) 2)WAP to search a particular employees record in 'n' number of
employee's pool by using Fibonacci search with and without recursive
function. Assume suitable data for employee record */


#include <iostream>
#include <vector>
#include <string>
#include <iomanip> // For std::setprecision
#include <limits>  // For std::numeric_limits
#include <algorithm> // For std::sort

using namespace std;

struct Employee {
    int id;
    string name;
    double height; // in centimeters
    double weight; // in kilograms

    // Constructor
    Employee(int i, string n, double h, double w) : id(i), name(n), height(h), weight(w) {}
};

// Function to perform Fibonacci Search (non-recursive)
int fibonacciSearch(const vector<Employee>& employees, int id) {
    int n = employees.size();
    int fib2 = 0; // (m-2)'th Fibonacci number
    int fib1 = 1; // (m-1)'th Fibonacci number
    int fibM = fib1 + fib2; // m'th Fibonacci number

    // Find the largest Fibonacci number less than or equal to n
    while (fibM < n) {
        fib2 = fib1;
        fib1 = fibM;
        fibM = fib1 + fib2;
    }

    // Marks the eliminated range from front
    int offset = -1;

    while (fibM > 1) {
        // Check if fib2 is a valid location
        int i = min(offset + fib2, n - 1);

        if (employees[i].id < id) {
            // Move the range to the right
            fibM = fib1;
            fib1 = fib2;
            fib2 = fibM - fib1;
            offset = i; // Update the offset
        } else if (employees[i].id > id) {
            // Move the range to the left
            fibM = fib2;
            fib1 = fib1 - fib2;
            fib2 = fibM - fib1;
        } else {
            return i; // Found the element
        }
    }

    // Comparing the last element with id
    if (fib1 && offset + 1 < n && employees[offset + 1].id == id) {
        return offset + 1; // Found the element
    }

    return -1; // Element not found
}

// Recursive Fibonacci Search function
int fibonacciSearchRecursiveHelper(const vector<Employee>& employees, int id, int n, int fibM, int offset) {
    if (fibM == 0) return -1;

    int i = min(offset + (fibM == 1 ? 0 : employees[fibM - 2].id), n - 1);

    if (i < n && employees[i].id < id) {
        return fibonacciSearchRecursiveHelper(employees, id, n, fibM - 1, i);
    } else if (i >= 0 && employees[i].id > id) {
        return fibonacciSearchRecursiveHelper(employees, id, n, fibM - 2, offset);
    } else if (i < n && employees[i].id == id) {
        return i; // Found the element
    }

    return -1; // Element not found
}

int fibonacciSearchRecursive(const vector<Employee>& employees, int id) {
    int n = employees.size();
    
    // Initialize Fibonacci numbers
    int fib2 = 0; 
    int fib1 = 1; 
    int fibM = fib1 + fib2;

    while (fibM < n) {
        fib2 = fib1;
        fib1 = fibM;
        fibM = fib1 + fib2;
    }

    return fibonacciSearchRecursiveHelper(employees, id, n, fibM, -1);
}

int main() {
    int n;

    cout << "Enter the number of employees: ";
    cin >> n;

    vector<Employee> employees;

    // Input employee details
    for (int i = 0; i < n; ++i) {
        int id;
        string name;
        double height, weight;

        cout << "Enter ID of employee " << (i + 1) << ": ";
        cin >> id;

        cout << "Enter name of employee " << (i + 1) << ": ";
        cin >> ws; // To consume any leading whitespace
        getline(cin, name);

        cout << "Enter height of employee " << (i + 1) << " (in cm): ";
        cin >> height;

        cout << "Enter weight of employee " << (i + 1) << " (in kg): ";
        cin >> weight;

        employees.emplace_back(id, name, height, weight);
    }

   // Sort employees by ID for searching purposes
   sort(employees.begin(), employees.end(), [](const Employee& a, const Employee& b) {
       return a.id < b.id;
   });

   int searchId;
   
   cout << "Enter ID of employee to search: ";
   cin >> searchId;

   // Perform Fibonacci Search (non-recursive)
   int indexNonRecursive = fibonacciSearch(employees, searchId);
   
   if (indexNonRecursive != -1) {
       cout << "Employee found: ID: " << employees[indexNonRecursive].id 
             << ", Name: " << employees[indexNonRecursive].name 
             << ", Height: " << employees[indexNonRecursive].height 
             << ", Weight: " << employees[indexNonRecursive].weight << "\n";
   } else {
       cout << "Employee with ID " << searchId << " not found.\n";
   }

   // Perform Fibonacci Search (recursive)
   int indexRecursive = fibonacciSearchRecursive(employees, searchId);
   
   if (indexRecursive != -1) {
       cout << "Employee found using recursive search: ID: " 
             << employees[indexRecursive].id 
             << ", Name: " << employees[indexRecursive].name 
             << ", Height: " << employees[indexRecursive].height 
             << ", Weight: " << employees[indexRecursive].weight << "\n";
   } else {
       cout << "Employee with ID " << searchId << " not found using recursive search.\n";
   }

   return 0;
}

/*Enter the number of employees: 3
Enter ID of employee 1: 101
Enter name of employee 1: Alice
Enter height of employee 1 (in cm): 165
Enter weight of employee 1 (in kg): 60
Enter ID of employee 2: 102
Enter name of employee 2: Bob
Enter height of employee 2 (in cm): 175
Enter weight of employee 2 (in kg): 80
Enter ID of employee 3: 103
Enter name of employee 3: Charlie
Enter height of employee 3 (in cm): 170
Enter weight of employee 3 (in kg): 70

Enter ID of employee to search: 102

Employee found: ID: 102, Name: Bob, Height: 175.00, Weight: 80.00

Employee found using recursive search: ID: 102, Name: Bob, Height: 175.00, Weight: 80.00*/