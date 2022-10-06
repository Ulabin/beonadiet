package com.beonadiet.beonadiet.entity.my_own_series;

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
public class MyOwnLunchboxSidedish extends BaseEntity{
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

    @Column(nullable = true)
    private String category;

    @Column(nullable = true)
    private Long sales_count;
}
