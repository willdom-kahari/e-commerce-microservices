package com.waduclay.ecommerce.order;


import com.waduclay.ecommerce.customer.CustomerClient;
import com.waduclay.ecommerce.exception.BusinessException;
import com.waduclay.ecommerce.kafka.OrderConfirmation;
import com.waduclay.ecommerce.kafka.OrderProducer;
import com.waduclay.ecommerce.orderline.OrderLineRequest;
import com.waduclay.ecommerce.orderline.OrderLineService;
import com.waduclay.ecommerce.payment.PaymentClient;
import com.waduclay.ecommerce.payment.PaymentRequest;
import com.waduclay.ecommerce.product.ProductClient;
import com.waduclay.ecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(@Valid OrderRequest request) {
        //check the customer (OpenFeign)
        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: Customer with id %s not found".formatted(request.customerId())));

        // purchase the products (product microservice)
        var products = productClient.purchaseProducts(request.products());

        // persist order
        var order = orderRepository.save(Order.of(request));

        // persist order lines
        for(PurchaseRequest purchaseRequest: request.products()) {
            orderLineService.saveOrderLine(new OrderLineRequest(null, order.getId(), purchaseRequest.productId(), purchaseRequest.quantity()));
        }

        //TODO: start payment process
        PaymentRequest paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                request.id(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);
        // send the order confirmation (notification microservice - kafka)

        orderProducer.sendOrderConfirmation(OrderConfirmation.of(order, customer, products));
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
               .stream()
               .map(OrderResponse::of)
               .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer id) {
        return orderRepository.findById(id)
               .map(OrderResponse::of)
               .orElseThrow(() -> new EntityNotFoundException("Order with id %d not found".formatted(id)));
    }
}
