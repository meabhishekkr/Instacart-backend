package com.instacart.ecommerce.entity;

import java.time.LocalDateTime;

public class OrderStatusHistory {
    private Long id;
    private Order order;
    private Order.OrderStatus status;
    private String notes;
    private LocalDateTime createdAt;
}
