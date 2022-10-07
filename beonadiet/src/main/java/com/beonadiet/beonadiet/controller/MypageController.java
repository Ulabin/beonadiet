package com.beonadiet.beonadiet.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beonadiet.beonadiet.dto.UserDto;
import com.beonadiet.beonadiet.dto.AdrDto;
import com.beonadiet.beonadiet.entity.Address;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.AddressRepository;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.service.AdrService;
import com.beonadiet.beonadiet.service.UserService;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/mypage")
@Controller
@Log4j2
public class MypageController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserService userService;

  
  @GetMapping("/healthTest")
  public String healthTest(){
    return "mypage/healthTest";
  }

  @GetMapping("/active_page")
  public String activePage(){
    return "mypage/active_page";
  }

  // @GetMapping("/userinfo")
  // public String userInfo(){
  //   return "mypage/userinfo";
  // }

  // @GetMapping("/delete_account")
  // public String deleteAccount(){
    //   return "mypage/delete_account";
    // }

    // @GetMapping("/address")
  // public String address(){
    //   return "mypage/address";
    // }
    @Autowired
    AdrService adrService;
    
  @Autowired
  AddressRepository addressRepository;
  
  // @Autowired
  // UserDto userDto;
  
  @GetMapping("/address")
  public String addressList(@RequestParam("mid") String mid, Model model){
    //서비스에서 생성한 리스트를 list라는 이름으로 반환하겠다.
    Member memberTmp = userRepository.findByUsername(mid);
    
    // model.addAttribute("list", addressRepository.findById(id));
    // List<Address> addressList = addressRepository.findById(id);
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
    public String deleteAccount(@RequestParam("mid") String mid, Model model){
      Member memberTmp =userRepository.findByUsername(mid);
      model.addAttribute("userid", memberTmp.getUsername());
      return "mypage/delete_account";
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
  

  @PostMapping("/health_info/calorie")
  public String updateCalorie(@RequestParam(value="daily-calorie-intake") Long dailyCalorieIntake, @RequestParam(value="user_id") String user_id) {
    Member memberTmp =userRepository.findByUsername(user_id);
    memberTmp.setDaily_calorie_intake(dailyCalorieIntake);
        log.info("................................"+memberTmp);
        userRepository.save(memberTmp);
        // return "mypage/health_info";
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
        // return "mypage/health_info";
        return "redirect:/mypage/health_info?mid="+user_id;
    }

  @PostMapping("/health_info/allergy")
  public String createAddress(@RequestParam(value="allergy") String allergy,@RequestParam(value="user_id") String user_id) {
        Member memberTmp =userRepository.findByUsername(user_id);
        memberTmp.setAllergy(allergy);
        log.info("................................"+memberTmp);
        userRepository.save(memberTmp);
        // return "mypage/health_info";
        return "redirect:/mypage/health_info?mid="+user_id;
    }
    
    // @PostMapping("/health_info/create")
    // public String createHealthInfo(Member member,@RequestParam(value="daily-calorie-intake") Long dailyCalorieIntake,@RequestParam(value="user_id") String user_id){
    //   userService.UpdateHealthInfo(dailyCalorieIntake, user_id);
    //   return "redirect:/mypage/health_info";
    //   // return "redirect:/login";
    // }

    
  }