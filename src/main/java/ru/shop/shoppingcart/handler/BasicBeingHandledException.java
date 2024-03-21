package ru.shop.shoppingcart.handler;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public abstract class BasicBeingHandledException extends RuntimeException {
    private static final long serialVersionUID = 8393838748328283L;
    private final String code;
    private final String title;
    private final String errorTraceId = UUID.randomUUID().toString();
    private final LocalDateTime time = LocalDateTime.now();

    public BasicBeingHandledException(String code, String title, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.title = title;
    }
}
