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
		this.maxTime= maxTime;
	}
	public void addRoute4Vehicle(Vehicle v, ArrayList<Junction> juncs, ArrayList<Road> roads) {
		//create list of junction with lastJunction:
		ArrayList<Junction> listJunc= new ArrayList<Junction>();
		ArrayList<Road> listRoad= new ArrayList<Road>();
		listJunc.add(v.getLastJunction());// add The first junction
		if (listJunc.get(0).getExitingRoads().isEmpty()==false){
			v.setLastRoad(listJunc.get(0).getExitingRoads().get(0));
		}
		boolean flag=false; // flag to know if ExitRoad is empty
		if (listJunc.get(0).getExitingRoads().isEmpty()==false){
			listRoad.add(listJunc.get(0).getExitingRoads().get(0));// add the first road
			flag=true;
		}
		int index=0;
		if (flag== true) {
			do {
				if (listJunc.get(index)!=listRoad.get(index).getToJucn()) {
					listJunc.add(listRoad.get(index).getToJucn());
					index++;
					if (!listJunc.get(index).getExitingRoads().isEmpty())
						listRoad.add(listJunc.get(index).getExitingRoads().get(0));
					else
						flag=false;
				}
			}while((!listJunc.get(index).getExitingRoads().isEmpty() && listJunc.size()<10) && flag==true ) ;// loop for add 10 juncs or arrive to no exit road.
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
			for (int j=0; j<this.getVehicles().size();j++) {// runnig for all vehicles
				System.out.println(this.getVehicles().get(j)+" is starting "+this.getVehicles().get(j).getCurrentRoute());// Print START Route
				if ( !this.getVehicles().get(j).getLastRoad().getIsOpen()) {// check if have light & have red light
					System.out.println(this.getVehicles().get(j)+" is waiting for green light in"+this.getVehicles().get(j).getLastJunction());
				}
				else {// THE MOVE step
					System.out.println(this.getVehicles().get(j)+" has left "+this.getVehicles().get(j).getLastJunction());
					this.getVehicles().get(j).move();
					if (this.getVehicles().get(j).getLastJunction()==this.getVehicles().get(j).getCurrentRoute().getEnd()) {
						System.out.println(this.getVehicles().get(j)+" is Arrive to DST-->"+ this.getVehicles().get(j).getCurrentRoute().getEnd());
						this.getVehicles().get(j).getCurrentRoute().calcDelay();
						System.out.println(this.getVehicles().get(j)+ " has finished the route. Total time is: "+this.getVehicles().get(j).getCurrentRoute().getDelay());
						this.getVehicles().remove(j);
					}
				}		
			}
			for (int j=0; j<this.getVehicles().size();j++) {// runnig for all vehicles
				if (this.getVehicles().get(j).getLastJunction().getHasLight() ) {
					this.getVehicles().get(j).getLastJunction().changeLight();
					}
			}
		}

	}
}
