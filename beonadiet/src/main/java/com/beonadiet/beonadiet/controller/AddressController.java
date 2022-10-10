package com.beonadiet.beonadiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beonadiet.beonadiet.dto.AdrDto;
import com.beonadiet.beonadiet.entity.Address;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.AddressRepository;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.service.AdrService;

@Controller
public class AddressController {
  
  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private AdrService adrService;

  @Autowired
  private UserRepository userRepository;
  
  @PostMapping("/adr_popup")
  public String createAddress(AdrDto adrDto, @RequestParam(value="user_id") String user_id) {

      Member memberTmp =userRepository.findByUsername(user_id);
      adrDto.setMid(memberTmp.getId());
      
      // 1. Dto를 Entity 변환
      Address address = adrService.dtoToEntity(adrDto);
      
      // 2. Repository에게 Entity를 DB로 저장하게 함
      addressRepository.save(address);
      return "redirect:/mypage/adr_popup";
  }
}
