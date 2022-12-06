package application;


/**
 * This class will set the name of the new incoming workoutType and compare it to the 
 * users goals. This class will also calculate the duration in hours for further 
 * workout based calculations.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public abstract class Workout {

	// instance variables
	private String workoutType;
	private Workout newWorkout;
	private double duration;

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
		newWorkout = component;
	}

	public Workout getWorkout() {
		return newWorkout;
	}
	
	public abstract double getDuration();
	
	public abstract double getCalories();
	
	public abstract double getDistance();
	
	public abstract String compareTo(GoalComponent goal);
	
	// This method takes the duration in minutes and converts it to seconds
	public double durationInHours() {
		duration = getDuration() / 60;
		return duration;
	}



}
