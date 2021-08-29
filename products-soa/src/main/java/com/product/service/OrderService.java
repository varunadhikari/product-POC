package com.product.service;

import com.product.entity.Order;
import com.product.mapper.OrderMapper;
import com.product.model.OrderDTO;
import com.product.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public OrderDTO save(OrderDTO orderDto) {
        Order entity = OrderMapper.INSTANCE.orderDTOToOrder(orderDto);
        return OrderMapper.INSTANCE.orderToOrderDTO(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public OrderDTO findById(Integer id) {
        return OrderMapper.INSTANCE.orderToOrderDTO(repository.findById(id).get());
    }

    public OrderDTO update(OrderDTO orderDto, Integer id) {
        OrderDTO data = findById(id);
        Order entity = OrderMapper.INSTANCE.orderDTOToOrder(orderDto);
        return OrderMapper.INSTANCE.orderToOrderDTO(repository.save(entity));
    }
}