package com.beonadiet.beonadiet.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beonadiet.beonadiet.entity.product.Product;
import com.beonadiet.beonadiet.entity.product.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, String> {
    @EntityGraph(attributePaths = {"product"}, type = EntityGraph.EntityGraphType.FETCH)
    List<ProductImage> findByProduct(Product product);
}
