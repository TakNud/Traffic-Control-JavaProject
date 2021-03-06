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
	public Road getLastRoad() {
		return this.lastRoad;
	}
	public void setLastRoad(Road R) {
		this.lastRoad=R;
	}
	public void setLastJunction(Junction j) {// setting last junction when get a route
		this.lastJunction=j;
	}
	public String toString() {
		return this.type+", ID:"+this.id;
	}
	public void move() {
		//CHECKING: have more junction, have more roads, allowed Vehicle .
		if (this.currentRoute.getJunctions().isEmpty()==false&& this.currentRoute.getRoads().isEmpty()==false ) {//&& this.getCurrentRoute().getCurrentRoad().getAllowedVehicle().contains(this.type)) {
			if (this.currentRoute.getJunctions().get(0).checkAvailability(this.currentRoute.getCurrentRoad())) {
				this.movesNow=true;
				this.checkIn();
				this.spentTime= this.currentRoute.getDelay();
				System.out.println(this.toString()+"is moving on "+this.lastRoad+" Delay time:"+this.currentRoute.getDelay());
				this.currentRoute.getRoads().remove(0);
				if (this.currentRoute.getRoads().isEmpty()==false)
					this.lastRoad= this.currentRoute.getRoads().get(0);

			}
		//else 
			//System.out.println(this.toString()+" is stay at "+ this.lastJunction+"-- no existing road");
		}
		else 
			System.out.println(this.toString()+" is stay at "+ this.lastJunction+"-- no existing road");
		
	}
	//REturn if vehicle move  or not 
	public void status() {
		System.out.println(this.toString()+" Position:"+ this.lastJunction+ ", Current Route:"+ this.currentRoute + ", Time Spent:"+
	this.spentTime);
		
		
	}
	public void checkIn() {
		this.currentRoute.getJunctions().remove(0);
		this.lastJunction=this.currentRoute.getJunctions().get(0);
		this.currentRoute.calcDelay();
		
	}

}
