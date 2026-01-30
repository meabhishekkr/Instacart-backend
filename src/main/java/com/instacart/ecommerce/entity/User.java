package com.instacart.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private UserRole role = UserRole.CUSTOMER;
    private Boolean enabled = true;
    private Boolean accountNonLocked = true;
    private String emailVerificationToken;
    private LocalDateTime emailVerificationTokenExpiry;
    private Boolean emailVerified = false;
    private String passwordResetToken;
    private LocalDateTime passwordResetTokenExpiry;
    private Set<Address> addresses = new HashSet<>();
    private Cart cart;
    private Set<Order> orders = new HashSet<>();
    private Set<Review> reviews = new HashSet<>();
    private Set<Wishlist> wishlists = new HashSet<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;
    public enum UserRole {
        CUSTOMER,
        SELLER,
        ADMIN,
        SUPER_ADMIN
    }
}
