package application;

/**
 * This class will take a Duration object and validate its input, the length of the duration will 
 * be checked and converted into hours and minutes.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class Duration extends WorkoutComponent{

	private long length;
	


	public void setLength(String duration) throws InvalidEntryException {
		try {
			length = Long.parseLong(duration);
			System.out.println(length);
			
			if (length < 0 || length > 300) {
				throw new InvalidEntryException(
						String.format("Invalid workout duration entry. Enter a number between 0 and 300 minutes "));
			}
		} catch (NumberFormatException npe) {
			throw new InvalidEntryException("Invalid Duration Entry.");
		}
		
	}
	
	public long getLength() {
		return length;
	}

	//This method will return the duration of the workout in hours and minutes 
	public String lengthInSeconds() {
		if (length > 60) {
			long durHour = length / 60;
			return durHour + " hours";
		} else {
			long durMin = length;
			return durMin + " minutes ";
		}
	}
		
}


