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
		//lastRoad= lastJunction;
		System.out.println(this.type+ ", ID:"+this.id
				+" has beed created and placed at Junction-> "+this.lastJunction.getNameJunc());
		//Route route= new Route(lastJunction,lastRoad,type);
		//this.currentRoute= 
		//lastJunction.
	}
	public void setRoute(Route R) {
		//if (R.getStart()==this.lastJunction)
			this.currentRoute=R;
	}
	public Route getCurrentRoute() {
		return this.currentRoute;
	}
	public VehicleType getVehicleType() {
		return this.type;
	}
	public Junction getLastJunction() {
		return this.lastJunction;
	}
	public void setLastJunction(Junction j) {// setting last junction when get a route
		this.lastJunction=j;
	}
	public String toString() {
		return this.type+", ID:"+this.id;
	}
	public void move() {
		this.movesNow=true;
		if (this.currentRoute.getJunctions().get(0).checkAvailability(this.currentRoute.getCurrentRoad())) {
			this.currentRoute.getJunctions().remove(0);
			this.lastJunction=this.currentRoute.getJunctions().get(0);
			System.out.println(this.toString()+"is moving on "+this.lastRoad);
			this.lastRoad= this.currentRoute.getRoads().get(1);
			this.currentRoute.getRoads().remove(0);
		}
		else {
			System.out.println(this.toString()+" is stay at "+ this.lastJunction+"-- no existing road");
		}
		
	}
	public void status() {
		
		
	}
	public void checkIn() {
		System.out.println(this.type+ ", ID:"+this.type.getName()+"is starting route from junction "+
	this.lastJunction+ "to");
		
	}

}
