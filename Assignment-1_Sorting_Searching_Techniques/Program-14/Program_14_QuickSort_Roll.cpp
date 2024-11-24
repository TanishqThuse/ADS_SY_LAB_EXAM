/**Q1) 14)Using Quick sort, assign the roll nos. to the students of your class as per
Searching their previous years result. i.e. topper will be roll no. 1.
 */

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <iomanip> // For std::ws

struct Student {
    std::string name;
    int marks;

    // Constructor
    Student(std::string n, int m) : name(n), marks(m) {}
};

// Function to swap two students
void swap(Student& a, Student& b) {
    Student temp = a;
    a = b;
    b = temp;
}

// Partition function for Quick Sort
int partition(std::vector<Student>& students, int low, int high) {
    int pivot = students[high].marks; // Choosing the last element as pivot
    int i = low - 1; // Index of smaller element

    for (int j = low; j <= high - 1; j++) {
        if (students[j].marks > pivot) { // Sort in descending order
            i++;
            swap(students[i], students[j]);
        }
    }
    swap(students[i + 1], students[high]);
    return i + 1;
}

// Quick Sort function
void quickSort(std::vector<Student>& students, int low, int high) {
    if (low < high) {
        int pi = partition(students, low, high);
        quickSort(students, low, pi - 1);
        quickSort(students, pi + 1, high);
    }
}

// Function to assign roll numbers based on sorted order
void assignRollNumbers(std::vector<Student>& students) {
    quickSort(students, 0, students.size() - 1);

    std::cout << "\nAssigned Roll Numbers:\n";
    for (int i = 0; i < students.size(); i++) {
        std::cout << "Roll No: " << (i + 1) << ", Name: " << students[i].name << ", Marks: " << students[i].marks << "\n";
    }
}

int main() {
    int n;

    std::cout << "Enter the number of students: ";
    std::cin >> n;

    std::vector<Student> students;

    // Input student names and marks
    for (int i = 0; i < n; ++i) {
        std::string name;
        int marks;
        std::cout << "Enter name of student " << (i + 1) << ": ";
        std::cin >> std::ws; // To consume any leading whitespace
        std::getline(std::cin, name);
        
        std::cout << "Enter marks of student " << (i + 1) << ": ";
        std::cin >> marks;

        students.emplace_back(name, marks);
    }

    // Assign roll numbers based on sorted order
    assignRollNumbers(students);

    return 0;
}

// Enter the number of students: 3
// Enter name of student 1: Alice
// Enter marks of student 1: 85
// Enter name of student 2: Bob
// Enter marks of student 2: 92
// Enter name of student 3: Charlie
// Enter marks of student 3: 78

// Assigned Roll Numbers:
// Roll No: 1, Name: Bob, Marks: 92
// Roll No: 2, Name: Alice, Marks: 85
// Roll No: 3, Name: Charlie, Marks: 78