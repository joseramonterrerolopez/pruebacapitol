package local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject;

import local.joseramonterrerolopez.pruebacapitol.shared.domain.valueobject.ValueObject;

public class ProductId extends ValueObject<Integer> {
    protected ProductId(Integer value) {
        super(value);
    }

    public static ProductId of(Integer value)
    {
        return new ProductId(value);
    }
}
