/**Q1) 5)Sorting & Searching
WAP to implement Insertion sort and Quick Sort on 1D array of Student
structure (contains student_name, student_roll_no, total_marks), with
key as student_roll_no. And count the number of swap performed.
 */

#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct Student {
    string student_name;
    int student_roll_no;
    float total_marks;
};

// Function to perform Insertion Sort
void insertionSort(vector<Student>& students, int& swapCount) {
    size_t n = students.size();
    for (size_t i = 1; i < n; i++) {
        Student key = students[i];
        int j = i - 1;

        while (j >= 0 && students[j].student_roll_no > key.student_roll_no) {
            students[j + 1] = students[j];
            swapCount++;
            j--;
        }
        students[j + 1] = key;
    }
}

// Function to partition the array for Quick Sort
int partition(vector<Student>& students, int low, int high, int& swapCount) {
    int pivot = students[high].student_roll_no; // Choosing the last element as pivot
    int i = low - 1; // Index of smaller element

    for (int j = low; j < high; j++) {
        if (students[j].student_roll_no <= pivot) {
            i++;
            swap(students[i], students[j]);
            swapCount++;
        }
    }
    swap(students[i + 1], students[high]); // Place the pivot in the correct position
    swapCount++;
    return i + 1; // Return the partitioning index
}

// Function to perform Quick Sort
void quickSort(vector<Student>& students, int low, int high, int& swapCount) {
    if (low < high) {
        int pi = partition(students, low, high, swapCount); // Partitioning index
        quickSort(students, low, pi - 1, swapCount); // Recursively sort elements before partition
        quickSort(students, pi + 1, high, swapCount); // Recursively sort elements after partition
    }
}

// Function to print the list of students
void printStudents(const vector<Student>& students) {
    for (const auto& student : students) {
        cout << "Name: " << student.student_name 
             << ", Roll No: " << student.student_roll_no 
             << ", Marks: " << student.total_marks << endl;
    }
}

int main() {
    vector<Student> students;
    int n;

    cout << "Enter number of students: ";
    cin >> n;

    for (int i = 0; i < n; i++) {
        Student student;
        cout << "Enter name, roll number and total marks for student " << (i + 1) << ": ";
        cin >> student.student_name >> student.student_roll_no >> student.total_marks;
        students.push_back(student);
    }

    int choice;

    do {
        cout << "\nMenu:\n";
        cout << "1. Insertion Sort\n";
        cout << "2. Quick Sort\n";
        cout << "3. Exit\n";
        cout << "Choose sorting algorithm: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                int swapCount = 0;
                insertionSort(students, swapCount);
                cout << "Sorted using Insertion Sort:\n";
                printStudents(students);
                cout << "Total swaps: " << swapCount << endl;
                break;
            }
            case 2: {
                int swapCount = 0;
                quickSort(students, 0, n - 1, swapCount);
                cout << "Sorted using Quick Sort:\n";
                printStudents(students);
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

