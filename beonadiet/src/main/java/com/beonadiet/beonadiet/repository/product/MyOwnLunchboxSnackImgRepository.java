package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSnack;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSnackImg;

public interface MyOwnLunchboxSnackImgRepository extends JpaRepository<MyOwnLunchboxSnackImg, String>{
    @EntityGraph(attributePaths = {"myOwnLunchboxSnack"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnLunchboxSnackImg findByMyOwnLunchboxSnack(MyOwnLunchboxSnack snack);
}
