package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class will control all of the scene changes of the application.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class WorkoutAppController {
	Stage applicationStage;

	@FXML
	private Label inspirationQuoteLabel;

	@FXML
	private ChoiceBox<String> chooseUserChoiceBox;

	private Label userErrorLabel = new Label();

	private Label printGoalsLabel = new Label();

	private Label userGoalLabel = new Label();

	private Label userWorkoutLabel = new Label();

	
	// Get a randomly generated quote and returns the string at the random index
	// https://stackoverflow.com/questions/8065532/how-to-randomly-pick-an-element-from-an-array
	public String getRandomQuote() {
		String[] quoteArray = new String[] { "Progress, not perfection.", "Find your joy.",
				"This is the moment to begin.", "Goal setting is the secret to a compelling future." };
		int rndQuote = new Random().nextInt(quoteArray.length);
		return quoteArray[rndQuote];
		// this function could be placed in a new class
	}

	/**
	 * This method will get the user's workout history. If the user hasn't
	 * previously entered any workouts a message will be printed to the user on the GUI.
	 *  If the user has logged previous workouts, the user will be able to see their history.
	 * 
	 * @param event an Action Event that occurs when the user presses the exit button
	 * @param returnUserScene the current user's main welcome scene
	 * @param viewUser the current user
	 */
	void showLog(ActionEvent event, Scene returnUserScene, User viewUser) {
		userWorkoutLabel.setText(" ");
		try {

			VBox statsContainer = new VBox();
			Button exitButton = new Button("Exit");
			VBox.setMargin(exitButton, new Insets(10, 10, 10, 10));
			statsContainer.getChildren().addAll(userWorkoutLabel, exitButton);
			if (viewUser.getNumWorkouts() > 0) {
				userWorkoutLabel.setText(viewUser.toString());

				VBox.setMargin(userWorkoutLabel, new Insets(10, 10, 10, 10));
			} else if (viewUser.getNumWorkouts() == 0) {
				userWorkoutLabel.setText("No Workout History. Exit and Log a Workout.");
				VBox.setMargin(userWorkoutLabel, new Insets(10, 10, 10, 10));
			}
			exitButton.setOnAction(exitEvent -> applicationStage.setScene(returnUserScene));

			Scene statsScene = new Scene(statsContainer);
			applicationStage.setScene(statsScene);

		} catch (NullPointerException npe) {
		}

	}

	/**
	 * This method will set up a new user in the application. The method will
	 * validate that the user name is alphabetic, if the user has entered a proper
	 * user name the application will add the new user to the ChoiceBox.
	 * 
	 * @param mainScene
	 * @param newUserTextfield string value entered by the user
	 * @param newUser 
	 */
	void setNewUser(Scene mainScene, TextField newUserTextfield, User newUser) {
		userErrorLabel.setText(" ");

		// validate that the user has entered a name
		String errorMessage = newUser.setName(newUserTextfield.getText());

		// Check if error message (if so show an error message to the user)
		if (errorMessage.equals(" ")) {
			chooseUserChoiceBox.getItems().add(newUser.getName()); // https://jenkov.com/tutorials/javafx/choicebox.html
			applicationStage.setScene(mainScene);
		} else {
			userErrorLabel.setText(errorMessage);
		}

	}

	/**
	 * This method will take the user's input from the GUI and print the goals to
	 * the user. The method will check if the user has entered a number. If not an
	 * error message will be shown.
	 * 
	 * @param returnUserScene the returning user's main welcome scene
	 * @param viewUser the current user
	 * @param durationTextfield string value entered by the user
	 * @param targetWeightTextfield string value entered by the user
	 * @param calorieGoalTextfield string value entered by the user
	 * @throws InvalidEntryException catches if the user enters anything not numerical
	 */
	private GoalComponent goal;
	
	void calculateGoals(Scene returnUserScene, User viewUser, TextField durationTextfield,
			TextField targetWeightTextfield, TextField calorieGoalTextfield) throws InvalidEntryException {

		boolean error = false;
		goal = new GoalComponent(durationTextfield.getText(), targetWeightTextfield.getText(),
				calorieGoalTextfield.getText());
		goal.setGoals(goal);
		String goalList = goal.getGoals().toString();
		// Retrieve goals and show to user
		

		if (!error) {
			applicationStage.setScene(returnUserScene);
			printGoalsLabel.setText(chooseUserChoiceBox.getValue() + "'s Goals: ");
			userGoalLabel.setText(goalList);
		}

	}

	/**
	 * This method will generate a scene change for the returning user to input
	 * their workout statistics. This method will create the containers for user
	 * input.
	 * 
	 * @param event an Action Event that occurs when the user presses the log workout button
	 * @param returnUserScene the returning user's main welcome scene
	 * @param viewUser the current user
	 * @param typeChoiceBox
	 */
	void getWorkoutScene(ActionEvent event, Scene returnUserScene, User viewUser, ChoiceBox<String> typeChoiceBox) {

		// main container and set a new scene
		VBox workoutStatsContainer = new VBox();
		SetWorkoutScene ws = new SetWorkoutScene();
		workoutStatsContainer.getChildren().add(userErrorLabel);
		VBox.setMargin(userErrorLabel, new Insets(10, 10, 10, 10));

		if (typeChoiceBox.getValue() == "Cardio") {
			applicationStage.setTitle("Log " + " " + chooseUserChoiceBox.getValue() + " " + "Cardio Workout");
			userErrorLabel.setText("Enter Cardio Workout Stats: ");
			Button submitStats = new Button("Done");
			VBox.setMargin(submitStats, new Insets(10, 10, 10, 10));
			workoutStatsContainer.getChildren().addAll(ws.setDistance(), ws.setDuration(), ws.setCalories(),
					submitStats);

			submitStats.setOnAction(cardioEvent -> calculateCardio(returnUserScene, viewUser, ws.getDistance(),
					ws.getDurationTextField(), ws.getCaloriesTextfield(), typeChoiceBox));

		} else if (typeChoiceBox.getValue() == "Weight Training") {
			applicationStage.setTitle("Log " + " " + chooseUserChoiceBox.getValue() + " " + "Strength Workout");
			userErrorLabel.setText("Enter Strength Workout Stats: ");
			Button submitWeightStats = new Button("Done");
			VBox.setMargin(submitWeightStats, new Insets(10, 10, 10, 10));
			workoutStatsContainer.getChildren().addAll(ws.setCalories(), ws.setDuration(), ws.setIntensity(),
					submitWeightStats);

			submitWeightStats.setOnAction(weightEvent -> calculateWorkout(returnUserScene, viewUser,
					ws.getCaloriesTextfield(), ws.getDurationTextField(), ws.getIntensityChoiceBox(), typeChoiceBox));
		}

		Scene workoutStatsScene = new Scene(workoutStatsContainer);
		applicationStage.setScene(workoutStatsScene);

	}
	/**
	 * This method will create a new Cardio object. The new cardio workout will be compared
	 * to the goals entered by the user. If a goal is achieved the achievement message will 
	 * be printed to the user on the GUI.
	 * 
	 * @param returnUserScene the current user's main scene
	 * @param viewUser the current user
	 * @param distance string value entered by the user
	 * @param durationTextField string value entered by the user
	 * @param caloriesTextfield string value entered by the user
	 * @param typeChoiceBox the type of workout chosen by the user
	 */
	private void calculateCardio(Scene returnUserScene, User viewUser, TextField distance, TextField durationTextField,
			TextField caloriesTextfield, ChoiceBox<String> typeChoiceBox) {
		boolean error = false;

		try {
			Cardio cardioWorkout = new Cardio(distance.getText(), durationTextField.getText(),
					caloriesTextfield.getText());
			
			cardioWorkout.setWorkoutType(typeChoiceBox.getValue());
			cardioWorkout.setWorkout(cardioWorkout);
			
			if (goal != null) {
				String message = cardioWorkout.compareTo(goal);
			
				// sets the goal label on home screen to indicate achievement to user
				if (!(message.equals(""))) {
					userGoalLabel.setText(message);
				} else {
					userGoalLabel.setText(goal.getGoals().toString());
				}
			}

		} catch (InvalidEntryException e) {
			error = true;
			userErrorLabel.setText(e.getMessage()); // shows error message to the user
		}

		if (!error) {
			applicationStage.setScene(returnUserScene);
		}

	}

	/**
	 * This method will take in the user's input from the GUI and check if the use
	 * has entered a number.If there are no error's in input the scene will 
	 * change back to the user's main scene.
	 * 
	 * @param returnUserScene the current user's main welcome scene
	 * @param viewUser the current user
	 * @param caloriesTextfield a string value entered by the user
	 * @param durationTextfield a string value entered by the user
	 * @param workoutIntensityChoiceBox a string value entered by the user
	 * @param typeChoiceBox the type of workout chosen by the user
	 */
	void calculateWorkout(Scene returnUserScene, User viewUser, TextField caloriesTextfield,
			TextField durationTextfield, ChoiceBox<String> workoutIntensityChoiceBox, ChoiceBox<String> typeChoiceBox) {

		boolean error = false;
		try {
			Strength strWorkout = new Strength(durationTextfield.getText(), caloriesTextfield.getText(),
					workoutIntensityChoiceBox.getValue());
			strWorkout.setWorkoutType(typeChoiceBox.getValue());
			
			strWorkout.setWorkout(strWorkout);
			if (goal != null) {
				String message = strWorkout.compareTo(goal);
				
				// sets the goal label on home screen to indicate achievement to user
				if (!(message.equals(""))) {
					userGoalLabel.setText(message);
				} else {
					userGoalLabel.setText(goal.getGoals().toString());
				}
			}
			
		} catch (InvalidEntryException e) {
			userErrorLabel.setText(e.getMessage()); // shows error message to the user
			error = true;
		}
		if (!error) {
			applicationStage.setScene(returnUserScene);
		}
	}

	/**
	 * This method generates the scene change for goal input. The user will be able
	 * to enter in their workout goals onto the GUI interface.
	 * 
	 * @param event an Action Event that occurs when the user presses submit goals button
	 * @param returnUserScene the returning user's main welcome scene
	 * @param viewUser the current user
	 */
	void getGoalScene(ActionEvent event, Scene returnUserScene, User viewUser) {
		userErrorLabel.setText("");
		// Set the title of the scene based on the user
		applicationStage.setTitle("Log" + " " + chooseUserChoiceBox.getValue() + " " + "Goals");

		VBox workoutGoalsContainer = new VBox();

		SetGoalsScene gs = new SetGoalsScene();

		Button submitGoals = new Button("Done");
		VBox.setMargin(submitGoals, new Insets(10, 10, 10, 10));
		workoutGoalsContainer.getChildren().addAll(gs.setDurationGoal(), gs.setTargetWeight(), gs.setCalorieGoal(),
				submitGoals);
		workoutGoalsContainer.getChildren().add(userErrorLabel);

		// Validates and Changes Scene if the user enters proper input
		submitGoals.setOnAction(doneEvent -> {
			try {
				calculateGoals(returnUserScene, viewUser, gs.getDurationGoalTextfield(), gs.getWeightGoalTextfield(),
						gs.getCalorieGoalTextfield());
			} catch (InvalidEntryException e) {
				userErrorLabel.setText(e.getMessage());
			}
		});

		Scene workoutGoalScene = new Scene(workoutGoalsContainer);
		applicationStage.setScene(workoutGoalScene);
	}

	/**
	 * This method generates a new scene based on the users interaction with the
	 * Welcome Page ChoiceBox. Depending on the choice, the user can generate a new
	 * user that will be added to the ChoiceBox for later entry or sign in as a
	 * previous user.
	 * 
	 * @param event holds the input from the ChoiceBox entered by the user
	 */

	@FXML
	void chooseUser(ActionEvent event) {

		Scene mainScene = applicationStage.getScene();
		inspirationQuoteLabel.setText(getRandomQuote());

		// Get the input from the user
		String user = chooseUserChoiceBox.getValue();

		// Change the scene to add a new user to the ChoiceBox
		if (user.equals("Add a User")) {
			applicationStage.setTitle("Get Fit");
			User nu = new User();

			VBox newUserContainer = new VBox();
			Button doneButton = new Button("Enter Here");
			VBox.setMargin(doneButton, new Insets(10, 10, 10, 10));
			doneButton.setOnAction(doneEvent -> setNewUser(mainScene, nu.setNewUserTextfield(), nu));

			newUserContainer.getChildren().addAll(nu.setUserTitle(), nu.setUserNameContainer(), doneButton);

			newUserContainer.getChildren().add(userErrorLabel);
			VBox.setMargin(userErrorLabel, new Insets(10, 10, 10, 10));
			Scene addUserScene = new Scene(newUserContainer);
			applicationStage.setScene(addUserScene); // places the new scene on the stage

		} else {
			User viewUser = new User(chooseUserChoiceBox.getValue());
			// Creates a new workout history for the user
			viewUser.newHistory();

			VBox returnUserContainer = new VBox();
			applicationStage.setTitle(user + "'s Get Fit");

			Scene returnUserScene = new Scene(returnUserContainer);
			Label returnUserLabel = new Label("Welcome " + user + " !");
			VBox.setMargin(returnUserLabel, new Insets(10, 10, 10, 10));
			Label activityLabel = new Label("How were you active today?");
			VBox.setMargin(activityLabel, new Insets(10, 10, 10, 10));

			returnUserContainer.getChildren().addAll(returnUserLabel, activityLabel, viewUser.setWorkoutContainer(),
					viewUser.setGoalsContainer(), printGoalsLabel, userGoalLabel);

			// This will change the scene for user to enter stats depending on the user's
			// workout type choice
			viewUser.getDoneButton().setOnAction(
					doneEvent -> getWorkoutScene(event, returnUserScene, viewUser, viewUser.getTypeChoiceBox()));

			// This will change scene so user can enter goals
			viewUser.getGoalsButton().setOnAction(goalsEvent -> getGoalScene(event, returnUserScene, viewUser));

			VBox.setMargin(printGoalsLabel, new Insets(0, 0, 0, 10));
			VBox.setMargin(userGoalLabel, new Insets(5, 0, 0, 10));

			// User can see previous workout history
			Button seeWorkoutsButton = new Button("See previous workouts");
			VBox.setMargin(seeWorkoutsButton, new Insets(10, 10, 10, 10));
			seeWorkoutsButton.setOnAction(seeWorkoutEvent -> showLog(event, returnUserScene, viewUser));
			returnUserContainer.getChildren().add(seeWorkoutsButton);

			// Allows the user to log out of their account and return to the mainScene
			Button logOutButton = new Button("Log Out");
			VBox.setMargin(logOutButton, new Insets(10, 10, 10, 10));
			logOutButton.setOnAction(logOutEvent -> applicationStage.setScene(mainScene));
			returnUserContainer.getChildren().add(logOutButton);
			applicationStage.setScene(returnUserScene);
		}

	}

}
