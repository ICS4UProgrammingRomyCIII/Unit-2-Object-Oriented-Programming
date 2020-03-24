/*
 * Created by: Romy I. Chu III
 * Created on: 12-March-2020
 * Created for: ICS4U
 * Day #20 (Vehicle Class)
 * This program ... Has a vehicle class that allows the user to create a car with specific properties.
*/
import java.util.ArrayList;
public class Vehicle {
	// Variables
	public String licensePlateNumber; // This is a public variable for the vehicle's license plate
	public String vehicleColor;		  // This is a public variable for the vehicle's colour.
	public int numDoors;			  // This is a public variable for the number of doors.
	
	private static int currentSpeed = 0;	// A private variable for the vehicles current speed.
	private static int maxSpeed = 0;		// A private variable for the vehicles max speed.
	public static ArrayList<String> out = new ArrayList<>();
	
	public int GetCurrentSpeed() {return currentSpeed;}		// A public method to get the current speed.
	public int getMaxSpeed() {return maxSpeed;}				// A public method to get the max speed.
	
	static protected void Accelerate() { currentSpeed += 10; maxSpeed += 10; }	// A protected method tp accelerate the car.
	static protected void Brake() {												// A private method to brake the car.
		if (currentSpeed > 0) { currentSpeed -= 5;}								// If the current speed is greater than 0, decrease the speed by 5.			
	}
	public void FillAddCar(int numCar) {
		// Adds all of the information the list of information.
		String outTemp = String.format("Vehicle #%d : ", numCar) + "\n"
						+ "License Plate : " + licensePlateNumber + "\n"
						+ "Car Colour : " + vehicleColor + "\n"
						+ "Number of Doors : " + numDoors + "\n"
						+ "Current Speed : " + currentSpeed + "\n"
						+ "Max Speed : " + maxSpeed + "\n\n";
		out.add(outTemp);
		
		// Resets all of the variables
		licensePlateNumber = null;
		vehicleColor = null;
		numDoors = 0;
		currentSpeed = 0;
		maxSpeed = 0;
	}
}
