package ru.shop.shoppingcart.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailDTO {

    private Integer orderId;
    private Integer productId;
    private BigDecimal price;
    private Integer quantity;
}
