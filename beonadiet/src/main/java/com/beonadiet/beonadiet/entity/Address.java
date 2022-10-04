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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
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

  @ManyToOne(fetch = FetchType.EAGER)    
  @JoinColumn(name = "member_id")    
  private Member member;

  @Builder
  public Address(Long num, String address_name, Long zip_code, String address, String receiver_name,
                  String mobile_num, Character default_address, Member member){
                  
         this.num = num; this.address_name = address_name; this.zip_code = zip_code; this.address = address;
         this.receiver_name = receiver_name; this.mobile_num = mobile_num; this.default_address = default_address;
         this.member = member;           
  }

}
