/*
 * Created by: Romy I. Chu III
 * Created on: 12-March-2019
 * Created for: ICS4U
 * Day #20 (Vehicle Class)
 * This program... Has a vehicle class that allows the user to create a car with specific properties,
*/

import java.util.*;

public class Vehicle_Program {
	// Objects
	static Scanner sc = new Scanner(System.in); // To read the user's input from the console. 
	static Vehicle vehicle = new Vehicle(); 	 // New object for the Vehicle Class
	
	static // Variables
	int numCar = 1;
	static boolean firstTime = true;
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("Add a Vehicle? y/N");
			String addNew = sc.nextLine().toUpperCase(); // Get the letter.
			
			if(addNew.equals("Y")) { 			// If the letter is Y...
				CreateVehicle();	// Call CreateVehicle.
			} else { 						// Otherwise...
				System.out.println("Print all info? y/N");// Ask if the user wants to print all of the info
				String pAll = sc.nextLine();	// Get the letter.
				pAll.toUpperCase();				// Change it to upper case.
				if (pAll.equals("Y")) { for(String s : vehicle.out) { System.out.println(s); } }
				break;
			}
		}
	}
	
	static void CreateVehicle() {
		// Gets the car's license plate from the user.
		System.out.println("License Plate Number : ");
		vehicle.licensePlateNumber = sc.nextLine();
		
		// Gets the car's colour from the user.
		System.out.println("Car's Colour : ");
		vehicle.vehicleColor = sc.nextLine();
		
		// This try catch will ensure that the user only inputs an integer.
		while(vehicle.numDoors == 0) {
			System.out.println("Number of Doors : ");							  // Gets the number of car doors from the user.
			try {vehicle.numDoors = Integer.parseInt(sc.nextLine()); }  		  // Parse it as an integer.
			catch(Exception e) {System.out.println("Please enter an integer."); } // If the user didn't input and integer, tell them to enter a new one.
		}
		
		for (int i = 0; i < 10; i++ ) {
			System.out.println("Accelerate (A) or Brake (B)?");
			String letter = sc.nextLine();	// Get the letter.
			letter.toUpperCase();			// Change it to upper case.
			// Check Whether or not the user inputed a valid letter.
			while(letter.equals("A") == false && letter.equals("B") == false ) {
				System.out.println("ONLY enter A or B, to accelerate or brake!! "); // Tell the user that they did not input a valid character.S
				letter = sc.nextLine();		// Get the letter.
				letter.toUpperCase();		// Change it to upper case.
			}
			if(letter.equals("A")) 		// If the letter is A...
				Vehicle.Accelerate();	// Call accelerate
			else 						// Otherwise...
				Vehicle.Brake();		// Call Brake.
		}
		System.out.println();	// Print a blank line
		vehicle.FillAddCar(numCar);
		numCar++; // Increment the numCar
	}
}
