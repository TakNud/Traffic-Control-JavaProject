package components;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
public class VehicleType {
	private Vehicle typeName;
	private int speed;
	
	public VehicleType(Vehicle name, int speed) {
		this.typeName=name;
		this.speed=speed;
	}

	//FIXED!!!
	//RETURN STRING FOR OBJ
	public static String getRandomVehicleTypes() {
		//String array
		String[] strings = {"Bus", "Taxi", "Private",
		"MotorBike", "Bicycle", "Track", "FullTrack"}; 
		int index = (int)(Math.random() * 10);
		return strings[index];
		}
	//RETURN ARRYLIST FOR ROAD
	public static ArrayList<String> getRandomListVehicleTypes() {
		//String array
		String[] strings = {"Bus", "Taxi", "Private",
		"MotorBike", "Bicycle", "Track", "FullTrack"}; 
		ArrayList <String> ListVehicleTypes= new ArrayList<String>();
		for (int i=0;i<=5;i++) {
			int index = (int)(Math.random() * 6);
			if (!ListVehicleTypes.contains(strings[index])) {//check existence
				ListVehicleTypes.add(strings[index]);
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
	



public static void main (String[] args) {
	System.out.print(getRandomVehicleTypes());
}
}
	