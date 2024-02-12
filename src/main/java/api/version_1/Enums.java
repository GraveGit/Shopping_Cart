package api.version_1;

public class Enums {

    public enum OrderStatus {
        created,
        processing,
        cancelled,
        shipped
    };
    public enum PaymentMethod {
        CREDIT_CARD,
        PAY_PAL,
        ON_RECEIPT
    }
}
