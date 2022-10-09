package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSaladProtein;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladProteinImg;



public interface MyOwnSaladProteinImgRepository extends JpaRepository<MyOwnSaladProteinImg, String>{
    @EntityGraph(attributePaths = {"myOwnSaladProtein"}, type = EntityGraph.EntityGraphType.FETCH)
    MyOwnSaladProteinImg findByMyOwnSaladProtein(MyOwnSaladProtein protein);
}
