/*Q1) 2)WAP to implement Insertion sort and Merge Sort on 1D array of
Student structure (contains student_name, student_roll_no, total_marks),
with key as student_roll_no. And count the number of swap performed.*/

#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct Student {
    string student_name;
    int student_roll_no;
    float total_marks;
};

void insertionSort(vector<Student>& students, int& swapCount) {
    for (size_t i = 1; i < students.size(); i++) {
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

void merge(vector<Student>& students, int left, int mid, int right, int& swapCount) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    vector<Student> L(n1), R(n2);

    for (int i = 0; i < n1; i++)
        L[i] = students[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = students[mid + 1 + j];

    int i = 0, j = 0, k = left;

    while (i < n1 && j < n2) {
        if (L[i].student_roll_no <= R[j].student_roll_no) {
            students[k] = L[i];
            i++;
        } else {
            students[k] = R[j];
            swapCount += (n1 - i); // Count swaps
            j++;
        }
        k++;
    }

    while (i < n1) {
        students[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        students[k] = R[j];
        j++;
        k++;
    }
}

void mergeSort(vector<Student>& students, int left, int right, int& swapCount) {
    if (left < right) {
        int mid = left + (right - left) / 2;

        mergeSort(students, left, mid, swapCount);
        mergeSort(students, mid + 1, right, swapCount);
        merge(students, left, mid, right, swapCount);
    }
}

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
        cout << "2. Merge Sort\n";
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
                mergeSort(students, 0, n - 1, swapCount);
                cout << "Sorted using Merge Sort:\n";
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