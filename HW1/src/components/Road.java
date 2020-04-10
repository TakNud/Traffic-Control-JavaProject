package components;

import java.util.ArrayList;
import java.util.Random;
public class Road {
	
	private Junction fromJunc;
	private Junction toJunc;
	private ArrayList<String> allowedVehicles;
	private boolean isOpen;
	private boolean isEnabled;
	private double length;
	private int maxSpeed;
	
	public Road(Junction from, Junction to) {
		this.fromJunc=from;
		this.toJunc=to;
		this.allowedVehicles= VehicleType.getRandomVehicleTypes();
		this.isOpen= new Random().nextBoolean();
		this.isEnabled= new Random().nextBoolean();
		
	}
	public Road(Junction from, Junction to, ArrayList<String> allowed, boolean open, boolean enabled) {
		this.fromJunc=from;
		this.toJunc= to;
		this.allowedVehicles= allowed;
		this.isOpen=open;
		this.isEnabled= enabled;
	}
	
	public void addVehicleType(String type) {
		allowedVehicles.add(100, type);
	}
	
	public void countLength() {
		
	}
	public void setIsOpen(boolean what) {
		isOpen=what;
	}
	
}
