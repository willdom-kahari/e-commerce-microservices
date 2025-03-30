package com.waduclay.ecommerce.order;


import java.math.BigDecimal;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record OrderResponse(
        Integer id,
        PaymentMethod paymentMethod,
        BigDecimal amount,
        String reference,
        String customerId
) {
    public static OrderResponse of(Order order) {
        return new OrderResponse(order.getId(), order.getPaymentMethod(), order.getTotalAmount(), order.getReference(), order.getCustomerId());
    }
}
