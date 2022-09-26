package com.beonadiet.beonadiet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TestController {
  
  @RequestMapping("/")
  public String home(ModelAndView mav) {
    return "home";  
  }
  
  @ResponseBody
  @RequestMapping("/test")
  public String test() {
    return "OK";
  }
  
  @ResponseBody
  @RequestMapping("/adminOnly")
  public String adminOnly() {
    return "Secret Page";
  }
  
  @RequestMapping("/login")
  public String login() {
    return "login";
  }
  
  @RequestMapping("/find_id")
  public String findId() {
    return "/find_id";
  }

  @RequestMapping("/find_pwd")
  public String findPwd() {
    return "/find_pwd";
  }

  @RequestMapping("/join")
  public String join() {
    return "/join";
  }

  @GetMapping("/403")
    public String forbidden() {
    return "/403";
  }
}