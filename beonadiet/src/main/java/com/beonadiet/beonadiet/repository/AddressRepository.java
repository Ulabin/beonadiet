package com.beonadiet.beonadiet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beonadiet.beonadiet.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
  
}
