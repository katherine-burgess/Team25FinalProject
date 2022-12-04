package application;

/**
 * This class will track cardio workouts entered by the user. 
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class Cardio extends Workout{

	private int caloriesBurned;
	private double distance;
	private double duration;
	
	// This constructor will check for valid cardio workout entries
	public Cardio(String dist, String dur, String cal) {
		distance = Double.parseDouble(dist);
		duration = Double.parseDouble(dist);
		caloriesBurned = Integer.parseInt(cal);
	}
	
	public int minDistance() {
		return 0;
	}
}
