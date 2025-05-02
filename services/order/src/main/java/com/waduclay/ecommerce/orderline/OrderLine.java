package com.waduclay.ecommerce.orderline;

import com.waduclay.ecommerce.order.Order;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Getter
@Setter
@Entity
@Builder
@Table(name = "customer_line")
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private double quantity;

    public static OrderLine of(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.id())
                .productId(orderLineRequest.productId())
                .order(Order.builder().id(orderLineRequest.orderId()).build())
                .quantity(orderLineRequest.quantity())
                .build();
    }
}
