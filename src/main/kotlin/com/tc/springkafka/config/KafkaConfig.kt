package com.tc.springkafka.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaConfig {

    companion object {
        const val DELIVERY_SERVICE_TOPIC = "delivery-service"
        const val DELIVERY_SERVICE_TOPIC_NUM_PARTITIONS = 1
        const val DELIVERY_SERVICE_TOPIC_REPLICATION_FACTOR: Short = 1
    }

    @Bean
    fun deliveryServiceTopic(): NewTopic {
        return NewTopic(DELIVERY_SERVICE_TOPIC, DELIVERY_SERVICE_TOPIC_NUM_PARTITIONS, DELIVERY_SERVICE_TOPIC_REPLICATION_FACTOR)
    }

}