package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxRice;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxRiceImage;

public interface MyOwnLunchboxRiceImgRepository extends JpaRepository<MyOwnLunchboxRiceImage, String>{
    @EntityGraph(attributePaths = {"myOwnLunchboxRice"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnLunchboxRiceImage findByMyOwnLunchboxRice(MyOwnLunchboxRice rice);
}
