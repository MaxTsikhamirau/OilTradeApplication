package exceptions;

	import java.sql.SQLException;

	public class DAOException extends SQLException {

		private static final long serialVersionUID = 1L;

		public DAOException(String message) {
			super(message);
		}

		public DAOException(Throwable cause) {
			super(cause);
		}

		public DAOException(String message, Throwable cause) {
			super(message, cause);
		}

	}


