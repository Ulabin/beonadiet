package com.beonadiet.beonadiet.entity;

import lombok.*;
import javax.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity //DB 테이블 역할
@Getter //get 함수를 일괄적으로 만들어준다
@Setter
@ToString
@NoArgsConstructor //기본 생성자 만들어준다
public class Member extends BaseEntity {

    @Id
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
    
    // @ColumnDefault("0")
    // @Column(nullable=false)
    // private Character role;

    // @Enumerated(EnumType.STRING)
    // private Role role;

    @Column
    private String role; //ROLE_USER, ROLE_ADMIN

    @Builder
    public Member(Long id, String user_id, String password, String user_name, 
                String nickname, String email, Long mobile_num, Long birthday,
                String allergy, Long daily_calorie_intake, boolean social_login_flag, 
                Long point, Long carb_protein_fat_rate, String role){
                    
                    this.id = id; this.user_id = user_id; this.password = password;
                    this.user_name = user_name; this.nickname = nickname; this.email = email;
                    this.mobile_num = mobile_num; this.birthday = birthday; this.allergy = allergy;
                    this.daily_calorie_intake = daily_calorie_intake; this.social_login_flag = social_login_flag;
                    this.point = point; this.carb_protein_fat_rate = carb_protein_fat_rate; this.role = role;
                    
    }




    // public static Member createUser(UserDto userDto, PasswordEncoder passwordEncoder) {

    //     Member member = new Member();
    //     member.setUser_id(member.getUser_id());
    //     String password = passwordEncoder.encode(userDto.getPassword());
    //     member.setPassword(password);
    //     member.setUser_name(member.getUser_name());
    //     member.setNickname(member.getNickname());
    //     member.setEmail(member.getEmail());
    //     member.setMobile_num(member.getMobile_num());
    //     member.setBirthday(member.getBirthday());
    //     member.setAllergy(member.getAllergy());
    //     member.setDaily_calorie_intake(member.getDaily_calorie_intake());
    //     member.setPoint(member.getPoint());
    //     member.setCarb_protein_fat_rate(member.getCarb_protein_fat_rate());
    //     member.setRole(Role.USER);
    //     return member;

    // }


}