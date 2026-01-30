package com.instacart.ecommerce.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Coupon {
    private Long id;
    private String code;
    private String description;
    private DiscountType discountType;
    private BigDecimal discountValue;
    private BigDecimal minOrderAmount;
    private BigDecimal maxDiscountAmount;
    private Integer usageLimit;
    private Integer usageCount = 0;
    private Integer perUserLimit;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isActive = true;
    public enum DiscountType {
        PERCENTAGE,
        FIXED_AMOUNT
    }
}
