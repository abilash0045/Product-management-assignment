package com.example.demo.Repository;

import com.example.demo.Entities.MobilePhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends JpaRepository<MobilePhoneEntity,Integer> {
}
