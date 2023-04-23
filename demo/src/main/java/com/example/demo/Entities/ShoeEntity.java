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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoeEntity {

    @Id
    private int id;

    private int size;

    @Enumerated(value = EnumType.STRING)
    private ShoeStyle shoeStyle;

    @OneToOne
    @JoinColumn
    private ProductEntity productEntity;
}
