package com.example.demo.Dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDto {

    private int productId;

    private String productName;

    private String description;

    private double price;

    private String color;

    private int quantity;

    private String brand;

    public String Category;
}
