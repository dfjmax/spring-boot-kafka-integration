package com.tc.springkafka.delivery

import com.tc.springkafka.config.KafkaConfig.Companion.DELIVERY_SERVICE_TOPIC
import com.tc.springkafka.model.Order
import java.util.UUID
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class DeliveryListener {

    companion object {
        private val logger = LoggerFactory.getLogger(DeliveryListener::class.java)
    }

    @KafkaListener(topics = [DELIVERY_SERVICE_TOPIC])
    fun processOrder(record: ConsumerRecord<UUID, Order>) {
        logger.info("Processing delivery for order ID: ${record.key()} to ${record.value().deliveryAddress}")
    }

}