package components;

public class Vehicle {
	private int id;
	private String type;
	private int speed;
	private Route currentRoute;
	private Junction lastJunction;
	private Road lastRoad;
	private boolean movesNow;
	private double spentTime;
	
	public Vehicle(int id, String type, Junction lastJunction) {
		this.id = id;
		this.type = type;
		this.lastJunction = lastJunction;
	}
	
	public void move() {
		
	}
	public void status() {
		
	}
	public void checkIn() {
		
	}

}
