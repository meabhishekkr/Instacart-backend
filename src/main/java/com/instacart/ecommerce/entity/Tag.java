package com.instacart.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

public class Tag {
    private Long id;
    private String name;
    private Set<Product> products = new HashSet<>();
}
