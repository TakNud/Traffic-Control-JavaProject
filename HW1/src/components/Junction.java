package components;

import java.util.ArrayList;

import utilities.Point;

public class Junction {
	private String junctionName;
	private Point location;
	private ArrayList<Road> enetringRoads;
	private ArrayList<Road> exitingRoads;
	private boolean hasLights;
	private int delay;
	private ArrayList<Road> vehicles;
	
	//Constructor
	public Junction(String name, Point loc) {
		this.junctionName=name;
		this.location=loc;
	}
	//
	public void changeLight() {
		for ( int i=0; i< this.enetringRoads.size();i++) {
			this.enetringRoads.get(i).setIsOpen(false);
		}
		this.enetringRoads.get(2).setIsOpen(true);
	}
	public void checkAvailability(Road r) {
	
	}
	// check equals between 2 junction Objs 
	public boolean equals(Junction other) {
		 if (this.delay==other.delay && this.hasLights== other.hasLights
				&& this.junctionName== other.junctionName) {
			 return true;
		 }
		 else
			 return false;
	}
	// return list of exiting road
	public ArrayList<Road> getExitingRoads() {
		return this.enetringRoads;
	}
	
	public ArrayList<Road> getEnteringRoads(){
		return this.enetringRoads;
	}
	//פונקציה שהסתומה רשמה לעשות בדוגמת הרצה - לא יודע אם אני צריך לפנות למקום הראשון ברשימה
	public void setLightsOn() {
		if (this.hasLights) {
			this.enetringRoads.get(1).setIsOpen(true);
		}
	}
}

