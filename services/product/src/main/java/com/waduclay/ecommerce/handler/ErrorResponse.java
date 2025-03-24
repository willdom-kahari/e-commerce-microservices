package com.waduclay.ecommerce.handler;


import java.util.Map;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record ErrorResponse(
        Map<String, String> errors
) {
}
