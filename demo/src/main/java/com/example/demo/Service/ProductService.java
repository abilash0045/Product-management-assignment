package com.example.demo.Service;

import com.example.demo.Dtos.ProductEntryDTO;
import com.example.demo.Dtos.ProductResponseDto;
import com.example.demo.Entities.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MobileRepository mobileRepository;
    @Autowired
    ShoeRepository shoeRepository;
    @Autowired
    ClothingRepository clothingRepository;


    public String addProduct(ProductEntryDTO productEntityDTO) throws Exception{

        Category category;
//        if (categoryRepository.existsById(productEntity.getCategory().getId())){
//            category = categoryRepository.findById(productEntity.getCategory().getId()).get();
//        }
        if (categoryRepository.findByName(productEntityDTO.getCategory())!=null){
            category = categoryRepository.findByName(productEntityDTO.getCategory());
        }
        else{
            category = categoryService.addCategory(productEntityDTO.getCategory());
        }

        ProductEntity productEntity = ProductEntity.builder()
                .brand(productEntityDTO.getBrand())
                .color(productEntityDTO.getColor())
                .quantity(productEntityDTO.getQuantity())
                .productName(productEntityDTO.getProductName())
                .description(productEntityDTO.getDescription())
                .price(productEntityDTO.getPrice()).build();

        List<ProductEntity> productEntities = category.getProducts();
        productEntities.add(productEntity);
        category.setProducts(productEntities);

//        category = categoryRepository.save(category);

        productEntity.setCategory(category);

        categoryRepository.save(category);

        return "Product added successfully";

    }

    public String updateProduct(int id, ProductEntryDTO productEntryDTO) throws Exception{

        ProductEntity product = productRepository.findById(id).get();
        Category category = product.getCategory();

        product.setProductName(productEntryDTO.getProductName());
        product.setBrand(productEntryDTO.getBrand());
        product.setColor(productEntryDTO.getColor());
        product.setPrice(productEntryDTO.getPrice());
        product.setQuantity(productEntryDTO.getQuantity());
        product.setDescription(productEntryDTO.getDescription());

        categoryRepository.save(category);

        return "Product updated successfully";
    }

    public String deleteProduct(int productId){

        productRepository.deleteById(productId);
        return "Product deleted successfully";
    }

    public ProductResponseDto getProduct(int productId) {

        ProductEntity product = productRepository.findById(productId).get();

        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .brand(product.getBrand())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .Category(product.getCategory().getProductCategory()).build();

        return productResponseDto;
    }

    public List<ProductResponseDto> getAllProducts() {

        List<ProductEntity> productEntities = productRepository.findAll();

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for (ProductEntity product : productEntities){
            ProductResponseDto productResponseDto = ProductResponseDto.builder()
                    .productId(product.getProductId())
                    .productName(product.getProductName())
                    .brand(product.getBrand())
                    .color(product.getColor())
                    .price(product.getPrice())
                    .description(product.getDescription())
                    .quantity(product.getQuantity())
                    .Category(product.getCategory().getProductCategory()).build();

            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }
}
