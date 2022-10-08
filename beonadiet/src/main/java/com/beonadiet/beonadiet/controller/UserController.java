package com.beonadiet.beonadiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.service.UserService;

@Controller
public class UserController{

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserService userService;

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

  @GetMapping("/cart")
  public String cart(){
    return "cart";
  }
  @GetMapping("/order")
  public String order(){
    return "order";
  }

  @PostMapping("/joinProc")
  public String joinProc(Member member){
    userService.Join(member);
    return "redirect:/join_complete";
  }
}
