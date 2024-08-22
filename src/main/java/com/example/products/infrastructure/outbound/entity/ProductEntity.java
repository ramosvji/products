package com.example.products.infrastructure.outbound.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>
 * Descripción de la clase.
 * </p>
 *
 * @author José Ignacio Ramos Vanegas
 * @version 1.0
 * @since 2024-08-19
 */
@Document(collection= "products")
public class ProductEntity {
        @Id
        String id;
        String name;
        String category;
        String description;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}
