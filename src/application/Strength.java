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
	private Strength newStr;

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


	@Override
	public double getDuration() {
		return duration;
	}
	public double getCalories() {
		return caloriesBurned;
	}
	
	public String caloriesPerHour() {
		int caloriesHour = (int) (caloriesBurned / durationInHours());
		return "Calories burned per hour: " +  caloriesHour ;
	}
	
	@Override
	public String compareTo(GoalComponent goal) {
		
		String durMessage = " ", calMessage = "";
		
		if (getDuration() > goal.getDurationGoal()) {
			durMessage = "New Strength Duration goal has been achieved!  " + goal.getDurationGoal() + "  minutes "+ '\n';
			//AchievedGoals achGoal = new AchievedGoals(goal);
		} 
		if (getCalories() > goal.getCalorieGoal()) {
			calMessage = "New Strength Calorie goal has been achieved!  " + goal.getCalorieGoal() + "  calories ";
		}
		
		if (!(durMessage == "" && calMessage == "")) {
			return durMessage + calMessage;	
		} else if ((durMessage != "") &&( calMessage == "")) {
			return durMessage;
		} else {
			return calMessage;
		}
	}
}
