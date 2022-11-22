package application;

public class GoalComponent {
	
	// Instance Variables
	private double targetWeight;
	private long duration = 720;
	private double lowerBodyPR;
	private double upperBodyPR;
	
	
	// This constructor takes in the four goal components and validates the input 
	GoalComponent(String duration, String weight, String upperBody, String lowerBody) throws InvalidEntryException{
		try {
			this.duration = Long.parseLong(duration);
			targetWeight = Double.parseDouble(weight);
			lowerBodyPR = Double.parseDouble(lowerBody);
			upperBodyPR = Double.parseDouble(upperBody);
			
			// Duration of workout cannot be longer than 12 hours 
			if (this.duration < 0 || this.duration > durationInHours()) {
				throw new InvalidEntryException(String.format("Duration of workout can only be between 0 and %d hours. ", durationInHours()));
				
			}
			
		} catch (NumberFormatException e) {
			throw new InvalidEntryException(String.format("Invalid Goal Entry. Make sure to enter a number."));
		}
	}


	private long durationInHours() {
		long hours = duration / 60;
		return hours;
	}
	
	
	
	
	
}
