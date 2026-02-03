package com.instacart.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "product_variants")
@Data
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private String name;

    private String size;

    private String color;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private Integer stockQuantity = 0;

    private String imageUrl;
}
