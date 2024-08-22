package com.example.products.infrastructure.outbound.repository;

import com.example.products.infrastructure.outbound.entity.ProductSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Descripción de la clase.
 * </p>
 *
 * @author José Ignacio Ramos Vanegas
 * @version 1.0
 * @since 2024-08-21
 */
@Repository
public class ProducerReposritory {

    @Autowired
    private KafkaTemplate<String, ProductSub> template;

    public void sendProduct(ProductSub productSub) {
        template.send("topico-prueba",productSub);
    }
}
