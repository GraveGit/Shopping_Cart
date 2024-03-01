package ru.shop.shoppingcart.dto;

import ru.shop.shoppingcart.enums.OrderStatus;
import ru.shop.shoppingcart.enums.PaymentMethod;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private Integer customerId;
}
