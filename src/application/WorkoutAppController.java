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

public class WorkoutAppController {
	Stage applicationStage;

	@FXML
	private Label inspirationQuoteLabel;

	@FXML
	private ChoiceBox<String> chooseUserChoiceBox;

	Label userErrorLabel = new Label();

	Label userGoalLabel = new Label();

	// Get a randomly generated quote and returns the string at the random index
	// https://stackoverflow.com/questions/8065532/how-to-randomly-pick-an-element-from-an-array
	public static String getRandomQuote() {
		String[] quoteArray = new String[] { "Progress, not perfection.",
				"It's our choices that show what we truly are, far more than our abilities.",
				"Goal setting is the secret to a compelling future." };
		int rndQuote = new Random().nextInt(quoteArray.length);
		return quoteArray[rndQuote];
		// this function could be placed in a new class (inheritance call)
	}

	/**
	 * This method will set up a new user in the application. The method will
	 * validate that the user name is alphabetic, if the user has entered a proper
	 * user name the application will add the new user to the ChoiceBox.
	 * 
	 * @param mainScene
	 * @param newUserTextfield
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
	 * This method will take in the user's input from the GUI and check if the user
	 * has entered a number. The method will check if the user has entered a number,
	 * if not the GUI will return a specific error message to the user. If there are
	 * no error's in input the scene will change back to the user's main welcome
	 * screen.
	 * 
	 * @param returnUserScene
	 * @param caloriesTextfield
	 * @param durationTextfield
	 * @param workoutIntensityChoiceBox
	 * @param workoutTypeChoiceBox
	 */
	void calculateWorkout(Scene returnUserScene, TextField caloriesTextfield, TextField durationTextfield,
			ChoiceBox<String> workoutIntensityChoiceBox, ChoiceBox<String> workoutTypeChoiceBox) {
		// creation of user object
		User viewUser = new User(chooseUserChoiceBox.getValue());

		boolean error = false;
		try {
			// associate the workout stats with the use
			viewUser.logWorkout(caloriesTextfield.getText(), durationTextfield.getText(),
					workoutIntensityChoiceBox.getValue(), workoutTypeChoiceBox.getValue());

		} catch (InvalidEntryException e) {
			userErrorLabel.setText(e.getMessage()); // shows error message to the user
			error = true;
		}
		if (!error) {
			applicationStage.setScene(returnUserScene);
		}
	}

	/**
	 * This method will return the user's goals and print the goals to the user.
	 * This method will create a new Goal Component Object, and check to make sure
	 * that the user has entered a number.
	 * 
	 * @param returnUserScene
	 * @param durationTextfield
	 * @param targetWeightTextfield
	 * @param upperBodyPRTextfield
	 * @param lowerBodyPRTextfield
	 * @throws InvalidEntryException
	 */
	void calculateGoals(Scene returnUserScene, TextField durationTextfield, TextField targetWeightTextfield,
			TextField upperBodyPRTextfield, TextField lowerBodyPRTextfield) throws InvalidEntryException {

		// creation of new user object
		User viewUser = new User(chooseUserChoiceBox.getValue());

		boolean error = false;
		viewUser.logGoals(durationTextfield.getText(), targetWeightTextfield.getText(), upperBodyPRTextfield.getText(),
				lowerBodyPRTextfield.getText());

		if (!error) {
			applicationStage.setScene(returnUserScene);
			userGoalLabel.setText("");
		}

	}

	/**
	 * This method will generate a scene change for the returning user to input
	 * their workout stats. This method will create the containers for user input.
	 * 
	 * @param event
	 * @param returnUserScene
	 */
	void getWorkoutLog(ActionEvent event, Scene returnUserScene) {

		applicationStage.setTitle("Log" + " " + chooseUserChoiceBox.getValue() + " " + "Workout Stats");

		// main container
		VBox workoutStatsContainer = new VBox();

		// Container for choosing a workout type
		HBox workoutTypeContainer = new HBox();
		Label workoutTypeLabel = new Label("Workout Type : ");
		HBox.setMargin(workoutTypeLabel, new Insets(10, 10, 10, 10));
		ChoiceBox<String> workoutTypeChoiceBox = new ChoiceBox<String>(); // add padding to the ChoiceBox
		HBox.setMargin(workoutTypeChoiceBox, new Insets(10, 10, 10, 10));
		workoutTypeChoiceBox.getItems().add("Cardio");
		workoutTypeChoiceBox.getItems().add("Weight Training");
		workoutTypeContainer.getChildren().addAll(workoutTypeLabel, workoutTypeChoiceBox);

		// Container for duration of workout
		HBox durationContainer = new HBox();
		Label durationLabel = new Label("Duration : ");
		HBox.setMargin(durationLabel, new Insets(10, 10, 10, 10));
		TextField durationTextfield = new TextField();
		HBox.setMargin(durationTextfield, new Insets(10, 10, 10, 10));
		Label durationMinLabel = new Label("minutes");
		HBox.setMargin(durationMinLabel, new Insets(10, 10, 10, 10));
		durationContainer.getChildren().addAll(durationLabel, durationTextfield, durationMinLabel);

		// Container for workout intensity
		HBox workoutIntensityContainer = new HBox();
		Label workoutIntensityLabel = new Label("Intensity : ");
		HBox.setMargin(workoutIntensityLabel, new Insets(10, 10, 10, 10));
		ChoiceBox<String> workoutIntensityChoiceBox = new ChoiceBox<String>(); // add padding to the ChoiceBox
		HBox.setMargin(workoutIntensityChoiceBox, new Insets(10, 10, 10, 10));
		workoutIntensityChoiceBox.getItems().add("Easy");
		workoutIntensityChoiceBox.getItems().add("Medium");
		workoutIntensityChoiceBox.getItems().add("Hard");
		workoutIntensityContainer.getChildren().addAll(workoutIntensityLabel, workoutIntensityChoiceBox);

		// Container for calories burned
		HBox caloriesContainer = new HBox();
		Label caloriesBurnedLabel = new Label("Calories Burned :");
		HBox.setMargin(caloriesBurnedLabel, new Insets(10, 10, 10, 10));
		TextField caloriesTextfield = new TextField();
		HBox.setMargin(caloriesTextfield, new Insets(10, 10, 10, 10));
		Label caloriesLabel = new Label("calories");
		HBox.setMargin(caloriesLabel, new Insets(10, 10, 10, 10));
		caloriesContainer.getChildren().addAll(caloriesBurnedLabel, caloriesTextfield, caloriesLabel);

		Button submitStats = new Button("Done");
		VBox.setMargin(submitStats, new Insets(10, 10, 10, 10));
		workoutStatsContainer.getChildren().addAll(workoutTypeContainer, durationContainer, workoutIntensityContainer,
				caloriesContainer, submitStats);

		workoutStatsContainer.getChildren().add(userErrorLabel);

		// when user is done inputting stats, return to user's home page
		submitStats.setOnAction(doneEvent -> calculateWorkout(returnUserScene, caloriesTextfield, durationTextfield,
				workoutIntensityChoiceBox, workoutTypeChoiceBox));

		Scene workoutStatsScene = new Scene(workoutStatsContainer);
		applicationStage.setScene(workoutStatsScene);
		;
	}

	/**
	 * This method generates the scene change for goal input. The user will be able
	 * to enter in their workout goals onto the GUI interface.
	 * 
	 * @param event
	 * @param returnUserScene
	 */
	void getGoalLog(ActionEvent event, Scene returnUserScene) {

		applicationStage.setTitle("Log" + " " + chooseUserChoiceBox.getValue() + " " + "Goals");

		// main container
		VBox workoutGoalsContainer = new VBox();

		// User can enter goals for target body weight, duration, personal weight record
		// for upper and lower body

		// Container for entering duration target goals
		HBox durationGoalContainer = new HBox();
		Label durationGoalLabel = new Label("Workout Duration Goal");
		HBox.setMargin(durationGoalLabel, new Insets(10, 10, 10, 10));
		TextField durationTextfield = new TextField();
		HBox.setMargin(durationTextfield, new Insets(10, 10, 10, 10));
		Label durationMinLabel = new Label("minutes");
		HBox.setMargin(durationMinLabel, new Insets(10, 10, 10, 10));
		durationGoalContainer.getChildren().addAll(durationGoalLabel, durationTextfield, durationMinLabel);

		// Container for entering target body weight
		HBox targetWeightContainer = new HBox();
		Label targetWeightLabel = new Label("Target Weight Goal");
		HBox.setMargin(targetWeightLabel, new Insets(10, 10, 10, 10));
		TextField targetWeightTextfield = new TextField();
		HBox.setMargin(targetWeightTextfield, new Insets(10, 10, 10, 10));
		targetWeightContainer.getChildren().addAll(targetWeightLabel, targetWeightTextfield);

		// Container for entering personal weight record upper body
		HBox upperBodyPRContainer = new HBox();
		Label upperBodyPRLabel = new Label("Upper Body PR Goal");
		HBox.setMargin(upperBodyPRLabel, new Insets(10, 10, 10, 10));
		TextField upperBodyPRTextfield = new TextField();
		HBox.setMargin(upperBodyPRTextfield, new Insets(10, 10, 10, 10));
		upperBodyPRContainer.getChildren().addAll(upperBodyPRLabel, upperBodyPRTextfield);

		// Container for entering personal weight record lower body
		HBox lowerBodyPRContainer = new HBox();
		Label lowerBodyPRLabel = new Label("Lower Body PR Goal");
		HBox.setMargin(lowerBodyPRLabel, new Insets(10, 10, 10, 10));
		TextField lowerBodyPRTextfield = new TextField();
		HBox.setMargin(lowerBodyPRTextfield, new Insets(10, 10, 10, 10));
		lowerBodyPRContainer.getChildren().addAll(lowerBodyPRLabel, lowerBodyPRTextfield);

		Button submitGoals = new Button("Done");
		VBox.setMargin(submitGoals, new Insets(10, 10, 10, 10));
		workoutGoalsContainer.getChildren().addAll(durationGoalContainer, targetWeightContainer, upperBodyPRContainer,
				lowerBodyPRContainer, submitGoals);

		workoutGoalsContainer.getChildren().add(userErrorLabel);

		// Validates and Changes Scene if the user enters proper input
		submitGoals.setOnAction(doneEvent -> {
			try {
				calculateGoals(returnUserScene, durationTextfield, targetWeightTextfield, upperBodyPRTextfield,
						lowerBodyPRTextfield);
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
	 * @param event
	 */

	@FXML
	void chooseUser(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();

		String inspirationQuote = getRandomQuote();
		inspirationQuoteLabel.setText(inspirationQuote);

		// Get the input from the user
		String user = chooseUserChoiceBox.getValue();

		// Change the scene to add a new user to the ChoiceBox
		if (user.equals("Add a User")) {
			applicationStage.setTitle("Get Fit");

			VBox newUserContainer = new VBox();

			HBox newUserTitle = new HBox();
			Label newUserLabel = new Label("Add a New User");
			newUserTitle.getChildren().add(newUserLabel);

			// Container for entering user name
			HBox userNameContainer = new HBox();
			Label userNameLabel = new Label("Enter New Username:");
			TextField newUserTextfield = new TextField();
			userNameContainer.getChildren().addAll(userNameLabel, newUserTextfield);

			Button doneButton = new Button("Enter Here");
			doneButton.setOnAction(doneEvent -> setNewUser(mainScene, newUserTextfield));

			newUserContainer.getChildren().addAll(newUserTitle, userNameContainer, doneButton);

			newUserContainer.getChildren().add(userErrorLabel);
			Scene addUserScene = new Scene(newUserContainer);
			applicationStage.setScene(addUserScene); // places the new scene on the stage

		} else {

			// will generate the returning user welcome page
			VBox returnUserContainer = new VBox();

			// Title changes based on the user that is entered
			applicationStage.setTitle(user);

			Scene returnUserScene = new Scene(returnUserContainer);

			Label returnUserLabel = new Label("Welcome " + user + " !"); // this will change will change based on what
																			// user is chosen
			VBox.setMargin(returnUserLabel, new Insets(10, 10, 10, 10));
			Label activityLabel = new Label("How were you active today?");
			VBox.setMargin(activityLabel, new Insets(10, 10, 10, 10));

			// Container for logging workout
			HBox workoutContainer = new HBox();
			Label logWorkoutLabel = new Label("Log your new workout");
			HBox.setMargin(logWorkoutLabel, new Insets(10, 10, 10, 10));
			Button doneButton = new Button("Enter Here");
			HBox.setMargin(doneButton, new Insets(10, 10, 10, 10));
			doneButton.setOnAction(doneEvent -> getWorkoutLog(event, returnUserScene));

			workoutContainer.getChildren().addAll(logWorkoutLabel, doneButton);

			// Container for workout goals
			HBox workoutGoalsContainer = new HBox();
			Label logGoalsLabel = new Label("Log your workout goals");
			HBox.setMargin(logGoalsLabel, new Insets(10, 10, 10, 10));
			Button goalsButton = new Button("Enter Goals Here");
			HBox.setMargin(goalsButton, new Insets(10, 10, 10, 10));
			goalsButton.setOnAction(goalsEvent -> getGoalLog(event, returnUserScene));

			workoutGoalsContainer.getChildren().addAll(logGoalsLabel, goalsButton);
			returnUserContainer.getChildren().addAll(returnUserLabel, activityLabel, workoutContainer,
					workoutGoalsContainer);

			workoutGoalsContainer.getChildren().addAll(userGoalLabel);

			applicationStage.setScene(returnUserScene);
		}

	}

}
