package application;

import java.util.ArrayList;

/** 
 * This class will keep count of the number of achieved goals the user has. 
 * 
 * @author CS219-user
 *
 */
public class AchievedGoals extends GoalComponent {

	private int numOfAchieved = 0;
	private ArrayList<GoalComponent> goalsAchieved;
	
	
	public AchievedGoals(String duration, String weight, String upperBody, String lowerBody) throws InvalidEntryException {
		super(duration, weight, upperBody, lowerBody);
	}
	
	public AchievedGoals(GoalComponent goals) {
		super(goals);
	}
	// this method will count the number of achieved goals
	public int countAchieved() {
		numOfAchieved = goalsAchieved.size();
		return numOfAchieved;
	}
	
	// this method will add the achieved goals to an ArrayList, if the goals is a repeat the goal won't be added. 
	public void addAchievedGoal(GoalComponent goal) {
		
		if (goalsAchieved.isEmpty()) {
			goalsAchieved.add(goal);
			return;
		}
		
		goalsAchieved.add(goal);
	}
	public ArrayList<GoalComponent> getAchievedGoals(){
		return new ArrayList<GoalComponent> (goalsAchieved);
	}
}
