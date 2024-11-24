/*Q2) 15)Searching
Techniques
Consider two sets of integers, S = {s1, s2, ...,sm} and T = {t1, t2, ..., tn}, m<=n. a.Device an algorithm that uses a hash table of size m to test
whether S is a subset of T. b.What is the average running time of your
algorithm?*/

#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

class HashTable {
private:
    unordered_set<int> table; // Using unordered_set for efficient lookup

public:
    // Insert elements into the hash table
    void insert(int key) {
        table.insert(key);
    }

    // Check if an element exists in the hash table
    bool contains(int key) {
        return table.find(key) != table.end();
    }
};

int main() {
    int m, n;

    // Input size of set S
    cout << "Enter the number of elements in set S (subset): ";
    cin >> m;
    vector<int> S(m);

    // Input elements of set S
    cout << "Enter elements of set S:\n";
    for (int i = 0; i < m; ++i) {
        cin >> S[i];
    }

    // Input size of set T
    cout << "Enter the number of elements in set T (superset): ";
    cin >> n;
    vector<int> T(n);

    // Input elements of set T
    cout << "Enter elements of set T:\n";
    for (int i = 0; i < n; ++i) {
        cin >> T[i];
    }

    // Create a hash table and insert elements from set T
    HashTable hashTable;
    for (int i = 0; i < n; ++i) {
        hashTable.insert(T[i]);
    }

    // Check if S is a subset of T
    bool isSubset = true;
    
    for (int i = 0; i < m; ++i) {
        if (!hashTable.contains(S[i])) {
            isSubset = false;
            break;
        }
    }

    // Output result
    if (isSubset) {
        cout << "Set S is a subset of Set T.\n";
    } else {
        cout << "Set S is NOT a subset of Set T.\n";
    }

    return 0;
}

/**
 * Enter the number of elements in set S (subset): 3
Enter elements of set S:
1 2 3
Enter the number of elements in set T (superset): 5
Enter elements of set T:
1 2 3 4 5

Set S is a subset of Set T.
 */