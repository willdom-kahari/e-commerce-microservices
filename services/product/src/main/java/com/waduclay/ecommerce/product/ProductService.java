package com.waduclay.ecommerce.product;


import com.waduclay.ecommerce.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
        var productIds = requests.stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        var storedProducts = productRepository.findAllByIdInOrderById(productIds);

        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exists");
        }

        var storedRequests = requests.stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();

        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (var i = 0; i < storedRequests.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequests.get(i);

            if (product.getAvailableQuantity() < productRequest.quantity()){
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: %s".formatted(productRequest.productId()));
            }

            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(ProductPurchaseResponse.of(product, productRequest.quantity())); // Placeholder for product purchase response. In a real-world scenario, you would return this object with purchase details.
        }
        return purchasedProducts;
    }

    public ProductResponse findById(Integer id) {
        return productRepository.findById(id)
                .map(ProductResponse::of)
                .orElseThrow(()-> new EntityNotFoundException("Product with id %d not found".formatted(id)));
    }

    public List<ProductResponse> findAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::of)
                .toList();
    }
}
