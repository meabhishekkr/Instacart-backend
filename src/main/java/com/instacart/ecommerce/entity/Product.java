package com.instacart.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String detailedDescription;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(precision = 10, scale = 2)
    private BigDecimal compareAtPrice; // Original price for showing discounts

    @Column(precision = 10, scale = 2)
    private BigDecimal costPrice;

    @Column(nullable = false)
    private Integer stockQuantity = 0;

    @Column(nullable = false)
    private String sku; // Stock keeping Unit

    private String barcode;

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_url")
    private List<String> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToMany
    @JoinTable(name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductVariant> variants = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    @Column(precision = 2, scale = 1)
    private Double averageRating = 0.0;

    @Column(nullable = false)
    private Integer reviewCount = 0;

    @Column(nullable = false)
    private Integer viewCount = 0;

    @Column(nullable = false)
    private Integer salesCount = 0;

    private Double weight;

    private String dimensions;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus status = ProductStatus.DRAFT;

    @Column(nullable = false)
    private Boolean isFeatured = false;

    @Column(nullable = false)
    private Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private User seller;

    private LocalDateTime publishedAt;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    private String metaTitle;

    @Column(length = 500)
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
