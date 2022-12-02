package application;

import java.util.ArrayList;

/**
 * This class will take in the user's goals and save them. If the user achieves a goal, the goal will 
 * be saved into an ArrayList of achieved goals. This class will keep count of how many goals the user 
 * has achieved and how many goals the user is working towards.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class GoalComponent {

	// Instance Variables
	private double targetWeight;
	private long durationGoal;
	private String intensityGoal;
	private double calorieGoal;
	private String goals;
	private ArrayList<GoalComponent> achievedGoals;
	private int numAchieved = 0;

	public GoalComponent(GoalComponent goalList) {
		achievedGoals = new ArrayList<GoalComponent>();
	}
	
	public int getAchieved() {
		return numAchieved;
	}
	// This constructor takes in the four goal components and validates the input
	public GoalComponent(String duration, String weight, String calorie, String intensity) throws InvalidEntryException {
		try {
			this.durationGoal = Long.parseLong(duration);
			targetWeight = Double.parseDouble(weight);
			calorieGoal = Double.parseDouble(calorie);
			intensityGoal = intensity;

			if (this.durationGoal < 0 || this.durationGoal > 300) {
				throw new InvalidEntryException(
						String.format("Duration of workout can only be between 0 and 300 minutes"));
			}
			if (targetWeight < 0 || targetWeight > 300) {
				throw new InvalidEntryException(
						String.format("Target weight can only be between 0 and 300 lbs"));
			}
			if (calorieGoal < 0 || calorieGoal > 1000) {
				throw new InvalidEntryException(String.format("A new calorie goal can't be less than 0 or greater than 1000 calories. "));
			}

		} catch (NumberFormatException e) {
			throw new InvalidEntryException(String.format("Invalid Goal Entry. Make sure to enter a number."));
		}
	}

	public long getDurationGoal() {
		return this.durationGoal;
	}

	public double getTargetWeight() {
		return targetWeight;
	}

	public double getCalorieGoal() {
		return calorieGoal;
	}

	public String getIntensityGoal() {
		return intensityGoal;
	}


	// Will create a string containing all of the inputed goals
	public String toString() {
		goals = "Duration: " + getDurationGoal() + " minutes " + '\n' + "Target Weight: " + getTargetWeight() + " lbs " + '\n'
				+ "Intensity Goal: " + getIntensityGoal() + '\n' + "Calories Burned Goal: " + getCalorieGoal() + " calories ";

		return goals;
	}

	public void compareTo(WorkoutComponent workoutStats) {
		
		
	}

}
