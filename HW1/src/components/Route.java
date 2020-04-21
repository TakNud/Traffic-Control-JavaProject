package components;

import java.util.ArrayList;
//import java.util.Collection;
import java.math.*;
import java.util.Random;
public class Route {
	
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private double delay;
	private VehicleType vehicleType;
	
	//def Con obj=NULL:
	//public Route () {
		//this.junctions=null;
		//this.roads=null;
		//this.vehicleType=null;
		
	//}
	public Route (ArrayList<Junction> juncs, ArrayList<Road> getRoads, VehicleType vehType) {
		
		this.roads=getRoads;
		this.junctions=juncs;
		this.vehicleType=vehType;
				
	}
	public Route(Junction start, Junction end, String vehType) {
		
	}
	//Getters && Setters
	public ArrayList<Junction> getJunctions() {
		return this.junctions;
	}
	public double getDelay() {
		return this.delay;
	}
	// return the point start route- Start Junc
	public Junction getStart() {
		return this.junctions.get(0);
	}
	//Return The end junction of route
	public Junction getEnd() {
		return this.junctions.get(this.junctions.size()-1);
	}
	public Road getCurrentRoad() {
		return this.roads.get(0);
	}
	public ArrayList <Road> getRoads(){
		return this.roads;
	}
	public void calcDelay() {
		double distanceT = 0,time;
		int  sum=0;
		int minSpeed;
		int i=0;
		while (i<this.junctions.size()&&this.junctions.get(i)!= this.getCurrentRoad().getFromJunc() ) {
			sum+= this.junctions.get(i).getDelay();
			//Check min Speed
			if (this.vehicleType.getSpeed()<this.roads.get(i).getMaxSpeed()) {
				distanceT += this.roads.get(i).getLength()/this.roads.get(i).getMaxSpeed(); //Calc time by diving len in maxSpeed
			}
			else
				distanceT += this.roads.get(i).getLength()/this.vehicleType.getSpeed();
			i++;
		}
		
		/*
		for ( int i=0;i<this.junctions.size();i++) {
			sum+= this.junctions.get(i).getDelay();
			//Check min Speed
			if (this.vehicleType.getSpeed()<this.roads.get(i).getMaxSpeed()) {
				distanceT += this.roads.get(i).getLength()/this.roads.get(i).getMaxSpeed(); //Calc time by diving len in maxSpeed
			}
			else
				distanceT += this.roads.get(i).getLength()/this.vehicleType.getSpeed();
		}
		*/
		this.delay= sum+distanceT;
	}
	public String toString() {
		return "route from- "+this.getStart()+" to -> "+this.getEnd();
	}
}
