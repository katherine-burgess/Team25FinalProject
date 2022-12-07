package application;

/** 
 * This class will 
 * @author CS219-user
 *
 */
public class Calories extends WorkoutComponent{

	private int caloriesBurned;
	

	public void setCalories(String calories) throws InvalidEntryException {
		try {
			caloriesBurned = Integer.parseInt(calories);
			
			if (caloriesBurned < 0 || caloriesBurned > 1000) {
				throw new InvalidEntryException(
						String.format("Invalid calorie entry. Enter a number between 0 and 1000 calories "));
				}
			
			} catch (NumberFormatException npe) {
				throw new InvalidEntryException("Invalid calorie entry %d. Make sure to enter a number.");
			}
		
		
	}
	
	public int getCal() {
		return caloriesBurned;
	}
	
	public void caloriesHour(Calories cal, Duration d) {
		
	}
}
