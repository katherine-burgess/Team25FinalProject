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
	private long duration;
	private String intensity;
	private int caloriesBurned;
	private double weight;
	

	
	// This constructor will check the user input for possible errors, if no errors
	// in input the instance variables will be set.
	// Otherwise an error will be thrown with a specific message to the user.
	public WorkoutComponent(String dur, String calories, String weight, String intensity, String type)
			throws InvalidEntryException {
		try {
			duration = Long.parseLong(dur);
			caloriesBurned = Integer.parseInt(calories);
			this.weight = Double.parseDouble(weight);
			this.intensity = intensity;
			workoutType = type;
			

			
			if (duration < 0 || duration > 300) {
				throw new InvalidEntryException(
						String.format("Invalid workout duration entry. Enter a number between 0 and 300 minutes "));
			}

			if (caloriesBurned < 0 || caloriesBurned > 1000) {
				throw new InvalidEntryException(
						String.format("Invalid calorie entry. Enter a number between 0 and 1000 calories "));
			}

			if (this.weight < 100 || this.weight > 300) {
				throw new InvalidEntryException(
						String.format("Invalid weight entry. Enter a number between 100 and 300 lbs "));
			}

		} catch (NumberFormatException nfe) {
			throw new InvalidEntryException(String.format("Invalid Workout Entry. Make sure to enter a number."));

		}
	}

	public long getDuration() {
		return duration;
	}

	public int getCalories() {
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
		if (getDuration() >= (goals.getDurationGoal())) {
			System.out.println("Duration Goal has been met! " + getDuration());
			return true;
		} else if (getWeight() < goals.getTargetWeight()) {
			System.out.println("Weight Goal has been met! " + getWeight());
			return true;
		
		} else if (getCalories() > goals.getCalorieGoal()) {
			System.out.println("Calorie Goal has been achieved!");
			return true;
		} else if (getIntensity() == goals.getIntensityGoal()) {
			System.out.println("Intensity Goal has been achieved");
			return true;
		}
	
		return false;
	}
	
	

}
