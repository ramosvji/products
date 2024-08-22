package com.example.products.application;

import com.example.products.application.mapper.Mapper;
import com.example.products.infastructure.inbound.model.Product;
import com.example.products.infrastructure.outbound.repository.ProducerReposritory;
import com.example.products.infrastructure.outbound.repository.ProductRepository;
import com.mongodb.MongoTimeoutException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Descripción de la clase.
 * </p>
 *
 * @author José Ignacio Ramos Vanegas
 * @version 1.0
 * @since 2024-08-19
 */
@Service
public class ProductServiceImpl {

    @Autowired
    private Mapper mapper;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProducerReposritory productRepository;

    @CircuitBreaker(name = "mongoServiceCircuitBreaker", fallbackMethod = "saveProductFallback")
    public Product saveProduct(final Product product) throws MongoTimeoutException {
        return mapper.toDto(repository.save(mapper.toEntity(product)));
    }

    public void saveProductFallback(final Product product,  Throwable throwable ) {
            productRepository.sendProduct(mapper.toSubscriberModel(product));
    }
}
