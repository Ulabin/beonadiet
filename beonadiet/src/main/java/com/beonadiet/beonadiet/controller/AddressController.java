package com.beonadiet.beonadiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.beonadiet.beonadiet.dto.AdrDto;
import com.beonadiet.beonadiet.entity.Address;
import com.beonadiet.beonadiet.repository.AddressRepository;
import com.beonadiet.beonadiet.service.AdrService;

@Controller
public class AddressController {
  
  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private AdrService adrService;
  
  @GetMapping("/address/new")
  public String newArticleForm() {
      return "articles/new";
  }
  
  @PostMapping("/address/create")
  // @PostMapping("/address/create")
  public String createAddress(AdrDto form) {
      // System.out.println(form.toString());
      
      // 1. Dto를 Entity 변환
      Address address = form.toEntity();
      // System.out.println(address.toString());
      
      // 2. Repository에게 Entity를 DB로 저장하게 함
      addressRepository.save(address);
      // Address saved = addressRepository.save(address);
      // System.out.println(saved.toString());
      // return "redirect:/mypage/address";
      return "";
  }

  // @PostMapping("/address/create")
  // public String addressPro(Address address){
  //   adrService.saveAddress(address);
  //   return "";
  // }
}
