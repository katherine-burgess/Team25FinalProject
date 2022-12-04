package application;


/**
 * This class will track the user's strength workouts. 
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class Strength extends Workout{
	private double duration;
	private int caloriesBurned;
	private String intensity;
	
	
	public Strength(String dur, String cal, String intense) {
		duration = Double.parseDouble(dur);
		caloriesBurned = Integer.parseInt(cal);
		intensity = intense;
	}
}
