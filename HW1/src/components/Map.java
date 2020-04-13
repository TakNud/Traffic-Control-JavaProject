package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Map {
	
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	//Default constructor- Random junction&&roads
	public Map() {
		junctions= new ArrayList<Junction>();
		roads= new ArrayList<Road>();
		Junction arr[]=new Junction[20];
		for (int i=0;i<20;i++) {
			double x= new Random().nextDouble()*100000;
			double y= new Random().nextDouble()*800;
			arr[i]=new Junction(new String("" +i),new Point(x,y));
			this.addJunction(arr[i]);
		}
		
		Road arrR[]=new Road[30];
		for (int i=0;i<arrR.length;i++){
			
			int j=new Random().nextInt(arr.length);
			int k=new Random().nextInt(arr.length);
			if (!arr[j].equals(arr[k])) {
				arrR[i]=new Road(arr[j],arr[k], VehicleType.getRandomListVehicleTypes(), false,true);
				this.addRoad(arrR[i]);
				arr[j].setExitingRoads(arrR[i]);
				arr[k].setEnteringRoads(arrR[i]);
			}
			else i--;
	 		
		}
		/*
		Junction arr[]=new Junction[20];
		for (int i=0;i<20;i++) {
			arr[i]=new Junction(new String("" +i),new Point(-1,-1));
			Road e= new Road(arr[i]);
			arr[i].setEnteringRoads(e);
		}
		*/
	}
	// Con get numbers to build map - RANDOMLY
	public Map(int junction, int roads) {
		this.junctions= new ArrayList<Junction>();
		this.roads= new ArrayList<Road>();
		Junction arr[]=new Junction[junction];
		for (int i=0;i<junction;i++) {
			double x= new Random().nextDouble()*100000;
			double y= new Random().nextDouble()*800;
			arr[i]=new Junction(new String("" +i),new Point(x,y));	
			this.junctions.add(arr[i]);
		}
		Road arrR[]=new Road[roads];
		int g=0;
		for (int i=0;i<arrR.length;i++){
			int j=new Random().nextInt(arr.length);
			int k=new Random().nextInt(arr.length);
			while (j==k) {
			j=new Random().nextInt(arr.length);
			k=new Random().nextInt(arr.length);
			}
			if (!arr[j].equals(arr[k])) {
				arrR[i]=new Road(arr[j],arr[k], VehicleType.getRandomListVehicleTypes(), false,true);
				this.roads.add(arrR[i]);
				//arr[i].changeLight();
				arr[j].setExitingRoads(arrR[i]);
				arr[k].setEnteringRoads(arrR[i]);
				if (g<arr.length) {
					arr[g].setLightsOn();;
				}
			}
			else i--;
			
		}	
		
		
	}
	//CON- GET LIST of Junction and create ROADS(RANDOM)
	public Map(ArrayList<Junction> juncs) {
		this.junctions=juncs;
		Road arrR[]=new Road[juncs.size()];
		for (int i=0;i<arrR.length;i++){
			int j=0;
			int k=0;
			while (j==k) {
			j=new Random().nextInt(juncs.size());
			k=new Random().nextInt(juncs.size());
			}
			if (!juncs.get(j).equals(juncs.get(k))) {
				arrR[i]=new Road(juncs.get(j),juncs.get(k), VehicleType.getRandomListVehicleTypes(), false,true);
				this.roads.add(arrR[i]);
				juncs.get(j).setExitingRoads(arrR[i]);
				juncs.get(k).setEnteringRoads(arrR[i]);
				System.out.println(arrR[i].toString() + " has been created");
			}
			else i--;
		}	
		
	}
	//GETtERS--&&--SETTERS
	public ArrayList<Junction> getJunctions() {
		return this.junctions;
	}
	public ArrayList<Road> getRoads(){
		return this.roads;
	}
	//CON- Get 2 lost(junc&roads)- build map
	public Map(ArrayList<Junction>juncs, ArrayList<Road>roads) {
		this.junctions=juncs;
		this.roads=roads;
	}
	//set road in road list
	public void addRoad(Road r) {
		this.roads.add(r);
	}
	//REmove road obj from list
	public void removeRoad(Road r) {
		this.roads.remove(r);
	}
	//set junc on junction list
	public void addJunction(Junction junc) {
		this.junctions.add(junc);
	}
	//remove junc OBJ from list
	public void removeJunction(Junction junc) {
		for (int i =0 ; i< junc.getExitingRoads().size();i++) {
			junc.getExitingRoads().remove(i);
		}
		for (int i =0 ; i< junc.getEnteringRoads().size();i++) {
			junc.getEnteringRoads().remove(i);
		}
		this.junctions.remove(junc);
		System.out.println("Junction Test has been removed from the map.");
	}

}
