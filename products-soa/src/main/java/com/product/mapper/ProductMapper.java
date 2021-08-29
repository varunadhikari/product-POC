package com.product.mapper;


import com.product.entity.Product;
import com.product.model.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO entityToDTO(Product product);
    Product dtoToEntity(ProductDTO productDto);

    List<ProductDTO> entityListToDTOList(List<Product> entities);

    List<Product> dtoListToEntityList(List<ProductDTO> entities);
}