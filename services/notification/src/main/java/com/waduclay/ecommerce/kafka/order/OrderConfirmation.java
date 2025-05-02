package com.waduclay.ecommerce.kafka.order;


import com.waduclay.ecommerce.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
