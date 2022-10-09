package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSandwichVegetable;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichVegetableImg;

public interface MyOwnSandwichVegetableImgRepository extends JpaRepository<MyOwnSandwichVegetableImg, String>{
    @EntityGraph(attributePaths = {"myOwnSandwichVegetable"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSandwichVegetableImg findByMyOwnSandwichVegetable(MyOwnSandwichVegetable vegetable);
}
