package com.ntt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Product")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="user_id")
    private Long userId;
}
