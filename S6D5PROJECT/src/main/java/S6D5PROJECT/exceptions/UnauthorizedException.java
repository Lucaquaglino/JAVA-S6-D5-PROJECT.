package S6D5PROJECT.exceptions;

public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 8440571514177491097L;

	public UnauthorizedException(String message) {
		super(message);
	}

}