package application;

import java.util.Calendar;
import java.util.Date;

/**
 * This class will set the name of the new incoming workoutType and compare it to the 
 * users goals. This class will also calculate the duration in hours for further 
 * workout based calculations.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public abstract class Workout {

	// instance variables
	private String workoutType;
	private Workout newWorkout;
	private double duration;
	private int year;
	private int month;
	private int day;

	public Workout() {
		workoutType = new String();
	}

	// Copy constructor
	public Workout(Workout toCopy) {
		if (toCopy != null) {
			newWorkout = toCopy.newWorkout;
		}
	}

	// sets the new incoming workoutType
	public void setWorkoutType(String type) {
		workoutType = type;
	}

	public String getWorkoutType() {
		return workoutType;
	}
	
	 /**
	  * This method is used to get the date of workout inputed by the user. If non numerical values 
	  * are entered the InvalidEntryException will be thrown with a specific error message for the user.
	  * 
	  * @param newYear a year string value entered by the user
	  * @param newMonth a month string value entered by the user
	  * @param newDay a day string value entered by the user
	  * @return the calendar date
	  * @throws InvalidEntryException
	  */
	public void setDate(String newYear, String newMonth, String newDay) throws InvalidEntryException {
		try {

			
			year = Integer.parseInt(newYear);
			month = Integer.parseInt(newMonth);
			day = Integer.parseInt(newDay);
			
			if (month < 0 || month > 12) {
				throw new InvalidEntryException("Invalid Date entered. Make sure to enter a month between 1 and 12.");
			}
			if (day < 0 || day > 31) {
				throw new InvalidEntryException("Invalid Date entered. Make sure to enter a day between 1 and 31.");
			}
			if (year < 2022 || year > 2100) {
				throw new InvalidEntryException("Invalid Date entered. Make sure to enter a year between 2022 and 2100.");
			}
			

		}catch (NumberFormatException npe) {
			throw new InvalidEntryException("Invalid Date entered. Make sure to enter a whole number.");
		}
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public abstract double getDuration();
	
	public abstract double getCalories();
	
	public abstract double getDistance();
	
	// This method will compare the newly entered workout with the user's goals
	public abstract String compareTo(GoalComponent goal);
	
	// This method takes the duration in minutes and converts it to seconds
	public double durationInHours() {
		duration = getDuration() / 60;
		return duration;
	}



}
