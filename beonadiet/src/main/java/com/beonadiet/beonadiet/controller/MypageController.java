package com.beonadiet.beonadiet.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beonadiet.beonadiet.entity.Address;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.AddressRepository;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.service.AdrService;
import com.beonadiet.beonadiet.service.UserService;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/mypage")
@Controller
@Log4j2
public class MypageController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserService userService;

  @GetMapping("/health_info")
  public String healthInfo(){
    return "mypage/health_info";
  }

  @GetMapping("/active_page")
  public String activePage(){
    return "mypage/active_page";
  }

  @GetMapping("/userinfo")
  public String userInfo(){
    return "mypage/userinfo";
  }

  @GetMapping("/delete_account")
  public String deleteAccount(){
    return "mypage/delete_account";
  }

  // @GetMapping("/address")
  // public String address(){
  //   return "mypage/address";
  // }
  @Autowired
  AdrService adrService;

  @Autowired
  AddressRepository addressRepository;

  @GetMapping("/address")
  public String addressList(@RequestParam("mid") String mid,Model model){
      //서비스에서 생성한 리스트를 list라는 이름으로 반환하겠다.
      Member memberTmp = userRepository.findByUsername(mid);

      // model.addAttribute("list", addressRepository.findById(id));
      // List<Address> addressList = addressRepository.findById(id);
      model.addAttribute("list", addressRepository.findByMember(memberTmp));
      log.info(".................."+memberTmp);
      log.info(".................");
      return "mypage/address";
  }

  // @GetMapping("/address")
  // public String addressList(Model model){
  //     //서비스에서 생성한 리스트를 list라는 이름으로 반환하겠다.
  //     model.addAttribute("list", adrService.addressList());
  //     return "mypage/address";
  // }

  @GetMapping("/adr_modify")
  public String adrModify(){
    return "mypage/adr_modify";
  }

  @GetMapping("/adr_popup")
  public String adrPopup(){
    return "mypage/adr_popup";
  }

  @GetMapping("/pointPage")
  public String pointPage(){
    return "mypage/pointPage";
  }

  @GetMapping("/shopping_list")
  public String shoppingList(){
    return "mypage/shopping_list";
  }

  @GetMapping("/pick_list")
  public String pickList(){
    return "mypage/pick_list";
  }
}