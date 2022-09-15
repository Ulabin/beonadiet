package com.ds.mainpagetest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myownrecipe")
public class MyownrecipeController {
  
  @GetMapping("/mor")
  public String mor(){
    return "myownrecipe/mor";
  }
}
