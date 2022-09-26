// package com.beonadiet.beonadiet.dto;

// import java.io.Serializable;

// import com.beonadiet.beonadiet.entity.User;

// import lombok.Getter;

// @Getter
// public class UserSessionDto implements Serializable {    
//   private String user_id;    
//   private String password;    
//   private String user_name;    
//   private String nickname;    
//   private String email;    
//   private Long mobile_num;
//   private Long birthday;
//   private Character role;	    
  
//   /* Entity -> Dto */    
//   public UserSessionDto(User user) {        
//     this.user_id = user.getUser_id();        
//     this.password = user.getPassword();        
//     this.user_name = user.getUser_name();        
//     this.nickname = user.getNickname();        
//     this.email = user.getEmail();     
//     this.mobile_num = user.getMobile_num();     
//     this.birthday = user.getBirthday();     
//     this.role = user.getRole();    
//   }
  
// }