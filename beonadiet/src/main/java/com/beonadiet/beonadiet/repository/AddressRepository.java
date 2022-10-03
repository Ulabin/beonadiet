package com.beonadiet.beonadiet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.beonadiet.beonadiet.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
// public interface AddressRepository extends CrudRepository<Address, Long>{
  
}
