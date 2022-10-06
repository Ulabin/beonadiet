package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSidedish;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSidedishImage;

public interface MyOwnLunchboxSidedishImgRepository extends JpaRepository<MyOwnLunchboxSidedishImage, String>{
    @EntityGraph(attributePaths = {"myOwnLunchboxSidedish"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnLunchboxSidedishImage findByMyOwnLunchboxSidedish(MyOwnLunchboxSidedish sidedish);
}
