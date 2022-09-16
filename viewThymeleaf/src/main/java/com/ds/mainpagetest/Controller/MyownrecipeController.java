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

  @GetMapping("/morhistory")
  public String morhistory(){
    return "myownrecipe/morhistory";
  }

  @GetMapping("/moradddetail")
  public String moradddetail(){
    return "myownrecipe/moradddetail";
  }

  @GetMapping("/morproductpage")
  public String morproductpage(){
    return "myownrecipe/morproductpage";
  }
  @GetMapping("/moruserpost")
  public String moruserpost(){
    return "myownrecipe/moruserpost";
  }
}
