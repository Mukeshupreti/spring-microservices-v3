
# Advanced CQRS Example (Spring Boot + Kafka + Redis)

This project demonstrates a **production-style CQRS architecture**.

## Architecture

Command Side
------------
Client → REST API → Command Service → PostgreSQL/H2

Event Streaming
---------------
Command Service → Kafka Topic

Query Side
----------
Kafka Consumer → Build Read Model → Redis

Query API → Redis

## Sequence Diagram

Client
   |
POST /orders
   |
OrderCommandService
   |
Write DB (JPA)
   |
Publish Event
   |
Kafka Topic
   |
Kafka Consumer
   |
Redis Read Model
   |
GET /orders/{id}

## Technologies

- Spring Boot
- Kafka
- Redis
- Docker Compose
- JPA / Hibernate

## Running the Project

Start infrastructure:

docker compose up

Run application:

Run CqrsApplication.java

## Test

Create order

POST /orders

{
 "product": "Laptop",
 "quantity": 2
}

Fetch order

GET /orders/1
