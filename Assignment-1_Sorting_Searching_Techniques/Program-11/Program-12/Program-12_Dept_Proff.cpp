/**Q1) 12)Write a program to arrange the data of the faculties recruited in the
institute. There are three categories of faculties in the every deartment
namely professor, Associate professor, and assistant professor.
Recruitment is done as mentioned below. 1. Every professor has two
associate professors. 2. Every Associate has two assistant professors.
Data is given randomly. Suggest suitable sorting method and implement */


#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <iomanip> // For std::ws

class Faculty {
public:
    std::string name;
    std::string position; // "Professor", "Associate Professor", "Assistant Professor"
    std::vector<Faculty*> subordinates;

    Faculty(std::string n, std::string pos) : name(n), position(pos) {}
};

// Function to add subordinates to a faculty member
void addSubordinate(Faculty* supervisor, Faculty* subordinate) {
    supervisor->subordinates.push_back(subordinate);
}

// Function to perform DFS and collect sorted faculties
void collectFaculties(Faculty* faculty, std::vector<Faculty*>& sortedFaculties) {
    if (faculty == nullptr) return;

    sortedFaculties.push_back(faculty); // Add current faculty to the list

    // Recursively collect subordinates
    for (auto& sub : faculty->subordinates) {
        collectFaculties(sub, sortedFaculties);
    }
}

// Comparison function for sorting faculties
bool compareFaculty(Faculty* a, Faculty* b) {
    if (a->position == b->position) {
        return a->name < b->name; // Sort by name if positions are the same
    }
    return a->position < b->position; // Sort by position
}

// Function to print sorted faculties
void printSortedFaculties(const std::vector<Faculty*>& sortedFaculties) {
    for (const auto& faculty : sortedFaculties) {
        std::cout << faculty->name << " (" << faculty->position << ")\n";
    }
}

int main() {
    int numProfessors;

    std::cout << "Enter the number of Professors: ";
    std::cin >> numProfessors;

    std::vector<Faculty*> professors;
    
    // Input Professors
    for (int i = 0; i < numProfessors; ++i) {
        std::string name;
        std::cout << "Enter name of Professor " << (i + 1) << ": ";
        std::cin >> std::ws; // To consume any leading whitespace
        std::getline(std::cin, name);
        professors.push_back(new Faculty(name, "Professor"));
        
        // Input Associate Professors
        for (int j = 0; j < 2; ++j) {
            std::string assocName;
            std::cout << "  Enter name of Associate Professor " << (j + 1) << ": ";
            std::cin >> std::ws; // To consume any leading whitespace
            std::getline(std::cin, assocName);
            Faculty* associate = new Faculty(assocName, "Associate Professor");
            addSubordinate(professors.back(), associate); // Associate under the last added professor
            
            // Input Assistant Professors
            for (int k = 0; k < 2; ++k) {
                std::string assistName;
                std::cout << "    Enter name of Assistant Professor " << (k + 1) << ": ";
                std::cin >> std::ws; // To consume any leading whitespace
                std::getline(std::cin, assistName);
                Faculty* assistant = new Faculty(assistName, "Assistant Professor");
                addSubordinate(associate, assistant); // Assistant under the last added associate professor
            }
        }
    }

    // Collect all faculties in a vector
    std::vector<Faculty*> sortedFaculties;
    
    for (auto& prof : professors) {
        collectFaculties(prof, sortedFaculties);
    }

    // Sort faculties based on position and name
    std::sort(sortedFaculties.begin(), sortedFaculties.end(), compareFaculty);

    // Print sorted faculties
    std::cout << "\nSorted Faculties:\n";
    printSortedFaculties(sortedFaculties);

    // Clean up memory
    for (auto& prof : professors) {
        delete prof; // Delete professors and their subordinates in a real application.
        // Note: In a full implementation, you would need to recursively delete all subordinates.
        // For simplicity in this example, we only delete professors.
    }

    return 0;
}

/**Enter the number of Professors: 2
Enter name of Professor 1: Dr. Smith
  Enter name of Associate Professor 1: Dr. Johnson
    Enter name of Assistant Professor 1: Dr. Brown
    Enter name of Assistant Professor 2: Dr. Wilson
  Enter name of Associate Professor 2: Dr. Lee
    Enter name of Assistant Professor 1: Dr. White
    Enter name of Assistant Professor 2: Dr. Green

Enter name of Professor 2: Dr. Adams
  Enter name of Associate Professor 1: Dr. Taylor
    Enter name of Assistant Professor 1: Dr. Black
    Enter name of Assistant Professor 2: Dr. Gray
  Enter name of Associate Professor 2: Dr. Harris
    Enter name of Assistant Professor 1: Dr. Blue
    Enter name of Assistant Professor 2: Dr. Red */