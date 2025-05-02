package com.waduclay.ecommerce.notification;


import com.waduclay.ecommerce.payment.PaymentMethod;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
