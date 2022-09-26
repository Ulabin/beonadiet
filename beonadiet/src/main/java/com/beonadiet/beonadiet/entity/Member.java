package com.beonadiet.beonadiet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
// import com.beonadiet.constant.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Setter;
import lombok.ToString;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import com.beonadiet.beonadiet.dto.UserDto;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
// import org.springframework.security.crypto.password.PasswordEncoder;


@Entity
// @Table(name = "USER")
@Getter 
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Member extends BaseEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String user_id;
    
    @Column(length = 100, nullable = false)
    private String password;
    
    @Column(length = 20, nullable = false)
    private String user_name;
    
    @Column(length = 20, nullable = false, unique = true)
    private String nickname;
    
    @Column(length = 30, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private Long mobile_num;
    
    @Column(nullable = false)
    private Long birthday;
    
    @Column(length = 500)
    private String allergy;
    
    @Column
    private Long daily_calorie_intake;
    
    @Column(nullable = false)
    private boolean social_login_flag;
    
    @ColumnDefault("0")
    @Column(nullable=false)
    private Long point;
    
    @Column
    private Long carb_protein_fat_rate;
    
    @ColumnDefault("0")
    @Column(nullable=false)
    private Character role;

    // public UserEntity(String password, String user_name, String nickname, String email, Long mobile_num, 
    //                     Long birthday, String allergy, Long daily_calorie_intake, Long point, Long carb_protein_fat_rate) {
	// 	this.password   = password;
	// 	this.user_name = user_name;
    //     this.nickname = nickname;
    //     this.email = email;
    //     this.mobile_num = mobile_num;
    //     this.birthday = birthday;
    //     this.allergy = allergy;
    //     this.daily_calorie_intake = daily_calorie_intake;
    //     this.point = point;
    //     this.carb_protein_fat_rate = carb_protein_fat_rate;
        
	// }

    // public static UserEntity createUser(UserDto userDto, PasswordEncoder passwordEncoder) {

    //     UserEntity user = new UserEntity();
    //     user.setUser_id(user.getUser_id());
    //     user.setName(user.getName());
    //     user.setEmail(user.getEmail());
    //     user.setAddress(user.getAddress());
    //     String password = passwordEncoder.encode(userDto.getPassword());
    //     user.setPassword(password);
    //     user.setRole(Role.USER);
    //     return user;

    // }


}