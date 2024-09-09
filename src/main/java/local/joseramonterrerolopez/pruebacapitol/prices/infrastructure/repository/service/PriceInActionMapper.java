package local.joseramonterrerolopez.pruebacapitol.prices.infrastructure.repository.service;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInAction;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.*;
import local.joseramonterrerolopez.pruebacapitol.shared.infrastructure.dao.prices.jpa.PriceDto;
import org.springframework.stereotype.Service;

@Service
public class PriceInActionMapper {
    public PriceInAction from(PriceDto priceDto)
    {
        return PriceInAction.of(
            PriceList.of(priceDto.getPriceList()),
            BrandId.of(priceDto.getBrandId()),
            ProductId.of(priceDto.getProductId()),
            StartDate.of(priceDto.getStartDate()),
            EndDate.of(priceDto.getEndDate()),
            Price.of(priceDto.getPrice())
        );
    }
}
