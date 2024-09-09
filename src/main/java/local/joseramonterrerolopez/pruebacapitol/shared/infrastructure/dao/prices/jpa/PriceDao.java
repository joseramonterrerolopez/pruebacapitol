package local.joseramonterrerolopez.pruebacapitol.shared.infrastructure.dao.prices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceDao extends JpaRepository<PriceDto, Integer> {
    @Query("SELECT p FROM PriceDto p WHERE p.brandId = :brandId AND p.productId = :productId AND p.startDate <= :dateTime AND p.endDate >= :dateTime ORDER BY p.priority DESC LIMIT 1")
    Optional<PriceDto> findInAction(
        @Param("brandId") int brandId,
        @Param("productId") int productId,
        @Param("dateTime") LocalDateTime dateTime
    );
}
