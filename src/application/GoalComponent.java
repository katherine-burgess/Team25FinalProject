package application;

import java.util.ArrayList;

/**
 * This class will take in the user's goals and save them. If the user achieves
 * a goal, the goal will be saved into an ArrayList of achieved goals. This
 * class will keep count of how many goals the user has achieved and how many
 * goals the user is working towards.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class GoalComponent {

	// Instance Variables
	private double targetWeight;
	private double durationGoal;
	private double calorieGoal;

	private GoalComponent goals;

	// This constructor takes in the three goal components and validates the input
	public GoalComponent(String duration, String weight, String calorie) throws InvalidEntryException {
		try {
			this.durationGoal = Double.parseDouble(duration);
			targetWeight = Double.parseDouble(weight);
			calorieGoal = Double.parseDouble(calorie);

			if (this.durationGoal < 0 || this.durationGoal > 300) {
				throw new InvalidEntryException(
						String.format("Duration of workout can only be between 0 and 300 minutes"));
			}
			if (targetWeight < 0 || targetWeight > 300) {
				throw new InvalidEntryException(String.format("Target weight can only be between 0 and 300 lbs"));
			}
			if (calorieGoal < 0 || calorieGoal > 1000) {
				throw new InvalidEntryException(
						String.format("A new calorie goal can't be less than 0 or greater than 1000 calories. "));
			}

		} catch (NumberFormatException e) {
			throw new InvalidEntryException(String.format("Invalid Goal Entry %d. Make sure to enter a number."));
		}
	}

	// Copy constructor
	public GoalComponent(GoalComponent newGoal) {
		goals = newGoal.goals;
	}

	public double getDurationGoal() {
		return this.durationGoal;
	}

	public double getTargetWeight() {
		return targetWeight;
	}

	public double getCalorieGoal() {
		return calorieGoal;
	}

	// This method will log the goals
	public void setGoals(GoalComponent newGoal) {
		goals = new GoalComponent(newGoal);
	}

	public GoalComponent getGoals() {
		return goals;
	}

//			// check if the instance variable is null
//			if ( stats != null) {
//				goals.compareTo(stats);
//			}
//		}

	// Will create a string containing all of the inputed goals
	public String toString() {
		String goal = "Duration: " + getDurationGoal() + " minutes " + '\n' + "Target Weight: " + getTargetWeight()
				+ " lbs " + '\n' + "Calories Burned Goal: " + getCalorieGoal() + " calories ";

		return goal;
	}

}
