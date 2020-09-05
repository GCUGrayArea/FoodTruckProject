package com.skilldistillery.foodtruckproject;

public class FoodTruckProject {
	// making this a class field saves me from messing around with passing
	// it to other methods as a parameter. I can just use `this`
	private FoodTruck[] foodTruckArr;

	public static void main(String[] args) {
		
		boolean inMenu;
		java.util.Scanner kb = new java.util.Scanner(System.in);

		FoodTruckProject trucks = new FoodTruckProject();
		trucks.foodTruckArr = trucks.enterFoodTrucks(kb);
		do {
			inMenu = trucks.workWithTrucks(kb);
		} while ( inMenu );
		//no loose ends
		trucks = null;
		kb.close();
	}

	private boolean workWithTrucks(java.util.Scanner kb) {
		int menuSelection;
		printMenu();
		menuSelection = kb.nextInt();
		//pretty pleased with this switch statement. hadn't been able
		//to make one work for menu input previously. unfortunately not
		//sure what I'd been doing wrong
		switch (menuSelection) {
			case 4:
				System.out.println("We hope you use our program again. Have a nice day!");
				return false;
			case 1:
				displayFoodTrucks();
				break;
			case 2:
				displayAverageTruckRating();
				break;
			case 3:
				displayHighestRatedTruck();
				break;
			default:
				System.out.println("Input not recognized. Please selection an option (1 - 4) to continue.");
				break;				
		}
		return true;

	}
	
	private void displayAverageTruckRating() {
		if ( this.foodTruckArr.length == 0 ) {
			System.out.println("There are currently no food trucks on file.");			
		} else {
			double sum = 0;
			for ( FoodTruck i : this.foodTruckArr ) {
				sum += i.getRating();
			}
			double average = sum / this.foodTruckArr.length;
			System.out.printf("The average rating of the %d food trucks on file is %.1f.%n" ,
					this.foodTruckArr.length ,
					average );
		}
	}

	private void displayHighestRatedTruck() {
		if (this.foodTruckArr.length == 0) {
			System.out.println("There are currently no food trucks on file.");
		} else {
			FoodTruck truckToPrint = this.foodTruckArr[0];
			if (this.foodTruckArr.length > 1) {
				for (int i = 1; i < this.foodTruckArr.length; i++) {
					if (this.foodTruckArr[i].getRating() > truckToPrint.getRating()) {
						truckToPrint = this.foodTruckArr[i];
					}
				}
			}
			System.out.println("The highest-rated food truck on file is: ");
			System.out.println(truckToPrint);
		}

	}

	private void printMenu() {
		// This displays all the options requested in user story #3.
		String endLine = "===============================================\n";
		System.out.println(endLine);
		System.out.print("Now, would you like to: \n");
		System.out.println("1. Print out a list of all existing food trucks");
		System.out.println("2. See the average rating of all food trucks");
		System.out.println("3. See the highest-rated food truck");
		System.out.println("4. Quit this program\n");
		System.out.println(endLine);
	}

	private void displayFoodTrucks() {
		for (FoodTruck i : this.foodTruckArr) {
			System.out.println(i);
		}
	}

	private FoodTruck[] enterFoodTrucks(java.util.Scanner kb) {
		// This method covers user story 1. Gets user input for fields,
		// and unless stopped by giving "quit" as the name constructs a new FoodTruck
		// instance for each truck entered, to a maximum of 5. Per requirements
		// the uniqueId field is supplied by a static field in FoodTruck rather
		// than any input here.
		String truckName;
		String truckCuisine;
		double truckRating;
		FoodTruck[] trucksIn = new FoodTruck[5];

		for (int i = 0; i < 5; i++) {
			System.out.printf("Enter the name of truck #%d: ", FoodTruck.foodTrucksEntered + 1);
			truckName = kb.nextLine();
			// This handles user story 2. the "quit" string, and only the "quit"
			// string, will stop input before five trucks have been added.
			if (!truckName.equals("quit")) {
				System.out.printf("What sort of food does %s serve? ", truckName);
				truckCuisine = kb.nextLine();
				System.out.print("Please enter this truck's numerical rating: ");
				truckRating = kb.nextDouble();
				kb.nextLine(); // needed to fix weird scanner behavior with numbers
				trucksIn[i] = new FoodTruck(FoodTruck.foodTrucksEntered, truckName, truckCuisine, truckRating);
			} else {
				break;
			}
		}
		// trimming to length
		FoodTruck[] trucksOut = new FoodTruck[FoodTruck.foodTrucksEntered];
		for (int i = 0; i < FoodTruck.foodTrucksEntered; i++) {
			trucksOut[i] = trucksIn[i];
		}
		trucksIn = null;
		return trucksOut;

	}

}
