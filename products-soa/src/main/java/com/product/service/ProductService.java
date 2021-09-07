package com.product.service;

import com.product.model.ProductDTO;
import com.product.entity.Product;
import com.product.mapper.ProductMapper;
import com.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO save(ProductDTO productDto) {
        Product entity = ProductMapper.INSTANCE.dtoToEntity(productDto);
        return ProductMapper.INSTANCE.entityToDTO(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public ProductDTO findById(Integer id) {
        return ProductMapper.INSTANCE.entityToDTO(repository.findById(id).get());
    }

    public Page<ProductDTO> findByCondition(ProductDTO productDto, Pageable pageable) {
        Page<Product> entityPage = repository.findAll(pageable);
        List<Product> entities = entityPage.getContent();
        return new PageImpl<>(ProductMapper.INSTANCE.entityListToDTOList(entities), pageable, entityPage.getTotalElements());
    }

    public ProductDTO update(ProductDTO productDto, Integer id) {
        ProductDTO data = findById(id);
        Product entity = ProductMapper.INSTANCE.dtoToEntity(productDto);
        return save(ProductMapper.INSTANCE.entityToDTO(entity));
    }

    public List<ProductDTO> findAllProducts() {
        List<Product> products = repository.findAll();
        return ProductMapper.INSTANCE.entityListToDTOList(products);
    }
}