package com.product.controller;

import com.product.model.OrderDTO;
import com.product.service.OrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
@Slf4j
@Api("order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated OrderDTO orderDto) {
        orderService.save(orderDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("id") Integer id) {
        OrderDTO order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        orderService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated OrderDTO orderDto, @PathVariable("id") Integer id) {
        orderService.update(orderDto, id);
        return ResponseEntity.ok().build();
    }
}