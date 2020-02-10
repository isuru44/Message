package com.ntt.serviceImpl;

import com.ntt.dto.ProductDto;
import com.ntt.entity.ProductEntity;
import com.ntt.repository.ProductRepository;
import com.ntt.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for(ProductEntity entity : productEntityList){
            ProductDto dto = new ProductDto();
            BeanUtils.copyProperties(entity,dto);
            productDtoList.add(dto);
        }
        return ResponseEntity.accepted().body(productDtoList);
    }

    @Override
    public ResponseEntity<ProductEntity> saveProduct(ProductDto productDto) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(productDto,entity);
        ProductEntity savedEntity = productRepository.save(entity);
        return ResponseEntity.ok().body(savedEntity);
    }
}
