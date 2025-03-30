package com.waduclay.ecommerce.kafka;


import com.waduclay.ecommerce.customer.CustomerResponse;
import com.waduclay.ecommerce.order.Order;
import com.waduclay.ecommerce.order.PaymentMethod;
import com.waduclay.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
    public static OrderConfirmation of(Order order, CustomerResponse customer, List<PurchaseResponse> products) {
        return new OrderConfirmation(
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                customer,
                products
        );
    }
}
