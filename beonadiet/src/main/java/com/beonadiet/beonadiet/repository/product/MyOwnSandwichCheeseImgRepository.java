package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSandwichCheese;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichCheeseImg;

public interface MyOwnSandwichCheeseImgRepository extends JpaRepository<MyOwnSandwichCheeseImg, String>{
    @EntityGraph(attributePaths = {"myOwnSandwichCheese"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSandwichCheeseImg findByMyOwnSandwichCheese(MyOwnSandwichCheese cheese);
}
