package local.joseramonterrerolopez.pruebacapitol.prices.domain;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.BrandId;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.ProductId;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    public Optional<PriceInAction> findInAction(BrandId brandId, ProductId productId, LocalDateTime dateTime);
}
