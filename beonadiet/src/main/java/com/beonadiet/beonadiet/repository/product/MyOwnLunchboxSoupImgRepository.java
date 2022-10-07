package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSoup;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSoupImage;

public interface MyOwnLunchboxSoupImgRepository extends JpaRepository<MyOwnLunchboxSoupImage, String>{
    @EntityGraph(attributePaths = {"myOwnLunchboxSoup"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnLunchboxSoupImage findByMyOwnLunchboxSoup(MyOwnLunchboxSoup soup);
}
