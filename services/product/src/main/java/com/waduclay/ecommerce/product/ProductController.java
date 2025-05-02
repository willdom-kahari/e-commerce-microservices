package com.waduclay.ecommerce.product;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProductRequest request
    ){
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> requests
    ){
        return ResponseEntity.ok(productService.purchaseProducts(requests));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("product-id") Integer id
    ){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }
}
