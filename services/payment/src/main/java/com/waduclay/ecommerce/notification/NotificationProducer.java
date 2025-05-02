package com.waduclay.ecommerce.notification;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationProducer {
    private final KafkaTemplate<String, PaymentNotificationRequest> kafkaTemplate;
    public void sendPaymentNotification(PaymentNotificationRequest paymentNotificationRequest){
        log.info("Sending payment notification with body <{}>", paymentNotificationRequest);
        Message<PaymentNotificationRequest> message = MessageBuilder
                .withPayload(paymentNotificationRequest)
                .setHeader(KafkaHeaders.TOPIC, "payment-topic")
                .build();
        kafkaTemplate.send(message);
        log.info("Payment notification sent successfully");
    }
}
