package com.example.products.infastructure.inbound;

import com.example.products.application.ProductServiceImpl;
import com.example.products.infastructure.inbound.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Descripción de la clase.
 * </p>
 *
 * @author José Ignacio Ramos Vanegas
 * @version 1.0
 * @since 2024-08-19
 */
@RestController
@RequestMapping(path="/example/api/products")
public class ProductSaveController {

    private final Logger logger = LoggerFactory.getLogger(ProductSaveController.class);

    @Autowired
    private ProductServiceImpl service;

    @PostMapping(path="/v1/products")
    public ResponseEntity<Product> saveProduct(final @RequestBody Product body) {
        logger.info("request post");

        service.saveProduct(body);

        return new ResponseEntity<Product>(null, new HttpHeaders(), HttpStatus.CREATED);
    }

}
