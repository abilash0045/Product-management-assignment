package com.example.demo.Entities;

import com.example.demo.Enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;

    private String description;

    private double price;

    private String color;

    private String brand;

    @Enumerated(value = EnumType.STRING)
    private ProductCategory productCategory;

    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private MobilePhoneEntity mobilePhoneEntity;

    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private ShoeEntity shoeEntity;

    @OneToOne(mappedBy = "productEntity",cascade = CascadeType.ALL)
    private ClothingEntity clothingEntity;
}
