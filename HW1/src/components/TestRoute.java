/**
 * 
 */
package components;

import components.Junction;
import components.Map;
import components.Road;
import components.Route;
import components.VehicleType;

/**
 * @author krsof
 *
 */
public class TestRoute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map map= new Map(5,5);
		
		Route route=new Route(map.getJunctions(),map.getRoads(), VehicleType.getRandomVehicleTypes() );
		System.out.println(route.getJunctions());
		
		//route.printRoute();
		System.out.println("Start: "+route.getStart()+", End: "+route.getEnd());
	
	}

}
