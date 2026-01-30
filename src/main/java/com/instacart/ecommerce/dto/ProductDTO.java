package com.instacart.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private BigDecimal price;
    private BigDecimal compareAtPrice;
    private Integer stockQuantity;
    private String sku;
    private List<String> images;
    private String categoryName;
    private Long categoryId;
    private String brandName;
    private Double averageRating;
    private Integer reviewCount;
    private Boolean isFeatured;
}
