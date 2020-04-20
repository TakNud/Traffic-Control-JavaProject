package components;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
public class Road {
	
	private Junction fromJunc;
	private Junction toJunc;
	private ArrayList<VehicleType> allowedVehicles;
	private boolean isOpen;
	private boolean isEnabled;
	private double length;
	private int maxSpeed;
	
	public Road(Junction from, Junction to) {
		this.fromJunc=from;
		this.toJunc=to;
		this.allowedVehicles= VehicleType.getRandomListVehicleTypes();
		this.isOpen= new Random().nextBoolean();
		this.isEnabled= new Random().nextBoolean();
		this.countLength();
		this.maxSpeed= new Random().nextInt(100);
		System.out.println(this.toString() + " has been created");
	}
	public Road(Junction from, Junction to, ArrayList<VehicleType> allowed, boolean open, boolean enabled) {
		this.fromJunc=from;
		this.toJunc= to;
		this.allowedVehicles= allowed;
		this.isOpen=open;
		this.isEnabled= enabled;
		this.countLength();
		this.maxSpeed= new Random().nextInt(100);
		System.out.println(this.toString() + " has been created");
	}
	
	public void addVehicleType(VehicleType type) {
		allowedVehicles.add(type);
		
	}
	//Calculate the length beetween roads
	public void countLength() {
		double calcX=Math.abs((this.toJunc.getLocation().getX())-
				(this.fromJunc.getLocation().getX()));
		double calcY= Math.abs((this.toJunc.getLocation().getY())-
				(this.fromJunc.getLocation().getY()));
		double sum = Math.pow(calcX,2)+Math.pow(calcY,2);
		this.length= Math.sqrt(sum);
		
		
	}
	//SETers && GETters:
	public int getMaxSpeed() {
		return this.maxSpeed;
	}
	public ArrayList<VehicleType> getAllowedVehicle(){
		return this.allowedVehicles;
	}
	public double getLength() {
		return this.length;
	}
	public Junction getFromJunc() {
		return this.fromJunc;
	}
	public Junction getToJucn() {
		return this.toJunc;
	}
	public boolean getIsOpen () {
		return this.isOpen;
	}
	public void setIsOpen(boolean what) {
		this.isOpen=what;
		if (this.isOpen) {
			System.out.println("Road from "+ this.fromJunc.getNameJunc() +" to-->"+
			this.toJunc.getNameJunc()+": Green Light");
		}
	}
	
	// m= The Sentence like Example process
	public String toString() {
		String m= "Road from "+ fromJunc.getNameJunc() +"-->to-->"+ toJunc.getNameJunc();
		return m;
	}
	
}
