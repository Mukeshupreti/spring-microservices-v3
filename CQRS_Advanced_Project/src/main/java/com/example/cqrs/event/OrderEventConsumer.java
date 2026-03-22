
package com.example.cqrs.event;

import com.example.cqrs.query.dto.OrderViewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {

    private static final Logger log = LoggerFactory.getLogger(OrderEventConsumer.class);
    private final RedisTemplate<String, OrderViewDTO> redisTemplate;

    public OrderEventConsumer(RedisTemplate<String, OrderViewDTO> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @KafkaListener(topics = "order-created")
    public void consume(OrderCreatedEvent event) {
        log.info("STEP 4: Event consumed from Kafka topic=order-created: orderId={}, product={}, quantity={}",
                event.getOrderId(), event.getProduct(), event.getQuantity());

        OrderViewDTO view = new OrderViewDTO();
        view.setId(event.getOrderId());
        view.setProduct(event.getProduct());
        view.setQuantity(event.getQuantity());

        redisTemplate.opsForValue().set("order:" + event.getOrderId(), view);
        log.info("STEP 5: Redis read model updated for key=order:{} with payload={}",
                event.getOrderId(), view);
    }
}
