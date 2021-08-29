package com.product.mapper;

import com.product.entity.OrderDetail;
import com.product.model.OrderDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = OrderMapper.class)
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    OrderDetail dtoToEntity(OrderDetailDTO orderDetailDto);

    List<OrderDetail> dtoListToEntityList(List<OrderDetailDTO> orderDetailDtoList);

    OrderDetailDTO entityToDto(OrderDetail orderDetail);

    List<OrderDetailDTO> entityToDto(List<OrderDetail> orderDetailList);
}
