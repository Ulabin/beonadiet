package com.beonadiet.beonadiet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.beonadiet.beonadiet.entity.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //DB 테이블 역할
@Getter //get 함수를 일괄적으로 만들어준다
@ToString(exclude = {"member","product"})
@AllArgsConstructor
@NoArgsConstructor //기본 생성자 만들어준다
@Builder
public class Cart extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
  
    //조합내용
    @Column(length = 4000)
    private String combination_content;

    private Float carbs_amount;
    private Float protein_amount;
    private Float fat_amount;
    private Float calorie;
  
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "member_id")
    private Member member;
  
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "product_id")
    private Product product;

    private Long productCount;
}

