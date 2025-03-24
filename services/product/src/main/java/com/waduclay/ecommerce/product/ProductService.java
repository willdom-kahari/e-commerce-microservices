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
    private final ProductRepository productRepository;
    public Integer createProduct(@Valid ProductRequest request) {
        Product product = Product.of(request);
        return productRepository.save(product).getId();
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
