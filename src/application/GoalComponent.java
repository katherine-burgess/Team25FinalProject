package application;

public class GoalComponent {
	
	// Instance Variables
	private double targetWeight;
	private long durationGoal = 720;
	private double lowerBodyPR;
	private double upperBodyPR;
	private String goals;
	
	
	// This constructor takes in the four goal components and validates the input 
	GoalComponent(String duration, String weight, String upperBody, String lowerBody) throws InvalidEntryException{
		try {
			this.durationGoal = Long.parseLong(duration);
			targetWeight = Double.parseDouble(weight);
			lowerBodyPR = Double.parseDouble(lowerBody);
			upperBodyPR = Double.parseDouble(upperBody);
			
			// Duration of workout cannot be longer than 12 hours 
//			if (this.durationGoal < 0 || this.durationGoal > durationInHours()) {
//				throw new InvalidEntryException(String.format("Duration of workout can only be between 0 and %d hours. ", durationInHours()));
//				
//			}
			
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
	
	
	private long durationInHours() {
		long hours = durationGoal / 60;
		return hours;
	}
	
	
	
	// Will create a string containing all of the inputed goals 
	public String toString() {
		goals = "Duration: " + getDurationGoal() + '\n' + "Target Weight: " + getTargetWeight() + '\n' 
				+ "Upper Body PR: " + getUpperBody() + '\n' + "Lower Body PR: " + getLowerBody();
 		
		
		return goals;
	}
	
	
	
}
