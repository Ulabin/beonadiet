package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSandwichSauce;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichSauceImg;

public interface MyOwnSandwichSauceImgRepository extends JpaRepository<MyOwnSandwichSauceImg, String>{
    @EntityGraph(attributePaths = {"myOwnSandwichSauce"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSandwichSauceImg findByMyOwnSandwichSauce(MyOwnSandwichSauce sauce);
}
