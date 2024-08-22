package com.example.products.infrastructure.outbound.repository;


import com.example.products.infrastructure.outbound.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Descripción de la clase.
 * </p>
 *
 * @author José Ignacio Ramos Vanegas
 * @version 1.0
 * @since 2024-08-19
 */
@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
