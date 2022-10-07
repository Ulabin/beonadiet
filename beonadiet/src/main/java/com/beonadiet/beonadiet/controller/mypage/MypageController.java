package com.beonadiet.beonadiet.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {
  
  @GetMapping
  public String mypage(){
    return "mypage/mypage";
  }

  @GetMapping("/mypost")
  public String mypost(){
    return "mypage/mypost";
  }
}
