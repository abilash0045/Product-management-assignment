package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "mobiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobilePhoneEntity extends ProductEntity{

    private String model;

    private String operatingSystem;

    private String RAM;

    private String storage;

    private double screenSize;

    private int cameraResolution;

}
