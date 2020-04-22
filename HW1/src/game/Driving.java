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
		Random rand= new Random();
		listJunc.add(v.getLastJunction());// add The first junction
		if (listJunc.get(0).getExitingRoads().isEmpty()==false){
			//v.setLastRoad(listJunc.get(0).getExitingRoads().get(0));
		}
		boolean flag=false; // flag to know if ExitRoad is empty
		if (listJunc.get(0).getExitingRoads().isEmpty()==false){
			listRoad.add(listJunc.get(0).getExitingRoads().get(rand.nextInt(9)));// add the first road
			flag=true;
		}
		int index=0;
		if (flag== true) {
			do {
				int count=0;
				int junc=rand.nextInt(9);
				for (int i=0; i<listJunc.size();i++) {
					if (listJunc.get(index).getExitingRoads().get(junc).getToJucn()!= listJunc.get(i)) {
						count++;
					}
				}
					if (count==listJunc.size()) {
						listJunc.add(listRoad.get(index).getToJucn());
						index++;
				 }
					if (!listJunc.get(index).getExitingRoads().isEmpty())
						listRoad.add(listJunc.get(index).getExitingRoads().get(junc));
					else
						flag=false;
				
				//index++;
			}while((!listJunc.get(index).getExitingRoads().isEmpty() && listRoad.size()<10) && flag==true ) ;// loop for add 10 juncs or arrive to no exit road.
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
			int rand2= (int) (Math.random()*this.currentMap.getJunctions().get(rand).getEnteringRoads().size());
			vehicle.setLastRoad(this.currentMap.getJunctions().get(rand).getEnteringRoads().get(rand2));
			this.currentVehicles.add(vehicle);
			//this.currentVehicles.get().
		//}
	}
	public ArrayList<Vehicle> getVehicles(){
		return this.currentVehicles;
	}
	public void startDrive (int maxTime) {
		for (int i=0; i<maxTime ;i++) {// runnig maxTime= Rounds! 
			System.out.println("Trun-> ***"+i+"***");
			for (int j=0; j<this.getVehicles().size();j++) {// runnig for all vehicles
				if (this.getVehicles().get(j).getCurrentRoute().getStart()== this.currentVehicles.get(j).getLastJunction())
					System.out.println(this.getVehicles().get(j)+" is starting "+this.getVehicles().get(j).getCurrentRoute());// Print START Route
				if ( !this.getVehicles().get(j).getLastRoad().getIsOpen()) {// check if have light & have red light
					System.out.println(this.getVehicles().get(j)+" is waiting for green light in"+this.getVehicles().get(j).getLastJunction());
					System.out.println(this.getVehicles().get(j).getLastRoad());
				}
				else {// THE MOVE step
					System.out.println(this.getVehicles().get(j)+" has left "+this.getVehicles().get(j).getLastJunction());
					this.getVehicles().get(j).move();
					System.out.println(this.getVehicles().get(j)+" is Arrive to "+ this.getVehicles().get(j).getLastJunction());
					if (this.getVehicles().get(j).getLastJunction()==this.getVehicles().get(j).getCurrentRoute().getEnd()) {
						System.out.println(this.getVehicles().get(j)+" is Arrive to DST-->"+ this.getVehicles().get(j).getCurrentRoute().getEnd());
						System.out.println(this.getVehicles().get(j)+ " has finished the route. Total time is: "+this.getVehicles().get(j).getCurrentRoute().getDelay());
						this.addRoute4Vehicle(this.getVehicles().get(j), this.currentMap.getJunctions(), this.currentMap.getRoads());//create new route for vehicle finished
					}
				}		
			}
			for (int j=0; j<this.currentMap.getJunctions().size();j++) {// runnig for all vehicles to change traffic light ertujnq
					this.currentMap.getJunctions().get(j).changeLight();
					
			}
		}
		System.out.println("****STATUS****");
		for (int i=0 ; i<this.getVehicles().size(); i++) {
			this.getVehicles().get(i).status();
		}

	}
}
