package com.beonadiet.beonadiet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase,Long>{
    List<Purchase> findByMember(Member member);
}
