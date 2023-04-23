package com.example.demo.Entities;

import com.example.demo.Enums.ClothingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClothingEntity {

    @Id
    private int id;

    private int size;


    @Enumerated(value = EnumType.STRING)
    private ClothingType clothingType;

    @OneToOne
    @JoinColumn
    private ProductEntity productEntity;
}
