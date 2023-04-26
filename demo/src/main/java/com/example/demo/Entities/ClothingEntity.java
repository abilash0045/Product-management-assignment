package com.example.demo.Entities;

import com.example.demo.Enums.ClothingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClothingEntity extends ProductEntity{

    private int size;

    private String material;

    @Enumerated(value = EnumType.STRING)
    private ClothingType clothingType;
}
