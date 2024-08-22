package com.example.products.application.configuration;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Descripción de la clase.
 * </p>
 *
 * @author José Ignacio Ramos Vanegas
 * @version 1.0
 * @since 2024-08-20
 */
@Configuration
public class MongoConfiguration {

    @Bean
    public MongoClient mongoClient() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.serverSelectionTimeout(3, TimeUnit.SECONDS)) // Tiempo de espera para seleccionar un servidor
                .applyToSocketSettings(builder ->
                        builder.connectTimeout(3, TimeUnit.SECONDS) // Tiempo de espera para conectar
                                .readTimeout(3, TimeUnit.SECONDS)) // Tiempo de espera para leer
                .applyToConnectionPoolSettings(builder ->
                        builder.maxWaitTime(3, TimeUnit.SECONDS) // Tiempo máximo de espera en el pool de conexiones
                                .maxConnectionIdleTime(1, TimeUnit.SECONDS)) // Tiempo máximo de inactividad en el pool de conexiones
                .build();

        return MongoClients.create(settings);
    }

}
