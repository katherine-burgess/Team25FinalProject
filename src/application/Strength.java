package application;

/**
 * This class will track the user's strength workouts.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class Strength extends Workout {
	private double duration;
	private double caloriesBurned;
	private String intensity;

	public Strength(String dur, String cal, String intense) throws InvalidEntryException {
		try {
			duration = Double.parseDouble(dur);
			caloriesBurned = Double.parseDouble(cal);
			intensity = intense;

			if (duration < 0 || duration > 200) {
				throw new InvalidEntryException(
						String.format("Make sure to enter a duration number between 0 and 200 minutes.", duration));
			}

			if (caloriesBurned < 0 || caloriesBurned > 500) {
				throw new InvalidEntryException(
						String.format("Make sure to enter a duration number between 0 and 500 calories.", caloriesBurned));
			}

		} catch (NumberFormatException npe) {
			throw new InvalidEntryException("Invalid Strength Workout Entry. Make sure to enter a number");
		}
	}
	
	public double getDuration() {
		return duration;
	}
	public double getCalories() {
		return caloriesBurned;
	}
	
	
	@Override
	public String compareTo(GoalComponent goal) {
		String message = "";
		if (getDuration() > goal.getDurationGoal()) {
			AchievedGoals ag = new AchievedGoals(goal);
			
		}
		return message;
	}
}
