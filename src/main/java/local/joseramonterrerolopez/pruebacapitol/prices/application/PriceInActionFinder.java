package local.joseramonterrerolopez.pruebacapitol.prices.application;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInAction;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInActionPrimitives;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceRepository;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.BrandId;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.ProductId;
import local.joseramonterrerolopez.pruebacapitol.shared.domain.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceInActionFinder {
    private final PriceRepository priceRepository;

    public PriceInActionFinder(PriceRepository priceRepository)
    {
        this.priceRepository = priceRepository;
    }

    public PriceInActionPrimitives execute(BrandId brandId, ProductId productId, LocalDateTime dateTime)
    {
        return priceRepository.findInAction(brandId, productId, dateTime)
                .map(PriceInAction::toPrimitives)
                .orElseThrow(() -> new NotFoundException("Price"));
    }
}
