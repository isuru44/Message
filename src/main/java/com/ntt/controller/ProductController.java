package com.ntt.controller;

import com.ntt.dto.ProductDto;
import com.ntt.entity.ProductEntity;
import com.ntt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return productService.getProducts();
    }

    @PostMapping("/save")
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }
}
