package game;

import java.util.ArrayList;

import components.Junction;
import components.Map;
import components.Road;
import components.Route;
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
		for (int i=0;i<vehicles;i++) {//create Vehicles
		addVehicles();
		addRoute4Vehicle(currentVehicles.get(i),map.getJunctions(),map.getRoads());
		}
		/* CHcking the Routes- not need anymore;
		for (int i=0; i<currentVehicles.size();i++) {
			System.out.println(currentVehicles.get(i).getCurrentRoute());
		}
		*/
		
		this.maxTime= maxTime;
	}
	public void addRoute4Vehicle(Vehicle v, ArrayList<Junction> juncs, ArrayList<Road> roads) {
		//create list of junction with lastJunction:
		ArrayList<Junction> listJunc= new ArrayList<Junction>();
		ArrayList<Road> listRoad= new ArrayList<Road>();
		listJunc.add(v.getLastJunction());// add The first junction
		Random random= new Random();
		int randFor= random.nextInt(juncs.size()-2)+2;// random num for junction for route
		for (int i=0 ; i<randFor ; i++) {
			int randJunction= random.nextInt(juncs.size());
			if (!listJunc.contains(juncs.get(randJunction))) {// add junction to list if not exist
				listJunc.add(juncs.get(randJunction));
			}
		}
		for (int i=0 ; i<randFor ; i++) {
			int randRoad= random.nextInt(roads.size());
			if (!listRoad.contains(juncs.get(randRoad))) {// add junction to list if not exist
				listRoad.add(roads.get(randRoad));
			}
		}
		Route route = new Route (listJunc,listRoad,v.getVehicleType());
		v.setRoute(route);
		
	}
	
	public void addMap() {
		int numOfJunc= new Random().nextInt(10)+15;
		int numOfRoad= new Random().nextInt(10)+15;
		Map map= new Map(numOfJunc,numOfRoad);
		//this.currentMap= map;
		
	}
	public void addVehicles() {
		//for ( int i=0; i<new Random().nextInt(6)+2;i++ ) {
			int rand= new Random().nextInt(this.currentMap.getJunctions().size());
			Vehicle vehicle= new Vehicle(numOfVehicles,VehicleType.getRandomVehicleTypes(),this.currentMap.getJunctions().get(rand));
			numOfVehicles++;
			this.currentVehicles.add(vehicle);
		//}
	}
	public ArrayList<Vehicle> getVehicles(){
		return this.currentVehicles;
	}
	public void startDrive (int maxTime) {
		for (int i=0; i<maxTime ;i++) {// runnig maxTime= Rounds! 
			System.out.println("Trun-> *"+i+"*");
			for (int j=0; j<this.numOfVehicles;j++) {// runnig for all vehicles
				System.out.println(this.getVehicles().get(j)+" is starting "+this.getVehicles().get(j).getCurrentRoute());// Print START Route
				if (this.getVehicles().get(j).getLastJunction().getHasLight() && !this.getVehicles().get(j).getCurrentRoute().getCurrentRoad().getIsOpen()) {// check if have light & have red light
					System.out.println(this.getVehicles().get(j)+" is waiting for green light in"+this.getVehicles().get(j).getLastJunction());
				}
				else {
					System.out.println(this.getVehicles().get(j)+" has left "+this.getVehicles().get(j).getLastJunction());
					this.getVehicles().get(j).move();
				}
					
			}
			
			}
		}


}
