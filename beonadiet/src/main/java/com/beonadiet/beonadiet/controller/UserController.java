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
    return "redirect:/login";
  }
}
