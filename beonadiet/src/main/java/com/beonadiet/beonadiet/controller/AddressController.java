package com.beonadiet.beonadiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
  
  // @GetMapping("/address/new")
  // public String newArticleForm() {
  //     return "articles/new";
  // }
  
  @PostMapping("/adr_popup")
  public String createAddress(AdrDto adrDto, @RequestParam(value="user_id") String user_id) {
      // System.out.println(form.toString());

      Member memberTmp =userRepository.findByUsername(user_id);
      adrDto.setMid(memberTmp.getId());
      
      // 1. Dto를 Entity 변환
      Address address = adrService.dtoToEntity(adrDto);
      // System.out.println(address.toString());
      
      // 2. Repository에게 Entity를 DB로 저장하게 함
      addressRepository.save(address);
      // Address saved = addressRepository.save(address);
      // System.out.println(saved.toString());
      return "redirect:/mypage/adr_popup";
      // return "";
  }
}
