package controladores;

public class LibEmpException extends Exception {
	public LibEmpException() {
	}

	public LibEmpException(String message) {
		super(message);
	}

	public LibEmpException(Throwable cause) {
		super(cause);
	}

	public LibEmpException(String message, Throwable cause) {
		super(message, cause);
	}

	public LibEmpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
