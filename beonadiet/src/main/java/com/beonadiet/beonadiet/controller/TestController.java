package com.beonadiet.beonadiet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TestController {
  
  @RequestMapping("/home")
  public String home(ModelAndView mav) {
    return "home";  
  }
  
  @ResponseBody
  @RequestMapping("/test")
  public String test() {
    return "OK";
  }
  
  @ResponseBody
  @RequestMapping("admin/adminOnly")
  public String adminOnly() {
    return "Secret Page";
  }
  
  // @RequestMapping(value = "/login")
  // public String login() {
  //   return "login.html";
  // }
  
  // @RequestMapping(value = "/find_id")
  // public String findId() {
  //   return "/find_id.html";
  // }

  // @RequestMapping(value = "/find_pwd")
  // public String findPwd() {
  //   return "/find_pwd.html";
  // }

  // @RequestMapping(value = "/join")
  // public String join() {
  //   return "/join.html";
  // }
  // @RequestMapping("/join")
  // public String join() {
  //   return "/join";
  // }

  @GetMapping("/403")
    public String forbidden() {
    return "/403";
  }
}