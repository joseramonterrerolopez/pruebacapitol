package local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject;

import local.joseramonterrerolopez.pruebacapitol.shared.domain.valueobject.ValueObject;

import java.time.LocalDateTime;

public class EndDate extends ValueObject<LocalDateTime> {
    protected EndDate(LocalDateTime value) {
        super(value);
    }

    public static EndDate of(LocalDateTime value)
    {
        return new EndDate(value);
    }
}
