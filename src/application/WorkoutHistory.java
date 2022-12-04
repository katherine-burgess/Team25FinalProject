package application;

import java.util.ArrayList;

/**
 * This class will keep track of the user's workout history. When a new workout
 * is logged, it will be added to the workoutHistory ArrayList.
 * 
 * @author CS219-user
 *
 */
public class WorkoutHistory {

	private ArrayList<Workout> workoutHistory;

	public WorkoutHistory() {
		// creation of a new workout history with a new user
		workoutHistory = new ArrayList<Workout>();
	}

	// This method will add each new workout component to the ArrayList
	public void addWorkout(Workout component) {
		workoutHistory.add(component);
	}

	public ArrayList<Workout> getWorkoutHistory() {
		return workoutHistory;
	}

	// This method will generate a workout history in a string format
	public String toString() {
		String w = new String();
		for (int i = 0; i < workoutHistory.size(); i++) {
			w += "Log: " + (i) + '\t' + (workoutHistory.get(i)) + '\n';
		}
		System.out.println(w);
		return w;
	}

}
