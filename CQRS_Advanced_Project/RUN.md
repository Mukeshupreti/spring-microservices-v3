# Run Guide

This document explains how to run the CQRS demo end to end and verify each stage with logs, Kafka, Redis, and H2.

## Project Directory

Run all commands from:

```bash
cd /home/mukesh/IdeaProjects/spring-microservices-v3/CQRS_Advanced_Project
```

## 1. Start Infrastructure

Start ZooKeeper, Kafka, and Redis:

```bash
docker compose up -d
docker compose ps
```

Expected services:

- `zookeeper`
- `kafka`
- `redis`

## 2. Start the Spring Boot Application

Run the application:

```bash
mvn spring-boot:run
```

If you use IntelliJ, run:

- `com.example.cqrs.CqrsApplication`

Application URL:

```text
http://localhost:8080
```

## 3. End-to-End Write Flow

Create an order:

```bash
curl -X POST http://localhost:8080/orders \
  -H 'Content-Type: application/json' \
  -d '{"product":"Laptop","quantity":2}'
```

Example response:

```text
1
```

Create another order:

```bash
curl -X POST http://localhost:8080/orders \
  -H 'Content-Type: application/json' \
  -d '{"product":"Phone","quantity":3}'
```

## 4. End-to-End Read Flow

Read order `1`:

```bash
curl http://localhost:8080/orders/1
```

Example response:

```json
{"id":1,"product":"Laptop","quantity":2}
```

Read order `2`:

```bash
curl http://localhost:8080/orders/2
```

## 5. Application Logs to Watch

The application now logs the CQRS flow in numbered steps.

### Write-side logs

After `POST /orders`, look for these logs in the Spring Boot console:

```text
STEP 1: Controller received create order request
STEP 2: Order saved to DB
STEP 3: Event published to Kafka topic=order-created
STEP 4: Event consumed from Kafka topic=order-created
STEP 5: Redis read model updated for key=order:{id}
```

### Read-side logs

After `GET /orders/{id}`, look for:

```text
READ STEP 1: Controller received read request for orderId={id}
READ STEP 2: Query service reading from Redis for key=order:{id}
READ STEP 3: Query service returned data from Redis for orderId={id}
```

These logs prove:

- controller received the request
- data was saved in DB
- event was published to Kafka
- Kafka listener consumed the event
- Redis read model was updated
- read API returned data from Redis

## 6. Check Kafka Messages

Consume messages from Kafka topic `order-created`:

```bash
docker compose exec kafka kafka-console-consumer \
  --bootstrap-server localhost:9092 \
  --topic order-created \
  --from-beginning
```

When you create an order, you should see JSON-like event data for the new message.

## 7. Check Redis Data

List keys in Redis:

```bash
docker compose exec redis redis-cli --raw KEYS '*'
```

Read order `1` from Redis:

```bash
docker compose exec redis redis-cli --raw GET order:1
```

Read order `2` from Redis:

```bash
docker compose exec redis redis-cli --raw GET order:2
```

You can also open interactive Redis CLI:

```bash
docker compose exec redis redis-cli
```

Then run:

```redis
KEYS *
GET order:1
GET order:2
```

## 8. Access H2 Console

H2 console is enabled at:

```text
http://localhost:8080/h2-console
```

Use these values:

- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `sa`
- Password: leave empty

Once connected, run:

```sql
SELECT * FROM orders;
```

Use table `orders`, not `order`.

## 9. Full Verification Sequence

Use this order to verify the whole application:

1. Start Docker services with `docker compose up -d`.
2. Start the Spring Boot app with `mvn spring-boot:run`.
3. Send a `POST /orders` request.
4. Watch the Spring Boot logs for `STEP 1` through `STEP 5`.
5. Watch Kafka topic `order-created` with `kafka-console-consumer`.
6. Check Redis key `order:{id}` with `redis-cli`.
7. Call `GET /orders/{id}`.
8. Watch `READ STEP 1` through `READ STEP 3`.
9. Open H2 console and run `SELECT * FROM orders;`.

## 10. Troubleshooting

### `no configuration file provided: not found`

You are probably not in the project directory. Run:

```bash
cd /home/mukesh/IdeaProjects/spring-microservices-v3/CQRS_Advanced_Project
```

### Kafka consumer joined but no event was consumed

The consumer may be ready but no `POST /orders` request has been sent yet. Send a create request and check the app logs again.

### Redis looks empty

Verify from the application first:

```bash
curl http://localhost:8080/orders/1
```

If this returns data, Redis already contains the read model because the query side reads from Redis.

### H2 table creation error with `order`

This project uses table `orders` to avoid H2 reserved keyword issues.
