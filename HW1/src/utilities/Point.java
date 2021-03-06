package utilities;
import java.util.Random;
public class Point {
	
	public static final double MAX_X = 1000000.000;
	public static final int MIN_X = 0;
	public static final int MAX_Y = 800;
	public static final int MIN_Y = 0;
	
	private double x;
	private double y;
	
	public Point() {
		this(0, 0);
	}
	
	public Point (double x, double y) {
		if(!this.setX(x)){
			this.setX( new Random().nextDouble()*1000000.000);
			System.out.println ("therefore has been replaced with"+this.x);
		}
		else
			this.setX(x);
		if (!(this.setY(y))) {
			this.setY( 800* new Random().nextDouble());
			System.out.println ("therefore has been replaced with"+x);
		}
		else 
			this.setY(y);
		System.out.println ("Point ("+ this.x+ "," + this.y +") has been created!");
	}
		
	public Point (Point other) {
		if(other == null) {
			other = new Point(0, 0);
		}
		this.setX(other.x);
		this.setY(other.y);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public boolean setX(double x) {
		if (x> MAX_X || x< MIN_X) {
			System.out.println("The vlaue"+ x +"is illegal for X");
			return false;
		}
		else {
			this.x=x;
			return true;
		}
	}
	public boolean setY(double y) {
		if (y> MAX_Y || y< MIN_Y) {
			System.out.println("The vlaue"+ y +"is illegal for Y");
			return false;
		}
		this.y=y;
		return true;
	}
	
	@Override
	public String toString() {
		
		return "(" + this.x + "," + this.y + ")";
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Point) {
			Point p = (Point) other;
			return this.x == p.x && this.y == p.y ;
		}
		return false;
	}
}
