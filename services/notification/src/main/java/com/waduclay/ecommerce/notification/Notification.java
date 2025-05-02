package com.waduclay.ecommerce.notification;


import com.waduclay.ecommerce.kafka.order.OrderConfirmation;
import com.waduclay.ecommerce.kafka.payment.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Getter
@Setter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    private String id;
    private NotificationType type;
    private String message;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
