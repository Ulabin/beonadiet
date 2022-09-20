package com.ds.mainpagetest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.mainpagetest.entity.MyOwnRecipe;
import com.ds.mainpagetest.repositiory.MainpagetestRepository;

@Controller
@RequestMapping("/myownrecipe")
public class MyownrecipeController {
  @Autowired
  private MainpagetestRepository mrepository;
  
  @GetMapping("/mor")
  public String mor(){
    return "myownrecipe/mor";
  }

  @GetMapping("/morhistory")
  public String morhistory(){
    // List<MyOwnRecipe> list = mrepository.findAll();
    // model.addAttribute("list", list);
    return "myownrecipe/morhistory";
  }

  @GetMapping("/morlunchbox")
  public String morlunchbox(Model model ){
    List<MyOwnRecipe> list = mrepository.findAll();
    model.addAttribute("list", list);
    return "myownrecipe/morlunchbox";
  }
  @GetMapping("/morsalad")
  public String morsalad(Model model ){
    List<MyOwnRecipe> list = mrepository.findAll();
    model.addAttribute("list", list);
    return "myownrecipe/morsalad";
  }
  
  @GetMapping("/morsandwich")
  public String morsandwich(Model model ){
    List<MyOwnRecipe> list = mrepository.findAll();
    model.addAttribute("list", list);
    return "myownrecipe/morsandwich";
  }

  @PostMapping("/moradddetail")
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
