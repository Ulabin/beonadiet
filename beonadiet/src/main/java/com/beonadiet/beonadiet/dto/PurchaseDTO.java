package com.beonadiet.beonadiet.dto;

import java.time.LocalDateTime;

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

  private Long pid;
 
  private Long mid;

  private LocalDateTime regDate;
  private LocalDateTime modDate;
}
