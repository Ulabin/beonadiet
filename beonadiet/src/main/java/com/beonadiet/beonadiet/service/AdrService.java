package com.beonadiet.beonadiet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.entity.Address;
import com.beonadiet.beonadiet.repository.AddressRepository;

@Service
public class AdrService {

  @Autowired
  private AddressRepository addressRepository;
  public void saveAddress(Address address) {
    addressRepository.save(address);
  }
  
}
