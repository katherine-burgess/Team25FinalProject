package application;

/**
 * This class will track the user's strength workouts. It will check if the user has 
 * entered in a number, if not an invalid entry exception will be thrown. 
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class Strength extends Workout {
	private double duration;
	private double caloriesBurned;
	private String intensity;
	
	/**
	 * This constructor will take in the strength fitness input by the user on the GUI and check if 
	 * the user has entered a number. If not an Invalid Entry Exception will be thrown.
	 * 
	 * @param dur a string duration value entered by the user 
	 * @param cal a string calorie value entered by the user
	 * @param intense a string value entered by the user
	 * @throws InvalidEntryException when user input is not a number
	 */
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
	
	@Override
	public double getCalories() {
		return caloriesBurned;
	}
	
	
	@Override
	/**
	 * This method will compare the newest incoming workout to the user's entered goals.
	 * If a goal is achieved an achievement message will be returned to display to the user.
	 * 
	 * @param goal the goals inputed by the user on the GUI
	 */
	public String compareTo(GoalComponent goal) {
		
		String durMessage = " ", calMessage = "";
		
		if (getDuration() > goal.getDurationGoal()) {
			durMessage = "New Strength Duration goal has been achieved!  " + goal.getDurationGoal() + "  minutes "+ '\n';
			//AchievedGoals achGoal = new AchievedGoals(goal);
		} 
		if (getCalories() > goal.getCalorieGoal()) {
			calMessage = "New Strength Calories Burned goal has been achieved!  " + goal.getCalorieGoal() + "  calories ";
		}
		
		if (!(durMessage == "" && calMessage == "")) {
			return durMessage + calMessage;	
		} else if ((durMessage != "") &&( calMessage == "")) {
			return durMessage;
		} else {
			return calMessage;
		}
	}

	// find a way to not need this 
	@Override
	public double getDistance() {
		// TODO Auto-generated method stub
		return 0;
	}
}
