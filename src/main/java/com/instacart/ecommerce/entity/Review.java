package com.instacart.ecommerce.entity;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private Product product;
    private User user;
    private Integer rating;
    private String title;
    private String comment;
    private Boolean isVerifiedPurchase = false;
    private LocalDateTime createdAt;
}
