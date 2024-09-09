package local.joseramonterrerolopez.pruebacapitol.prices.domain;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.*;
import local.joseramonterrerolopez.pruebacapitol.shared.domain.exception.NullValueObjectException;
import local.joseramonterrerolopez.pruebacapitol.shared.domain.Primitable;

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

    private void guardNotNull(Object valueObject)
    {
        if (valueObject == null) {
            throw new NullValueObjectException("Value object cannot be null");
        }
    }
}
