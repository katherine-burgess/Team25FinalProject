package application;

/**
 * This class will track cardio workouts entered by the user. If the user has entered an invalid fitness log, 
 * an InvalidEntryException will be thrown.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class Cardio extends Workout {

	// Instance Variables
	private double caloriesBurned;
	private double distance;
	private double duration;

	/**
	 *  This constructor will check for valid cardio workout entries, if entry is
	 *  not a number an invalid entry exception will be thrown. 
	 *  
	 * @param dist a string distance value entered by the user
	 * @param dur a string duration value entered by the user
	 * @param cal a string calorie value entered by the user
	 * @throws InvalidEntryException when non numerical input is entered
	 */
	public Cardio(String dist, String dur, String cal) throws InvalidEntryException {
		try {
			
			
			distance = Double.parseDouble(dist);
			duration = Double.parseDouble(dur);
			caloriesBurned = Double.parseDouble(cal);

			
			if (distance < 0 || distance > 80) {
				throw new InvalidEntryException(
						String.format("Make sure to enter a distance number between 0 and 80 km.", dist));
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
					String.format("Invalid Cardio Workout Entry. Make sure to enter a number and fill in all the boxes. "));
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
	public double getDistance() {
		return distance;
		
	}
	
	// This method will calculate the pace (seconds/km)
	public double calculatePace() {
		double pace = getDuration() / getDistance();
		return  pace;
	}
	
	// This method will take the results from the calculate pace method and return it in a string format
	public String paceToString() {
		if (calculatePace() > 1) {
			return  String.format("Pace: %.2f minutes per kilometer", calculatePace());
		} else {
			return String.format("Pace: %.2f minute per kilometer", calculatePace());
		}
	}
	// This method will calculate the mileage and return in a string format
	public String calculateMileage() {
		double mileage = getDuration() / calculatePace();
		if (mileage > 1) {
			return  String.format("Mileage: %.2f kilometers", mileage);
		} else {
			return String.format( "Mileage: %.2f kilometer", mileage);
		}
	}
	
	
	@Override
	/**
	 * This method will compare the newest incoming workout to the user's entered goals.
	 * If a goal is achieved an achievement message will be returned to display to the user.
	 * 
	 * @param goal the goals inputed by the user on the GUI
	 */
	public String compareTo(GoalComponent goal) {
		String durMessage = " ", calMessage = "", distMessage = "";
		
		if (getDuration() > goal.getDurationGoal()) {
			durMessage = "Cardio Duration goal has been achieved!  " + goal.getDurationGoal() + "  minutes "+ '\n'; 
		} 
		if (getCalories() > goal.getCalorieGoal()) {
			calMessage = "Cardio Calories Burned goal has been achieved!  " + goal.getCalorieGoal() + "  calories " + '\n';
		}
		if (getDistance() > goal.getDistanceGoal()) {
			distMessage = "Cardio Distance goal has been achieved!  " + goal.getDistanceGoal() + " km";
		}
		
		// If more than one goal is achieved at once, display multiple to user
		if (!(durMessage == "" || calMessage == "" || distMessage == "")) {
			return durMessage + calMessage + distMessage;	
		} else {
			return "";
		}
	}
	
	
	
	
}
