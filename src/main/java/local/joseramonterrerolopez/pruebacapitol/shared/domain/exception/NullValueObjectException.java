package local.joseramonterrerolopez.pruebacapitol.shared.domain.exception;

public class NullValueObjectException extends IllegalArgumentException {
    public NullValueObjectException(String message) {
        super(message);
    }
}
