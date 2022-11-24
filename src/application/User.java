
package application;

public class User {

	// Instance variables
	private String name;
	private double weight;
	private double height;
	
	
	
	User(String name, double weight, double height){
		this.name = name;
		this.weight = weight;
		this.height = height;
		
	}
	
	public User(String newName) {
		name = newName;
	}

	// sets the user's name
	public String setName(String nameAsString) {
		String errorMessage = " ";
		boolean validName = true;
		
		for (char n : nameAsString.toCharArray()) {
			if (!Character.isAlphabetic(n)) {
				validName = false;
				errorMessage = String.format("Your username must use only letters", n);
			}
		}	
		
		if (validName) {
			name = nameAsString;
		}
		
		return errorMessage;
		
	}
	
	public String getName() {
		return name;
	}
	
	// This method will call the WorkoutComponent() to get the stats from the user
	public void logWorkout(String calories, String duration, String intensity, String type) throws InvalidEntryException {
		WorkoutComponent workoutstat = new WorkoutComponent(duration, calories);
		
		
	}
	
	// This method will call the GoalComponent() to get the goals 
	public void logGoals(String duration, String weight, String upperBody, String lowerBody) throws InvalidEntryException {
		GoalComponent goals = new GoalComponent(duration, weight, upperBody, lowerBody);
		goals.getToString();
		
	}
	
	// This method will compare the workout stats to the user's goals
	public void compareTo(WorkoutComponent workoutstat, GoalComponent goals) {
		
		if ( workoutstat.getDuration() >= (goals.getDurationGoal())) {
			System.out.println("Duration Goal has been met!");
		} 
		
		
	}
}