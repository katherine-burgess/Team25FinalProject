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
public class Workout {
	
	// instance variables
	private String workoutType;
	private Workout newWorkout;
	
	//private Workout stats;
	
	public Workout() {
		workoutType = new String();
	}
	
	// Copy constructor 
	public Workout(Workout toCopy) {
		if (toCopy != null) {
			workoutType = toCopy.workoutType;
			newWorkout = toCopy.newWorkout;
		}
	}
	
	// sets the new incoming workoutType
	public void setWorkoutType(String type) {
		workoutType = type;
	}
	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkout(Workout component) {
		newWorkout = new Workout(component);
	}
	
	public Workout getWorkout() {
		return newWorkout;
	}
	
	// Takes users workout statistics and returns them as a string
//	public String toString() {
//		String workout = new String();
//		workout += "Workout Type: " + getWorkoutType() + '\t' + "Duration: " + getDuration() + '\t' + "Intensity: "
//				+ getIntensity() + '\t' + " Calories Burned: " + getCalories() + '\t' + " Weight: " + getWeight() + '\n';
//	
//		return workout;
//	}

	// This method will compare the user's newest workout statistics to their goals.
	// If a goal is met, method will return true. If no goal is met, the method will return false.
//	public boolean compareTo(GoalComponent goals) {;
//		if (duration.getLength() >= (goals.getDurationGoal())) {
//			System.out.println("Duration Goal has been met!");
//			return true;
//		} else if (getWeight() < goals.getTargetWeight()) {
//			System.out.println("Weight Goal has been met! ");
//			return true;
//		
//		} else if (caloriesBurned.getCal() > goals.getCalorieGoal()) {
//			System.out.println("Calorie Goal has been achieved!");
//			return true;
//		}
//	
//		return false;
//	}

//	public Workout getWorkout(Workout workout) {
//		stats = workout;
//		return stats;
//	}


	
	
	

}
