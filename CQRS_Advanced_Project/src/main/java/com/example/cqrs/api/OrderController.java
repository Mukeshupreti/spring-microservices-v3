
package com.example.cqrs.api;

import com.example.cqrs.command.dto.CreateOrderCommandDTO;
import com.example.cqrs.command.OrderCommandService;
import com.example.cqrs.query.OrderQueryService;
import com.example.cqrs.query.dto.OrderViewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderCommandService commandService;
    private final OrderQueryService queryService;

    public OrderController(OrderCommandService commandService, OrderQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public Long create(@RequestBody CreateOrderCommandDTO command) {
        log.info("STEP 1: Controller received create order request: product={}, quantity={}",
                command.getProduct(), command.getQuantity());
        return commandService.createOrder(command);
    }

    @GetMapping("/{id}")
    public OrderViewDTO get(@PathVariable Long id) {
        log.info("READ STEP 1: Controller received read request for orderId={}", id);
        return queryService.getOrder(id);
    }
}
