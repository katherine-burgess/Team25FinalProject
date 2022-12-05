package application;

/**
 * This class will track cardio workouts entered by the user.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class Cardio extends Workout {

	// Instance Variables
	private double caloriesBurned;
	private double distance;
	private double duration;

	// This constructor will check for valid cardio workout entries, if entry is
	// invalid an invalid entry exception will be thrown
	public Cardio(String dist, String dur, String cal) throws InvalidEntryException {
		try {
			distance = Double.parseDouble(dist);
			duration = Double.parseDouble(dist);
			caloriesBurned = Double.parseDouble(cal);

			if (distance < 0 || distance > 50) {
				throw new InvalidEntryException(
						String.format("Make sure to enter a distance number between 0 and 50 km.", dist));
			}

			if (duration < 0 || duration > 200) {
				throw new InvalidEntryException(
						String.format("Make sure to enter a duration number between 0 and 200 minutes.", dur));
			}

			if (caloriesBurned < 0 || caloriesBurned > 500) {
				throw new InvalidEntryException(
						String.format("Make sure to enter a duration number between 0 and 500 calories.", cal));
			}

		} catch (NumberFormatException npe) {
			throw new InvalidEntryException(
					String.format("Invalid Cardio Workout Entry. Make sure to enter a number. "));
		}
	}

	public double getDuration() {
		return duration;
	}
	
	public double getCaloriesBurned() {
		return caloriesBurned;
	}
	public double getDistance() {
		return distance;
		
	}
	
	@Override
	public String compareTo(GoalComponent goal) {
		String message = "";
		if (getDuration() > goal.getDurationGoal()) {
			message = "New Cardio Duration goal has been achieved!";
			AchievedGoals achGoal = new AchievedGoals(goal);
			
		} else if (getCaloriesBurned() > goal.getCalorieGoal()) {
			message = "New Cardio Calorie goal has been achieved!";
		}
		
		return message;
	}
}
