
# CQRS Pattern – Complete Example (Spring Boot + Kafka + Redis)

## 1. What is CQRS?

CQRS stands for **Command Query Responsibility Segregation**.

It is an architectural pattern that **separates read operations (queries) from write operations (commands)**.

In traditional CRUD systems, the same model handles:

- Creating data
- Updating data
- Deleting data
- Reading data

CQRS separates these responsibilities into **two different models**:

- **Command Model** → responsible for modifying data (writes)
- **Query Model** → responsible for retrieving data (reads)

This separation allows systems to scale and optimize read and write workloads independently.

---

# 2. Why Use CQRS?

Modern applications often have:

- Millions of **read requests**
- Fewer **write requests**
- Complex **business rules for writes**
- Optimized **data structures for reads**

Using one model for both creates problems:

Example:

Order table optimized for writes may not be optimized for search queries.

CQRS solves this by creating:

Write Model → optimized for **business logic**
Read Model → optimized for **fast queries**

---

# 3. High Level Architecture

```
                 +-----------+
                 |  Client   |
                 +-----------+
                       |
               REST API Controller
                       |
              +------------------+
              | Command Service  |
              +------------------+
                       |
                   Write DB
                 (PostgreSQL)
                       |
                Publish Event
                       |
                      Kafka
                       |
                Event Consumer
                       |
             Build Read Model
                       |
                    Redis
                       |
             +------------------+
             | Query Service    |
             +------------------+
                       |
                    Client
```

---

# 4. Command Side (Write Model)

The **Command side** handles operations that change system state.

Examples:

- Create Order
- Update Order
- Cancel Order

Command flow:

```
Client
  |
POST /orders
  |
Controller
  |
OrderCommandService
  |
JPA Repository
  |
Write Database
```

After the write succeeds, the system publishes an **event**.

Example event:

```
OrderCreatedEvent
```

---

# 5. Event Streaming Layer

Events are sent to **Kafka**.

Kafka acts as a **message broker** that distributes events to other services.

Example:

```
OrderCommandService
        |
        v
   Kafka Topic
        |
        v
   Multiple Consumers
```

This allows:

- asynchronous processing
- decoupled architecture
- horizontal scalability

---

# 6. Query Side (Read Model)

The Query side is optimized for **fast reads**.

Instead of reading from the relational database, we read from **Redis**.

Example flow:

```
Kafka Consumer
      |
      v
Transform Event
      |
      v
Store Projection
      |
      v
Redis
```

Query request:

```
Client
  |
GET /orders/{id}
  |
Query Service
  |
Redis
  |
Client
```

---

# 7. Eventual Consistency

CQRS systems are **eventually consistent**.

This means the read model may be updated **slightly after** the write operation.

Example timeline:

```
Create Order
     |
Write DB
     |
Publish Event
     |
Consumer Updates Redis
```

There may be a delay of a few milliseconds.

---

# 8. Technology Stack Used

| Layer | Technology |
|------|-----------|
API | Spring Boot |
Write DB | PostgreSQL / H2 |
Event Streaming | Kafka |
Read Model | Redis |
Containerization | Docker |
ORM | Hibernate / JPA |

---

# 9. Project Structure

```
src/main/java/com/example/cqrs

api
 └── OrderController

command
 ├── CreateOrderCommand
 └── OrderCommandService

domain
 └── Order

event
 ├── OrderCreatedEvent
 └── OrderEventConsumer

query
 ├── OrderView
 └── OrderQueryService

repository
 └── OrderRepository
```

---

# 10. Sequence Diagram

```
Client
  |
POST /orders
  |
Controller
  |
Command Service
  |
Save Order
  |
PostgreSQL
  |
Publish Event
  |
Kafka
  |
Kafka Consumer
  |
Build Read Model
  |
Redis
  |
Client GET /orders/{id}
  |
Query Service
  |
Redis
  |
Response
```

---

# 11. Advantages of CQRS

### 1. Scalability

Reads and writes can scale independently.

### 2. Performance

Read models can be optimized for fast queries.

### 3. Separation of Concerns

Business logic and query logic are separated.

### 4. Event Driven Architecture

Supports event-driven systems.

### 5. Microservice Friendly

Works well with distributed systems.

---

# 12. Disadvantages of CQRS

### 1. Increased Complexity

More components and infrastructure.

### 2. Eventual Consistency

Read model may lag behind write model.

### 3. Debugging Difficulty

Event-based systems can be harder to debug.

### 4. Infrastructure Cost

Requires Kafka, Redis, messaging systems.

---

# 13. When to Use CQRS

Use CQRS when:

- Read traffic is much higher than write traffic
- Complex business logic exists for writes
- You need scalable distributed systems
- Event-driven architecture is required

Avoid CQRS when:

- Small applications
- Simple CRUD systems
- Low traffic systems

---

# 14. Real World Companies Using CQRS

Many large scale companies use CQRS:

- Amazon
- Uber
- Netflix
- LinkedIn
- Banking platforms

---

# 15. Running the Project

Start infrastructure:

```
docker compose up
```

Run application:

```
Run CqrsApplication.java
```

---

# 16. API Examples

Create Order

POST /orders

```
{
  "product": "Laptop",
  "quantity": 2
}
```

Fetch Order

GET /orders/1

---

# 17. Future Improvements

Production systems often include:

- Outbox Pattern
- Schema Migration (Flyway)
- Monitoring (Prometheus)
- Distributed tracing
- Event versioning
- Dead letter queues

---

# 18. Summary

CQRS separates **read and write responsibilities**.

This enables:

- scalable architecture
- better performance
- event-driven systems

However, it also introduces **additional complexity**, so it should be used only when needed.
