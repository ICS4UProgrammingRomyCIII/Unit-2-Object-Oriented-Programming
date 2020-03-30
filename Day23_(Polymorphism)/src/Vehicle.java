/*
 * Created by: Romy I. Chu III
 * Created on: 24-March-2020
 * Created for: ICS4U
 * Day #23 (Polymorphism)
 * This program ... Inherits from the vehicle class and creates bikes and trucks but the subclasses have an override function.
*/

import java.util.ArrayList;
public class Vehicle {
	// Variables
	String licensePlateNumber; // This is a public variable for the vehicle's license plate
	String vehicleColor;		  // This is a public variable for the vehicle's colour.
	int numDoors;			  // This is a public variable for the number of doors.
	// Default Values
	int seats;
	int wheels;
	int length;
	
	static int currentSpeed = 0;	// A private variable for the vehicles current speed.
	static int maxSpeed = 0;		// A private variable for the vehicles max speed.
	public ArrayList<String> out = new ArrayList<>();
	
	public int GetCurrentSpeed() {return currentSpeed;}		// A public method to get the current speed.
	public int getMaxSpeed() {return maxSpeed;}				// A public method to get the max speed.
	
	static protected void Accelerate() { currentSpeed += 10; maxSpeed += 10; }	// A protected method tp accelerate the car.
	static protected void Brake() {												// A private method to brake the car.
		if (currentSpeed > 0) { currentSpeed -= 5;}								// If the current speed is greater than 0, decrease the speed by 5.			
	}
	public void FillVehicleInfo(int numCar) {
		// Adds all of the information the list of information.
		String outTemp = String.format("Vehicle #%d : ", numCar) + "\n"
						+ "License Plate : " + licensePlateNumber + "\n"
						+ "Car Colour : " + vehicleColor + "\n"
						+ "Number of Doors : " + numDoors + "\n"
						+ "Current Speed : " + currentSpeed + "\n"
						+ "Max Speed : " + maxSpeed + "\n\n";
		out.add(outTemp);
		ClearValues();
	}
	
	public void PrintInfo() {
		for(String s : out) { System.out.println(s); System.out.println(); }
	}
	public void ClearValues() {
		// Resets all of the variables
		licensePlateNumber = null;
		vehicleColor = null;
		seats = 0;
		wheels = 0;
		length = 0;
		numDoors = 0;
		currentSpeed = 0;
		maxSpeed = 0;
	}
}