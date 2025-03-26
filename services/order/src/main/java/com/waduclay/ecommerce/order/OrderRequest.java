package com.waduclay.ecommerce.order;


import com.waduclay.ecommerce.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message = "Order amount must be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method should be precised")
        PaymentMethod paymentMethod,
        @NotBlank(message = "Customer should be present")
        String customerId,
        @NotEmpty(message = "You should at least purchase one product")
        List<PurchaseRequest> products
) {
}
