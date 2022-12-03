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
		String[] quoteArray = new String[] { "Progress, not perfection.",
				"Find your joy.", "This is the moment to begin.",
				"Goal setting is the secret to a compelling future." };
		int rndQuote = new Random().nextInt(quoteArray.length);
		return quoteArray[rndQuote];
		// this function could be placed in a new class 
	}

	/**
	 *  This method will get the user's workout history. If the user hasn't previously entered 
	 *  any workout logs, a message will be printed to the user on the GUI. If the user has logged previous 
	 *  workouts, the user will be able to see their history.
	 *  
	 * @param event an Action Event that occurs when the user presses the exit button
	 * @param returnUserScene the current user's main welcome scene
	 * @param viewUser the current user 
	 */
	void showLog( ActionEvent event, Scene returnUserScene, User viewUser) {
		userWorkoutLabel.setText(" ");
		try {
			
			VBox statsContainer = new VBox();
			Button exitButton = new Button("Exit");
			VBox.setMargin(exitButton, new Insets(10,10,10,10));
			statsContainer.getChildren().addAll(userWorkoutLabel, exitButton);
			if (viewUser.getNumWorkouts() > 0) {
				userWorkoutLabel.setText(viewUser.toString());
				
				VBox.setMargin(userWorkoutLabel, new Insets(10,10,10,10));
			} else if (viewUser.getNumWorkouts() == 0){
				userWorkoutLabel.setText("No Workout History. Exit and Log a Workout.");
				VBox.setMargin(userWorkoutLabel, new Insets(10,10,10,10));
			}
			exitButton.setOnAction(exitEvent -> applicationStage.setScene(returnUserScene));
			
			Scene statsScene = new Scene(statsContainer);
			applicationStage.setScene(statsScene);
			
		} catch (NullPointerException npe) {}
		
	}
	
	
	/**
	 * This method will set up a new user in the application. The method will
	 * validate that the user name is alphabetic, if the user has entered a proper
	 * user name the application will add the new user to the ChoiceBox.
	 * 
	 * @param mainScene 
	 * @param newUserTextfield string value entered by the user
	 */
	void setNewUser(Scene mainScene, TextField newUserTextfield) {
		userErrorLabel.setText(" ");

		// creates a new user object
		User newUser = new User(" ");

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
	 * This method will take in the user's input from the GUI and check if the use has entered a number. The method will check 
	 * if the user has entered a number, if not the GUI will return a specific error message to the user. If there are
	 * no error's in input the scene will change back to the user's main welcome screen.
	 * 
	 * @param returnUserScene the current user's main welcome scene
	 * @param viewUser the current user
	 * @param caloriesTextfield a string value entered by the user
	 * @param durationTextfield a string value entered by the user
	 * @param workoutIntensityChoiceBox a string value entered by the user
	 * @param workoutTypeChoiceBox a string value entered by the user
	 * @param weightTextfield a string value entered by the user
	 */
	void calculateWorkout(Scene returnUserScene, User viewUser, TextField caloriesTextfield,
			TextField durationTextfield, ChoiceBox<String> workoutIntensityChoiceBox,
			ChoiceBox<String> workoutTypeChoiceBox, TextField weightTextfield) {

		boolean error = false;
		try {
			// associate the workout stats with the user
			WorkoutComponent workout = new WorkoutComponent(caloriesTextfield.getText(), durationTextfield.getText(),
					workoutIntensityChoiceBox.getValue(), workoutTypeChoiceBox.getValue(), weightTextfield.getText());
//			viewUser.logWorkout(caloriesTextfield.getText(), durationTextfield.getText(),
//					workoutIntensityChoiceBox.getValue(), workoutTypeChoiceBox.getValue(), weightTextfield.getText());

		} catch (InvalidEntryException e) {
			userErrorLabel.setText(e.getMessage()); // shows error message to the user
			error = true;
		}
		if (!error) {
			applicationStage.setScene(returnUserScene);
		}
	}

	/**
	 * This method will take the user's input from the GUI and print the goals to the user. The method will 
	 * check if the user has entered a number. If not an error message will be shown.
	 * 
	 * @param returnUserScene the returning user's main welcome scene
	 * @param viewUser the current user
	 * @param durationTextfield string value entered by the user 
	 * @param targetWeightTextfield string value entered by the user
	 * @param calorieGoalTextfield string value entered by the user
	 * @throws InvalidEntryException catches if the user enters anything not numerical
	 */
	void calculateGoals(Scene returnUserScene, User viewUser, TextField durationTextfield,
			TextField targetWeightTextfield, TextField calorieGoalTextfield)
			throws InvalidEntryException {
		
		boolean error = false;
		viewUser.logGoals(durationTextfield.getText(), targetWeightTextfield.getText(), calorieGoalTextfield.getText());

		if (!error) {
			applicationStage.setScene(returnUserScene);
			printGoalsLabel.setText(chooseUserChoiceBox.getValue() + "'s Goals: ");
			userGoalLabel.setText(viewUser.getGoals());
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
	 */
	void getWorkoutScene(ActionEvent event, Scene returnUserScene, User viewUser) {

		applicationStage.setTitle("Log" + " " + chooseUserChoiceBox.getValue() + " " + "Workout Stats");

		// main container
		VBox workoutStatsContainer = new VBox();

		SetWorkoutScene ws = new SetWorkoutScene();

		Button submitStats = new Button("Done");
		VBox.setMargin(submitStats, new Insets(10, 10, 10, 10));
		workoutStatsContainer.getChildren().addAll(ws.setWorkoutType(), ws.setDuration(), ws.setIntensity(),
				ws.setCalories(), ws.setWeight(), submitStats);

		workoutStatsContainer.getChildren().add(userErrorLabel);

		// when user is done inputting statistics, return to user's home page
		submitStats.setOnAction(doneEvent -> calculateWorkout(returnUserScene, viewUser, ws.getCaloriesTextfield(),
				ws.getDurationTextField(), ws.getIntensityChoiceBox(), ws.getWorkoutChoiceBox(), ws.getWeightTextfield()));

		Scene workoutStatsScene = new Scene(workoutStatsContainer);
		applicationStage.setScene(workoutStatsScene);
		
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

		// Set the title of the scene based on the user
		applicationStage.setTitle("Log" + " " + chooseUserChoiceBox.getValue() + " " + "Goals");

		VBox workoutGoalsContainer = new VBox();
		
		SetGoalsScene gs = new SetGoalsScene();
		
		Button submitGoals = new Button("Done");
		VBox.setMargin(submitGoals, new Insets(10, 10, 10, 10));
		workoutGoalsContainer.getChildren().addAll(gs.setDurationGoal(), gs.setTargetWeight(), gs.setCalorieGoal(), submitGoals);
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
	 * user that will be added to the ChoiceBox for later entry or sign in as a previous user.
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

			VBox newUserContainer = new VBox();

			HBox newUserTitle = new HBox();
			Label newUserLabel = new Label("Add a New User");
			HBox.setMargin(newUserLabel, new Insets(10,10,10,10));
			newUserTitle.getChildren().add(newUserLabel);

			// Container for entering user name
			HBox userNameContainer = new HBox();
			Label userNameLabel = new Label("Enter New Username:");
			HBox.setMargin(userNameLabel, new Insets(10,10,10,10));
			TextField newUserTextfield = new TextField();
			HBox.setMargin(newUserTextfield, new Insets(10,10,10,10));
			userNameContainer.getChildren().addAll(userNameLabel, newUserTextfield);

			Button doneButton = new Button("Enter Here");
			VBox.setMargin(doneButton, new Insets(10,10,10,10));
			doneButton.setOnAction(doneEvent -> setNewUser(mainScene, newUserTextfield));

			newUserContainer.getChildren().addAll(newUserTitle, userNameContainer, doneButton);

			newUserContainer.getChildren().add(userErrorLabel);
			VBox.setMargin(userErrorLabel, new Insets(10,10,10,10));
			Scene addUserScene = new Scene(newUserContainer);
			applicationStage.setScene(addUserScene); // places the new scene on the stage

		} else {

			User viewUser = new User(chooseUserChoiceBox.getValue());
			// Creates a new workout history for the user
			viewUser.newHistory();

			// will generate the returning user welcome page
			VBox returnUserContainer = new VBox();

			// Title changes based on the user that is entered
			applicationStage.setTitle(user + "'s Get Fit");

			Scene returnUserScene = new Scene(returnUserContainer);
			Label returnUserLabel = new Label("Welcome " + user + " !"); // this will change will change based on what
																			// user is chosen
			VBox.setMargin(returnUserLabel, new Insets(10, 10, 10, 10));
			Label activityLabel = new Label("How were you active today?");
			VBox.setMargin(activityLabel, new Insets(10, 10, 10, 10));

			viewUser.getDoneButton().setOnAction(doneEvent -> getWorkoutScene(event, returnUserScene, viewUser)); 
			viewUser.getGoalsButton().setOnAction(goalsEvent -> getGoalScene(event, returnUserScene, viewUser));
			
			returnUserContainer.getChildren().addAll(returnUserLabel, activityLabel, viewUser.setWorkoutContainer(),
					viewUser.setGoalsContainer(), printGoalsLabel, userGoalLabel);
			VBox.setMargin(printGoalsLabel, new Insets(0,0,0,10));
			VBox.setMargin(userGoalLabel, new Insets(5,0,0,10));

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
