package application;

import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * This class creates the containers for the workout scene. User's will be able
 * to enter in their numerical and ChoiceBox input based on their workout
 * statistics.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class SetWorkoutScene {

	// Instance variables for strength workout entry
	private TextField durationTextfield;
	private ChoiceBox<String> intensityChoiceBox;
	private TextField caloriesTextfield;
	private TextField yearTextfield;
	private TextField monthTextfield;
	private TextField dayTextfield;
	
	// Instance variables for cardio workout entry
	private TextField distanceTextfield;

	/**
	 *  This method will create a container for the user to enter distance
	 * @return cardioDistanceContainer
	 */
	public HBox setDistance() {
		HBox cardioDistanceContainer = new HBox();
		Label cardioDistanceLabel = new Label("Distance: ");
		HBox.setMargin(cardioDistanceLabel, new Insets(10, 10, 10, 10));
		distanceTextfield = new TextField();
		HBox.setMargin(distanceTextfield, new Insets(10, 10, 10, 10));
		Label cardioUnitsLabel = new Label("Km");
		HBox.setMargin(cardioUnitsLabel, new Insets(10, 10, 10, 10));
		cardioDistanceContainer.getChildren().addAll(cardioDistanceLabel, distanceTextfield, cardioUnitsLabel);
		return cardioDistanceContainer;
	}

	public TextField getDistance() {
		return distanceTextfield;
	}

	/**
	 *  This method will create a container for the duration of a workout
	 * @return durationContainer
	 */
	public HBox setDuration() {
		// Container for duration of workout
		HBox durationContainer = new HBox();
		Label durationLabel = new Label("Duration : ");
		HBox.setMargin(durationLabel, new Insets(10, 10, 10, 10));
		durationTextfield = new TextField();
		HBox.setMargin(durationTextfield, new Insets(10, 10, 10, 10));
		Label durationMinLabel = new Label("minutes");
		HBox.setMargin(durationMinLabel, new Insets(10, 10, 10, 10));
		durationContainer.getChildren().addAll(durationLabel, durationTextfield, durationMinLabel);

		return durationContainer;

	}

	public TextField getDurationTextField() {
		return durationTextfield;
	}

	/**
	 *  This method will create a container for the workout intensity. 
	 * @return workoutIntensityContainer
	 */
	public HBox setIntensity() {

		HBox workoutIntensityContainer = new HBox();
		Label workoutIntensityLabel = new Label("Intensity : ");
		HBox.setMargin(workoutIntensityLabel, new Insets(10, 10, 10, 10));
		intensityChoiceBox = new ChoiceBox<String>(); // add padding to the ChoiceBox
		HBox.setMargin(intensityChoiceBox, new Insets(10, 10, 10, 10));
		intensityChoiceBox.getItems().add("Easy");
		intensityChoiceBox.getItems().add("Medium");
		intensityChoiceBox.getItems().add("Hard");
		workoutIntensityContainer.getChildren().addAll(workoutIntensityLabel, intensityChoiceBox);

		return workoutIntensityContainer;
	}

	public ChoiceBox<String> getIntensityChoiceBox() {
		return intensityChoiceBox;
	}

	/**
	 *  This method will create a container for calories burned
	 * @return caloriesContainer
	 */
	public HBox setCalories() {

		HBox caloriesContainer = new HBox();
		Label caloriesBurnedLabel = new Label("Calories Burned :");
		HBox.setMargin(caloriesBurnedLabel, new Insets(10, 10, 10, 10));
		caloriesTextfield = new TextField();
		HBox.setMargin(caloriesTextfield, new Insets(10, 10, 10, 10));
		Label caloriesLabel = new Label("calories");
		HBox.setMargin(caloriesLabel, new Insets(10, 10, 10, 10));
		caloriesContainer.getChildren().addAll(caloriesBurnedLabel, caloriesTextfield, caloriesLabel);

		return caloriesContainer;
	}

	public TextField getCaloriesTextfield() {
		return caloriesTextfield;
	}

	/**
	 * This method creates the container for the user to enter in dates associated with 
	 * the workout log
	 * 
	 * @return fitnessDateContainer 
	 */
	public HBox setFitnessDate() {
		
		HBox fitnessDateContainer = new HBox();
		Label dateLabel = new Label("Enter Date (Year/Month/Day) : ");
		HBox.setMargin(dateLabel, new Insets(10,10,10,10));
		yearTextfield = new TextField();
		HBox.setMargin(yearTextfield, new Insets(10,10,10,10));
		monthTextfield = new TextField();
		HBox.setMargin(monthTextfield, new Insets(10,10,10,10));
		dayTextfield = new TextField();
		HBox.setMargin(dayTextfield, new Insets(10,10,10,10));
		fitnessDateContainer.getChildren().addAll(dateLabel, yearTextfield, monthTextfield, dayTextfield);
		return fitnessDateContainer;
	}
	
	public TextField getYear() {
		return yearTextfield;
	}
	
	public TextField getMonth() {
		return monthTextfield;
	}
	
	public TextField getDay() {
		return dayTextfield;
	}
}
