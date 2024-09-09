package local.joseramonterrerolopez.pruebacapitol.shared.domain.valueobject;

import local.joseramonterrerolopez.pruebacapitol.shared.domain.exception.NullValueObjectContentException;

public abstract class ValueObject<T> {
    private final T value;

    protected ValueObject(T value)
    {
        this.value = value;
        guardNotNull(value);
    }

    public T value()
    {
        return value;
    }

    private void guardNotNull(T value)
    {
        if (value == null) {
            throw new NullValueObjectContentException("Value object content cannot be null");
        }
    }
}
