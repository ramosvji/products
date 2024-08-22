package com.example.products.application.configuration;

import com.example.products.infrastructure.outbound.entity.ProductSub;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Descripción de la clase.
 * </p>
 *
 * @author José Ignacio Ramos Vanegas
 * @version 1.0
 * @since 2024-08-21
 */

@Configuration
public class KafkaConfiguration {
    private Map<String, Object> producerProps() {
        Map<String, Object> props=new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return props;
    }

    @Bean
    public KafkaTemplate<String, ProductSub> createTemplate() {
        Map<String, Object>senderProps= producerProps();
        ProducerFactory<String, ProductSub> pf= new
                DefaultKafkaProducerFactory<String, ProductSub>(senderProps);
        KafkaTemplate<String, ProductSub> template=new KafkaTemplate<>(pf);
        return template;
    }

}
