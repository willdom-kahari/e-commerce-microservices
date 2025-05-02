package com.waduclay.ecommerce.payment;


import com.waduclay.ecommerce.customer.CustomerResponse;
import com.waduclay.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
