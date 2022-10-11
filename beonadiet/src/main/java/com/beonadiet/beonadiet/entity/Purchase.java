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

@Entity
@Getter 
@ToString(exclude = {"member","product"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long productCount;
  
    //조합내용
    @Column(length = 4000)
    private String combination_content;
    
    private Long price;
  
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "member_id")
    private Member member;
  
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "product_id")
    private Product product;
}

