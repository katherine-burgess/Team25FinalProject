package application;

public class Duration extends WorkoutComponent{

	private long length;
	
	public Duration(String dur, String calories, String weight, String intensity, String type)
			throws InvalidEntryException {
		super(dur, calories, weight, intensity, type);
		// TODO Auto-generated constructor stub
	}

	public void setLength(String duration) throws InvalidEntryException {
		try {
			length = Long.parseLong(duration);
			
		} catch (NumberFormatException npe) {
			throw new InvalidEntryException("Invalid Duration Entry.");
		}
		
	}
	
	public long getLength() {
		return length;
	}
}
