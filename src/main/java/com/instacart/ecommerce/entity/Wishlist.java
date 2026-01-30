package com.instacart.ecommerce.entity;

import java.time.LocalDateTime;

public class Wishlist {
    private Long id;
    private User user;
    private Product product;
    private LocalDateTime createdAt;
}
