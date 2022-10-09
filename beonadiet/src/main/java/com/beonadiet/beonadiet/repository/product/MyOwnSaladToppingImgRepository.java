package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSaladTopping;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladToppingImg;


public interface MyOwnSaladToppingImgRepository extends JpaRepository<MyOwnSaladToppingImg, String>{
    @EntityGraph(attributePaths = {"myOwnSaladTopping"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSaladToppingImg findByMyOwnSaladTopping(MyOwnSaladTopping topping);
}
