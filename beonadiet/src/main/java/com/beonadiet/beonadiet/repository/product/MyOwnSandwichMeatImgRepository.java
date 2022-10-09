package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSandwichMeat;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichMeatImg;

public interface MyOwnSandwichMeatImgRepository extends JpaRepository<MyOwnSandwichMeatImg, String>{
    @EntityGraph(attributePaths = {"myOwnSandwichMeat"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSandwichMeatImg findByMyOwnSandwichMeat(MyOwnSandwichMeat meat);
}
