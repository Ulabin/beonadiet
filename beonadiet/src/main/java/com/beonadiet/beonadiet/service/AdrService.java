package com.beonadiet.beonadiet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.AdrDto;
import com.beonadiet.beonadiet.entity.Address;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.AddressRepository;
import com.beonadiet.beonadiet.repository.UserRepository;

@Service
public class AdrService {

  @Autowired
  private AddressRepository addressRepository;

  public void saveAddress(Address address) {
    addressRepository.save(address);
  }

  public Address dtoToEntity(AdrDto dto){
    Address address= Address.builder()
    .num(dto.getNum())
    // .address_name(dto.getAddress_name())
    // .zip_code(dto.getZip_code())
    .address(dto.getAddress())
    .receiver_name(dto.getReceiver_name())
    .mobile_num(dto.getMobile_num())
    .default_address(dto.getDefault_address())
    .member(Member.builder().id(dto.getMid()).build()).build();
    return address;
  }

  public AdrDto entityToDTO(Address adr){
    AdrDto dto = AdrDto.builder()
    .num(adr.getNum())
    .address(adr.getAddress())
    .receiver_name(adr.getReceiver_name())
    .mobile_num(adr.getMobile_num())
    .default_address(adr.getDefault_address())
    .mid(adr.getMember().getId())
    .build();
    return dto;
  }

  //게시글 처리
  public List<Address> addressList(){
    
    return  addressRepository.findAll();
  }

}
