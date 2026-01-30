package com.instacart.ecommerce.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private String orderNumber;
    private User user;
    private List<OrderItem> orderItems = new ArrayList<>();
    private OrderStatus orderStatus = OrderStatus.PENDING;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    private PaymentMethod paymentMethod;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal shippingCost;
    private BigDecimal discount = BigDecimal.ZERO;
    private BigDecimal totalAmount;
    private Coupon coupon;
    private Address shippingAddress;
    private Address billingAddress;
    private String trackingNumber;
    private String shippingCarrier;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime deliveredAt;
    private LocalDateTime cancelledAt;
    private String cancellationReason;
    private String notes;
    private String customerNotes;
    private String paymentIntentId;
    private String transactionId;
    private List<OrderStatusHistory> statusHistory = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum OrderStatus {
        PENDING,
        CONFIRMED,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED,
        RETURNED,
        REFUNDED
    }

    public enum PaymentStatus {
        PENDING,
        AUTHORIZED,
        PAID,
        FAILED,
        REFUNDED,
        PARTIALLY_REFUNDED
    }

    public enum PaymentMethod {
        CREDIT_CARD,
        DEBIT_CARD,
        CASH_ON_DELIVERY,
        BANK_TRANSFER,
        UPI
    }

    public void calculateTotal() {
        this.subtotal = orderItems.stream().map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.totalAmount = subtotal.add(tax).add(shippingCost).subtract(discount);
    }
}
