package com.example.demo.Dtos;

import com.example.demo.Enums.ClothingType;
import com.example.demo.Enums.ProductCategory;
import com.example.demo.Enums.ShoeStyle;
import lombok.Data;


@Data
public class ProductEntryDTO {

    // common details

    private String productName;

    private String description;

    private double price;

    private ProductCategory productCategory;

    private String brand;

    private int size;

    private String color;


    // Additional details of clothing

    private ClothingType clothingType;

    // Additional details of shoe

    private ShoeStyle shoeStyle;

    // Additional details of mobile
    private String model;

    private String operatingSystem;

    private String RAM;

    private String storage;

    private double screenSize;

    private int cameraResolution;
}


