package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "mobiles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobilePhoneEntity {

    @Id
    private int id;

    private String model;

    private String operatingSystem;

    private String RAM;

    private String storage;

    private double screenSize;

    private int cameraResolution;

    @OneToOne
    @JoinColumn
    private ProductEntity productEntity;
}
