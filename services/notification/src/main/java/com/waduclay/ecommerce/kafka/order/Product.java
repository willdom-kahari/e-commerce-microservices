package com.waduclay.ecommerce.kafka.order;


import java.math.BigDecimal;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record Product(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
