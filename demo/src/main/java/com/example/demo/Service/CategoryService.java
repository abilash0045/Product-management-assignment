package com.example.demo.Service;

import com.example.demo.Entities.Category;
import com.example.demo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category addCategory(String category){
        Category productCategory = Category.builder()
                .productCategory(category).build();
        return categoryRepository.save(productCategory);
    }
}
