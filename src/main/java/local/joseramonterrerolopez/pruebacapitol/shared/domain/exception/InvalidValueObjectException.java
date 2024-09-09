package local.joseramonterrerolopez.pruebacapitol.shared.domain.exception;

public class InvalidValueObjectException extends IllegalArgumentException {
    public InvalidValueObjectException(String message) {
        super(message);
    }
}
