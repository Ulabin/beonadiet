package com.beonadiet.beonadiet.dto;

import com.beonadiet.beonadiet.entity.Member;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
  
  private Long id;

  private String username;
  // private String user_id;

  private String password;

  private String user_name;

  private String nickname;

  private String email;

  private String mobile_num;

  private Long birthday;

  private String allergy;

  private Long daily_calorie_intake;

  // private boolean social_login_flag;

  private Long point;

  private Long carb_rate;

  private Long protein_rate;

  private Long fat_rate;

  private String role;

  private LocalDateTime regDate;

  private LocalDateTime modDate;


  /* DTO -> Entity */    
  public Member toEntity() {        
    Member member = Member.builder() 
              .id(id)               
              .username(username)                
              .password(password)                
              .user_name(user_name)                
              .nickname(nickname)                
              .email(email)                
              .mobile_num(mobile_num)                
              .birthday(birthday)                
              .allergy(allergy)                
              .daily_calorie_intake(daily_calorie_intake)                
              // .social_login_flag(social_login_flag)                
              .point(point)                
              .carb_rate(carb_rate)                
              .protein_rate(protein_rate)                
              .fat_rate(fat_rate)                
              .role(role)                
              .build();        
    return member;    
  }

  @Builder

  public UserDto(Long id, String username, String password, String user_name, 
              String nickname, String email, String mobile_num, Long birthday,
              String allergy, Long daily_calorie_intake, 
              Long point, Long carb_rate, Long protein_rate, Long fat_rate, String role,
              LocalDateTime regDate, LocalDateTime modDate){

    this.id = id; this.username = username; this.password = password;
    this.user_name = user_name; this.nickname = nickname; this.email = email;
    this.mobile_num = mobile_num; this.birthday = birthday; this.allergy = allergy;
    this.daily_calorie_intake = daily_calorie_intake;
    this.point = point; this.carb_rate = carb_rate; 
    this.protein_rate = protein_rate; this.fat_rate = fat_rate; this.role = role;
    this.regDate = regDate; this.modDate = modDate;

  }
}
