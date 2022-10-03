package com.beonadiet.beonadiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.service.UserService;

@RequestMapping("/mypage")
@Controller
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

  @GetMapping("/address")
  public String address(){
    return "mypage/address";
  }

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
