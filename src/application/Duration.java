package application;

public class Duration extends WorkoutComponent{

	private long length;
	
	public Duration() throws InvalidEntryException {
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
