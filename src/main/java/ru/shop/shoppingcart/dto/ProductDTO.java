package ru.shop.shoppingcart.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private BigDecimal price;
    private String description;
    private Boolean inStock;
}
