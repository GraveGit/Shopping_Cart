package api.dto;

import api.enumclass.OrderStatus;
import api.enumclass.PaymentMethod;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private Integer customerId;
}
