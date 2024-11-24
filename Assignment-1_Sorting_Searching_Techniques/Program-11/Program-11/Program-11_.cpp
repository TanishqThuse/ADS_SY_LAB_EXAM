/**Q1) 11) You hav e a fleet of N cars waiting for repair, with the estimated repair
times rk for the car Ci , 1 ? k ? N. What is the best repairschedule (order
of repairs) to minimize the total lost time for being out­of­service. How
much computation is needed to find the lost service­times all schedules? */

#include <iostream>
#include <vector>
#include <algorithm>

struct Car {
    int id;          // Car ID
    int repair_time; // Estimated repair time
};

// Function to calculate total lost time using SJF scheduling
int calculateTotalLostTime(std::vector<Car>& cars) {
    // Sort cars based on repair times (Shortest Job First)
    std::sort(cars.begin(), cars.end(), [](const Car& a, const Car& b) {
        return a.repair_time < b.repair_time;
    });

    int totalLostTime = 0;
    int cumulativeRepairTime = 0;

    // Calculate lost times
    for (const auto& car : cars) {
        totalLostTime += cumulativeRepairTime; // Add cumulative time before this car
        cumulativeRepairTime += car.repair_time; // Update cumulative time with this car's repair time
    }

    return totalLostTime;
}

int main() {
    int numCars;

    std::cout << "Enter the number of cars: ";
    std::cin >> numCars;

    std::vector<Car> cars(numCars);

    // Input car details
    for (int i = 0; i < numCars; ++i) {
        cars[i].id = i + 1; // Assigning ID starting from 1
        std::cout << "Enter estimated repair time for Car " << cars[i].id << " (in minutes): ";
        std::cin >> cars[i].repair_time;
    }

    // Calculate total lost time
    int totalLostTime = calculateTotalLostTime(cars);
    
    std::cout << "\nThe total lost time due to being out of service is: " << totalLostTime << " minutes.\n";

    return 0;
}

//Input : 
/**Enter the number of cars: 5
Enter estimated repair time for Car 1 (in minutes): 10
Enter estimated repair time for Car 2 (in minutes): 5
Enter estimated repair time for Car 3 (in minutes): 8
Enter estimated repair time for Car 4 (in minutes): 12
Enter estimated repair time for Car 5 (in minutes): 6
 */