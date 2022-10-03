package com.beonadiet.beonadiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.service.UserService;

@Controller
public class UserController {

  @Autowired
  UserRepository userRepository;
  // private UserRepository userRepository;

  @Autowired
  UserService userService;

  // @Autowired
  // private BCryptPasswordEncoder bCryptPasswordEncoder;

  @GetMapping("/login")
  public String login(){
    return "login";
  }
  @GetMapping("/find_id")
  public String findId(){
    return "find_id";
  }
  @GetMapping("/find_pwd")
  public String findPwd(){
    return "find_pwd";
  }
  @GetMapping("/join")
  public String join(){
    return "join";
  }
  @GetMapping("/join_complete")
  public String joinComplete(){
    return "join_complete";
  }
  // @GetMapping("/userinfo")
  // public String userInfo(){
  //   return "userinfo";
  // }
  // @GetMapping("/delete_account")
  // public String deleteAccount(){
  //   return "delete_account";
  // }
  // @GetMapping("/health_info")
  // public String healthInfo(){
  //   return "health_info";
  // }
  // @GetMapping("/active_page")
  // public String activePage(){
  //   return "active_page";
  // }
  // @GetMapping("/address")
  // public String address(){
  //   return "address";
  // }
  // @GetMapping("/adr_modify")
  // public String adrModify(){
  //   return "adr_modify";
  // }
  // @GetMapping("/adr_popup")
  // public String adrPopup(){
  //   return "adr_popup";
  // }
  // @GetMapping("/pointPage")
  // public String pointPage(){
  //   return "pointPage";
  // }
  @GetMapping("/cart")
  public String cart(){
    return "cart";
  }
  @GetMapping("/order")
  public String order(){
    return "order";
  }
  // @GetMapping("/shopping_list")
  // public String shoppingList(){
  //   return "shopping_list";
  // }
  // @GetMapping("/pick_list")
  // public String pickList(){
  //   return "pick_list";
  // }

  //PostMapping -> 데이터를 추가하기 위한 Post 요청
  // @PostMapping("/joinProc") 
  // public String joinProc(Member member){
  //   System.out.println("회원가입 진행 : " + member);
  //   String rawPassword = member.getPassword();
  //   String encPassword = bCryptPasswordEncoder.encode(rawPassword);
  //   member.setPassword(encPassword);
  //   member.setRole("ROLE_USER");
  //   userRepository.save(member);
  //   return "redirect:/";
  // }

  @PostMapping("/joinProc")
  public String joinProc(Member member){
    userService.Join(member);
    return "redirect:/join_complete";
    // return "redirect:/login";
  }
}
