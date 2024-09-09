package local.joseramonterrerolopez.pruebacapitol.prices.domain;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.*;
import local.joseramonterrerolopez.pruebacapitol.shared.domain.exception.NullValueObjectException;
import local.joseramonterrerolopez.pruebacapitol.shared.domain.Primitable;

import java.util.Objects;

public class PriceInAction implements Primitable<PriceInActionPrimitives> {
    private final PriceList priceList;
    private final BrandId brandId;
    private final ProductId productId;
    private final StartDate startDate;
    private final EndDate endDate;
    private final Price price;

    private PriceInAction(PriceList priceList, BrandId brandId, ProductId productId, StartDate startDate, EndDate endDate, Price price) {
        this.priceList = priceList;
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        guardNotNull(priceList);
        guardNotNull(brandId);
        guardNotNull(productId);
        guardNotNull(startDate);
        guardNotNull(endDate);
        guardNotNull(price);
    }

    public static PriceInAction of(PriceList priceList, BrandId brandId, ProductId productId, StartDate startDate, EndDate endDate, Price price)
    {
        return new PriceInAction(priceList, brandId, productId, startDate, endDate, price);
    }

    @Override
    public PriceInActionPrimitives toPrimitives()
    {
        return new PriceInActionPrimitives(
                priceList.value(),
                brandId.value(),
                productId.value(),
                startDate.value(),
                endDate.value(),
                price.value()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceInAction that = (PriceInAction) o;
        return Objects.equals(priceList.value(), that.priceList.value())
                && Objects.equals(brandId.value(), that.brandId.value())
                && Objects.equals(productId.value(), that.productId.value())
                && Objects.equals(startDate.value(), that.startDate.value())
                && Objects.equals(endDate.value(), that.endDate.value())
                && Objects.equals(price.value(), that.price.value());
    }

    private void guardNotNull(Object valueObject)
    {
        if (valueObject == null) {
            throw new NullValueObjectException("Value object cannot be null");
        }
    }
}
