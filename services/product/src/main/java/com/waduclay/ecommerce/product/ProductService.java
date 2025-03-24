package com.waduclay.ecommerce.product;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    public Integer createProduct(@Valid ProductRequest request) {
        return null;
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requests) {
        return null;
    }

    public ProductResponse findById(Integer id) {
        return null;
    }

    public List<ProductResponse> findAllProducts() {
        return null;
    }
}
