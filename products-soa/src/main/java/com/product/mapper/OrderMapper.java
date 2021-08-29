package com.product.mapper;

import com.product.entity.Order;
import com.product.model.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = OrderDetailMapper.class)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO orderToOrderDTO(Order order);
    Order orderDTOToOrder(OrderDTO dto);

    List<OrderDTO> orderListToOrderDTOList(List<Order> order);
    List<Order> orderDTOListToOrderList(List<OrderDTO> dto);

}