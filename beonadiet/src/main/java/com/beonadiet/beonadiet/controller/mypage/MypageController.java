package com.beonadiet.beonadiet.controller.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.entity.recipe.MyOwnRecipePost;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.repository.recipe.MyOwnRecipePostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/mypage")
@Log4j2
@RequiredArgsConstructor
public class MypageController {
  private final MyOwnRecipePostRepository mPostRepository;

  @Autowired
  UserRepository userRepository;
  
  @GetMapping
  public String mypage(@RequestParam("mid") String mid, Model model){
    Member memberTmp =userRepository.findByUsername(mid); 
    model.addAttribute("username", memberTmp.getUser_name());
    return "/mypage";
  }

  @GetMapping("/mypost")
  public String mypost(@RequestParam("mid") String mid,Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    log.info(list);
    Member memberTmp =userRepository.findByUsername(mid); 
    model.addAttribute("username", memberTmp.getUser_name());
    return "mypage/mypost";
  }

  @GetMapping("/mypage/mypostlunchbox")
  public String mypostlunchbox(Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    log.info(list);
    return "/mypage/mypage/mypostlunchbox";
  }
  @GetMapping("/mypage/mypostsandwich")
  public String mypostsandwich(Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    log.info(list);
    return "/mypage/mypage/mypostsandwich";
  }
  @GetMapping("/mypage/mypostsalad")
  public String mypostsalad(Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    log.info(list);
    return "/mypage/mypage/mypostsalad";
  }
}
