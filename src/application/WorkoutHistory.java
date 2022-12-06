package application;

import java.util.ArrayList;

/**
 * This class will keep track of the user's workout history. When a new workout
 * is logged, it will be added to the workoutHistory ArrayList.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class WorkoutHistory {

	private ArrayList<Workout> workoutHistory;

	public WorkoutHistory() {
		// creation of a new workout history with a new user
		workoutHistory = new ArrayList<Workout>();
	}
	
	// copy constructor 
	public WorkoutHistory(Workout component) {
		workoutHistory = new ArrayList<Workout>();
		
	}

	// This method will add each new workout component to the ArrayList
	public void addWorkout(Workout component) {
		if (workoutHistory.isEmpty()) {
			workoutHistory.add(component);
			return;
		}
		workoutHistory.add(component);
		
	}

	public ArrayList<Workout> getWorkoutHistory() {
		return workoutHistory;
	}

	// This method will generate a workout history in a string format
	public String toString() {
		String w = new String();
		for (int i = 0; i < workoutHistory.size(); i++) {
			if (workoutHistory.get(i).getWorkoutType() == "Cardio") {
				w +=  " Cardio Log: "  + '\t' + "Duration: " + (workoutHistory.get(i).getDuration()) + " minutes" + '\t'
						+ "Calories Burned: " + workoutHistory.get(i).getCalories() + " calories " + '\t'
						+ " Distance: " + workoutHistory.get(i).getDistance() + " km "+ '\n';
				
			} else if (workoutHistory.get(i).getWorkoutType() == "Weight Training") {
				w +=  " Strength Log: "  + '\t' + "Duration: " + (workoutHistory.get(i).getDuration()) + " minutes" + '\t'
						+ "Calories Burned: " + workoutHistory.get(i).getCalories() + " calories " + '\n';	
			}
		}
		return w;
	}

}
