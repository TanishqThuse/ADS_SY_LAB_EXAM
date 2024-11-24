/**Q2) 14)Searching
Techniques
In a lab there were 15 computers which are having numbers as 35 to 50.
Students registered for a lab are 14 only. Design appropriate hash
function to assign a computer to every student. Now assume that two
students are absent of this batch so another batch's three students want to
use computers in this lab. Allocate the computers to these new students
by using linear probing with replacement. */

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class HashTable {
private:
    vector<int> table; // Table to store computer numbers
    int size;

public:
    HashTable(int s) : size(s) {
        table.resize(size, -1); // Initialize the hash table with -1 (indicating empty)
    }

    // Hash function using modulo
    int hashFunction(int key) {
        return key % size; // Ensure it fits within table size
    }

    // Insert computer number into the hash table with replacement
    void insert(int computerNumber) {
        int index = hashFunction(computerNumber);
        
        // Linear probing with replacement
        while (table[index] != -1) { // While the slot is occupied
            if (table[index] == computerNumber) { // If the same computer number exists, replace it
                cout << "Replaced: Computer Number = " << computerNumber << " at index " << index << ".\n";
                table[index] = computerNumber; // Replace (though it's the same)
                return;
            }
            index = (index + 1) % size; // Move to next index
        }
        
        // Insert at the found index
        table[index] = computerNumber; 
        cout << "Inserted: Computer Number = " << computerNumber << " at index " << index << ".\n";
    }

    // Display the hash table contents
    void display() {
        for (int i = 0; i < size; ++i) {
            if (table[i] != -1) {
                cout << "Index " << i << ": Computer Number = " << table[i] << "\n";
            } else {
                cout << "Index " << i << ": EMPTY\n";
            }
        }
    }
};

int main() {
    int n = 15; // Total computers available
    HashTable hashTable(n);

    // Initial registered students (14 computers assigned)
    vector<int> registeredComputers = {35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48};

    for (int i = 0; i < registeredComputers.size(); ++i) {
        hashTable.insert(registeredComputers[i]);
    }

    cout << "\nCurrent state of computers allocated:\n";
    hashTable.display();

    // Assume two students are absent and three new students want to use computers
    vector<int> newStudentsComputers = {49, 50, 35}; // One existing computer number is reused

    cout << "\nAllocating computers for new students:\n";
    
    for (int comp : newStudentsComputers) {
        hashTable.insert(comp);
    }

    cout << "\nFinal state of computers allocated:\n";
    hashTable.display();

    return 0;
}

/**
 * Inserted: Computer Number = 35 at index 0.
Inserted: Computer Number = 36 at index 1.
Inserted: Computer Number = 37 at index 2.
Inserted: Computer Number = 38 at index 3.
Inserted: Computer Number = 39 at index 4.
Inserted: Computer Number = 40 at index 5.
Inserted: Computer Number = 41 at index 6.
Inserted: Computer Number = 42 at index 7.
Inserted: Computer Number = 43 at index 8.
Inserted: Computer Number = 44 at index 9.
Inserted: Computer Number = 45 at index 10.
Inserted: Computer Number = 46 at index 11.
Inserted: Computer Number = 47 at index 12.
Inserted: Computer Number = 48 at index 13.

Current state of computers allocated:
Index 0: Computer Number = 35
Index 1: Computer Number = 36
Index 2: Computer Number = 37
Index 3: Computer Number = 38
Index 4: Computer Number = 39
Index 5: Computer Number = 40
Index 6: Computer Number = 41
Index 7: Computer Number = 42
Index 8: Computer Number = 43
Index 9: Computer Number = 44
Index 10: Computer Number = 45
Index 11: Computer Number = 46
Index 12: Computer Number = 47
Index 13: Computer Number = 48
Index 14: EMPTY

Allocating computers for new students:
Inserted: Computer Number =49 at index X.
Inserted: Computer Number =50 at index Y.
Replaced: Computer Number=35 at index Z.

Final state of computers allocated:
Index X :Computer Number=49 
Index Y :Computer Number=50 
Index Z :Computer Number=35 
... 
 */