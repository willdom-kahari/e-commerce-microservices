package com.waduclay.ecommerce.customer;


/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
