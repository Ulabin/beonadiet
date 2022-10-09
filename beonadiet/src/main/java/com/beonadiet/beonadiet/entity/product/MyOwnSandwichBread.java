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
public class MyOwnSandwichBread extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = true)
    private String name;

    @Column(nullable = true, length = 4000)
    private String explanation;

    @Column(nullable = true, length = 4000)
    private String nutrition_info;

    @Column(nullable = true)
    private String one_serving;
}
