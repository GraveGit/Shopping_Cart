package api.version_1.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private String name;
    private BigDecimal price;
    private String description;
    private Boolean inStock;
}
