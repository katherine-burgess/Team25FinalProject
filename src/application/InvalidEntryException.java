package application;

public class InvalidEntryException extends Exception{
	
	public InvalidEntryException(String msg) {
		super(msg);
	}
	
	public InvalidEntryException(Throwable cause) {
		super(cause);
	}
	
	public InvalidEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public InvalidEntryException(String msg, Throwable cause, boolean enableSupression, boolean writableStackTrace) {
		super(msg, cause, enableSupression, writableStackTrace);
	}
}
