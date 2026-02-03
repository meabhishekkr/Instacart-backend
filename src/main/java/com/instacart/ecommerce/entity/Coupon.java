package com.instacart.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "coupons")
@Data
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiscountType discountType;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal discountValue;

    @Column(precision = 10, scale = 2)
    private BigDecimal minOrderAmount;

    @Column(precision = 10, scale = 2)
    private BigDecimal maxDiscountAmount;

    private Integer usageLimit;

    private Integer usageCount = 0;

    private Integer perUserLimit;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Column(nullable = false)
    private Boolean isActive = true;

    public enum DiscountType {
        PERCENTAGE,
        FIXED_AMOUNT
    }
}
