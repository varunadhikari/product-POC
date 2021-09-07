package com.product.mapper;

import com.product.entity.OrderDetail;
import com.product.model.OrderDetailDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    @Mapping(source = "totalAmount" , target = "amount")
    @Named("dtoToEntity")
    OrderDetail dtoToEntity(OrderDetailDTO orderDetailDto);

    @IterableMapping(qualifiedByName = "dtoToEntity")
    List<OrderDetail> dtoListToEntityList(List<OrderDetailDTO> orderDetailDtoList);

    @Mapping(source = "amount" , target = "totalAmount")
    @Mapping(source = "product.name" , target = "name")
    @Mapping(source = "product.company" , target = "company")
    @Mapping(source = "product.description" , target = "description")
    @Mapping(source = "product.price" , target = "price")
    @Named("entityToDto")
    OrderDetailDTO entityToDto(OrderDetail orderDetail);

    @IterableMapping(qualifiedByName = "entityToDto")
    List<OrderDetailDTO> entityToDto(List<OrderDetail> orderDetailList);
}
