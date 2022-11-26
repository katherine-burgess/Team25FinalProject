package application;

/**
 * This class will be called when the user has entered an invalid workout entry
 * or goal entry. A specific message will be presented to the user when they
 * enter an invalid number.
 * 
 * @author CS219-user Katie Burgess
 *
 */
public class InvalidEntryException extends Exception {

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
