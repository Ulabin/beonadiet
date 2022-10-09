package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSandwichBread;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichBreadImg;

public interface MyOwnSandwichBreadImgRepository extends JpaRepository<MyOwnSandwichBreadImg, String>{
    @EntityGraph(attributePaths = {"myOwnSandwichBread"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSandwichBreadImg findByMyOwnSandwichBread(MyOwnSandwichBread bread);
}
