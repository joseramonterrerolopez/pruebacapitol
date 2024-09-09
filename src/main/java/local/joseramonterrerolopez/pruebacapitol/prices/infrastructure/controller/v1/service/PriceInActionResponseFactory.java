package local.joseramonterrerolopez.pruebacapitol.prices.infrastructure.controller.v1.service;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInActionPrimitives;
import org.openapitools.model.PriceInActionResponse;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
public class PriceInActionResponseFactory {
    public PriceInActionResponse from(PriceInActionPrimitives priceInActionPrimitives, ZoneOffset givenUserOffset)
    {
        return new PriceInActionResponse()
            .productId(priceInActionPrimitives.productId())
            .brandId(priceInActionPrimitives.brandId())
            .priceList(priceInActionPrimitives.priceList())
            .startDate(OffsetDateTime
                    .of(priceInActionPrimitives.startDate(), ZoneOffset.UTC)
                    .withOffsetSameInstant(givenUserOffset)
            )
            .endDate(OffsetDateTime
                    .of(priceInActionPrimitives.endDate(), ZoneOffset.UTC)
                    .withOffsetSameInstant(givenUserOffset)
            )
            .price(priceInActionPrimitives.price());
    }
}
