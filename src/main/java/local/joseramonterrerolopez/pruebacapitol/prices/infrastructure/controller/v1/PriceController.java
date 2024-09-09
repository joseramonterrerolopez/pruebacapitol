package local.joseramonterrerolopez.pruebacapitol.prices.infrastructure.controller.v1;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import local.joseramonterrerolopez.pruebacapitol.prices.application.PriceInActionFinder;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInActionPrimitives;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.BrandId;
import local.joseramonterrerolopez.pruebacapitol.prices.domain.valueobject.ProductId;
import local.joseramonterrerolopez.pruebacapitol.prices.infrastructure.controller.v1.service.PriceInActionResponseFactory;
import lombok.AllArgsConstructor;
import org.openapitools.api.PricesApi;
import org.openapitools.model.PriceInActionResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/api/v1/prices")
@AllArgsConstructor
public class PriceController implements PricesApi {
    private final PriceInActionFinder priceInActionFinder;
    private final PriceInActionResponseFactory priceInActionResponseFactory;

    @Override
    @GetMapping("/in-action")
    public ResponseEntity<PriceInActionResponse> getPricesInAction(
            @NotNull(message = "Brand ID is required.")
            @Parameter(name = "brandId", description = "The unique identifier of the brand.", required = true, in = ParameterIn.QUERY)
            @Valid @RequestParam(value = "brandId", required = true) Integer brandId,

            @NotNull(message = "Product ID is required.")
            @Parameter(name = "productId", description = "The unique identifier of the product.", required = true, in = ParameterIn.QUERY)
            @Valid @RequestParam(value = "productId", required = true) Integer productId,

            @NotNull(message = "Date and time are required.")
            @Parameter(name = "dateTime", description = "The specific date and time for which the price is requested, in ISO 8601 format.", required = true, in = ParameterIn.QUERY)
            @Valid @RequestParam(value = "dateTime", required = true)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime dateTime
    ) {
        LocalDateTime utcDateTime = dateTime
                .withOffsetSameInstant(ZoneOffset.UTC)
                .toLocalDateTime();
        ZoneOffset clientOffset = dateTime.getOffset();

        PriceInActionPrimitives priceInActionPrimitives = priceInActionFinder.execute(
                BrandId.of(brandId),
                ProductId.of(productId),
                utcDateTime
        );
        PriceInActionResponse priceInActionResponse = priceInActionResponseFactory.from(
                priceInActionPrimitives,
                clientOffset
        );

        return ResponseEntity.ok(priceInActionResponse);
    }
}
