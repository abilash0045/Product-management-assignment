package com.example.demo.Service;

import com.example.demo.Dtos.ProductEntryDTO;
import com.example.demo.Dtos.UpdateEntryDTO;
import com.example.demo.Entities.ClothingEntity;
import com.example.demo.Entities.MobilePhoneEntity;
import com.example.demo.Entities.ProductEntity;
import com.example.demo.Entities.ShoeEntity;
import com.example.demo.Enums.ProductCategory;
import com.example.demo.Repository.ClothingRepository;
import com.example.demo.Repository.MobileRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MobileRepository mobileRepository;
    @Autowired
    ShoeRepository shoeRepository;
    @Autowired
    ClothingRepository clothingRepository;


    public String addProduct(ProductEntryDTO productEntryDTO) throws Exception{

        System.out.println(productEntryDTO.toString());

        ProductEntity productEntity = ProductEntity.builder().productName(productEntryDTO.getProductName())
                .description(productEntryDTO.getDescription())
                .price(productEntryDTO.getPrice())
                .productCategory(productEntryDTO.getProductCategory())
                .brand(productEntryDTO.getBrand())
                .color(productEntryDTO.getColor())
                .build();

        if (productEntryDTO.getProductCategory() != null && (productEntryDTO.getProductCategory()).equals(ProductCategory.MOBILE)){
            MobilePhoneEntity mobilePhoneEntity = MobilePhoneEntity.builder().model(productEntryDTO.getModel())
                    .id(productEntity.getProductId())
                    .RAM(productEntryDTO.getRAM())
                    .model(productEntryDTO.getModel())
                    .storage(productEntryDTO.getStorage())
                    .cameraResolution(productEntryDTO.getCameraResolution())
                    .operatingSystem(productEntryDTO.getOperatingSystem()).build();
            productEntity.setMobilePhoneEntity(mobilePhoneEntity);
            mobilePhoneEntity.setProductEntity(productEntity);

        }

        else if (productEntryDTO.getProductCategory() != null && productEntryDTO.getProductCategory().equals(ProductCategory.SHOE)) {
            ShoeEntity shoeEntity = ShoeEntity.builder()
                    .id(productEntity.getProductId())
                    .shoeStyle(productEntryDTO.getShoeStyle())
                    .size(productEntryDTO.getSize())
                    .build();
            productEntity.setShoeEntity(shoeEntity);
            shoeEntity.setProductEntity(productEntity);

        }

        else if (productEntryDTO.getProductCategory() != null && productEntryDTO.getProductCategory().equals(ProductCategory.CLOTHING)) {
            ClothingEntity clothingEntity = ClothingEntity.builder()
                    .id(productEntity.getProductId())
                    .clothingType(productEntryDTO.getClothingType())
                    .size(productEntryDTO.getSize())
                    .build();
            productEntity.setClothingEntity(clothingEntity);
            clothingEntity.setProductEntity(productEntity);
        }

        productRepository.save(productEntity);

        return "Product added successfully";

    }

    public String updateProduct(UpdateEntryDTO updateEntryDTO) throws Exception{

        ProductEntity productEntity = productRepository.findById(updateEntryDTO.getId()).get();

        if (productEntity == null){
            throw new Exception("Product not found");
        }

        productEntity.setProductCategory(updateEntryDTO.getProductCategory());
        productEntity.setProductName(updateEntryDTO.getProductName());
        productEntity.setBrand(updateEntryDTO.getBrand());
        productEntity.setColor(updateEntryDTO.getColor());
        productEntity.setDescription(updateEntryDTO.getDescription());
        productEntity.setPrice(updateEntryDTO.getPrice());

        if (updateEntryDTO.getProductCategory() != null && productEntity.getProductCategory().equals(ProductCategory.MOBILE)){

            MobilePhoneEntity mobilePhoneEntity = productEntity.getMobilePhoneEntity();

            mobilePhoneEntity.setRAM(updateEntryDTO.getRAM());
            mobilePhoneEntity.setModel(updateEntryDTO.getModel());
            mobilePhoneEntity.setStorage(updateEntryDTO.getStorage());
            mobilePhoneEntity.setCameraResolution(updateEntryDTO.getCameraResolution());
            mobilePhoneEntity.setOperatingSystem(updateEntryDTO.getOperatingSystem());
            mobilePhoneEntity.setScreenSize(updateEntryDTO.getScreenSize());

            productEntity.setMobilePhoneEntity(mobilePhoneEntity);
            mobilePhoneEntity.setProductEntity(productEntity);

        }

        else if (updateEntryDTO.getProductCategory() != null && productEntity.getProductCategory().equals(ProductCategory.SHOE)) {

            ShoeEntity shoeEntity = productEntity.getShoeEntity();

            shoeEntity.setShoeStyle(updateEntryDTO.getShoeStyle());
            shoeEntity.setSize(updateEntryDTO.getSize());

            productEntity.setShoeEntity(shoeEntity);
            shoeEntity.setProductEntity(productEntity);
       }

        else if (updateEntryDTO.getProductCategory() != null && productEntity.getProductCategory().equals(ProductCategory.CLOTHING)) {
            ClothingEntity clothingEntity = productEntity.getClothingEntity();

            clothingEntity.setClothingType(updateEntryDTO.getClothingType());
            clothingEntity.setSize(updateEntryDTO.getSize());

            productEntity.setClothingEntity(clothingEntity);
            clothingEntity.setProductEntity(productEntity);
        }

        productRepository.save(productEntity);
        return "Product updated successfully";
    }

    public String deleteProduct(int productId){

        productRepository.deleteById(productId);
        return "Product deleted successfully";
    }

    public ProductEntity getProduct(int productId) {

        return productRepository.findById(productId).get();
    }

    public List<ProductEntity> getAllProducts() {

        List<ProductEntity> productEntities = productRepository.findAll();

        return productEntities;
    }
}
