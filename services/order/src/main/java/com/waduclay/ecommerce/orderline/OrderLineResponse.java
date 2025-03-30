package com.waduclay.ecommerce.orderline;


/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public record OrderLineResponse(
        Integer id,
        Double quantity
) {
    public static OrderLineResponse of(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
}
