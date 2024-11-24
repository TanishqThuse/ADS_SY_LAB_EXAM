/**Q2) 12)In Computer Engg. Dept. of VIT there are S.E., T.E., and B.E. students.
Assume that all these students are on ground for a function. We need to
identify a student of S.E. div. (X) whose name is "XYZ" and roll no. is
"17". Apply appreopriate searching method to identify a required
student.
 */

#include <iostream>
#include <vector>
#include <string>
#include <list>

using namespace std;

struct Student {
    int rollNo; // Student Roll Number
    string name; // Student Name
    string division; // Student Division (e.g., S.E., T.E., B.E.)

    // Constructor
    Student(int r, string n, string d) : rollNo(r), name(n), division(d) {}
};

class HashTable {
private:
    vector<list<Student*>> table; // Table of lists for chaining
    int size;

public:
    HashTable(int s) : size(s) {
        table.resize(size); // Initialize the hash table
    }

    // Hash function using mid-square method
    int hashFunction(int key) {
        long long square = static_cast<long long>(key) * key; // Square the key
        string squareStr = to_string(square); // Convert to string to extract middle digits

        int midIndex = squareStr.length() / 2; // Find the middle index
        int hashValue;

        // Extract middle digits (2 digits for simplicity)
        if (squareStr.length() > 2) {
            hashValue = stoi(squareStr.substr(midIndex - 1, 2)); // Get two middle digits
        } else {
            hashValue = key; // If the number is too small, use the key itself
        }

        return hashValue % size; // Ensure it fits within table size
    }

    // Insert student record into the hash table with replacement
    void insert(Student* student) {
        int index = hashFunction(student->rollNo);
        
        // Check if the roll number already exists and replace it if so
        for (auto& existingStudent : table[index]) {
            if (existingStudent->rollNo == student->rollNo) {
                delete existingStudent; // Free old memory
                existingStudent = student; // Replace with new record
                cout << "Replaced: Roll No = " << student->rollNo << ", Name = " << student->name << " at index " << index << ".\n";
                return;
            }
        }
        
        // If not found, insert the new student record into the chain
        table[index].push_back(student); 
        cout << "Inserted: Roll No = " << student->rollNo << ", Name = " << student->name << " at index " << index << ".\n";
    }

    // Search for a student record by roll number and name
    Student* search(int rollNo, const string& name) {
        int index = hashFunction(rollNo);
        
        for (const auto& student : table[index]) {
            if (student->rollNo == rollNo && student->name == name) {
                return student; // Found the student
            }
        }
        
        return nullptr; // Not found
    }

    // Destructor to clean up memory
    ~HashTable() {
        for (auto& chain : table) {
            for (auto student : chain) {
                delete student; // Free allocated memory for each Student object
            }
        }
    }
};

int main() {
    int n, tableSize;

    cout << "Enter the size of the hash table: ";
    cin >> tableSize;

    HashTable hashTable(tableSize);

    cout << "Enter the number of students to register: ";
    cin >> n;

    for (int i = 0; i < n; ++i) {
        int rollNo;
        string name, division;

        cout << "Enter Roll No of student " << (i + 1) << ": ";
        cin >> rollNo;

        cout << "Enter name of student " << (i + 1) << ": ";
        cin >> ws; // To consume any leading whitespace
        getline(cin, name);

        cout << "Enter division of student " << (i + 1) << ": ";
        getline(cin, division);

        Student* student = new Student(rollNo, name, division);
        hashTable.insert(student);
    }

    int searchRollNo;
    string searchName;
    
    cout << "Enter Roll No of student to search: ";
    cin >> searchRollNo;
    
    cout << "Enter Name of student to search: ";
    cin >> ws; // To consume any leading whitespace
    getline(cin, searchName);

    Student* foundStudent = hashTable.search(searchRollNo, searchName);
    
    if (foundStudent != nullptr) {
        cout << "Found: Roll No: " << foundStudent->rollNo 
             << ", Name: " << foundStudent->name 
             << ", Division: " << foundStudent->division << "\n";
    } else {
        cout << "Student with Roll No " << searchRollNo 
             << " and Name '" << searchName << "' not found.\n";
    }

    return 0;
}

//input
/*
Enter the size of the hash table: 10
Enter the number of students to register: 3
Enter Roll No of student 1: 17
Enter name of student 1: XYZ
Enter division of student 1: S.E.
Inserted: Roll No = 17, Name = XYZ at index X.
Enter Roll No of student 2: 18
Enter name of student 2: Alice
Enter division of student 2: T.E.
Inserted: Roll No = 18, Name = Alice at index Y.
Enter Roll No of student 3: 19 
Enter name of student 3: Bob 
Enter division of student 3: B.E. 
Inserted: Roll No = 19, Name = Bob at index Z.

Enter Roll No of student to search: 17 
Enter Name of student to search: XYZ 
Found: Roll No: 17, Name: XYZ, Division: S.E. */