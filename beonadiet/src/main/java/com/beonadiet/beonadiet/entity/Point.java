package com.beonadiet.beonadiet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "point")
@Builder
public class Point extends BaseEntity {
  //적립금내역 ID
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  //적립,사용코드
  @Column
  private Character earn_use_code;

  //적립,사용일자
  @Column
  private Date point_date;

  //적립,사용전금액
  @Column
  private Long before_point;

  //적립,사용후금액
  @Column
  private Long after_point;


  @ManyToOne(fetch = FetchType.EAGER)    
  @JoinColumn(name = "member_id")
  // @JoinColumn(name = "member_id", unique = true)
  private Member member;

  // @PrePersist
  // public void prePersist() {
  //     this.default_address = this.default_address == null ? 0 : this.default_address;
  // }

}
