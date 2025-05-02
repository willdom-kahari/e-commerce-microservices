package com.waduclay.ecommerce.payment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Integer> createPayment(
            @RequestBody @Valid PaymentRequest paymentRequest
    ) {
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }
}
