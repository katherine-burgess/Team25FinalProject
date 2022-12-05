package application;

import java.util.ArrayList;

/**
 * This class will keep count of the number of achieved goals the user has.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class AchievedGoals {

	private ArrayList<GoalComponent> goalsAchieved;

	
	public AchievedGoals(GoalComponent achGoal) {
		addAchievedGoal(achGoal);
	}

	// this method will add the achieved goals to an ArrayList, if the goals is a
	// repeat the goal won't be added.
	public void addAchievedGoal(GoalComponent goal) {

		if (goalsAchieved.isEmpty()) {
			goalsAchieved.add(goal);
			return;
		}
		
		for (int i = 0; i < goalsAchieved.size(); i++) {
			if (!(goal.getDurationGoal() == goalsAchieved.get(i).getDurationGoal()) 
					&& (!(goal.getCalorieGoal() == goalsAchieved.get(i).getCalorieGoal()))) {
				goalsAchieved.add(i,goal);
				
			} 
		}
	}

	public ArrayList<GoalComponent> getAchievedGoals() {
		return new ArrayList<GoalComponent>(goalsAchieved);
	}
}
