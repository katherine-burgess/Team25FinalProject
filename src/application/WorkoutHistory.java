package application;

import java.util.ArrayList;

public class WorkoutHistory extends User{
	
	
	private ArrayList<WorkoutComponent> workoutHistory;
	
	
	
	public WorkoutHistory(String newName) {
		super(newName);
	}

	public void addWorkout(WorkoutComponent component) {
		if (workoutHistory.isEmpty()){
			workoutHistory.add(component);
			return;
		}
		workoutHistory.add(component);
	}
	
	public ArrayList<WorkoutComponent> getWorkoutHistory() {
		return new ArrayList<WorkoutComponent>();
	}
	
	
}
