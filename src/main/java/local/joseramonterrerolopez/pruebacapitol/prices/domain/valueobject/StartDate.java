package local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject;

import local.joseramonterrerolopez.pruebacapitol.shared.domain.valueobject.ValueObject;

import java.time.LocalDateTime;

public class StartDate extends ValueObject<LocalDateTime> {
    protected StartDate(LocalDateTime value) {
        super(value);
    }

    public static StartDate of(LocalDateTime value)
    {
        return new StartDate(value);
    }
}
