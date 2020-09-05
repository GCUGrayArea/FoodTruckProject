# SD27 Homework, Week 2: Food Truck list

## Food Truck project

### Overview

This script requests input from the user for the name, cuisine type and numerical rating of up to five food trucks, storing each with a unique associated numerical ID. It will stop automatically after data has been provided for five trucks, or after fewer if the user enters the string "quit" as the name of a truck. After collecting this input, it gives the user the option to view all data entered, the average rating of the trucks on file, or the single highest-rated truck.

### Topics
* Taking User input
  - A single scanner is created to collect user input and passed to all methods that require it until the user quits the program.
* Encapsulation: Visibility Modifiers
  - Apart from the single main method and the getter and setter methods used for the fields of the FoodTruck class, every method in the two files used for this project is set to `private`. The only non-private field used is `foodTrucksEntered` in the `FoodTruck` class, to simplify the sizing of the array of food trucks returned when the user is done entering them.
* Encapsulation: Minimum possible use of non-instance fields and methods
  - Apart from the `main` method in `FoodTruckProject`, this code makes no use of static methods, and only one static field, `foodTrucksEntered` in the `FoodTruck` class, is used.
* Object-Oriented Design
- This week's object-oriented concepts are used heavily. In addition to the encapsulation discussed above, as much code as possible has been moved out of the `main` method by placing it in other methods of `FoodTruckProject` and instantiating that class as part of the `main` method.

### How to Run

1. Compile the `MakeChange.java` class file with `javac` or load it in Eclipse or another IDE.
2. Run the file from the command line with `java MakeChange`, or with your IDE's run tools.
3. Enter the inputs requested by the program.
4. ~~PROFIT!~~ Look at console output for the answers you seek.
