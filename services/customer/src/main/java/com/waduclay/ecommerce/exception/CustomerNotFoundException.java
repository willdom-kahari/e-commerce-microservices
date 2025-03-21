package com.waduclay.ecommerce.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerNotFoundException extends RuntimeException {
    private final String message;
}
