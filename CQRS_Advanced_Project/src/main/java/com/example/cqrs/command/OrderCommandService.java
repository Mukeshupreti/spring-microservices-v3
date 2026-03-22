
package com.example.cqrs.command;

import com.example.cqrs.command.dto.CreateOrderCommandDTO;
import com.example.cqrs.domain.Order;
import com.example.cqrs.event.OrderCreatedEvent;
import com.example.cqrs.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandService {

    private static final Logger log = LoggerFactory.getLogger(OrderCommandService.class);
    private final OrderRepository repository;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderCommandService(OrderRepository repository, KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Long createOrder(CreateOrderCommandDTO command) {

        Order order = new Order();
        order.setProduct(command.getProduct());
        order.setQuantity(command.getQuantity());
        order.setStatus("CREATED");

        repository.save(order);
        log.info("STEP 2: Order saved to DB: orderId={}, product={}, quantity={}, status={}",
                order.getId(), order.getProduct(), order.getQuantity(), order.getStatus());

        OrderCreatedEvent event = new OrderCreatedEvent(
                order.getId(),
                order.getProduct(),
                order.getQuantity()
        );
        kafkaTemplate.send("order-created", event);
        log.info("STEP 3: Event published to Kafka topic=order-created: orderId={}, product={}, quantity={}",
                event.getOrderId(), event.getProduct(), event.getQuantity());

        return order.getId();
    }
}
