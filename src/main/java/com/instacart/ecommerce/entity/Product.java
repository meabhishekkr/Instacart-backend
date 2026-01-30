package com.instacart.ecommerce.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Product {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String detailedDescription;
    private BigDecimal price;
    private BigDecimal compareAtPrice; // Original price for showing discounts
    private BigDecimal costPrice;
    private Integer stockQuantity = 0;
    private String sku; // Stock keeping Unit
    private String barcode;
    private List<String> images = new ArrayList<>();
    private Category category;
    private Brand brand;
    private Set<Tag> tags = new HashSet<>();
    private List<ProductVariant> variants = new ArrayList<>();
    private Set<Review> reviews = new HashSet<>();
    private Double averageRating = 0.0;
    private Integer reviewCount = 0;
    private Integer viewCount = 0;
    private Integer salesCount = 0;
    private Double weight;
    private String dimensions;
    private ProductStatus status = ProductStatus.DRAFT;
    private Boolean isFeatured = false;
    private Boolean isActive = true;
//    private User seller;
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;
    public enum ProductStatus {
        DRAFT,
        ACTIVE,
        OUT_OF_STOCK,
        DISCONTINUED,
        ARCHIVED
    }
    public void incrementViewCount() {
        this.viewCount++;
    }

    public void incrementSalesCount(int quantity) {
        this.salesCount += quantity;
    }

    public void decreaseStock(int quantity) {
        if (this.stockQuantity >= quantity) {
            this.stockQuantity -= quantity;
            if (this.stockQuantity == 0) {
                this.status = ProductStatus.OUT_OF_STOCK;
            }
        }
    }

    public void increaseStock(int quantity) {
        this.stockQuantity += quantity;
        if (this.status == ProductStatus.OUT_OF_STOCK && this.stockQuantity > 0) {
            this.status = ProductStatus.ACTIVE;
        }
    }
}
