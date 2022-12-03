
package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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
	private Button goalsButton;
	private Button doneButton;

	private static int numWorkouts = 0;
	
	// need to add functionality to this constructor
	public User() {
		
	}
	
	// This constructor sets the name of a new User
	public User(String newName) {
		name = newName;

	}
	
	// This method will create a container for workout statistics
	public HBox setWorkoutContainer(){
	
		HBox workoutContainer = new HBox();
		Label logWorkoutLabel = new Label("Log your new workout");
		HBox.setMargin(logWorkoutLabel, new Insets(10, 10, 10, 10));
		doneButton = new Button("Enter Here");
		HBox.setMargin(doneButton, new Insets(10, 10, 10, 10));
		workoutContainer.getChildren().addAll(logWorkoutLabel, doneButton);
		
		return workoutContainer;
	}
	
	public Button getDoneButton() {
		return doneButton;
	}
	
	// This method will create a container for workout goals
	public HBox setGoalsContainer() {
		
		HBox workoutGoalsContainer = new HBox();
		Label logGoalsLabel = new Label("Log your workout goals");
		HBox.setMargin(logGoalsLabel, new Insets(10, 10, 10, 10));
		goalsButton = new Button("Enter Goals Here");
		HBox.setMargin(goalsButton, new Insets(10, 10, 10, 10));
		workoutGoalsContainer.getChildren().addAll(logGoalsLabel, goalsButton);

		return workoutGoalsContainer;
	}
	
	public Button getGoalsButton() {
		return goalsButton;
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