package application;

/** 
 * This class will keep count of the number of goals the user is still working on. 
 * @author CS219-user
 *
 */
public class UnAchievedGoals extends GoalComponent {
	private int numOfUnachieved;
	
	UnAchievedGoals(String duration, String weight, String upperBody, String lowerBody) throws InvalidEntryException {
		super(duration, weight, upperBody, lowerBody);
		
	}

	// This method will count the number of goals the user is still working on. 
	public int unAchievedCount() {
		return numOfUnachieved;
	}
	
}
