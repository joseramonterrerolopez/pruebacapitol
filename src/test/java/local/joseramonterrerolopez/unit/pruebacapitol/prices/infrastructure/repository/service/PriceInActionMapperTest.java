package local.joseramonterrerolopez.unit.pruebacapitol.prices.infrastructure.repository.service;

import local.joseramonterrerolopez.pruebacapitol.prices.domain.PriceInAction;
import local.joseramonterrerolopez.pruebacapitol.prices.infrastructure.repository.service.PriceInActionMapper;
import local.joseramonterrerolopez.pruebacapitol.shared.domain.exception.InvalidValueObjectException;
import local.joseramonterrerolopez.pruebacapitol.shared.infrastructure.dao.prices.jpa.PriceDto;
import local.joseramonterrerolopez.unit.pruebacapitol.prices.shared.PriceMother;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PriceInActionMapperTest {
    @InjectMocks
    private PriceInActionMapper priceInActionMapper;
    @Test
    public void test_mapping_from_dto_to_domain_works_properly_given_a_standard_price_dto()
    {
        // Given
        PriceDto priceDto = givenTheStandardPriceDto();

        // When
        PriceInAction result = priceInActionMapper.from(priceDto);

        // Then
        PriceInAction expected = givenTheStandardPriceInAction();
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void test_mapping_from_invalid_dto_to_domain_throws_a_domain_exception()
    {
        // Given
        PriceDto invalidPriceDto = givenAnInvalidPriceDto();

        // When & Then: Attempt to map the invalid DTO to the domain model and assert that it throws a DomainException
        Assertions.assertThatThrownBy(() -> {
            var priceInAction = priceInActionMapper.from(invalidPriceDto);
        })
        .isInstanceOf(InvalidValueObjectException.class);
    }
    private PriceDto givenTheStandardPriceDto()
    {
        return PriceMother.standardPriceDtoSubject();
    }

    private PriceInAction givenTheStandardPriceInAction()
    {
        return PriceMother.standardInActionSubject();
    }
    private PriceDto givenAnInvalidPriceDto()
    {
        return PriceMother.invalidPriceDtoSubject();
    }
}
