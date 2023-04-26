package com.example.demo.Controller;

import com.example.demo.Dtos.ProductEntryDTO;
import com.example.demo.Dtos.ProductResponseDto;
import com.example.demo.Service.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*In this approach we can add different products with different or same categories with similar properties by calling add product Api,
  but if the product have extra properties like for mobile --> ram, storage, etc, we can easily create add api for mobile.
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductEntryDTO productEntityDTO){

        String response = null;
        try {
            response = productService.addProduct(productEntityDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateProduct(@RequestParam int id, @RequestBody ProductEntryDTO productEntryDTO){

        String response = null;

        try {
            response = productService.updateProduct(id,productEntryDTO);
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
    @JsonIgnore
    public ResponseEntity getProduct(@RequestParam int productId) {

        ProductResponseDto response = productService.getProduct(productId);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAllProduct")
    @JsonIgnore
    public ResponseEntity getAllProducts() {

        List<ProductResponseDto> response = productService.getAllProducts();

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}
