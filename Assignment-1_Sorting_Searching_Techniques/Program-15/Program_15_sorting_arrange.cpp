/**Q1) 15) Arrange the list of employees as per the average of their height and
weight by using appropriate sorting method */

#include <iostream>
#include <vector>
#include <string>
#include <iomanip> // For std::setprecision

struct Employee {
    std::string name;
    double height; // in centimeters
    double weight; // in kilograms

    // Constructor
    Employee(std::string n, double h, double w) : name(n), height(h), weight(w) {}

    // Function to calculate average of height and weight
    double average() const {
        return (height + weight) / 2.0;
    }
};

// Function to swap two employees
void swap(Employee& a, Employee& b) {
    Employee temp = a;
    a = b;
    b = temp;
}

// Partition function for Quick Sort
int partition(std::vector<Employee>& employees, int low, int high) {
    double pivot = employees[high].average(); // Choosing the last employee's average as pivot
    int i = low - 1; // Index of smaller element

    for (int j = low; j <= high - 1; j++) {
        if (employees[j].average() < pivot) { // Sort in ascending order based on average
            i++;
            swap(employees[i], employees[j]);
        }
    }
    swap(employees[i + 1], employees[high]);
    return i + 1;
}

// Quick Sort function
void quickSort(std::vector<Employee>& employees, int low, int high) {
    if (low < high) {
        int pi = partition(employees, low, high);
        quickSort(employees, low, pi - 1);
        quickSort(employees, pi + 1, high);
    }
}

// Function to print the sorted list of employees
void printEmployees(const std::vector<Employee>& employees) {
    std::cout << "\nSorted Employees by Average (Height & Weight):\n";
    std::cout << std::fixed << std::setprecision(2); // Set precision for output

    for (const auto& emp : employees) {
        std::cout << "Name: " << emp.name << ", Height: " << emp.height 
                  << " cm, Weight: " << emp.weight 
                  << " kg, Average: " << emp.average() << "\n";
    }
}

int main() {
    int n;

    std::cout << "Enter the number of employees: ";
    std::cin >> n;

    std::vector<Employee> employees;

    // Input employee details
    for (int i = 0; i < n; ++i) {
        std::string name;
        double height, weight;

        std::cout << "Enter name of employee " << (i + 1) << ": ";
        std::cin >> std::ws; // To consume any leading whitespace
        std::getline(std::cin, name);

        std::cout << "Enter height of employee " << (i + 1) << " (in cm): ";
        std::cin >> height;

        std::cout << "Enter weight of employee " << (i + 1) << " (in kg): ";
        std::cin >> weight;

        employees.emplace_back(name, height, weight);
    }

    // Sort the employees based on their average height and weight
    quickSort(employees, 0, n - 1);

    // Print the sorted list of employees
    printEmployees(employees);

    return 0;
}


/**Enter the number of employees: 3
Enter name of employee 1: Alice
Enter height of employee 1 (in cm): 165
Enter weight of employee 1 (in kg): 60
Enter name of employee 2: Bob
Enter height of employee 2 (in cm): 175
Enter weight of employee 2 (in kg): 80
Enter name of employee 3: Charlie
Enter height of employee 3 (in cm): 170
Enter weight of employee 3 (in kg): 70

Sorted Employees by Average (Height & Weight):
Name: Alice, Height: 165.00 cm, Weight: 60.00 kg, Average: 112.50
Name: Charlie, Height: 170.00 cm, Weight: 70.00 kg, Average: 120.00
Name: Bob, Height: 175.00 cm, Weight: 80.00 kg, Average: 127.50 */