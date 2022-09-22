package com.ds.mainpagetest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.mainpagetest.dto.MyOwnRecipeDTO;
import com.ds.mainpagetest.dto.PageRequestDTO;
import com.ds.mainpagetest.entity.MyOwnRecipe;
import com.ds.mainpagetest.repositiory.MainpagetestRepository;
import com.ds.mainpagetest.service.MainpagetestService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/myownrecipe")
@Log4j2
@RequiredArgsConstructor
public class MyownrecipeController {
  
  private final MainpagetestRepository mrepository;

  private final MainpagetestService mService;
  
  @GetMapping("/mor")
  public String mor(){
    return "myownrecipe/mor";
  }

  @GetMapping("/morhistory")
  public String morhistory(Model model){
    List<MyOwnRecipe> list = mrepository.findAll();
    model.addAttribute("list", list);
    return "myownrecipe/morhistory";
  }

  @GetMapping("/morlunchbox")
  public String morlunchbox( Model model){
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

  @GetMapping("/moradddetail")
  public String moradddetail(Long id, Model model){
    MyOwnRecipeDTO dto = mService.getRecipe(id);
    model.addAttribute("dto", dto);
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
