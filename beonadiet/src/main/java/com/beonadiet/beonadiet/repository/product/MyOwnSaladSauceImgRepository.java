package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSaladSauce;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladSauceImg;

public interface MyOwnSaladSauceImgRepository extends JpaRepository<MyOwnSaladSauceImg, String>{
    @EntityGraph(attributePaths = {"myOwnSaladSauce"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSaladSauceImg findByMyOwnSaladSauce(MyOwnSaladSauce sauce);
}
