package local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject;

import local.joseramonterrerolopez.pruebacapitol.shared.domain.valueobject.ValueObject;

public class Price extends ValueObject<Float> {
    protected Price(Float value) {
        super(value);
    }

    public static Price of(Float value)
    {
        return new Price(value);
    }
}
