package com.beonadiet.beonadiet.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.beonadiet.beonadiet.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = true)
    private String name;

    @Column(nullable=true)
    private Long price;

    private String unit;

    @Column(length = 4000)
    private String materialAndContent;

    @Column(length = 4000)
    private String allergy;

    @Column(length = 4000)
    private String nutritionInfo;

    private String volume;

    @Column(length = 4000)
    private String caution;

    @Column
    private String foodType;

    private String expirationDate;

    private String packageMaterial;

    private Long calorie;

    private String storageMethod;

    private String category;

    private String shippingMethod;

    private String bowl;
}

