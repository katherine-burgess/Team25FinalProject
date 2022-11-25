package application;

public class WorkoutComponent {
	// instance variables
	private String workoutType;
	private long duration;
	private String intensity;
	private int caloriesBurned;
	
	// Maximum duration for a workout is 300 minutes or 5 hours
	private double durationMax = 300;
	private int calorieMax = 1000;

	WorkoutComponent(String dur, String calories) throws InvalidEntryException {
		try {
			duration = Long.parseLong(dur);
			caloriesBurned = Integer.parseInt(calories);
			
			if (duration < 0 || duration > durationMax) {
				throw new InvalidEntryException(String.format("Invalid workout duration entry. Enter a number between 0 and %d ", durationMax));
			}
			
			if (caloriesBurned < 0 || caloriesBurned > calorieMax) {
				throw new InvalidEntryException(String.format("Invalid calorie entry. Enter a number between 0 and %d ", calorieMax));
			}
			
		} catch (NumberFormatException nfe) {
			throw new InvalidEntryException(String.format("Invalid Workout Entry. Enter a number."));

		}
	}

	public void setDuration(String dur) throws InvalidEntryException {
		try {
			duration = Long.parseLong(dur);
		} catch (NumberFormatException nfe) {
			throw new InvalidEntryException(String.format("Invalid Duration Entry. Enter a number."));
		}
	}

	public long getDuration() {
		System.out.println(duration);
		return duration;

	}

	public void setCalories(String calories) throws InvalidEntryException {
		try {
			caloriesBurned = Integer.parseInt(calories);
		} catch (NumberFormatException nfe) {
			throw new InvalidEntryException(String.format("Invalid Calorie Entry. Enter a number."));
		}
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
	
	// gets the duration length of workout in hours
	public long durationInHours() {
		long hours = getDuration() / 60;
		return hours;

	}

	// Takes users workout stats and returns them as a string
	public String toString() {
		String workout = new String();
		workout += "Workout Type: " +  getWorkoutType() + '\t' + "Duration:" + getDuration() + '\t' + "Intensity: " 
				+ getIntensity() + '\t' + "Calories Burned: " + getCalories();

		return workout;
	}

	
}
