package components;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
public class VehicleType {
	private String typeName;
	private int speed;
	
	public VehicleType(String name, int speed) {
		this.typeName=name;
		this.speed=speed;
	}

	//FIXED!!!
	//RETURN STRING FOR OBJ
	public static VehicleType getRandomVehicleTypes() {
		//String array
		String[] strings = {"Bus", "Taxi", "Private",
		"MotorBike", "Bicycle", "Track", "FullTrack"}; 
		int index = (int)(Math.random() * 6);
		int newSpeed= new Random().nextInt(100) ;
		VehicleType vehicle = new VehicleType(strings[index],newSpeed);
		return vehicle;
		}
	//RETURN ARRYLIST FOR ROAD
	public static ArrayList<VehicleType> getRandomListVehicleTypes() {
		//String array
		String[] strings = {"Bus", "Taxi", "Private",
		"MotorBike", "Bicycle", "Track", "FullTrack"}; 
		ArrayList <VehicleType> ListVehicleTypes= new ArrayList<VehicleType>();
		for (int i=0;i<=5;i++) {
			int index = (int)(Math.random() * 6);
			int speed = new Random().nextInt(100);
			if (!ListVehicleTypes.contains(strings[index])) {//check existence
				VehicleType Vehicle= new VehicleType(strings[index],speed);
				ListVehicleTypes.add(Vehicle);
				}
			}
		return ListVehicleTypes;
		}
 

		/*
	    int leftLimit = 65; // numeral 'A'
	    int rightLimit = 90; // letter 'Z'
	    int targetStringLength = 5;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    int randomSpeed= new Random().nextInt(100);// Get random speed
	    ArrayList<String> newVehicleType = null;
	    newVehicleType.add(randomSpeed,generatedString);
	    return newVehicleType;
	    
	}
	*/
	//GETTERS&& SETTERS
	public String getName() {
		return this.typeName;
	}
	public int getSpeed() {
		return this.speed;
	}
	public String toString() {
		return this.typeName +", AVG speed:"+ this.speed;
}
}
	