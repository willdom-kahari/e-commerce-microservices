package com.waduclay.ecommerce.customer;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Validated
public record Customer(
        String id,
        @NotBlank(message = "Customer first name is required")
        String firstName,
        @NotBlank(message = "Customer last name is required")
        String lastName,
        @Email(message = "Customer email is not correctly formatted")
        String email
) {
}
