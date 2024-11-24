/**Q2) 11)Searching
Techniques
In a lab there were 10 computers which are having numbers as 21 to 30.
Students registered for a lab are 10 only. Design appropriate hash
function to assign a computer to every student. Now assume that three
students are absent of this batch so another batch students want to use
computers in this lab. Allocate the computers to these new students by
using linear probing with chaining without replacement.
*/

#include <iostream>
#include <vector>
#include <string>
#include <list>

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
    vector<list<Faculty*>> table; // Table of lists for chaining
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

    // Insert faculty record into the hash table with replacement
    void insert(Faculty* faculty) {
        int index = hashFunction(faculty->id);
        
        // Check if the key already exists and replace it if so
        for (auto& existingFaculty : table[index]) {
            if (existingFaculty->id == faculty->id) {
                delete existingFaculty; // Free old memory
                existingFaculty = faculty; // Replace with new record
                cout << "Replaced: Key = " << faculty->id << ", Value = " << faculty->name << " at index " << index << ".\n";
                return;
            }
        }
        
        // If not found, insert the new faculty record into the chain
        table[index].push_back(faculty); 
        cout << "Inserted: Key = " << faculty->id << ", Value = " << faculty->name << " at index " << index << ".\n";
    }

    // Search for a faculty record by ID
    Faculty* search(int id) {
        int index = hashFunction(id);
        
        for (const auto& faculty : table[index]) {
            if (faculty->id == id) {
                return faculty; // Found the faculty member
            }
        }
        
        return nullptr; // Not found
    }

    // Destructor to clean up memory
    ~HashTable() {
        for (auto& chain : table) {
            for (auto faculty : chain) {
                delete faculty; // Free allocated memory for each Faculty object
            }
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

/*(*Enter the size of the hash table: 5
Enter the number of faculty records to insert: 3
Enter ID of faculty member 1: 12
Enter name of faculty member 1: Alice
Enter department of faculty member 1: Computer Science
Inserted: Key = 12, Value = Alice at index 4.
Enter ID of faculty member 2: 23
Enter name of faculty member 2: Bob
Enter department of faculty member 2: Mathematics
Inserted: Key = 23, Value = Bob at index 4.
Enter ID of faculty member 3: 34 
Enter name of faculty member 3: Charlie 
Enter department of faculty member 3: Physics 
Inserted: Key = 34, Value = Charlie at index 4.

Enter ID of faculty member to search: 23 
Found: ID: 23, Name: Bob, Department: Mathematics */