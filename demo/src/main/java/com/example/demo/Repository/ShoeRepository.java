package com.example.demo.Repository;

import com.example.demo.Entities.ShoeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepository extends JpaRepository<ShoeEntity,Integer> {
}
