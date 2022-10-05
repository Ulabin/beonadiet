package com.beonadiet.beonadiet.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.my_own_series.MyOwnLunchboxRice;
import com.beonadiet.beonadiet.entity.my_own_series.MyOwnLunchboxRiceImage;

public interface MyOwnLunchboxRiceImgRepository extends JpaRepository<MyOwnLunchboxRiceImage, String>{
    @EntityGraph(attributePaths = {"myOwnLunchboxRice"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnLunchboxRiceImage findByMyOwnLunchboxRice(MyOwnLunchboxRice rice);
}
