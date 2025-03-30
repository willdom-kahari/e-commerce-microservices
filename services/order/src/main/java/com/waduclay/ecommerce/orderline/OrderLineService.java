package com.waduclay.ecommerce.orderline;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        OrderLine orderLine = OrderLine.of(orderLineRequest);
        return orderLineRepository.save(orderLine).getId();
    }

    public List<OrderLineResponse> findByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrder_Id(orderId)
               .stream()
               .map(OrderLineResponse::of)
               .toList();
    }
}
