
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
	private double weight;
	private double height;
	private ArrayList<User> users; 
	
	private WorkoutComponent workoutStats;
	private GoalComponent goals;
	
	// This constructor will set the instance variables for each new user 
	User(String name, double weight, double height) {
		this.name = name;
		this.weight = weight;
		this.height = height;

	}

	// This constructor sets the name of a new User
	User(String newName) {
		name = newName;
		users = new ArrayList<User>();
		
	}

	// This method checks if the user name is an alphabetical letter
	public String setName(String nameAsString) {
		String errorMessage = " ";
		boolean validName = true;

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
	

	// This method will create a new workoutComponent
	// This method will take in a workoutComponent
	public void logWorkout(String calories, String duration, String intensity, String type, String newWeight)
			throws InvalidEntryException {
		workoutStats = new WorkoutComponent(duration, calories, newWeight, intensity, type);
		System.out.println(workoutStats);
		
		// check if the instance variable is null
		if (goals != null) {
			workoutStats.compareTo(goals); // will compare newly entered data to the goals (if user has entered goals previously)
		}
		
	}

	// This method will create a new Goal Component
	// This method will take in a goalComponent
	public void logGoals(String duration, String weight, String upperBody, String lowerBody)
			throws InvalidEntryException {
		
		// create a new goal component and save in instance variable
		goals = new GoalComponent(duration, weight, upperBody, lowerBody);
		
		// check if the instance variable is null
		if (workoutStats != null) {
			workoutStats.compareTo(goals);
		}

	}

	// This method will compare the workout stats to the user's goals
	public void compareTo(WorkoutComponent workoutStat) {
		if (workoutStat.getDuration() >= (goals.getDurationGoal())) {
			System.out.println("Duration Goal has been met!");
		} else if (workoutStat.getWeight() < goals.getTargetWeight()) {
			System.out.println("Target Weight has been achieved, way to go!");
		}
	}
	
	
}