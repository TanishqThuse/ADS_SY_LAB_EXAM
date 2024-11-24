/**Q2) 7) WAP to store k keys into an array of size n at the location computed
using a hash function, loc = key % n, where k<=n and k takes values
from [1 to m], m>n. To handle the collisions use the following collision
resolution techniques, a. Linear probing with chaining b. Rehashing
technique. */

#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct Faculty {
    int id;
    string name;
    string department;

    // Constructor
    Faculty(int i, string n, string d) : id(i), name(n), department(d) {}
};

class HashTable {
private:
    vector<Faculty*> table; // Pointer to Faculty objects
    int size;

public:
    HashTable(int s) : size(s) {
        table.resize(size, nullptr); // Initialize the hash table with nullptr
    }

    // Hash function using modulo
    int hashFunction(int id) {
        return id % size;
    }

    // Insert faculty record into the hash table
    void insert(Faculty* faculty) {
        int index = hashFunction(faculty->id);
        int originalIndex = index; // Store original index for probing

        while (table[index] != nullptr) { // Linear probing with replacement
            if (table[index]->id == faculty->id) {
                // If the ID already exists, replace the record
                delete table[index]; // Free old memory
                table[index] = faculty; // Replace with new record
                cout << "Replaced: " << faculty->name << " at index " << index << ".\n";
                return;
            }
            index = (index + 1) % size; // Wrap around if necessary
            if (index == originalIndex) {
                cout << "Hash table is full. Cannot insert " << faculty->name << ".\n";
                return;
            }
        }
        table[index] = faculty; // Insert at the found index
        cout << "Inserted: " << faculty->name << " at index " << index << ".\n";
    }

    // Search for a faculty record by ID
    Faculty* search(int id) {
        int index = hashFunction(id);
        int originalIndex = index; // Store original index for probing

        while (table[index] != nullptr) {
            if (table[index]->id == id) {
                return table[index]; // Found the faculty member
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
        for (auto faculty : table) {
            delete faculty; // Free allocated memory for each Faculty object
        }
    }
};

int main() {
    int n, tableSize;

    cout << "Enter the size of the hash table: ";
    cin >> tableSize;

    HashTable hashTable(tableSize);

    cout << "Enter the number of faculty records to insert: ";
    cin >> n;

    for (int i = 0; i < n; ++i) {
        int id;
        string name, department;

        cout << "Enter ID of faculty member " << (i + 1) << ": ";
        cin >> id;

        cout << "Enter name of faculty member " << (i + 1) << ": ";
        cin >> ws; // To consume any leading whitespace
        getline(cin, name);

        cout << "Enter department of faculty member " << (i + 1) << ": ";
        getline(cin, department);

        Faculty* faculty = new Faculty(id, name, department);
        hashTable.insert(faculty);
    }

    int searchId;
    cout << "Enter ID of faculty member to search: ";
    cin >> searchId;

    Faculty* foundFaculty = hashTable.search(searchId);
    
    if (foundFaculty != nullptr) {
        cout << "Found: ID: " << foundFaculty->id 
             << ", Name: " << foundFaculty->name 
             << ", Department: " << foundFaculty->department << "\n";
    } else {
        cout << "Faculty member with ID " << searchId << " not found.\n";
    }

    return 0;
}


/**
 * Enter the size of the hash table: 5
Enter the number of faculty records to insert: 3
Enter ID of faculty member 1: 101
Enter name of faculty member 1: Alice
Enter department of faculty member 1: Computer Science
Inserted: Alice at index 1.
Enter ID of faculty member 2: 102
Enter name of faculty member 2: Bob
Enter department of faculty member 2: Mathematics
Inserted: Bob at index 2.
Enter ID of faculty member 3: 101   // Duplicate ID to test replacement.
Enter name of faculty member 3: Charlie
Enter department of faculty member 3: Physics
Replaced: Charlie at index 1.
Enter ID of faculty member to search: 102
Found: ID: 102, Name: Bob, Department: Mathematics
 */