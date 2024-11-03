package com.tc.springkafka.model

import java.util.UUID

data class Order(
    val id: UUID = UUID.randomUUID(),
    val product: String,
    val deliveryAddress: String
)