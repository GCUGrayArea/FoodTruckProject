package com.skilldistillery.foodtruckproject;

public class FoodTruck {
	//Only static field needed, provides uniqueId values and makes it easy to
	//trim the array of FoodTruck's to length. Part of user story #1.
	//Left public so it can be used for convenience in FoodTruckProject.
	public static int foodTrucksEntered;

	// all instance-specific so these shouldn't be static even if it were allowed
	private final int uniqueId; //only field that needs to be final
	private String name;
	private String cuisine;
	private double rating;
	
	static {		
		foodTrucksEntered = 0;
	}
	

	public FoodTruck(int uniqueId, String name, String cuisine, double rating) {
		this.uniqueId = foodTrucksEntered;
		this.name = name;
		this.cuisine = cuisine;
		this.rating = rating;
		foodTrucksEntered++;
		//incrementing each time the constructor is called guarantees non-duplication
	}
	
	//no real *need* to use getters and setters  this, but can't let folk think I haven't been paying attention
	
	public int getUniqueId() {
		return uniqueId;
	}
	//no set method for getUniqueId as it's provided by another field and
	//initialized as final anyway
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCuisine() {
		return cuisine;
	}
	
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "FoodTruck [uniqueId=" + getUniqueId() + ", name=" + getName() + ", rating=" + getRating() + "]";
	}
	
	
}
