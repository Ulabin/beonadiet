package com.beonadiet.beonadiet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //DB 테이블 역할
@Getter //get 함수를 일괄적으로 만들어준다
@Setter
@ToString(exclude = {"member"})
@AllArgsConstructor
@NoArgsConstructor //기본 생성자 만들어준다
@Table(name = "shipping_info")
@Builder
public class Address extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long num;

  // @Column(length = 20)
  // private String address_name;

  // @Column
  // private Long zip_code;

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
  // @JoinColumn(name = "member_id", unique = true)
  private Member member;

  @PrePersist
  public void prePersist() {
      this.default_address = this.default_address == null ? 0 : this.default_address;
  }

}
