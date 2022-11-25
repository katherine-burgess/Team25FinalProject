
package application;

import java.util.ArrayList;

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
	
	// This constructor will set the instance variables for each new user 
	User(String name, double weight, double height) {
		this.name = name;
		this.weight = weight;
		this.height = height;

	}

	// This constructor sets the name of a new User
	User(String newName) {
		name = newName;
		
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
	public void logWorkout(String calories, String duration, String intensity, String type)
			throws InvalidEntryException {
		WorkoutComponent workoutstat = new WorkoutComponent(duration, calories);

	}

	// This method will create a new Goal Component
	// This method will take in a goalComponent
	public void logGoals(String duration, String weight, String upperBody, String lowerBody)
			throws InvalidEntryException {
		GoalComponent goals = new GoalComponent(duration, weight, upperBody, lowerBody);
		System.out.println(goals.toString());

	}

	// This method will compare the workout stats to the user's goals
	public void compareTo(WorkoutComponent workoutstat, GoalComponent goals) {

		if (workoutstat.getDuration() >= (goals.getDurationGoal())) {
			System.out.println("Duration Goal has been met!");
		}

	}
}