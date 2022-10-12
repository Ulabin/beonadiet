package com.beonadiet.beonadiet.dto;

import java.time.LocalDateTime;

import com.beonadiet.beonadiet.dto.product.ProductImageDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDTO{
  private Long id;

  private String combination_content;
  private Long productCount;
  
  private String productName;
  private Long productPrice;
  private ProductImageDTO productImg;
  
  private Long pid;
  private Long mid;

  private LocalDateTime regDate;
  private LocalDateTime modDate;
}
