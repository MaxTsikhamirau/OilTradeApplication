package org.TikhomirovServiseHyber.exception;

import java.sql.SQLException;

public class ServiseException extends SQLException {

	private static final long serialVersionUID = 1L;

	public ServiseException(String message) {
		super(message);
	}

	public ServiseException(Throwable cause) {
		super(cause);
	}

	public ServiseException(String message, Throwable cause) {
		super(message, cause);
	}
 

}
