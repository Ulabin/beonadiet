package com.beonadiet.beonadiet.entity;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

@Entity //DB 테이블 역할
@Getter //get 함수를 일괄적으로 만들어준다
@Builder
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor //기본 생성자 만들어준다
@Table(name = "member")
public class Member extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(length = 20, nullable = false, unique = true, name = "user_id")
    private String username;
    // private String user_id;
    
    @Column(length = 100, nullable = false)
    private String password;
    
    @Column(length = 20, nullable = false)
    private String user_name;
    
    @Column(length = 20, nullable = false, unique = true)
    private String nickname;
    
    @Column(length = 30, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String mobile_num;
    
    @Column(nullable = false)
    private Long birthday;
    
    @Column(length = 500)
    private String allergy;
    
    @Column
    private Long daily_calorie_intake;
    
    // @Column(nullable = false)
    // private boolean social_login_flag;
    
    // @ColumnDefault("0")
    // @Column(nullable=false)

    @Column
    private Long point;
    
    @Column
    private Long carb_rate;

    @Column
    private Long protein_rate;

    @Column
    private Long fat_rate;
    
    @Column
    private String role; //ROLE_USER, ROLE_ADMIN


    @PrePersist
    public void prePersist() {
        this.point = this.point == null ? 0 : this.point;
    }

}