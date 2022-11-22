package application;

public class GoalComponent {
	
	// Instance Variables
	private double targetWeight;
	private long duration;
	private double lowerBodyPR;
	private double upperBodyPR;
	
	
	// This constructor takes in the four goal components and validates the input 
	GoalComponent(String duration, String weight, String upperBody, String lowerBody) throws InvalidEntryException{
		try {
			this.duration = Long.parseLong(duration);
			targetWeight = Double.parseDouble(weight);
			lowerBodyPR = Double.parseDouble(lowerBody);
			upperBodyPR = Double.parseDouble(upperBody);
			
		} catch (NumberFormatException e) {
			throw new InvalidEntryException(String.format("Invalid Goal Entry. Make sure to enter a number."));
		}
	}
	
	
	
	
	
}
