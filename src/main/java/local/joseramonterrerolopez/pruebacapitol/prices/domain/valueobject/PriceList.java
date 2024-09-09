package local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject;

import local.joseramonterrerolopez.pruebacapitol.shared.domain.valueobject.ValueObject;

public class PriceList extends ValueObject<Integer> {
    protected PriceList(Integer value) {
        super(value);
    }

    public static PriceList of(Integer value)
    {
        return new PriceList(value);
    }
}
