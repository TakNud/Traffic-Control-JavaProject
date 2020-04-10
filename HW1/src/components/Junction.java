package components;

import java.util.ArrayList;
import java.util.Random;
//import com.sun.tools.javac.util.List;

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
		this.hasLights= new Random().nextBoolean();
		enetringRoads= new ArrayList<Road>();
		exitingRoads=new ArrayList<Road>();
		//System.out.
	}
	//
	public void changeLight() {
		if (hasLights) {
			for ( int i=0; i< this.enetringRoads.size();i++) {
				this.enetringRoads.get(i).setIsOpen(false);
			}
			this.enetringRoads.get(1).setIsOpen(true);
		}
		else 
			System.out.println("Junction"+this.junctionName+": no entering road. traffic lights cant be turn on!");
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
	////SETters--&&--GETters
	// return list of exiting road
	public ArrayList<Road> getExitingRoads() {
		return this.exitingRoads;
	}
	public ArrayList<Road> getEnteringRoads(){
		return this.enetringRoads;
	}
	public void setExitingRoads(Road e) {
		exitingRoads.add(e);
	}
	
	public void setEnteringRoads(Road e){
		enetringRoads.add(e);
	}
	public String getNameJunc() {
		return this.junctionName;
	}
	//FIXED!!!
	public void setLightsOn() {
		//this.hasLights=true;
		this.delay=(int) (new Random().nextInt(10));
		System.out.println("Junction"+this.getNameJunc()+
				": traffic ligth ON. Delay time is :"+this.delay);
		for (int i = 0 ; i<enetringRoads.size();i++) {
			this.enetringRoads.get(i).setIsOpen(true);
			}
		}
	
	public Point getLocation(){
		return location;
		
	}
	public String toString() {
		String jun= "Junction-"+ this.junctionName;
		return jun;
	}
	
}

