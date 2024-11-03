package com.tc.springkafka.order

import com.tc.springkafka.config.KafkaConfig.Companion.DELIVERY_SERVICE_TOPIC
import com.tc.springkafka.model.Order
import java.util.UUID
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class OrderService(private val kafkaTemplate: KafkaTemplate<UUID, Order>) {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    fun completeOrder(order: Order) {
        kafkaTemplate.send(DELIVERY_SERVICE_TOPIC, order.id, order).whenComplete { _, exception ->
            if (exception == null) {
                logger.info("Successfully sent order with ID ${order.id}")
            } else {
                logger.error("Failed to send order with ID ${order.id}", exception)
            }
        }
    }

}