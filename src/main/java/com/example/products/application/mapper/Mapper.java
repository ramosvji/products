package com.example.products.application.mapper;

import com.example.products.infastructure.inbound.model.Product;
import com.example.products.infrastructure.outbound.entity.ProductEntity;
import com.example.products.infrastructure.outbound.entity.ProductSub;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Descripción de la clase.
 * </p>
 *
 * @author José Ignacio Ramos Vanegas
 * @version 1.0
 * @since 2024-08-19
 */
@Component
public class Mapper {

    public ProductEntity toEntity(final Product product) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(product.name());
        productEntity.setCategory(product.category());
        productEntity.setDescription(product.description());

        return productEntity;
    }

    public Product toDto(ProductEntity productEntity) {
        Product product = new Product(productEntity.getId(),
                productEntity.getName(),
                productEntity.getCategory(),
                productEntity.getCategory());

        return product;
    }

    public ProductSub toSubscriberModel(final Product product) {
        ProductSub productSub = new ProductSub();
        productSub.setName(product.name());
        productSub.setCategory(product.category());
        productSub.setDescription(product.description());

        return productSub;
    }
}
