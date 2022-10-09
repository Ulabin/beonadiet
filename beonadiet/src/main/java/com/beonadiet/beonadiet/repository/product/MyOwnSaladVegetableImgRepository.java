package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSaladVegetable;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladVegetableImg;

public interface MyOwnSaladVegetableImgRepository extends JpaRepository<MyOwnSaladVegetableImg, String>{
    @EntityGraph(attributePaths = {"myOwnSaladVegetable"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSaladVegetableImg findByMyOwnSaladVegetable(MyOwnSaladVegetable vegetable);
}
