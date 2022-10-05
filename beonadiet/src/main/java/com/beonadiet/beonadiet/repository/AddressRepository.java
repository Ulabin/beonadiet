package com.beonadiet.beonadiet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.Address;
import com.beonadiet.beonadiet.entity.Member;

public interface AddressRepository extends JpaRepository<Address, Long>{
  List<Address> findByMember(Member member);
}
