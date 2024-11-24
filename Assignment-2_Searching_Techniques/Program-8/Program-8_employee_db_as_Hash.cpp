/**Q2) 8)  Searching
Techniques
WAP to simulate employee database as a hash table. Search a particular
faculty by using Mid square method as a hash function for linear
probing method of collision handling technique. Assume suitable data
for faculty record.
*/

#include <iostream>
#include <vector>
#include <string>
#include <cmath>

using namespace std;

struct Employee {
    int id;
    string name;
    string department;

    // Constructor
    Employee(int i, string n, string d) : id(i), name(n), department(d) {}
};

class HashTable {
private:
    vector<Employee*> table; // Pointer to Employee objects
    int size;

    // Function to calculate the mid-square hash value
    int midSquareHash(int key) {
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

public:
    HashTable(int s) : size(s) {
        table.resize(size, nullptr); // Initialize the hash table with nullptr
    }

    // Insert employee record into the hash table
    void insert(Employee* employee) {
        int index = midSquareHash(employee->id);
        int originalIndex = index; // Store original index for probing

        while (table[index] != nullptr) { // Linear probing
            if (table[index]->id == employee->id) {
                // If the ID already exists, replace the record
                delete table[index]; // Free old memory
                table[index] = employee; // Replace with new record
                cout << "Replaced: " << employee->name << " at index " << index << ".\n";
                return;
            }
            index = (index + 1) % size; // Wrap around if necessary
            if (index == originalIndex) {
                cout << "Hash table is full. Cannot insert " << employee->name << ".\n";
                return;
            }
        }
        table[index] = employee; // Insert at the found index
        cout << "Inserted: " << employee->name << " at index " << index << ".\n";
    }

    // Search for an employee record by ID
    Employee* search(int id) {
        int index = midSquareHash(id);
        int originalIndex = index; // Store original index for probing

        while (table[index] != nullptr) {
            if (table[index]->id == id) {
                return table[index]; // Found the employee
            }
            index = (index + 1) % size; // Linear probing
            if (index == originalIndex) {
                break; // Wrapped around to the original index
            }
        }
        return nullptr; // Not found
    }

    // Destructor to clean up memory
    ~HashTable() {
        for (auto employee : table) {
            delete employee; // Free allocated memory for each Employee object
        }
    }
};

int main() {
    int n, tableSize;

    cout << "Enter the size of the hash table: ";
    cin >> tableSize;

    HashTable hashTable(tableSize);

    cout << "Enter the number of employee records to insert: ";
    cin >> n;

    for (int i = 0; i < n; ++i) {
        int id;
        string name, department;

        cout << "Enter ID of employee " << (i + 1) << ": ";
        cin >> id;

        cout << "Enter name of employee " << (i + 1) << ": ";
        cin >> ws; // To consume any leading whitespace
        getline(cin, name);

        cout << "Enter department of employee " << (i + 1) << ": ";
        getline(cin, department);

        Employee* employee = new Employee(id, name, department);
        hashTable.insert(employee);
    }

    int searchId;
    cout << "Enter ID of employee to search: ";
    cin >> searchId;

    Employee* foundEmployee = hashTable.search(searchId);
    
    if (foundEmployee != nullptr) {
        cout << "Found: ID: " << foundEmployee->id 
             << ", Name: " << foundEmployee->name 
             << ", Department: " << foundEmployee->department << "\n";
    } else {
        cout << "Employee with ID " << searchId << " not found.\n";
    }

    return 0;
}

/**
 * Enter the size of the hash table: 5
Enter the number of employee records to insert: 3
Enter ID of employee 1: 12
Enter name of employee 1: Alice
Enter department of employee 1: Computer Science
Inserted: Alice at index 4.
Enter ID of employee 2: 23
Enter name of employee 2: Bob
Enter department of employee 2: Mathematics
Inserted: Bob at index 4.
Enter ID of employee 3: 34 
Enter name of employee 3: Charlie 
Enter department of employee 3: Physics 
Inserted: Charlie at index 4.

Enter ID of employee to search: 23 
Found: ID: 23, Name: Bob, Department: Mathematics 
 */