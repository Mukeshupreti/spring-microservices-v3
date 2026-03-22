
package com.example.cqrs.query;

import com.example.cqrs.query.dto.OrderViewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderQueryService {

    private static final Logger log = LoggerFactory.getLogger(OrderQueryService.class);
    private final RedisTemplate<String, OrderViewDTO> redisTemplate;

    public OrderQueryService(RedisTemplate<String, OrderViewDTO> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public OrderViewDTO getOrder(Long id) {
        log.info("READ STEP 2: Query service reading from Redis for key=order:{}", id);
        OrderViewDTO order = redisTemplate.opsForValue().get("order:" + id);
        log.info("READ STEP 3: Query service returned data from Redis for orderId={}: {}",
                id, order);
        return order;
    }
}
