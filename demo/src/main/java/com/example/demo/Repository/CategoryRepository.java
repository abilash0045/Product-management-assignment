package com.example.demo.Repository;

import com.example.demo.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "select * from category where  product_category = :productCategory",nativeQuery = true)
    public Category findByName(@Param("productCategory") String productCategory);
}
