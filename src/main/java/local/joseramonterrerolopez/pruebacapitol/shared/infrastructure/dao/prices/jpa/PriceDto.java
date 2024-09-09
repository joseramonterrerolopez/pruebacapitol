package local.joseramonterrerolopez.pruebacapitol.shared.infrastructure.dao.prices.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@NoArgsConstructor
@Getter
public class PriceDto {
    @Id
    @Column(name = "price_list", nullable = false)
    private Integer priceList;
    @Column(name = "brand_id", nullable = false)
    private Integer brandId;
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;
    @Column(name = "price", nullable = false)
    private Float price;
    @Column(name = "curr", nullable = false, length = 3)
    private String currency;
    @Column(name = "priority", nullable = false)
    private Integer priority;
}
