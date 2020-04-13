package components;

public class Vehicle {
	private int id;
	private VehicleType type;
	private int speed;
	private Route currentRoute;
	private Junction lastJunction;
	private Road lastRoad;
	private boolean movesNow;
	private double spentTime;
	
	public Vehicle(int id, VehicleType type, Junction lastJunction) {
		this.id = id;
		this.type = type;
		this.lastJunction = lastJunction;
		System.out.println(this.type+", AVG Speed:"+this.speed+", ID:"+this.id
				+" has beed created and placed at Junction-> "+this.lastJunction.getNameJunc());
		//this.currentRoute= 
		//lastJunction.
	}
	public String toString() {
		return this.type+", AVG Speed:"+this.speed+", ID:"+this.id;
	}
	public void move() {
		
	}
	public void status() {
		
	}
	public void checkIn() {
		
	}

}
