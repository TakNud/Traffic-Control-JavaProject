/**
 * 
 */
package components;

import components.Junction;
import components.Map;
import game.Driving;
import utilities.Point;

/**
 * @author krsof
 *
 */
public class TestDrivingMapVehicle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map map=new Map(5,5);
		
		map.addJunction(new Junction("Test", new Point(5.0,10.0)));
		System.out.println(map.getJunctions());
		
		map.removeJunction(map.getJunctions().get(5));
		System.out.println(map.getJunctions());
		
		Driving d=new Driving(5,4,20);
		System.out.println(d.getVehicles());
		d.addVehicles();
		System.out.println(d.getVehicles());
		System.out.println();
		/*
		for(int i=0;i<d.getVehicles().size();i++) {
			d.getVehicles().get(i).move();
		}
		*/
	}

}
