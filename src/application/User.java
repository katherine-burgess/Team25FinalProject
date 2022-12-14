
package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * This class will generate a new user. It will check if the user has entered a correct username 
 * containing only letters. This class will also contain helper methods to create the user scene changes.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class User {

	// Instance variables
	private String name;
	private WorkoutHistory history;
	private Button goalsButton;
	private Button doneButton;
	private TextField newUserTextfield;
	private ChoiceBox<String> workoutTypeChoiceBox;

	private static int numWorkouts = 0;

	// This constructors sets the name to empty
	public User() {
		name = " ";
	}

	// This constructor sets the name of a new User
	public User(String value) {
		name = value;
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

	// This part of the class will generate the containers for user scene changes

	/**
	 * This method will create a container for workout statistics
	 * @return workoutContainer holds widgets for user to enter workouts
	 */
	public HBox setWorkoutContainer() {

		HBox workoutContainer = new HBox();
		Label logWorkoutLabel = new Label("Log your new workout");
		HBox.setMargin(logWorkoutLabel, new Insets(10, 10, 10, 10));
		workoutTypeChoiceBox = new ChoiceBox();
		workoutTypeChoiceBox.getItems().add("Cardio");
		workoutTypeChoiceBox.getItems().add("Weight Training");
		HBox.setMargin(workoutTypeChoiceBox, new Insets(10, 10, 10, 10));
		doneButton = new Button("Enter Here");
		HBox.setMargin(doneButton, new Insets(10, 10, 10, 10));
		workoutContainer.getChildren().addAll(logWorkoutLabel, workoutTypeChoiceBox, doneButton);

		return workoutContainer;
	}

	public ChoiceBox<String> getTypeChoiceBox() {
		return workoutTypeChoiceBox;
	}

	public Button getDoneButton() {
		return doneButton;
	}

	/** 
	 * This method will create a container for workout goals
	 * @return workoutGoalsContainer holds the widgets for user to enter goals
	 */
	public HBox setGoalsContainer() {

		HBox workoutGoalsContainer = new HBox();
		Label logGoalsLabel = new Label("Log your fitness goals");
		HBox.setMargin(logGoalsLabel, new Insets(10, 10, 10, 10));
		goalsButton = new Button("Enter Goals Here");
		HBox.setMargin(goalsButton, new Insets(10, 10, 10, 10));
		workoutGoalsContainer.getChildren().addAll(logGoalsLabel, goalsButton);

		return workoutGoalsContainer;
	}

	public Button getGoalsButton() {
		return goalsButton;
	}

	// This generates the containers for generating a new user scene change on GUI

	/**
	 *  This method creates a container for new user name label
	 * @return newUserTitle  holds the widgets for label 
	 */
	public HBox setUserTitle() {
		HBox newUserTitle = new HBox();
		Label newUserLabel = new Label("Add a New User");
		HBox.setMargin(newUserLabel, new Insets(10, 10, 10, 10));
		newUserTitle.getChildren().add(newUserLabel);

		return newUserTitle;
	}

	/**
	 *  This method creates a container for a new user to set a username
	 * @return userNameContainer holds the widgets for user to enter a new username
	 */
	public HBox setUserNameContainer() {
		// Container for entering user name
		HBox userNameContainer = new HBox();
		Label userNameLabel = new Label("Enter New Username:");
		HBox.setMargin(userNameLabel, new Insets(10, 10, 10, 10));
		newUserTextfield = new TextField();
		HBox.setMargin(newUserTextfield, new Insets(10, 10, 10, 10));
		userNameContainer.getChildren().addAll(userNameLabel, newUserTextfield);

		return userNameContainer;
	}

	// This method will get the new username textfield
	public TextField getNewUserTextfield() {
		return newUserTextfield;
	}

	// Generates a new workout history for the user
	public void newHistory() {
		history = new WorkoutHistory();
	}
	
	// This method will add a new strength workout to the user's workout history
	public void setStrengthHistory(Strength newStr) {
		history.addWorkout(newStr);
		numWorkouts++;
	}
	
	// This method will add a new cardio workout to the user's workout history
	public void setCardioHistory(Cardio newCardio) {
		history.addWorkout(newCardio);
		numWorkouts++;
	}

	// This method will get the user's fitness history as a string
	public String getHistory() {
		return history.toString();
	}

	public int getNumWorkouts() {
		return numWorkouts;
	}

}