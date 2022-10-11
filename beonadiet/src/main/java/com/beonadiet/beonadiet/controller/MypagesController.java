package com.beonadiet.beonadiet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.AddressRepository;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.service.AdrService;
import com.beonadiet.beonadiet.service.UserService;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/mypage")
@Controller
@Log4j2
public class MypagesController {
  
  @Autowired
  UserRepository userRepository;
  
  @Autowired
  AddressRepository addressRepository;
  
  @Autowired
  UserService userService;
  
  @Autowired
  AdrService adrService;
  
  @Autowired //타입에 해당하는 빈을 주입
  BCryptPasswordEncoder bCryptPasswordEncoder;
  
  @GetMapping("/active_page")
  public String activePage(){
    return "mypage/active_page";
  }
  
  @GetMapping("/address")
  public String addressList(@RequestParam("mid") String mid, Model model){
    //서비스에서 생성한 리스트를 list라는 이름으로 반환.
    Member memberTmp = userRepository.findByUsername(mid);
    model.addAttribute("list", addressRepository.findByMember(memberTmp));
    log.info(".................."+memberTmp);
    log.info(".................");
    return "mypage/address";
    }

  @PostMapping("/address/delete")
  public String addressDelete(@RequestParam(value="addressNum") Long addressNum, @RequestParam("mid") String mid){
    addressRepository.deleteById(addressNum);
    return "redirect:/mypage/address?mid="+mid;
  }
  
  
  @GetMapping("/userinfo")
  public String userInfo(@RequestParam("mid") String mid, Model model){
    Member memberTmp =userRepository.findByUsername(mid);
    model.addAttribute("userid", memberTmp.getUsername());
    model.addAttribute("username", memberTmp.getUser_name());
    model.addAttribute("nickname", memberTmp.getNickname());
    model.addAttribute("email", memberTmp.getEmail());
    model.addAttribute("mobile", memberTmp.getMobile_num());
    model.addAttribute("birthday", memberTmp.getBirthday());
    return "mypage/userinfo";
  }
  
  @GetMapping("/delete_account")
  public String deleteAccount(){
  // public String deleteAccount(@RequestParam("mid") String mid, Model model){
    // Member memberTmp =userRepository.findByUsername(mid);
    // model.addAttribute("userid", memberTmp.getUsername());
    return "mypage/delete_account";
  }

  // @PostMapping("/delete_account/delete")
  // public String accountDelete(@RequestParam(value="id") Long id, @RequestParam("mid") String mid){
  //   userRepository.deleteById(123L);
  //   // userService.deleteById(123L);
  //   SecurityContextHolder.clearContext();
  //   return "redirect:/home";
  //   // return "redirect:/mypage/address?mid="+mid;
  // }

  // @PostMapping("/delete_account/delete")
  // public String accountDelete(@RequestParam(value="id", required = false) Long id, @RequestParam("mid") String mid){
  //   userRepository.deleteById(125L);
  //   SecurityContextHolder.clearContext();
  //   return "redirect:/home";
  //   // return "redirect:/mypage/address?mid="+mid;
  // }
  @PostMapping("/delete_account/delete")
  public String accountDelete(Long id){
    // userRepository.deleteById(125L);
    userService.delete(id);
    SecurityContextHolder.clearContext();
    return "redirect:/home";
    // return "redirect:/mypage/address?mid="+mid;
  }
  
  @PostMapping("/userinfo/modify")
  public String modify(Member member, @RequestParam(value="user_id") String user_id,
                      @RequestParam(value="user_name") String user_name, @RequestParam(value="nickname") String nickname,
                      @RequestParam(value="email") String email, @RequestParam(value="mobile_num") String mobile_num,
                      @RequestParam(value="birthday") Long birthday){
    Member memberTmp =userRepository.findByUsername(user_id);
    String EncPassword = bCryptPasswordEncoder.encode(member.getPassword());
    memberTmp.setPassword(EncPassword);
    memberTmp.setUser_name(user_name);
    memberTmp.setNickname(nickname);
    memberTmp.setEmail(email);
    memberTmp.setMobile_num(mobile_num);
    memberTmp.setBirthday(birthday);
    userRepository.save(memberTmp);
    // return "redirect:/mypage/userinfo?mid="+user_id;
    SecurityContextHolder.clearContext();
    return "redirect:/login";
  }
  
  
  
  @GetMapping("/adr_modify")
  public String adrModify(){
    return "mypage/adr_modify";
  }
  
  @GetMapping("/adr_popup")
  public String adrPopup(){
    return "mypage/adr_popup";
  }
  
  @GetMapping("/pointPage")
  public String pointPage(){
    return "mypage/pointPage";
  }
  
  @GetMapping("/shopping_list")
  public String shoppingList(){
    return "mypage/shopping_list";
  }
  
  @GetMapping("/pick_list")
  public String pickList(){
    return "mypage/pick_list";
  }
  
  @GetMapping("/health_info")
  public String healthInfo(@RequestParam("mid") String mid, Model model){
    Member memberTmp =userRepository.findByUsername(mid);
    model.addAttribute("calorie", memberTmp.getDaily_calorie_intake());
    model.addAttribute("carb", memberTmp.getCarb_rate());
    model.addAttribute("protein", memberTmp.getProtein_rate());
    model.addAttribute("fat", memberTmp.getFat_rate());
    model.addAttribute("allergy", memberTmp.getAllergy());
    return "mypage/health_info";
  }

  @PostMapping("/health_info/calorie")
  public String updateCalorie(@RequestParam(value="daily-calorie-intake") Long dailyCalorieIntake, @RequestParam(value="user_id") String user_id) {
    Member memberTmp =userRepository.findByUsername(user_id);
    memberTmp.setDaily_calorie_intake(dailyCalorieIntake);
        log.info("................................"+memberTmp);
        userRepository.save(memberTmp);
        return "redirect:/mypage/health_info?mid="+user_id;
    }

      @PostMapping("/health_info/rate")
      public String updateRate(@RequestParam(value="carb_rate") Long carb_rate, @RequestParam(value="protein_rate") Long protein_rate, 
      @RequestParam(value="fat_rate") Long fat_rate, @RequestParam(value="user_id") String user_id) {
                            Member memberTmp =userRepository.findByUsername(user_id);
                            memberTmp.setCarb_rate(carb_rate);
        memberTmp.setProtein_rate(protein_rate);
        memberTmp.setFat_rate(fat_rate);
        log.info("................................"+memberTmp);
        userRepository.save(memberTmp);
        return "redirect:/mypage/health_info?mid="+user_id;
  }

  @PostMapping("/health_info/allergy")
  public String createAddress(@RequestParam(value="allergy") String allergy,@RequestParam(value="user_id") String user_id) {
        Member memberTmp =userRepository.findByUsername(user_id);
        memberTmp.setAllergy(allergy);
        log.info("................................"+memberTmp);
        userRepository.save(memberTmp);
        return "redirect:/mypage/health_info?mid="+user_id;
  }
    
}