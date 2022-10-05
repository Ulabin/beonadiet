package com.ds.mainpagetest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ds.mainpagetest.dto.MyOwnRecipeDTO;
import com.ds.mainpagetest.dto.MyOwnRecipePostDTO;
import com.ds.mainpagetest.dto.PageRequestDTO;
import com.ds.mainpagetest.entity.MyOwnRecipe;
import com.ds.mainpagetest.entity.MyOwnRecipePost;
import com.ds.mainpagetest.repositiory.MyOwnRecipePostRepository;
import com.ds.mainpagetest.repositiory.MyOwnRecipeRepository;
import com.ds.mainpagetest.service.MyOwnRecipePostService;

import com.ds.mainpagetest.service.MyOwnRecipeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/myownrecipe")
@Log4j2
@RequiredArgsConstructor
public class MyownrecipeController {

  private final MyOwnRecipeRepository mrepository;
  private final MyOwnRecipePostRepository mPostRepository;
  private final MyOwnRecipeService mService;
  private final MyOwnRecipePostService mpService;

  @GetMapping("/mor")
  public String mor() {
    return "myownrecipe/mor";
  }

  @GetMapping("/morlunchboxpost")
  public String morlunchboxpost(Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    // MyOwnRecipePostDTO list = mpService.getMyOwnRecipePost(0);
    // log.info("PostMapping /morproductpage morlunchboxpost>>>>>>>>>>>>"+list);
    // model.addAttribute("list", list);
    return "/myownrecipe/morlunchboxpost";
  }

  @GetMapping("/morsandwichpost")
  public String morsandwichpost(Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    log.info(list);
    return "/myownrecipe/morsandwichpost";
  }

  @GetMapping("/morsaladpost")
  public String morsaladpost(Model model){
    List<MyOwnRecipePost> list = mPostRepository.findAll();
    model.addAttribute("list", list);
    log.info(list);
    return "/myownrecipe/morsaladpost";
  }

  @GetMapping("/morhistory")
  public String morhistory(Model model) {
    List<MyOwnRecipe> list = mrepository.findAll();
    model.addAttribute("list", list);
    return "myownrecipe/morhistory";
  }

  @GetMapping("/morlunchbox")
  public String morlunchbox(Model model) {
    List<MyOwnRecipe> list = mrepository.findAll();
    model.addAttribute("list", list);
    return "myownrecipe/morlunchbox";
  }

  @GetMapping("/morsalad")
  public String morsalad(Model model) {
    List<MyOwnRecipe> list = mrepository.findAll();
    model.addAttribute("list", list);
    return "myownrecipe/morsalad";
  }

  @GetMapping("/morsandwich")
  public String morsandwich(Model model) {
    List<MyOwnRecipe> list = mrepository.findAll();
    model.addAttribute("list", list);
    return "myownrecipe/morsandwich";
  }

  @GetMapping("/moradddetail")
  public void moradddetail(Long id,Model model) {
    MyOwnRecipeDTO dto = mService.getRecipe(id);
    log.info("GetMapping /moradddetail id.........."+id);
    model.addAttribute("dto", dto);
    log.info("GetMapping /moradddetail dto.........."+dto);
    
  }

  @Value("${com.ds.upload.path}")
  private String uploadPath;
 
  // 이미지들어가는 post return type Long
  @PostMapping("/moradddetail")
  public String registerPost(@ModelAttribute("morpost") MyOwnRecipePostDTO morpost, RedirectAttributes ra, Model model) {
    Long id = mpService.register(morpost);
    log.info("register post... " + morpost);
    log.info("PostMapping /morproductpage morpost's id..........."+id);
    log.info("PostMapping /morproductpage morpost's 받은 값들..........."+morpost);
    
    MyOwnRecipePostDTO dto = mpService.getMyOwnRecipePost(id);
    log.info("PostMapping /morproductpage getMyOwnRecipePost가 되고 받은 객체"+dto);
    model.addAttribute("dto", dto);
    return "myownrecipe/morproductpage";
  }
  @GetMapping("/morproductpage")
  public String goMorproductpage(Long id, Model model){
    MyOwnRecipePostDTO dto = mpService.getMyOwnRecipePost(id);
    log.info("PostMapping /morproductpage getMyOwnRecipePost가 되고 받은 객체"+dto);
    model.addAttribute("dto", dto);
    return "myownrecipe/morproductpage";
  }


  @GetMapping("/moruserpost")
  public String moruserpost() {
    return "myownrecipe/moruserpost";
  }
}
