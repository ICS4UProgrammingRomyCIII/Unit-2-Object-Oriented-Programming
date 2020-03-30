/*
 * Created by: Romy I. Chu III
 * Created on: 24-March-2020
 * Created for: ICS4U
 * Day #23 (Polymorphism)
 * This program ... Inherits from the vehicle class and creates bikes and trucks but the subclasses have an override function.
*/

import java.util.*;
public class Day23_Polymorphism {
	// Variables.
	static int bikeID = 1;
	static int truckID = 1;
	
	//Objects.
	public static Scanner in = new Scanner(System.in);
	static List<String> out = new ArrayList<String>();
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("Add a Vehicle? [y/N]");
			String addNew = in.nextLine().toUpperCase(); // Get the letter.
			
			if(addNew.equals("Y")) { 			// If the letter is Y...
				System.out.println("Bike or Truck? [B/t]");
				String bOrT = in.nextLine().toUpperCase(); // Get the letter.
				
				if(bOrT.equals("B")) { CreateBike(); bikeID++; }
				else if(bOrT.equals("T")) { CreateTruck(); truckID++; }
			} else { 						// Otherwise...
				System.out.println("Print all info? [y/N]");// Ask if the user wants to print all of the info
				String pAll = in.nextLine().toUpperCase();	// Get the letter.
				if (pAll.equals("Y")) { for(String s : out) { System.out.println(s); } }
				break;
			}
		}
	}
	
	static void CreateBike() {
		boolean speedCheck = true;
		String bColour;
		int numW = 0;
		int numS = 0;
		int curS = 0;
		int maxS = 0;
		
		System.out.println();
		System.out.println();
		
		System.out.println("Bike Colour?");
		bColour = in.nextLine();
		
		while(numW <= 0) {
			try { 
				System.out.println("How many wheels does your bike have?");
				numW = Integer.parseInt(in.nextLine());
			} catch(Exception exc) { System.out.println("Please input INTEGERS ONLY!"); }
		}
		
		while(numS <= 0) {
			try {
				System.out.println("How many seats does your bike have?");
				numS = Integer.parseInt(in.nextLine());
			} catch(Exception exc) { System.out.println("Please input INTEGERS ONLY!"); }
		}
		
		while(speedCheck) {
			try { 
				System.out.println("How fast is the bike going right now?");
				curS = Integer.parseInt(in.nextLine());
				speedCheck = false;
			} catch(Exception exc) { System.out.println("Please input INTEGERS ONLY!"); }
		}
		
		speedCheck = true;
		while(speedCheck) {
			try {
				System.out.println("What is the bike's max speed?");
				maxS = Integer.parseInt(in.nextLine());
				speedCheck = false;
			} catch(Exception exc) { System.out.println("Please input INTEGERS ONLY!"); }
		}
		
		System.out.println();
		System.out.println();
		
		Bike bk = new Bike(bColour, numW, numS, curS, maxS, bikeID);
	}
	static void CreateTruck() {
		boolean speedCheck = true;
		String truckLP = null;
		String tColour;
		int numD = 0, numW = 0, len = 0, curS = 0, maxS = 0;
		
		System.out.println();
		System.out.println();
		
		System.out.println("Truck Colour?");
		tColour = in.nextLine();
		
		while(numD <= 0) {
			try { 
				System.out.println("How many doors does your truck have?");
				numD = Integer.parseInt(in.nextLine());
			} catch(Exception exc) { System.out.println("Please input INTEGERS ONLY!"); }
		}
		
		while(numW <= 0) {
			try {
				System.out.println("How many wheels does your truck have?");
				numW = Integer.parseInt(in.nextLine());
			} catch(Exception exc) { System.out.println("Please input INTEGERS ONLY!"); }
		}
		
		while(len <= 0) {
			try {
				System.out.println("What is your truck's length?");
				len = Integer.parseInt(in.nextLine());
			} catch(Exception exc) { System.out.println("Please input INTEGERS ONLY!"); }
		}
		
		while(speedCheck) {
			try { 
				System.out.println("How fast is the truck going right now?");
				curS = Integer.parseInt(in.nextLine());
				speedCheck = false;
			} catch(Exception exc) { System.out.println("Please input INTEGERS ONLY!"); }
		}
		
		speedCheck = true;
		while(speedCheck) {
			try {
				System.out.println("What is the truck's max speed?");
				maxS = Integer.parseInt(in.nextLine());
				speedCheck = false;
			} catch(Exception exc) { System.out.println("Please input INTEGERS ONLY!"); }
		}
		
		System.out.println();
		System.out.println();
		
		Truck tr = new Truck(truckLP, tColour, numD, numW, len, curS, maxS, truckID);
	}
	
}

class Bike extends Vehicle {
	Bike(String color, int numWheels, int numSeats, int cSpeed, int sMax, int id) {			
		super.vehicleColor = color;
		super.wheels = numWheels;
		super.seats = numSeats;
		super.currentSpeed = cSpeed;
		super.maxSpeed = sMax;
		FillVehicleInfo(id);
	}
	@Override
	public void FillVehicleInfo(int bikeID) {
		String outTemp = String.format("Bike #%d : ", bikeID) + "\n"
				+ "Bike Colour : " + vehicleColor + "\n"
				+ "Number of wheels : " + wheels + "\n"
				+ "Number of seats : " + seats + "\n"
				+ "Current Speed : " + currentSpeed + "\n"
				+ "Max Speed : " + maxSpeed + "\n\n";
		Day23_Polymorphism.out.add(outTemp);
	}
}

class Truck extends Vehicle {
	Truck(String lP, String c, int numD, int numW, int len,int cSpeed, int sMax, int id) {			
		super.licensePlateNumber = lP;
		super.vehicleColor = c;
		super.numDoors = numD;
		super.wheels = numW;
		super.length = len;
		super.currentSpeed = cSpeed;
		super.maxSpeed = sMax;
		FillVehicleInfo(id);
	}
	
	@Override
	public void FillVehicleInfo(int truckID) {
		String outTemp = String.format("Truck #%d : ", truckID) + "\n"
				+ "Truck License Plate : " + licensePlateNumber + "\n"
				+ "Truck Colour : " + vehicleColor + "\n"
				+ "Number of Doors : " + numDoors + "\n"
				+ "Number of Wheels : " + wheels + "\n"
				+ "Length : " + length + "\n"
				+ "Current Speed : " + currentSpeed + "\n"
				+ "Max Speed : " + maxSpeed + "\n\n";
		Day23_Polymorphism.out.add(outTemp);
	}
}