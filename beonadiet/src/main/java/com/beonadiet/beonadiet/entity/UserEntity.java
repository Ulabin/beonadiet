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

@Entity
@Table(name = "user")
@Getter 
// @Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity extends BaseEntity {

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
    
    @Column(length = 500, nullable = false)
    private String allergy;
    
    @Column(nullable = false)
    private Long daily_calorie_intake;
    
    @Column(nullable = false)
    private boolean social_login_flag;
    
    @Column(nullable = false)
    private Long point;
    
    @Column(nullable = false)
    private Long carb_protein_fat_rate;
    
    @Column(length = 10, nullable = false)
    private String role;


    /* @Enumerated(EnumType.STRING) private Role role; */

    // public static User createMember(UserDto userDto,
    //                                   PasswordEncoder passwordEncoder) {
    //     User user = new User();
    //     user.setName(user.getName());
    //     user.setEmail(user.getEmail());
    //     user.setAddress(user.getAddress());
    //     String password = passwordEncoder.encode(userDto.getPassword());
    //     user.setPassword(password);
    //     member.setRole(Role.USER);
    //     return user;
    // }

}