package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * This class creates the containers for the entering goals scene. The Users
 * will be able to enter their numerical goal input on the GUI.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class SetGoalsScene {
	private TextField durationGoalTextfield;
	private TextField distanceTextfield;
	private TextField calorieGoalTextfield;

	// This method creates a container for setting user's duration goals
	public HBox setDurationGoal() {

		HBox durationGoalContainer = new HBox();
		Label durationGoalLabel = new Label("Workout Duration Goal: ");
		HBox.setMargin(durationGoalLabel, new Insets(10, 10, 10, 10));
		durationGoalTextfield = new TextField();
		HBox.setMargin(durationGoalTextfield, new Insets(10, 10, 10, 10));
		Label durationMinLabel = new Label("minutes");
		HBox.setMargin(durationMinLabel, new Insets(10, 10, 10, 10));
		durationGoalContainer.getChildren().addAll(durationGoalLabel, durationGoalTextfield, durationMinLabel);

		return durationGoalContainer;
	}

	public TextField getDurationGoalTextfield() {
		return durationGoalTextfield;
	}

	// This method creates a container for setting user's weight goal
	public HBox setTargetWeight() {

		HBox targetWeightContainer = new HBox();
		Label targetWeightLabel = new Label("Target Distance Goal: ");
		HBox.setMargin(targetWeightLabel, new Insets(10, 10, 10, 10));
		distanceTextfield = new TextField();
		HBox.setMargin(distanceTextfield, new Insets(10, 10, 10, 10));
		Label unitsLabel = new Label("km");
		HBox.setMargin(unitsLabel, new Insets(10, 10, 10, 10));
		targetWeightContainer.getChildren().addAll(targetWeightLabel, distanceTextfield, unitsLabel);

		return targetWeightContainer;
	}

	public TextField getWeightGoalTextfield() {
		return distanceTextfield;
	}

	// This method creates a container for setting the user's calorie goal
	public HBox setCalorieGoal() {

		HBox calorieGoalContainer = new HBox();
		Label calorieGoalLabel = new Label("Calories Burned Goal: ");
		HBox.setMargin(calorieGoalLabel, new Insets(10, 10, 10, 10));
		calorieGoalTextfield = new TextField();
		HBox.setMargin(calorieGoalTextfield, new Insets(10, 10, 10, 10));
		Label unitsLabel1 = new Label("calories");
		HBox.setMargin(unitsLabel1, new Insets(10, 10, 10, 10));

		calorieGoalContainer.getChildren().addAll(calorieGoalLabel, calorieGoalTextfield, unitsLabel1);

		return calorieGoalContainer;
	}

	public TextField getCalorieGoalTextfield() {
		return calorieGoalTextfield;
	}
}
