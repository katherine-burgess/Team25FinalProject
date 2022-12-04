package application;

import java.util.ArrayList;


/**
 * This class will log the user's workout statistics. The class will check to see that the user has entered a number, 
 * if not a specific error message will be thrown. This class will compare the new workout statistics with the user's goals.
 *  If the workout statistics are better than the goals, the user will receive an achievement message.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class WorkoutComponent {
	
	// instance variables
	private String workoutType;
	private Duration duration;
	private String intensity;
	private Calories caloriesBurned;
	private double weight;
	
	private WorkoutComponent stats;
	
	public WorkoutComponent() {
		// TODO Auto-generated constructor stub
	}
	
	public WorkoutComponent(WorkoutComponent toCopy) {
		if (toCopy != null) {
			workoutType = toCopy.workoutType;
			duration = toCopy.duration;
			intensity = toCopy.intensity;
			caloriesBurned = toCopy.caloriesBurned;
			weight = toCopy.weight;
		}
	}
	
	public WorkoutComponent(String dur, String cal, String intense, String type, String lbs) throws InvalidEntryException {
		try {
			duration = new Duration();
			duration.setLength(dur);
			
			caloriesBurned = new Calories();
			caloriesBurned.setCalories(cal);
			
			weight = Double.parseDouble(lbs);
			intensity = intense;
			workoutType = type;
		
			if (this.weight < 100 || this.weight > 300) {
				throw new InvalidEntryException(
					String.format("Invalid weight entry. Enter a number between 100 and 300 lbs "));
			}

		} catch (NumberFormatException nfe) {
			throw new InvalidEntryException(String.format("Invalid Workout Entry. Make sure to enter a number."));
		}
		
	}

	// return the duration of workout in hours and minutes 
	public Duration getDuration() { // this will be a privacy leak
		return duration;
	}

	public Calories getCalories() { // this will be a privacy leak
		return caloriesBurned;
	}

	private String getIntensity() {
		return intensity;
	}

	private String getWorkoutType() {
		return workoutType;
	}

	public double getWeight() {
		return weight;
	}
	
	// Takes users workout statistics and returns them as a string
	public String toString() {
		String workout = new String();
		workout += "Workout Type: " + getWorkoutType() + '\t' + "Duration: " + getDuration() + '\t' + "Intensity: "
				+ getIntensity() + '\t' + " Calories Burned: " + getCalories() + '\t' + " Weight: " + getWeight() + '\n';
	
		return workout;
	}

	// This method will compare the user's newest workout statistics to their goals.
	// If a goal is met, method will return true. If no goal is met, the method will return false.
	public boolean compareTo(GoalComponent goals) {;
		if (duration.getLength() >= (goals.getDurationGoal())) {
			System.out.println("Duration Goal has been met!");
			return true;
		} else if (getWeight() < goals.getTargetWeight()) {
			System.out.println("Weight Goal has been met! ");
			return true;
		
		} else if (caloriesBurned.getCal() > goals.getCalorieGoal()) {
			System.out.println("Calorie Goal has been achieved!");
			return true;
		}
	
		return false;
	}

	public WorkoutComponent getWorkout(WorkoutComponent workout) {
		stats = workout;
		return stats;
	}


	
	
	

}
