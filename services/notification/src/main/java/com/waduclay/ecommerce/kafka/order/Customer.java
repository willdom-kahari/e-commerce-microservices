package com.waduclay.ecommerce.kafka.order;


import org.springframework.validation.annotation.Validated;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Validated
public record Customer(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
