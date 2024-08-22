package com.example.products.infastructure.inbound.model;

import java.io.Serializable;

/**
 * <p>
 * Descripción de la clase.
 * </p>
 *
 * @author José Ignacio Ramos Vanegas
 * @version 1.0
 * @since 2024-08-19
 */
public record Product(String id,
                      String name,
                      String category,
                      String description) implements Serializable {
}
