package com.beonadiet.beonadiet.dto;

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

  private String role;

}
