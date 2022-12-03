
package application;


/**
 * This class will generate a new user. Each new user object will contain methods for 
 * logging both workout statistics and goals. 
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
	
	// need to add functionality to this constructor
	public User() {
		
	}
	
	// This constructor sets the name of a new User
	public User(String newName) {
		name = newName;

	}

	// This method checks if the user name is an alphabetical letter
	public String setName(String nameAsString) {
		String errorMessage = " ";
		boolean validName = true;
		
		if (nameAsString == "") {
			validName = false;
			errorMessage = String.format("Your username cannot be blank, enter your name.");
		}
		// Check if the username is alphabetical
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

	
	public void logWorkout(String calories, String duration, String intensity, String type, String newWeight)
			throws InvalidEntryException {
		Duration dur = new Duration();
		dur.setLength(duration);
		
		
		// add new workout to workout history
		history.addWorkout(workoutStats);
		
		if (goals != null) {
			if (workoutStats.compareTo(goals) == true) {
				// print out achievement to the user
				
			}
		}
		// increment static variable
		numWorkouts++;

	}
	

	// This method will create a new Goal Component
	public void logGoals(String duration, String weight, String calorie)
			throws InvalidEntryException {

		// create a new goal component and save in instance variable
		goals = new GoalComponent(duration, weight, calorie);

		// check if the instance variable is null
		if (workoutStats != null) {
			goals.compareTo(workoutStats);
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