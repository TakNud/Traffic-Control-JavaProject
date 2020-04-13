package game;

import java.util.ArrayList;

import components.Map;
import components.Vehicle;
import components.VehicleType;
import java.util.Random;
public class Driving {
	private int numOfJuncs;
	private int numOfVehicles;
	private Map currentMap;
	private ArrayList<Vehicle> currentVehicles;
	private double drivingTime;
	private int maxTime;
	
	public Driving(int juncs, int vehicles, int maxTime) {
		Map map= new Map(juncs,juncs);
		this.currentMap=map;
		currentVehicles= new ArrayList<Vehicle>();
		numOfVehicles=0;
		addVehicles();
		this.maxTime= maxTime;
	}
	
	public void addMap() {
		
	}
	public void addVehicles() {
		
		for ( int i=0; i<new Random().nextInt(6)+2;i++ ) {
			int rand= new Random().nextInt(this.currentMap.getJunctions().size());
			Vehicle vehicle= new Vehicle(numOfVehicles,VehicleType.getRandomVehicleTypes(),this.currentMap.getJunctions().get(rand));
			numOfVehicles++;
			this.currentVehicles.add(vehicle);
		}
	}
	public ArrayList<Vehicle> getVehicles(){
		return this.currentVehicles;
	}
	public void startDrive (int maxTime) {
		
	}


}
