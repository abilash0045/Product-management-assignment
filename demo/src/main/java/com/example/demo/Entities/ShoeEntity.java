package com.example.demo.Entities;

import com.example.demo.Enums.ShoeStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoeEntity extends ProductEntity{

    private int size;
    private String material;
    private String occasion;

    @Enumerated(value = EnumType.STRING)
    private ShoeStyle shoeStyle;

}
