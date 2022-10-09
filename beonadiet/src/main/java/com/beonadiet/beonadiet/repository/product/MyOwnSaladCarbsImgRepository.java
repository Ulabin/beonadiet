package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSaladCarbs;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladCarbsImg;

public interface MyOwnSaladCarbsImgRepository extends JpaRepository<MyOwnSaladCarbsImg, String>{
    @EntityGraph(attributePaths = {"myOwnSaladCarbs"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSaladCarbsImg findByMyOwnSaladCarbs(MyOwnSaladCarbs carbs);
}
