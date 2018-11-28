package ua.nure.kn.zapichnyi.usermanagement.db;


public class DatabaseException extends Exception {

	public DatabaseException(Exception e) {
		super(e);
	}

	public DatabaseException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -936870547536483898L;

}
