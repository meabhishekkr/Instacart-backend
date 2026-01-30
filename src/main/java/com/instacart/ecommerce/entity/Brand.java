package com.instacart.ecommerce.entity;

import lombok.Data;

@Data
public class Brand {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String logoUrl;
    private Boolean isActive = true;
}
