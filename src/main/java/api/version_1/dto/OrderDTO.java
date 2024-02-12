package api.version_1.dto;

import api.version_1.Enums;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    private LocalDate orderDate;
    private Enums.OrderStatus orderStatus;
    private Enums.PaymentMethod paymentMethod;
    private Integer customerId;
}
