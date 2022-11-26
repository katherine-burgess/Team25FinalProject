package application;

/**
 * This class will log the user's workout statistics. The class will check to see that the user has entered a number, 
 * if not a specific error message will be thrown. This class will compare the new workout statistics with the user's goals.
 *  If the workout statistics are better than the goals, the user will receive an achievement message.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class WorkoutComponent {
	// instance variables
	private String workoutType;
	private long duration;
	private String intensity;
	private int caloriesBurned;
	private double weight;

	// Maximum values for each numerical input
	private double durationMax = 300;
	private int calorieMax = 1000;
	private int weightMax = 300;

	// This constructor will check the user input for possible errors, if no errors
	// in input the instance variables will be set.
	// Otherwise an error will be thrown with a specific message to the user.
	public WorkoutComponent(String dur, String calories, String weight, String intensity, String type)
			throws InvalidEntryException {
		try {
			duration = Long.parseLong(dur);
			caloriesBurned = Integer.parseInt(calories);
			this.weight = Double.parseDouble(weight);
			this.intensity = intensity;
			workoutType = type;

			if (duration < 0 || duration > durationMax) {
				throw new InvalidEntryException(
						String.format("Invalid workout duration entry. Enter a number between 0 and %d ", durationMax));
			}

			if (caloriesBurned < 0 || caloriesBurned > calorieMax) {
				throw new InvalidEntryException(
						String.format("Invalid calorie entry. Enter a number between 0 and %d ", calorieMax));
			}

			if (this.weight < 0 || this.weight > weightMax) {
				throw new InvalidEntryException(
						String.format("Invalid weight entry. Enter a number between 0 and %d ", weight));
			}

		} catch (NumberFormatException nfe) {
			throw new InvalidEntryException(String.format("Invalid Workout Entry. Enter a number."));

		}
	}

	public long getDuration() {
		return duration;
	}

	public int getCalories() {
		return caloriesBurned;
	}

	private String getIntensity() {
		return intensity;
	}

	private String getWorkoutType() {
		return workoutType;
	}

	public double getWeight() {
		return weight;
	}

	// Gets the duration length of workout in hours
	public long durationInHours() {
		long hours = getDuration() / 60;
		return hours;

	}

	// Takes users workout statistics and returns them as a string
	public String toString() {
		String workout = new String();
		workout += "Workout Type: " + getWorkoutType() + '\t' + "Duration:" + getDuration() + '\t' + "Intensity: "
				+ getIntensity() + '\t' + " Calories Burned: " + getCalories() + '\t' + " Weight: " + getWeight();
		return workout;
	}

	// This method will compare the user's newest workout statistics to their goals.
	// If a goal is met,
	// an achievement message is printed.
	public void compareTo(GoalComponent goals) {
		if (getDuration() >= (goals.getDurationGoal())) {
			System.out.println("Duration Goal has been met!");
		}
		if (getWeight() < goals.getTargetWeight()) {
			System.out.println("Weight Goal has been met!");

		}

	}

}
