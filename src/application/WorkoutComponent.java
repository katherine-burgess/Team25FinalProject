package application;

public class WorkoutComponent {
	// instance variables 
		private String workoutType;
		private long duration;
		private String intensity;
		private int caloriesBurned;
		
		
		
		WorkoutComponent(String dur, String calories){
			try {
				duration = Long.parseLong(dur);
				caloriesBurned = Integer.parseInt(calories);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				
			}
		}
		
		public void setDuration(String dur) {
			try {
				duration = Long.parseLong(dur);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
		}
		
		public long getDuration() {
			return duration;
		}
		
		
		public void setCalories(String calories) {
			try {
				caloriesBurned = Integer.parseInt(calories);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
		}
		
		public int getCalories() {
			return caloriesBurned;
		}
		
		
		// gets the duration length of workout in seconds 
		public long durationInSeconds() {
			
			return 0;
			
		}
		
		// Takes users workout stats and returns them as a string
		public String toString() {
			String workout = new String();
		
			
			return " ";
		}
}
