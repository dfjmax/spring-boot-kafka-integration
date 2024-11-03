# Spring Boot Kafka Integration

## Project Overview
This project demonstrates integration between Spring Boot and Apache Kafka using Docker for local Kafka deployment. 
It includes a RESTful API for placing orders, which are processed and consumed from a Kafka topic.

## Tech Stack
- **Kotlin**
- **Spring Boot 3.3.5**
- **Kafka**
- **Zookeeper**
- **Kafka UI**
- **Docker**

### Prerequisites
- **Java 21** or higher.
- **Maven**
- **Docker and Docker Compose**

## Project Structure
```plaintext
.
├── src
│   ├── main
│   │   ├── kotlin/com/tc/springbootkafka
│   │   │   ├── Application.kt               # Main Spring Boot application
│   │   │   ├── config/KafkaConfig.kt        # Kafka topic configuration
│   │   │   ├── model/Order.kt               # Order model
│   │   │   ├── order/OrderService.kt        # Kafka producer service
│   │   │   ├── order/OrderController.kt     # REST controller
│   │   │   └── delivery/DeliveryListener.kt # Kafka consumer listener
│   └── test/kotlin/com/tc/springbootkafka   # Unit tests
├── docker-compose.yaml                      # Docker Compose for Kafka, Zookeeper, Kafka UI
├── pom.xml                                  # Maven dependencies and plugins
└── README.md                                # Project documentation
```

## How to Run the Application

1. **Clone the Repository**
    ```bash
    git clone https://github.com/dfjmax/spring-boot-kafka-integration.git
    cd spring-boot-kafka-integration
    ```
2. **Starting the application**: After the model is downloaded simply run:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## API Usage
**Place an Order:** Send a POST request to create an order. The orderId is auto-generated.
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"product": "Laptop", "deliveryAddress": "123 Main St"}' http://localhost:8080/api/orders
   ```

### Kafka Topic
* Topic Name: delivery-service
* Producer: OrderService sends order messages.
* Consumer: DeliveryListener consumes messages and logs order delivery processing.

### Viewing Kafka Messages
1.	Access Kafka UI at http://localhost:8090.
2.	Navigate to the delivery-service topic to view produced messages.