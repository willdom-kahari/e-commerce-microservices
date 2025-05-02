package com.waduclay.ecommerce.kafka;


import com.waduclay.ecommerce.email.EmailService;
import com.waduclay.ecommerce.kafka.order.OrderConfirmation;
import com.waduclay.ecommerce.kafka.payment.PaymentConfirmation;
import com.waduclay.ecommerce.notification.Notification;
import com.waduclay.ecommerce.notification.NotificationRepository;
import com.waduclay.ecommerce.notification.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationConsumer {
    private final NotificationRepository repository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void receivePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info("Received payment confirmation: {}", paymentConfirmation);
        Notification notification = Notification.builder()
                .type(NotificationType.PAYMENT_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .paymentConfirmation(paymentConfirmation)
                .build();
        repository.save(notification);
        var customerName = String.join(" ", paymentConfirmation.customerFirstName(), paymentConfirmation.customerLastName());

        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()
        );

    }

    @KafkaListener(topics = "order-topic")
    public void receiveOrderNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Received order confirmation: {}", orderConfirmation);
        Notification notification = Notification.builder()
                .type(NotificationType.ORDER_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .orderConfirmation(orderConfirmation)
                .build();
        repository.save(notification);

        var customerName = String.join(" ", orderConfirmation.customer().firstName(), orderConfirmation.customer().lastName());

        emailService.sendOrderConfirmation(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );
    }

}
