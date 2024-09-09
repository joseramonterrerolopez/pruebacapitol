package local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject;

import local.joseramonterrerolopez.pruebacapitol.shared.domain.exception.InvalidValueObjectException;
import local.joseramonterrerolopez.pruebacapitol.shared.domain.valueobject.ValueObject;

public class Price extends ValueObject<Float> {
    protected Price(Float value) {
        super(value);
        this.guardNonNegativeValue(value);
    }

    public static Price of(Float value)
    {
        return new Price(value);
    }

    private void guardNonNegativeValue(Float value)
    {
        if (value <= .0f) {
            throw new InvalidValueObjectException("price cannot be negative");
        }
    }
}
