package application;

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
	private double lowerBodyPR;
	private double upperBodyPR;
	private String goals;


	// This constructor takes in the four goal components and validates the input
	public GoalComponent(String duration, String weight, String upperBody, String lowerBody) throws InvalidEntryException {
		try {
			this.durationGoal = Long.parseLong(duration);
			targetWeight = Double.parseDouble(weight);
			lowerBodyPR = Double.parseDouble(lowerBody);
			upperBodyPR = Double.parseDouble(upperBody);

			if (this.durationGoal < 0 || this.durationGoal > 300) {
				throw new InvalidEntryException(
						String.format("Duration of workout can only be between 0 and 300 minutes"));
			}
			if (targetWeight < 0 || targetWeight > 300) {
				throw new InvalidEntryException(
						String.format("Target weight can only be between 0 and 300 lbs"));
			}
			if (lowerBodyPR < 0 || upperBodyPR < 0) {
				throw new InvalidEntryException(String.format("A new personal record can't be less than 0 lbs. "));
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

	public double getLowerBody() {
		return lowerBodyPR;
	}

	public double getUpperBody() {
		return upperBodyPR;
	}

	// Will get the duration goal length in hours
	public long durationInHours() {
		long hours = durationGoal / 60;
		return hours;
	}

	// Will create a string containing all of the inputed goals
	public String toString() {
		goals = "Duration: " + getDurationGoal() + " minutes " + '\n' + "Target Weight: " + getTargetWeight() + " lbs " + '\n'
				+ "Upper Body Lifting Goal: " + getUpperBody() + " lbs " + '\n' + "Lower Body Lifting Goal: " + getLowerBody() + " lbs ";

		return goals;
	}

}
