package local.joseramonterrerolopez.unit.pruebacapitol.prices.shared;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInAction;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInActionPrimitives;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.*;
import local.joseramonterrerolopez.pruebacapitol.shared.infrastructure.dao.prices.jpa.PriceDto;
import org.openapitools.model.PriceInActionResponse;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class PriceMother {
    public static PriceDto standardPriceDtoSubject()
    {
        return PriceDto
            .builder()
            .priceList(1)
            .brandId(1)
            .productId(1)
            .startDate(startOfTheYear())
            .endDate(endOfTheYear())
            .price(1.5f)
            .currency("EUR")
            .priority(0)
            .build();
    }
    public static PriceInAction standardInActionSubject()
    {
        PriceDto priceDto = standardPriceDtoSubject();
        return PriceInAction.of(
                PriceList.of(priceDto.getPriceList()),
                BrandId.of(priceDto.getBrandId()),
                ProductId.of(priceDto.getProductId()),
                StartDate.of(priceDto.getStartDate()),
                EndDate.of(priceDto.getEndDate()),
                Price.of(priceDto.getPrice())
        );
    }
    public static PriceInActionPrimitives standardInActionPrimitivesSubject()
    {
        return standardInActionSubject().toPrimitives();
    }
    public static PriceInActionResponse standardInActionResponseSubject(ZoneOffset zone)
    {
        PriceInActionPrimitives primitivesSubject = standardInActionPrimitivesSubject();
        return new PriceInActionResponse()
                .priceList(primitivesSubject.priceList())
                .brandId(primitivesSubject.brandId())
                .productId(primitivesSubject.productId())
                .startDate(toOffsetDateTime(primitivesSubject.startDate(), zone))
                .endDate(toOffsetDateTime(primitivesSubject.endDate(), zone))
                .price(primitivesSubject.price());
    }
    public static PriceDto invalidPriceDtoSubject()
    {
        Float invalidPrice = -1.5f;
        return PriceDto
                .builder()
                .priceList(1)
                .brandId(1)
                .productId(1)
                .startDate(startOfTheYear())
                .endDate(endOfTheYear())
                .price(invalidPrice)
                .currency("EUR")
                .priority(0)
                .build();
    }
    private static LocalDateTime startOfTheYear()
    {
        return LocalDateTime.of(2024, 1, 1, 0, 0, 0);
    }
    private static LocalDateTime endOfTheYear()
    {
        return LocalDateTime.of(2024, 12, 31, 23, 59, 59);
    }
    private static OffsetDateTime toOffsetDateTime(LocalDateTime dateTime, ZoneOffset toZone)
    {
        return OffsetDateTime
                .of(dateTime, ZoneOffset.UTC)
                .withOffsetSameInstant(toZone);
    }
}
