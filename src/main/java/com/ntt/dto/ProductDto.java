package com.ntt.dto;

import lombok.Data;

@Data
public class ProductDto {

    public ProductDto(){}

    public ProductDto(String productName,Integer quantity, Long userId){
        this.productName = productName;
        this.quantity = quantity;
        this.userId = userId;
    }

    private Long productId;
    private String productName;
    private Integer quantity;
    private Long userId;
}
