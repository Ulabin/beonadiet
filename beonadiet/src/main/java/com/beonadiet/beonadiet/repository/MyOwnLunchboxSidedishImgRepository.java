package com.beonadiet.beonadiet.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.my_own_series.MyOwnLunchboxSidedish;
import com.beonadiet.beonadiet.entity.my_own_series.MyOwnLunchboxSidedishImage;

public interface MyOwnLunchboxSidedishImgRepository extends JpaRepository<MyOwnLunchboxSidedishImage, String>{
    @EntityGraph(attributePaths = {"myOwnLunchboxSidedish"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnLunchboxSidedishImage findByMyOwnLunchboxSidedish(MyOwnLunchboxSidedish sidedish);
}
