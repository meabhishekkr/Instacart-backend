package com.instacart.ecommerce.entity;

import java.math.BigDecimal;

public class ProductVariant {
    private Long id;
    private Product product;
    private String name;
    private String size;
    private String color;
    private String sku;
    private BigDecimal price;
    private Integer stockQuantity = 0;
    private String imageUrl;
}
