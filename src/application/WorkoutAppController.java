package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class will control all of the scene changes of the application and will log both the goals and 
 * fitness logs inputed by the user.
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

	// results and error labels for GUI
	Label userErrorLabel = new Label();
	Label printGoalsLabel = new Label();
	Label userGoalLabel = new Label();
	Label userWorkoutLabel = new Label();
	Label mileageLabel = new Label("");
	Label resultsLabel = new Label("");
	
	
	
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
				userWorkoutLabel.setText(viewUser.getHistory());

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
	 * @param mainScene the main welcome scene user can choose a participant
	 * @param newUserTextfield string value entered by the user
	 * @param newUser a new participant
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
		workoutGoalsContainer.getChildren().addAll(gs.setDurationGoal(), gs.setTargetDistance(), gs.setCalorieGoal(),
				submitGoals);
		workoutGoalsContainer.getChildren().add(userErrorLabel);
		VBox.setMargin(userErrorLabel, new Insets(10,10,10,10));

		// Validates and Changes Scene if the user enters proper input
		submitGoals.setOnAction(doneEvent -> {
			try {
				calculateGoals(returnUserScene, viewUser, gs.getDurationGoalTextfield(), gs.getDistanceGoalTextfield(),
						gs.getCalorieGoalTextfield());
			} catch (InvalidEntryException e) {
				userErrorLabel.setText(e.getMessage());
			}
		});

		Scene workoutGoalScene = new Scene(workoutGoalsContainer);
		applicationStage.setScene(workoutGoalScene);
	}
	
	/**
	 * This method will take the user's input from the GUI and print the goals to
	 * the user. The method will check if the user has entered a number. If not an
	 * error message will be shown.
	 * 
	 * @param returnUserScene the returning user's main welcome scene
	 * @param viewUser the current user
	 * @param durationTextfield string duration value entered by the user
	 * @param distanceTextfield string distance value entered by the user
	 * @param calorieGoalTextfield string calorie value entered by the user
	 * @throws InvalidEntryException catches if the user enters anything not numerical
	 */
	private GoalComponent goal;
	void calculateGoals(Scene returnUserScene, User viewUser, TextField durationTextfield,
			TextField distanceTextfield, TextField calorieGoalTextfield) throws InvalidEntryException {

		boolean error = false;
		goal = new GoalComponent(durationTextfield.getText(), distanceTextfield.getText(),
				calorieGoalTextfield.getText());
		
		goal.setGoals(goal);
		String goalList = goal.getGoals().toString();

		// Retrieve goals and show to user
		if (cardioWorkout != null) {
			cardioWorkout.compareTo(goal);
		} else if (strWorkout != null) {
			 strWorkout.compareTo(goal);
		}

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
	 * @param typeChoiceBox contains the type of workout chosen by the user
	 */
	void getWorkoutScene(ActionEvent event, Scene returnUserScene, User viewUser, ChoiceBox<String> typeChoiceBox) {
		// resetting the results labels
		resultsLabel.setText("");
		mileageLabel.setText("");
		
		// main container and set a new scene
		VBox workoutStatsContainer = new VBox();
		SetWorkoutScene ws = new SetWorkoutScene();
		workoutStatsContainer.getChildren().add(userErrorLabel);
		VBox.setMargin(userErrorLabel, new Insets(10, 10, 10, 10));

		if (typeChoiceBox.getValue() == "Cardio") {
			applicationStage.setTitle("Log " + " " + chooseUserChoiceBox.getValue() + " 's" + " Cardio Workout");
			userErrorLabel.setText("Enter Cardio Workout Stats: ");
			Button submitStats = new Button("Submit Cardio Stats");
			VBox.setMargin(submitStats, new Insets(10, 10, 10, 10));
			workoutStatsContainer.getChildren().addAll(ws.setDistance(), ws.setDuration(), ws.setCalories(), ws.setFitnessDate(),
					submitStats, resultsLabel, mileageLabel);

			submitStats.setOnAction(cardioEvent -> calculateCardio( viewUser, ws.getDistance(),
					ws.getDurationTextField(), ws.getCaloriesTextfield(), typeChoiceBox, 
					ws.getYear(), ws.getMonth(), ws.getDay()));

		} else if (typeChoiceBox.getValue() == "Weight Training") {
			applicationStage.setTitle("Log " + " " + chooseUserChoiceBox.getValue() + " 's" + "Strength Workout");
			userErrorLabel.setText("Enter Strength Workout Stats: ");
			Button submitWeightStats = new Button("Submit Strength Stats");
			VBox.setMargin(submitWeightStats, new Insets(10, 10, 10, 10));
			workoutStatsContainer.getChildren().addAll(ws.setCalories(), ws.setDuration(), ws.setIntensity(), ws.setFitnessDate(),
					submitWeightStats, resultsLabel);

			submitWeightStats.setOnAction(weightEvent -> calculateStrength( viewUser,
					ws.getCaloriesTextfield(), ws.getDurationTextField(), ws.getIntensityChoiceBox(),
					typeChoiceBox, ws.getYear(), ws.getMonth(), ws.getDay()));
		}
		VBox.setMargin(resultsLabel, new Insets(10, 10, 0, 10));
		VBox.setMargin(mileageLabel, new Insets(10, 0, 10,10));
		Button doneButton = new Button("Done");
		VBox.setMargin(doneButton, new Insets(10, 10, 10, 10));
		workoutStatsContainer.getChildren().add(doneButton);
		
		doneButton.setOnAction(doneEvent -> applicationStage.setScene(returnUserScene));
		Scene workoutStatsScene = new Scene(workoutStatsContainer);
		applicationStage.setScene(workoutStatsScene);

	}
	
	 
	private Cardio cardioWorkout;
	/**
	 *  This method will create a new Cardio object. The new cardio workout will be compared
	 * to the goals entered by the user. If a goal is achieved the achievement message will 
	 * be printed to the user on the GUI.
	 * 
	 * @param viewUser the current user
	 * @param distanceTextField a string distance value entered by the user on the GUI
	 * @param durationTextField a string duration value entered by the user on the GUI
	 * @param caloriesTextfield a string calorie value entered by the user on the GUI
	 * @param typeChoiceBox a string workout type value entered by the user on the GUI
	 * @param yearTextField a string year value entered by the user on the GUI
	 * @param monthTextField a string month value entered by the user on the GUI
	 * @param dayTextField a string day value entered by the user on the GUI
	 */
	private void calculateCardio(User viewUser, TextField distanceTextField, TextField durationTextField,
			TextField caloriesTextfield, ChoiceBox<String> typeChoiceBox, TextField yearTextField, TextField monthTextField, TextField dayTextField) {
		boolean error = false;
		
		try {
			// This instance variable is an allowed privacy leak
			
			cardioWorkout = new Cardio(distanceTextField.getText(), durationTextField.getText(),
					caloriesTextfield.getText());
			cardioWorkout.setDate(yearTextField.getText(), monthTextField.getText(), dayTextField.getText());
			
			cardioWorkout.setWorkoutType(typeChoiceBox.getValue());
			//cardioWorkout.setWorkout(cardioWorkout);
			
			// add the new cardio workout to user's history
			viewUser.setCardioHistory(cardioWorkout);
			
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
			// Calculate the mileage/pace and prints results to user
			resultsLabel.setText(cardioWorkout.paceToString());
			mileageLabel.setText(cardioWorkout.calculateMileage());
		}

	}

	
	private Strength strWorkout;
	/**
	 * This method will take in the user's input from the GUI and check if the use
	 * has entered a number.If there are no error's in input the scene will 
	 * change back to the user's main scene.
	 * 
	 * @param viewUser the current user
	 * @param caloriesTextfield a string calorie value entered by the user on the GUI
	 * @param durationTextfield a string duration value entered by the user on the GUI
	 * @param workoutIntensityChoiceBox a string intensity value entered by the user on the GUI
	 * @param typeChoiceBox a string workout type value entered by the user on the GUI
	 * @param yearTextfield a string year value entered by the user on the GUI
	 * @param monthTextfield a string month value entered by the user on the GUI
	 * @param dayTextField a string day value entered by the user on the GUI
	 */
	void calculateStrength(User viewUser, TextField caloriesTextfield,
			TextField durationTextfield, ChoiceBox<String> workoutIntensityChoiceBox, ChoiceBox<String> typeChoiceBox, TextField yearTextfield, TextField monthTextfield, TextField dayTextField) {

		boolean error = false;
		try {
			// this can be reset each time (not a privacy leak)
			strWorkout = new Strength(durationTextfield.getText(), caloriesTextfield.getText(),
					workoutIntensityChoiceBox.getValue());
			strWorkout.setDate(yearTextfield.getText(), monthTextfield.getText(), dayTextField.getText());
			strWorkout.setWorkoutType(typeChoiceBox.getValue());
			
			
			// add the new strength workout to user's history
			viewUser.setStrengthHistory(strWorkout);
			
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
			// calculate the calories burned per hour
			resultsLabel.setText(" Strength workout has been submitted");
		}
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

		// Get the input from the user
		String user = chooseUserChoiceBox.getValue();

		// Change the scene to add a new user to the ChoiceBox
		if (user.equals("Add a User")) {
			applicationStage.setTitle("Get Fit");
			User nu = new User();

			VBox newUserContainer = new VBox();
			Button doneButton = new Button("Enter Here");
			VBox.setMargin(doneButton, new Insets(10, 10, 10, 10));
			doneButton.setOnAction(doneEvent -> setNewUser(mainScene, nu.getNewUserTextfield(), nu));

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
			Label returnUserLabel = new Label("Welcome to Get Fit " + user + " !");
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
			Button seeWorkoutsButton = new Button("See Workout History");
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
