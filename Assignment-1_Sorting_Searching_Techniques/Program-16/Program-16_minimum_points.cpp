/**Q1) 16)orting &
Searching
Given a set of points Pi , 1 ? i ? N (? 2) on the x­axis, find Pi and P j
such that |Pi ? P j | is minimum. e.g. P1 | P2 | P3 | P4 | P5 | P6 {P4 , P6}
is the closest pai */
#include <iostream>
#include <vector>
#include <algorithm> // For std::sort
#include <iomanip>   // For std::setprecision
#include <limits>    // For std::numeric_limits

// Function to find the closest pair of points
void findClosestPair(const std::vector<int>& points) {
    int n = points.size();
    if (n < 2) {
        std::cout << "Not enough points to find a pair.\n";
        return;
    }

    // Sort the points
    std::vector<int> sortedPoints = points;
    std::sort(sortedPoints.begin(), sortedPoints.end());

    int minDistance = std::numeric_limits<int>::max(); // Use numeric_limits to define INT_MAX
    int closestPair[2];

    // Find the minimum distance between consecutive points
    for (int i = 0; i < n - 1; i++) {
        int distance = sortedPoints[i + 1] - sortedPoints[i];
        if (distance < minDistance) {
            minDistance = distance;
            closestPair[0] = sortedPoints[i];
            closestPair[1] = sortedPoints[i + 1];
        }
    }

    std::cout << "The closest pair of points is: {" << closestPair[0] << ", " << closestPair[1] << "}\n";
}

int main() {
    int n;

    std::cout << "Enter the number of points: ";
    std::cin >> n;

    std::vector<int> points;

    // Input point coordinates
    for (int i = 0; i < n; ++i) {
        int point;
        std::cout << "Enter coordinate of point " << (i + 1) << ": ";
        std::cin >> point; // No need for ws here since we are reading integers directly
        points.push_back(point);
    }

    // Find and print the closest pair of points
    findClosestPair(points);

    return 0;
}

/**Input fiole */
/*
Enter the number of points: 6
Enter coordinate of point 1: 3
Enter coordinate of point 2: 8
Enter coordinate of point 3: 5
Enter coordinate of point 4: 10
Enter coordinate of point 5: 2
Enter coordinate of point 6: 6

The closest pair of points is: {5, 6}*/