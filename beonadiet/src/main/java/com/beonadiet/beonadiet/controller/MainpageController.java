package com.beonadiet.beonadiet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class MainpageController {
  
  // @GetMapping({"","/"})
  // public String mainpage(){
  //   return "mainpage";
  // }

  //메인페이지
  @RequestMapping("/main")
  public String home(ModelAndView mav) {
    return "mainpage";  
  }

}
