package com.waduclay.ecommerce.payment;

import com.waduclay.ecommerce.notification.NotificationProducer;
import com.waduclay.ecommerce.notification.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Service
@RequiredArgsConstructor
class PaymentService {

    private final PaymentRepository paymentRepository;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest paymentRequest) {
        var payment = paymentRepository.save(Payment.of(paymentRequest));
        notificationProducer.sendPaymentNotification(
                new PaymentNotificationRequest(
                        paymentRequest.orderReference(),
                        paymentRequest.amount(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.customer().firstName(),
                        paymentRequest.customer().lastName(),
                        paymentRequest.customer().email()
                )
        );
        return payment.getId();
    }
}
