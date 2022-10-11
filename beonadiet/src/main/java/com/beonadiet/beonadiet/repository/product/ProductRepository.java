package com.beonadiet.beonadiet.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}

