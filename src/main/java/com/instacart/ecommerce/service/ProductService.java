package com.instacart.ecommerce.service;

import com.instacart.ecommerce.dto.ProductDTO;
import com.instacart.ecommerce.entity.Product;
import com.instacart.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.incrementViewCount();
        productRepository.save(product);
        return product;
    }

    private ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .slug(product.getSlug())
                .description(product.getDescription())
                .price(product.getPrice())
                .compareAtPrice(product.getCompareAtPrice())
                .stockQuantity(product.getStockQuantity())
                .sku(product.getSku())
                .images(product.getImages())
                .categoryName(product.getCategory() != null ? product.getCategory().getName() : null)
                .brandName(product.getBrand() != null ? product.getBrand().getName():null)
                .averageRating(product.getAverageRating())
                .reviewCount(product.getReviewCount())
                .isFeatured(product.getIsFeatured())
                .build();
    }
}
