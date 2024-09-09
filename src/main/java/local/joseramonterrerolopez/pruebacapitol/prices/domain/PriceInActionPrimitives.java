package local.joseramonterrerolopez.pruebacapitol.prices.domain;

import java.time.LocalDateTime;

public record PriceInActionPrimitives(
        Integer priceList,
        Integer brandId,
        Integer productId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Float price
) {}
