package com.waduclay.ecommerce.payment;


import com.waduclay.ecommerce.customer.Customer;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
