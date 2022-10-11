package com.beonadiet.beonadiet.controller;

import java.util.List;
import java.util.function.Consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beonadiet.beonadiet.BadRequestException;
import com.beonadiet.beonadiet.dto.CartDto;
import com.beonadiet.beonadiet.dto.product.ProductDTO;
import com.beonadiet.beonadiet.dto.product.ProductImageDTO;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.entity.product.Product;
import com.beonadiet.beonadiet.entity.product.ProductImage;
import com.beonadiet.beonadiet.repository.UserRepository;
import com.beonadiet.beonadiet.repository.product.ProductImageRepository;
import com.beonadiet.beonadiet.service.CartService;
import com.beonadiet.beonadiet.service.UserService;
import com.beonadiet.beonadiet.service.product.ProductService;

@Controller
public class UserController{
  @Autowired
  UserRepository userRepository;

  @Autowired
  UserService userService;

  @GetMapping("/login")
  public String login(){
    return "login";
  }
  @GetMapping("/find_id")
  public String findId(){
    return "find_id";
  }
  @GetMapping("/find_pwd")
  public String findPwd(){
    return "find_pwd";
  }
  @GetMapping("/join")
  public String join(){
    return "join";
  }
  @GetMapping("/join_complete")
  public String joinComplete(){
    return "join_complete";
  }


  @GetMapping("/order")
  public String order(){
    return "order";
  }

  @PostMapping("/joinProc")
  public String joinProc(Member member){
    userService.Join(member);
    return "redirect:/join_complete";
  }


  @GetMapping("join/id/check")
  public ResponseEntity<?> checkIdDuplication(@RequestParam(value = "username") String username) throws BadRequestException {
      System.out.println(username);

      if (userService.existsByUsername(username) == true) {
        throw new BadRequestException("이미 사용중인 아이디 입니다.");
      } else {
          return ResponseEntity.ok("사용 가능한 아이디 입니다.");
      }
  }

  @GetMapping("join/nickname/check")
  public ResponseEntity<?> checkNicknameDuplication(@RequestParam(value = "nickname") String nickname) throws BadRequestException {
      System.out.println(nickname);

      if (userService.existsByNickname(nickname) == true) {
        throw new BadRequestException("이미 사용중인 닉네임 입니다.");
      } else {
          return ResponseEntity.ok("사용 가능한 닉네임 입니다.");
      }
  }

  @GetMapping("join/email/check")
  public ResponseEntity<?> checkEmailDuplication(@RequestParam(value = "email") String email) throws BadRequestException {
      System.out.println(email);

      if (userService.existsByEmail(email) == true) {
        throw new BadRequestException("이미 사용중인 이메일 입니다.");
      } else {
          return ResponseEntity.ok("사용 가능한 이메일 입니다.");
      }
  }

  @Autowired
  CartService cartService;

  @Autowired
  ProductService productService;

  @GetMapping("/cart")
  public String cartPost(@RequestParam("user_id") String user_id,Model model){
    List<CartDto> cartDtoList =cartService.findByMember(Member.builder().id(userRepository.findByUsername(user_id).getId()).build());
    cartDtoList.forEach(new Consumer<CartDto>() {
      @Override
      public void accept(CartDto t) {
        Product product = productService.findById(t.getPid());
        List<ProductImage> imgList=piRepository.findByProduct(Product.builder().id(t.getPid()).build());
        ProductImage img= imgList.get(0);
        ProductImageDTO imgDTO = ProductImageDTO.builder().folderPath(img.getFolderPath()).path(img.getPath()).uuid(img.getUuid()).imgName(img.getImgName()).build();
        t.setImage(imgDTO);
        t.setItemName(product.getName());
        t.setItemPrice(product.getPrice());
      }
    });

    model.addAttribute("list", cartDtoList);
    return "cart";
  }

  @Autowired
  ProductImageRepository piRepository;

  @PostMapping("/gocart/my_own_series")
  public String goCart(@RequestParam("my_own_series") String myOwnSeriesInfo,@RequestParam("type") String type,@RequestParam("user_id") String user_id, RedirectAttributes ra){
    ProductDTO productDTO=productService.findByName(type);
    CartDto cartDTO = CartDto.builder()
    .pid(productDTO.getId())
    .productCount(Long.valueOf(1))
    .mid(userRepository.findByUsername(user_id).getId())
    .combination_content(myOwnSeriesInfo).build();
    cartService.register(cartDTO);

    List<CartDto> cartDtoList =cartService.findByMember(Member.builder().id(cartDTO.getMid()).build());
    cartDtoList.forEach(new Consumer<CartDto>() {
      @Override
      public void accept(CartDto t) {
        Product product = productService.findById(t.getPid());
        List<ProductImage> imgList=piRepository.findByProduct(Product.builder().id(t.getPid()).build());
        ProductImage img= imgList.get(0);
        ProductImageDTO imgDTO = ProductImageDTO.builder().folderPath(img.getFolderPath()).path(img.getPath()).uuid(img.getUuid()).imgName(img.getImgName()).build();
        t.setImage(imgDTO);
        t.setItemName(product.getName());
        t.setItemPrice(product.getPrice());
      }
    });

    ra.addFlashAttribute("list", cartDtoList);

    return "redirect:/cart?user_id="+user_id;
  }
}
