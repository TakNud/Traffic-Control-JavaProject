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
		this.speed=this.type.getSpeed();
		System.out.println(this.type+ ", ID:"+this.id
				+" has beed created and placed at Junction-> "+this.lastJunction.getNameJunc());
		//Route route= new Route(lastJunction,lastRoad,type);
		//this.currentRoute= 
		//lastJunction.
	}
	public void setRoute(Route R) {
		this.currentRoute=R;
	}
	public VehicleType getVehicleType() {
		return this.type;
	}
	public String toString() {
		return this.type+", ID:"+this.id;
	}
	public void move() {
		
	}
	public void status() {
		
		
	}
	public void checkIn() {
		System.out.println(this.type+ ", ID:"+this.type.getName()+"is starting route from junction "+
	this.lastJunction+ "to");
		
	}

}
