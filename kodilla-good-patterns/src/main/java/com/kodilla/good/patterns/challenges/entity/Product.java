package com.kodilla.good.patterns.challenges.entity;

import com.kodilla.good.patterns.challenges.infrastructure.entity.AbstractEntity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Entity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Id;
import com.kodilla.good.patterns.challenges.repository.ProductRepository;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(repository = ProductRepository.class)
public class Product extends AbstractEntity {
    @Id
    private UUID uuid;
    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (uuid != null ? !uuid.equals(product.uuid) : product.uuid != null) return false;
        if (!name.equals(product.name)) return false;
        return price.equals(product.price);
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
