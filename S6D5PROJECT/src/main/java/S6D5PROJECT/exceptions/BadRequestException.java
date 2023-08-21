package S6D5PROJECT.exceptions;

public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = -2709878033911274969L;

	public BadRequestException(String message) {
		super(message);
	}
}
