package api.version_1.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "in_stock")
    private Boolean inStock;
}
