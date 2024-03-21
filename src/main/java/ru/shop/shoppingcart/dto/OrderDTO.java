package ru.shop.shoppingcart.dto;

import lombok.*;
import ru.shop.shoppingcart.enums.OrderStatus;
import ru.shop.shoppingcart.enums.PaymentMethod;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private Integer customerId;
}
