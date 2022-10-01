package com.beonadiet.beonadiet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //DB 테이블 역할
@Getter //get 함수를 일괄적으로 만들어준다
@Setter
@ToString
@NoArgsConstructor //기본 생성자 만들어준다
@Table(name = "shipping_info")
public class Address extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long num;

  @Column(length = 20)
  private String address_name;

  @Column
  private Long zip_code;

  @Column
  private String address;

  @Column(length = 20)
  private String receiver_name;

  @Column
  private String mobile_num;

  @Column
  private Character default_address;

  @JoinColumn(name = "member_id") // 외래키(포린키)의 이름을 바꿀 수 있다.
  @ManyToOne 
  // @ManyToOne(fetch = FetchType.EAGER) 
  private Member member; // user_id 만들어준다. 포린키 만들어준다. 
}
