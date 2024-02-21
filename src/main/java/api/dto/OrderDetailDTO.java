package api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class OrderDetailDTO {

    private Integer orderId;
    private Integer productId;
    private BigDecimal price;
    private Integer quantity;
}
