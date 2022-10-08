package com.beonadiet.beonadiet.controller.mypage;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beonadiet.beonadiet.entity.recipe.MyOwnRecipePost;
import com.beonadiet.beonadiet.repository.recipe.MyOwnRecipePostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/mypage")
@Log4j2
@RequiredArgsConstructor
public class MypageController {
  private final MyOwnRecipePostRepository mPostRepository;
  
  @GetMapping
  public String mypage(){
    return "mypage/mypage";
  }

  @GetMapping("/mypost")
  public String mypost(){
    return "mypage/mypost";
  }

  @GetMapping("/mypostlunchbox")
  public String mypostlunchbox(Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    log.info(list);
    return "/mypage/mypostlunchbox";
  }
  @GetMapping("/mypostsandwich")
  public String mypostsandwich(Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    log.info(list);
    return "/mypage/mypostsandwich";
  }
  @GetMapping("/mypostsalad")
  public String mypostsalad(Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    log.info(list);
    return "/mypage/mypostsalad";
  }
}
