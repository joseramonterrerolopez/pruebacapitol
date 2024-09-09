package local.joseramonterrerolopez.unit.pruebacapitol.prices.infrastructure.controller.v1.service;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInActionPrimitives;
import local.joseramonterrerolopez.pruebacapitol.prices.infrastructure.controller.v1.service.PriceInActionResponseFactory;
import local.joseramonterrerolopez.unit.pruebacapitol.prices.shared.PriceMother;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.PriceInActionResponse;

import java.time.ZoneOffset;

@ExtendWith(MockitoExtension.class)
public class PriceInActionResponseFactoryTest {
    @InjectMocks
    private PriceInActionResponseFactory factory;

    @ParameterizedTest
    @ValueSource(strings = {"Z", "+02:00", "-05:00"})
    public void test_factory_from_primitives_to_response_works_properly_given_a_standard_price_in_action_primitives_and_a_given_zone(String givenUserOffset)
    {
        // Given
        PriceInActionPrimitives priceInActionPrimitives = givenTheStandardPriceInActionPrimitives();

        // When
        PriceInActionResponse result = factory.from(priceInActionPrimitives, ZoneOffset.of(givenUserOffset));

        // Then
        PriceInActionResponse expected = givenTheStandardPriceInActionResponse(ZoneOffset.of(givenUserOffset));
        Assertions.assertThat(result).isEqualTo(expected);
    }
    private PriceInActionPrimitives givenTheStandardPriceInActionPrimitives()
    {
        return PriceMother.standardInActionPrimitivesSubject();
    }
    private PriceInActionResponse givenTheStandardPriceInActionResponse(ZoneOffset zoneOffset)
    {
        return PriceMother.standardInActionResponseSubject(zoneOffset);
    }
}
