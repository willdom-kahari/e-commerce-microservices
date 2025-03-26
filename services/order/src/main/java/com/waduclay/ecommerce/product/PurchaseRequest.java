package com.waduclay.ecommerce.product;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record PurchaseRequest(
        @NotNull(message = "Product is mandatory")
        Integer productId,
        @Positive(message = "Quantity is mandatory")
        double quantity
) {
}
