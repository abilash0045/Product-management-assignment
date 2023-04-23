package com.example.demo.Controller;


import com.example.demo.Dtos.ProductEntryDTO;
import com.example.demo.Dtos.UpdateEntryDTO;
import com.example.demo.Entities.ProductEntity;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductEntryDTO productEntryDTO){

        String response = null;
        try {
            response = productService.addProduct(productEntryDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateProduct(@RequestBody UpdateEntryDTO updateEntryDTO){

        String response = null;

        try {
            response = productService.updateProduct(updateEntryDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity deleteProduct(@RequestParam int productId){

        String response = productService.deleteProduct(productId);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/getProduct")
    public ResponseEntity getProduct(@RequestParam int productId) {

        ProductEntity response = productService.getProduct(productId);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity getAllProducts() {

        List<ProductEntity> response = productService.getAllProducts();

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}
