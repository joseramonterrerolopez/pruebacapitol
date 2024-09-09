package local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject;

import local.joseramonterrerolopez.pruebacapitol.shared.domain.valueobject.ValueObject;

public class BrandId extends ValueObject<Integer> {
    protected BrandId(Integer value) {
        super(value);
    }

    public static BrandId of(Integer value)
    {
        return new BrandId(value);
    }
}
