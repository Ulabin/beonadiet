package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxMinisalad;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxMinisaladImg;

public interface MyOwnLunchboxMinisaladImgRepository extends JpaRepository<MyOwnLunchboxMinisaladImg, String>{
    @EntityGraph(attributePaths = {"myOwnLunchboxMinisalad"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnLunchboxMinisaladImg findByMyOwnLunchboxMinisalad(MyOwnLunchboxMinisalad minisalad);
}
