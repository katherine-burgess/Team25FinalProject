package application;

import java.util.ArrayList;

public class WorkoutHistory {
	


	private ArrayList<WorkoutComponent> workoutHistory;
	
	public WorkoutHistory() {
		// creation of a new workout history with a new user
		workoutHistory = new ArrayList<WorkoutComponent>();
	}

	public void addWorkout(WorkoutComponent component) {
		if (workoutHistory.isEmpty()){
			workoutHistory.add(component);
			return;
		}
		workoutHistory.add(component);
		System.out.println(workoutHistory);
	}
	
	public ArrayList<WorkoutComponent> getWorkoutHistory() {
		return new ArrayList<WorkoutComponent>();
	}
	
	public String toString() {
		String w = new String();
		for (int i = 0; i < workoutHistory.size(); i++) {
			w += "Log: " + (i) + '\t' + ( workoutHistory.get(i)) + '\n' ;
		}
		System.out.println(w);
		return w;
	}
	
	
}
