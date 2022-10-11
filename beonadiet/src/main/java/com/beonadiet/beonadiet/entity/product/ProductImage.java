package com.beonadiet.beonadiet.entity.product;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "product")
@Getter
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long inum;
  
    private String uuid;
    private String imgName;
    private String path;
    private String folderPath;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
