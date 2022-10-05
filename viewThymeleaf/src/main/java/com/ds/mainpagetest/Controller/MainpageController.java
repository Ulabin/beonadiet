package com.ds.mainpagetest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainpageController {
  
  @GetMapping({"","/"})
  public String mainpage(){
    return "mainpage";
  }
}
