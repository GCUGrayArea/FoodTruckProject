package com.skilldistillery.foodtruckproject;

public class FoodTruckProject {

	public static void main(String[] args) {
		
		java.util.Scanner kb = new java.util.Scanner( System.in );
		
		FoodTruckProject trucks = new FoodTruckProject();
		FoodTruck[] foodTruckArr= trucks.enterFoodTrucks( kb );
		
		
		kb.close();
	}
	
	private void printMenu() {
		String endLine = "===============================================\n";
		System.out.println(endLine);
		System.out.print("Now, would you like to: ");
		System.out.println("1. Print out a list of all existing food trucks");
		System.out.println("2. See the average rating of all food trucks");
		System.out.println("3. See the highest-rated food truck");
		System.out.println("4. Quit this program\n");
		System.out.println(endLine);
	}
	
	private void displayFoodTrucks(FoodTruck[] foodTruckArr) {
		for ( FoodTruck i : foodTruckArr ) {
			System.out.println( i );
		}
	}

	private FoodTruck[] enterFoodTrucks( java.util.Scanner kb ) {
		//This method covers user story 1.  Gets user input for fields,
		//and unless stopped by giving "quit" as the name constructs a new FoodTruck
		//instance for each truck entered, to a maximum of 5. Per requirements
		//the uniqueId field is supplied by a static field in FoodTruck rather
		//than any input here.
		String truckName;
		String truckCuisine;
		double truckRating;
		FoodTruck [ ] trucksIn = new FoodTruck[5];

		for( int i = 0; i < 5; i++) {
			System.out.printf(
					"Enter the name of truck #%d: " ,
					FoodTruck.foodTrucksEntered + 1 );
			truckName = kb.nextLine();
			//This handles user story 2. the "quit" string, and only the "quit"
			//string, will stop input before five trucks have been added.
			if ( !truckName.equals( "quit" ) ) {
				System.out.printf(
						"What sort of food does %s serve? " ,
						truckName );
				truckCuisine = kb.nextLine();
				System.out.print( "Please enter this truck's numerical rating: " );
				truckRating = kb.nextDouble();
				kb.nextLine(); //needed to fix weird scanner behavior with numbers
				trucksIn[ i ] = new FoodTruck( 
						FoodTruck.foodTrucksEntered, truckName, truckCuisine, truckRating );
			} else {
				break;
			}
		}
		//trimming to length
		FoodTruck [ ] trucksOut = new FoodTruck [ FoodTruck.foodTrucksEntered ];
		for( int i = 0; i < FoodTruck.foodTrucksEntered ; i++ ) {
			trucksOut[ i ] = trucksIn [ i ];
		}
		trucksIn = null; 
		return trucksOut;

	}

}
