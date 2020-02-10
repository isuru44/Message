package com.ntt.service;

import com.ntt.dto.ProductDto;
import com.ntt.entity.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<List<ProductDto>> getProducts();
    ResponseEntity<ProductEntity> saveProduct(ProductDto productDto);
}
