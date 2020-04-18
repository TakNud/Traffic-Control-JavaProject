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
	public Junction () {
	}
	public Junction(String name, Point loc) {
		this.junctionName=name;
		this.location=loc;
		this.hasLights= new Random().nextBoolean();
		if (hasLights)
			this.delay= new Random().nextInt(10);
		enetringRoads= new ArrayList<Road>();
		exitingRoads=new ArrayList<Road>();
		System.out.println("Junction:->"+this.junctionName+" has been created");
		
	}
	//
	public void changeLight() {
		if (hasLights) {
			System.out.println("Junction"+this.getNameJunc()+
					": traffic ligth ON. Delay time is :"+this.delay);
			for ( int i=0; i< this.exitingRoads.size();i++) {
				this.exitingRoads.get(i).setIsOpen(false);
				//System.out.println(this.exitingRoads.get(i).toString()+this.exitingRoads.get(i).getIsOpen());
			}
			int index= new Random().nextInt(this.exitingRoads.size());
			if (index>this.exitingRoads.size()-1) {
				index-=1;
			}
			this.exitingRoads.get(index).setIsOpen(true);
		}
		else 
			System.out.println("Junction"+this.junctionName+": no entering road. traffic lights cant be turn on!");
	}
		//check if this road exist in this junction
	public boolean checkAvailability(Road r) {
		//if (r.getFromJunc()==this) {
			for (int i=0;i<this.exitingRoads.size();i++) {
				if (r.getFromJunc()==this.exitingRoads.get(i).getFromJunc())
					return true;
			//}
			
		} 
		return false;
	
	}
	// check equals between 2 junction Objs 
	public boolean equals(Junction other) {
		 if (junctionName== other.junctionName) {
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
		this.exitingRoads.add(e);
	}
	
	public void setEnteringRoads(Road e){
		this.enetringRoads.add(e);
	}
	public String getNameJunc() {
		return this.junctionName;
	}
	public int getDelay() {
		return this.delay;
	}
	//FIXED!!!
	public boolean getHasLight() {
		return this.hasLights;
	}
	public Point getLocation(){
		return location;	
	}
	public String toString() {
		String jun= "Junction-"+ this.junctionName;
		return jun;
	}
	//Not need anyMore:
	public void setLightsOn() {
		//this.hasLights=true;
		this.delay=(new Random().nextInt(10));
		System.out.println("Junction"+this.getNameJunc()+
				": traffic ligth ON. Delay time is :"+this.delay);
			this.hasLights=true;
			//int index= Integer.parseInt(junctionName);
			this.exitingRoads.get(exitingRoads.size()).setIsOpen(true);
		}
	
}

