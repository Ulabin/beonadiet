package com.beonadiet.beonadiet.controller;


import java.util.List;
import java.util.function.Consumer;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beonadiet.beonadiet.dto.PurchaseDTO;
import com.beonadiet.beonadiet.dto.product.ProductImageDTO;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.entity.product.Product;
import com.beonadiet.beonadiet.entity.product.ProductImage;
import com.beonadiet.beonadiet.repository.AddressRepository;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.repository.product.ProductImageRepository;
import com.beonadiet.beonadiet.service.AdrService;
import com.beonadiet.beonadiet.service.PurchaseService;
import com.beonadiet.beonadiet.service.UserService;
import com.beonadiet.beonadiet.service.product.ProductService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/mypage")
@Controller
@Log4j2
public class MypagesController {
  @Autowired
  PurchaseService purchaseService;
  @Autowired
  ProductImageRepository piRepository;
  @Autowired
  ProductService productService;

  
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
    model.addAttribute("username", memberTmp.getUser_name());
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
    return "redirect:/mypage/userinfo?mid="+user_id;
    // SecurityContextHolder.clearContext();
    // return "redirect:/login";
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
  public String pointPage(@RequestParam("mid") String mid, Model model){
    Member memberTmp =userRepository.findByUsername(mid);
    model.addAttribute("username", memberTmp.getUser_name());
    return "mypage/pointPage";
  }

  
  @GetMapping("/shopping_list")
  public String shoppingList(@RequestParam("mid") String mid, Model model){
    Member memberTmp =userRepository.findByUsername(mid);
    model.addAttribute("userid", memberTmp.getUsername());
    model.addAttribute("username", memberTmp.getUser_name());
    model.addAttribute("nickname", memberTmp.getNickname());
    model.addAttribute("email", memberTmp.getEmail());
    model.addAttribute("mobile", memberTmp.getMobile_num());
    model.addAttribute("birthday", memberTmp.getBirthday());
    List<PurchaseDTO> purchaseDtoList = purchaseService.findByMember(memberTmp);
    purchaseDtoList.forEach(new Consumer<PurchaseDTO>() {
      @Override
      public void accept(PurchaseDTO t) {
        Product product = productService.findById(t.getPid());
        List<ProductImage> imgList=piRepository.findByProduct(Product.builder().id(t.getPid()).build());
        ProductImage img= imgList.get(0);
        ProductImageDTO imgDTO = ProductImageDTO.builder().folderPath(img.getFolderPath()).path(img.getPath()).uuid(img.getUuid()).imgName(img.getImgName()).build();
        t.setProductImg(imgDTO);
        t.setProductName(product.getName());
      }
    });
    model.addAttribute("list",purchaseDtoList);
    return "mypage/shopping_list";
  }


  @PostMapping("/shopping_list")
  public String shoppingList2(@RequestParam("mid") String mid, Model model, @RequestParam("list") String list){
    Member memberTmp =userRepository.findByUsername(mid);
    log.info("............................."+list);

    try {
      JSONParser parser = new JSONParser();
      Object obj = parser.parse(list);
      JSONArray jsonArr = (JSONArray)obj;
  
      if (jsonArr.size() > 0){
          for(int i=0; i<jsonArr.size(); i++){
              JSONObject jsonObj = (JSONObject)jsonArr.get(i);
              
              PurchaseDTO purchaseDTO = PurchaseDTO.builder()
              .id((Long)jsonObj.get("id"))
              .combination_content(jsonObj.get("combination_content").toString())
              .productCount((Long)jsonObj.get("productCount"))
              .mid((Long)jsonObj.get("mid"))
              .pid((Long)jsonObj.get("pid"))
              .productPrice((Long)jsonObj.get("itemPrice"))
              .build();

              purchaseService.register(purchaseDTO);

              log.info(purchaseDTO);


          }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
 
    model.addAttribute("userid", memberTmp.getUsername());
    model.addAttribute("username", memberTmp.getUser_name());
    model.addAttribute("nickname", memberTmp.getNickname());
    model.addAttribute("email", memberTmp.getEmail());
    model.addAttribute("mobile", memberTmp.getMobile_num());
    model.addAttribute("birthday", memberTmp.getBirthday());

    List<PurchaseDTO> purchaseDtoList = purchaseService.findByMember(memberTmp);
    purchaseDtoList.forEach(new Consumer<PurchaseDTO>() {
      @Override
      public void accept(PurchaseDTO t) {
        Product product = productService.findById(t.getPid());
        List<ProductImage> imgList=piRepository.findByProduct(Product.builder().id(t.getPid()).build());
        ProductImage img= imgList.get(0);
        ProductImageDTO imgDTO = ProductImageDTO.builder().folderPath(img.getFolderPath()).path(img.getPath()).uuid(img.getUuid()).imgName(img.getImgName()).build();
        t.setProductImg(imgDTO);
        t.setProductName(product.getName());
      }
    });
    model.addAttribute("list",purchaseDtoList);

    return "mypage/shopping_list";
  }
  
  @GetMapping("/pick_list")
  public String pickList(@RequestParam("mid") String mid, Model model){
    Member memberTmp =userRepository.findByUsername(mid);
    model.addAttribute("username", memberTmp.getUser_name());
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
    model.addAttribute("username", memberTmp.getUser_name());
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