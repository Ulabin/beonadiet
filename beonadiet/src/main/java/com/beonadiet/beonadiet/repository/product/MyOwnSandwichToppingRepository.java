package com.beonadiet.beonadiet.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.MyOwnSandwichTopping;

public interface MyOwnSandwichToppingRepository extends JpaRepository<MyOwnSandwichTopping, Long> {
}

