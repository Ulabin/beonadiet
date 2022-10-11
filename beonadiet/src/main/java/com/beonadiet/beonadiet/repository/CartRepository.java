package com.beonadiet.beonadiet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.Cart;
import com.beonadiet.beonadiet.entity.Member;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByMember(Member member);
}
