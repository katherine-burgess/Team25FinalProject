package application;

import java.util.ArrayList;

/**
 * This class will log the user's workout statistics. The class will check to
 * see that the user has entered a number, if not a specific error message will
 * be thrown. This class will compare the new workout statistics with the user's
 * goals. If the workout statistics are better than the goals, the user will
 * receive an achievement message.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public abstract class Workout {

	// instance variables
	private String workoutType;
	private Workout newWorkout;
	private double duration;

	// private Workout stats;

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
		System.out.println(component);
		newWorkout = component;
	}

	public Workout getWorkout() {
		return newWorkout;
	}
	
	public abstract double getDuration();
	
	public abstract String compareTo(GoalComponent goal);
	
	// This method takes the duration in minutes and converts it to seconds
	public double durationInHours() {
		duration = getDuration() / 60;
		return duration;
	}



}
