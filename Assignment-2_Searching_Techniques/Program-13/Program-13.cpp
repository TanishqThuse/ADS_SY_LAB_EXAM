/**Q2) 13)WAP to store k keys into an array of size n at the location computed
using a hash function, loc = key / n, where k<=n and k takes values from
[1 to m], m>n. To handle the collisions use the following collision
resolution techniques, a. Linear probing with chaining with replacement
b. Quadratic probing technique. */

#include <iostream>
#include <vector>
#include <string>
#include <list>

using namespace std;

class HashTable {
private:
    vector<list<int>> table; // Table of lists for chaining
    int size;

public:
    HashTable(int s) : size(s) {
        table.resize(size); // Initialize the hash table
    }

    // Hash function using modulo
    int hashFunction(int key) {
        return key % size; // Ensure it fits within table size
    }

    // Insert key into the hash table with replacement (Linear Probing with Chaining)
    void linearProbingInsert(int key) {
        int index = hashFunction(key);
        
        // Check if the key already exists and replace it if so
        for (auto& existingKey : table[index]) {
            if (existingKey == key) {
                existingKey = key; // Replace with new record (same key)
                cout << "Replaced: Key = " << key << " at index " << index << ".\n";
                return;
            }
        }
        
        // If not found, insert the new key into the chain
        table[index].push_back(key); 
        cout << "Inserted: Key = " << key << " at index " << index << ".\n";
    }

    // Insert key into the hash table using Quadratic Probing
    void quadraticProbingInsert(int key) {
        int index = hashFunction(key);
        int i = 0;

        while (i < size) { // Limit attempts to size of table
            int probeIndex = (index + i * i) % size; // Quadratic probing formula
            
            if (table[probeIndex].empty() || find(table[probeIndex].begin(), table[probeIndex].end(), key) != table[probeIndex].end()) {
                // If slot is empty or contains the same key, replace or insert
                if (!table[probeIndex].empty()) {
                    table[probeIndex].clear(); // Clear existing keys at this position
                }
                table[probeIndex].push_back(key);
                cout << "Inserted/Updated: Key = " << key << " at index " << probeIndex << ".\n";
                return;
            }
            i++;
        }

        cout << "Hash table is full. Cannot insert " << key << ".\n";
    }

    // Display the hash table contents
    void display() {
        for (int i = 0; i < size; ++i) {
            cout << "Index " << i << ": ";
            for (const auto& key : table[i]) {
                cout << key << " -> ";
            }
            cout << "NULL\n";
        }
    }
};

int main() {
    int n, k;

    cout << "Enter the size of the hash table: ";
    cin >> n;

    HashTable linearHashTable(n);
    HashTable quadraticHashTable(n);

    cout << "Enter number of keys to insert: ";
    cin >> k;

    for (int i = 0; i < k; ++i) {
        int key;
        
        cout << "Enter Key #" << (i + 1) << ": ";
        cin >> key;

        // Insert using Linear Probing with Chaining
        linearHashTable.linearProbingInsert(key);
        
        // Insert using Quadratic Probing
        quadraticHashTable.quadraticProbingInsert(key);
    }

    cout << "\nLinear Probing with Chaining:\n";
    linearHashTable.display();

    cout << "\nQuadratic Probing:\n";
    quadraticHashTable.display();

    return 0;
}

/*
Enter the size of the hash table: 10
Enter number of keys to insert: 5
Enter Key #1: 21
Inserted: Key = 21 at index 1.
Enter Key #2: 22
Inserted: Key = 22 at index 2.
Enter Key #3: 31
Inserted: Key = 31 at index 1.
Enter Key #4: 42
Inserted: Key = 42 at index 2.
Enter Key #5: 53 
Inserted: Key = 53 at index 3.

Linear Probing with Chaining:
Index 0: NULL
Index 1: 21 -> 31 -> NULL
Index 2: 22 -> 42 -> NULL
Index 3: 53 -> NULL
Index 4: NULL
Index 5: NULL
Index 6: NULL
Index 7: NULL
Index 8: NULL
Index 9: NULL

Quadratic Probing:
Index 0: NULL
Index 1: NULL
Index 2: NULL
Index 3: NULL
Index 4: NULL
Index 5: NULL
Index 6: NULL
Index 7: NULL
Index 8: NULL
Index 9: NULL */