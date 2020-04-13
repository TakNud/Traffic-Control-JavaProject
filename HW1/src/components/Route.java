package components;

import java.util.ArrayList;

public class Route {
	
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private double delay;
	private VehicleType vehicleType;
	
	public Route (ArrayList<Junction> juncs, ArrayList<Road> roads, VehicleType vehType) {
		this.junctions=juncs;
		this.roads= roads;
		this.vehicleType=vehType;
	}
	//Getters && Setters
	public ArrayList<Junction> getJunctions() {
		return this.junctions;
	}

	// return the point start route- Start Junc
	public Junction getStart() {
		return this.junctions.get(0);
	}
	//Return The end junction of route
	public Junction getEnd() {
		return this.junctions.get(this.junctions.size()-1);
	}
	public void calcDelay() {
		double sum=0,distance;
		for ( int i=0;i<this.junctions.size();i++) {
			sum+= this.junctions.get(i).getDelay();
			distance += this.roads.get(i).countLength();
		}
		
		this.delay= 
	}
}
