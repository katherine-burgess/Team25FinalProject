package application;

import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SetWorkoutScene {
	
	private ChoiceBox<String> workoutTypeChoiceBox;
	private TextField durationTextfield;
	private ChoiceBox<String> intensityChoiceBox;
	private TextField caloriesTextfield;
	private TextField weightTextfield;
	
	
	// This method will create a container for the user to choose a workoutType
	public HBox setWorkoutType() {
	
		HBox workoutTypeContainer = new HBox();
		Label workoutTypeLabel = new Label("Workout Type : ");
		HBox.setMargin(workoutTypeLabel, new Insets(10, 10, 10, 10));
		workoutTypeChoiceBox = new ChoiceBox<String>(); // add padding to the ChoiceBox
		HBox.setMargin(workoutTypeChoiceBox, new Insets(10, 10, 10, 10));
		workoutTypeChoiceBox.getItems().add("Cardio");
		workoutTypeChoiceBox.getItems().add("Weight Training");
		workoutTypeContainer.getChildren().addAll(workoutTypeLabel, workoutTypeChoiceBox);
		
		return workoutTypeContainer;
		
	}
	
	public ChoiceBox<String> getWorkoutChoiceBox(){
		return workoutTypeChoiceBox;
	}
	
	// This method will create a container for the duration of a workout
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
	
	// This method will create a container for the workout intensity
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
	
	public ChoiceBox<String> getIntensityChoiceBox(){
		return intensityChoiceBox;
	}
	
	// This method will create a container for calories burned
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
	
	// This method will create a container for weight entry
	public HBox setWeight() {
		
		HBox weightContainer = new HBox();
		Label weightLabel = new Label("Weight :");
		HBox.setMargin(weightLabel, new Insets(10, 10, 10, 10));
		weightTextfield = new TextField();
		HBox.setMargin(weightTextfield, new Insets(10, 10, 10, 10));
		weightContainer.getChildren().addAll(weightLabel, weightTextfield);
		
		return weightContainer;
	}
	
	public TextField getWeightTextfield() {
		return weightTextfield;
	}
}
