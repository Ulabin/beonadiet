package com.beonadiet.beonadiet.dto;

import com.beonadiet.beonadiet.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
  
  private String user_id;

  private String password;

  private String user_name;

  private String nickname;

  private String email;

  private Long mobile_num;

  private Long birthday;

  private String allergy;

  private Long daily_calorie_intake;

  private boolean social_login_flag;

  private Long point;

  private Long carb_protein_fat_rate;

  private Character role;


  /* DTO -> Entity */    
  // public User toEntity() {        
  //   User user = User.builder()                
  //             .user_id(user_id)                
  //             .password(password)                
  //             .user_name(user_name)                
  //             .nickname(nickname)                
  //             .email(email)                
  //             .mobile_num(mobile_num)                
  //             .birthday(birthday)                
  //             .allergy(allergy)                
  //             .daily_calorie_intake(daily_calorie_intake)                
  //             .social_login_flag(social_login_flag)                
  //             .point(point)                
  //             .carb_protein_fat_rate(carb_protein_fat_rate)                
  //             .role(role)                
  //             .build();        
  //   return user;    }
}
