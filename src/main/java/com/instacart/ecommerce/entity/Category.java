package com.instacart.ecommerce.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class Category {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String imageUrl;
    private Category parent;
    private Set<Category> subCategories = new HashSet<>();
    private Set<Product> products = new HashSet<>();
    private Boolean isActive = true;
    private Integer displayOrder = 0;
    private String metaTitle;
    private String metaDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
