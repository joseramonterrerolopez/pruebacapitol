package local.joseramonterrerolopez.pruebacapitol.prices.infrastructure.repository;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInAction;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceRepository;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.BrandId;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.ProductId;
import local.joseramonterrerolopez.pruebacapitol.prices.infrastructure.repository.service.PriceInActionMapper;
import local.joseramonterrerolopez.pruebacapitol.shared.infrastructure.dao.prices.jpa.PriceDao;
import local.joseramonterrerolopez.pruebacapitol.shared.infrastructure.dao.prices.jpa.PriceDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaPriceRepository implements PriceRepository {
    private final PriceDao priceDao;
    private final PriceInActionMapper priceInActionMapper;

    @Override
    public Optional<PriceInAction> findInAction(BrandId brandId, ProductId productId, LocalDateTime dateTime) {
        Optional<PriceDto> priceDto = priceDao.findInAction(brandId.value(), productId.value(), dateTime);
        return priceDto.map(priceInActionMapper::from);
    }
}
