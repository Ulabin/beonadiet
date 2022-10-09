package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSandwichTopping;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichToppingImg;

public interface MyOwnSandwichToppingImgRepository extends JpaRepository<MyOwnSandwichToppingImg, String>{
    @EntityGraph(attributePaths = {"myOwnSandwichTopping"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSandwichToppingImg findByMyOwnSandwichTopping(MyOwnSandwichTopping topping);
}
