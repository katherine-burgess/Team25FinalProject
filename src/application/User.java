
package application;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class will generate a new user.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class User {

	// Instance variables
	private String name;
	private WorkoutComponent workoutStats;
	private GoalComponent goals;
	private WorkoutHistory history;

	private static int numWorkouts = 0;
	// This constructor will set the instance variables for each new user

	// This constructor sets the name of a new User
	public User(String newName) {
		name = newName;

	}
	public User() {
		
	}

	// This method checks if the user name is an alphabetical letter
	public String setName(String nameAsString) {
		String errorMessage = " ";
		boolean validName = true;
		
		if (nameAsString == "") {
			validName = false;
			errorMessage = String.format("Your username cannot be blank, enter your name.");
		}
		
		for (char n : nameAsString.toCharArray()) {
			if (!Character.isAlphabetic(n)) {
				validName = false;
				errorMessage = String.format("Your username must use only letters", n);
			} 
		}
		
		if (validName) {
			name = nameAsString;
			
		}

		return errorMessage;
	}

	public String getName() {
		return name;
	}

	public WorkoutHistory newHistory() {
		history = new WorkoutHistory();
		return history;
	}
	// This method will create a new workoutComponent
	// This method will take in a workoutComponent
	public void logWorkout(String calories, String duration, String intensity, String type, String newWeight)
			throws InvalidEntryException {
		workoutStats = new WorkoutComponent(duration, calories, newWeight, intensity, type);
		
		// add new workout to workout history
		history.addWorkout(workoutStats);
		
		
		// check if the instance variable is null
		if (goals != null) {
			if (workoutStats.compareTo(goals) == true) {
				// print out achievement to the user
				
			}
		}
		
		// increment static variable
		numWorkouts++;

	}
	

	// This method will create a new Goal Component
	// This method will take in a goalComponent
	public void logGoals(String duration, String weight, String calorie, String intensity)
			throws InvalidEntryException {

		// create a new goal component and save in instance variable
		goals = new GoalComponent(duration, weight, calorie, intensity);

		// check if the instance variable is null
		if (workoutStats != null) {
			workoutStats.compareTo(goals);
		}

	}

	public String getGoals() {
		return goals.toString();
	}
	
	public String toString() {
		return history.toString();
	}

	public int getNumWorkouts() {
		return numWorkouts;
	}

	

}