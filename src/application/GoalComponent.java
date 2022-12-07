package application;

import java.util.ArrayList;

/**
 * This class will take in the user's goals and save them for 
 * later comparison with the user's incoming workout stats. 
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class GoalComponent {

	// Instance Variables
	private double distanceGoal;
	private double durationGoal;
	private double calorieGoal;

	private GoalComponent goals;

	/**
	 *  This constructor takes in the three goal components and validates the input. If the 
	 *  input is not a number an Invalid Entry Exception will be thrown with a specific error 
	 *  message to the user.
	 *  
	 * @param duration a string duration goal value entered by the user
	 * @param distance a string distance goal value entered by the user
	 * @param calorie a string calorie goal value entered by the user
	 * @throws InvalidEntryException when non numerical input is entered
	 */
	public GoalComponent(String duration, String distance, String calorie) throws InvalidEntryException {
		try {
			durationGoal = Double.parseDouble(duration);
			distanceGoal = Double.parseDouble(distance);
			calorieGoal = Double.parseDouble(calorie);

			if (durationGoal < 0 || durationGoal > 300) {
				throw new InvalidEntryException(
						String.format("Duration of workout can only be between 0 and 300 minutes. "));
			}
			if (distanceGoal < 0 || distanceGoal > 80) {
				throw new InvalidEntryException(String.format("Target distance can only be between 0 and 80 km. "));
			}
			if (calorieGoal < 0 || calorieGoal > 1000) {
				throw new InvalidEntryException(
						String.format("A new calorie goal can't be less than 0 or greater than 1000 calories. "));
			}

		} catch (NumberFormatException e) {
			throw new InvalidEntryException(String.format("Invalid Goal Entry. Make sure to enter a number."));
		}
	}

	// Copy constructor
	public GoalComponent(GoalComponent newGoal) {
		if (newGoal != null) {
			goals = newGoal.goals;
		}
	}

	public double getDurationGoal() {
		return durationGoal;
	}

	public double getDistanceGoal() {
		return distanceGoal;
	}

	public double getCalorieGoal() {
		return calorieGoal;
	}

	// This method will log the goals
	public void setGoals(GoalComponent newGoal) {
		goals = newGoal;
	}

	public GoalComponent getGoals() {
		return goals;
	}


	/** 
	 * Will create a string containing all of the inputed goals by user
	 */
	public String toString() {
		String goal = "Target Duration: " + getDurationGoal() + " minutes " + '\n' + "Target Distance: " + getDistanceGoal()
				+ " km " + '\n' + "Target Calories Burned: " + getCalorieGoal() + " calories " ;
		return goal;
	}

}
