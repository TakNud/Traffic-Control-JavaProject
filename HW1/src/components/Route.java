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
		/*
		// create roads for the junction
		for (int i=0;i<juncs.size()-1;i++) {// runnig of all juncs
			for (int j=0; j<juncs.get(i).getExitingRoads().size()-1;j++) {// runnig for all exitingRoad of this junc
				//if (juncs.get(i).getExitingRoads().get(j).getToJucn()==juncs.get(i+1)&& !roads.contains(juncs.get(i).getExitingRoads().get(j))) {//check if not exist on list and if the road true
				int rand= new Random().nextInt(juncs.get(i).getExitingRoads().size())-1;
				if (rand>-1) {
					if (!roads.contains(juncs.get(i).getExitingRoads().get(rand)))
						this.roads.add(juncs.get(i).getExitingRoads().get(rand));
				}
			}
		}
			*/
		/*
		this.roads= new ArrayList <Road>();
		if (juncs.get(0).getExitingRoads().get(0)!=null)
			this.roads.add(juncs.get(0).getExitingRoads().get(0));
		Random rand= new Random();
		int randFor= rand.nextInt(getRoads.size());
		for (int i=0;i<randFor;i++) {
			int randRoad= rand.nextInt(getRoads.size()-1);
			if (randRoad>-1) {
				if (!this.roads.contains(getRoads.get(randRoad))) {
					this.roads.add(getRoads.get(randRoad));
				}
			}
		}
		*/
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
		for ( int i=0;i<this.junctions.size();i++) {
			sum+= this.junctions.get(i).getDelay();
			//Check min Speed
			if (this.vehicleType.getSpeed()<this.roads.get(i).getMaxSpeed()) {
				distanceT += this.roads.get(i).countLength()/this.roads.get(i).getMaxSpeed(); //Calc time by diving len in maxSpeed
			}
			else
				distanceT += this.roads.get(i).countLength()/this.vehicleType.getSpeed();
		}
		this.delay= sum+distanceT;
		System.out.println(this.delay);
	}
	public String toString() {
		return "route from- "+this.getStart()+" to -> "+this.getEnd();
	}
}
