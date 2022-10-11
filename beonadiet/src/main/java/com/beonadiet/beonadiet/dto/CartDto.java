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
public class CartDto {
  private Long id;

  private String combination_content;
  
  private Float carbs_amount;

  private Float protein_amount;

  private Float fat_amount;

  private Float calorie;

  private Long mid;

  private Long productCount;

  private Long pid;

  private LocalDateTime regDate;
  private LocalDateTime modDate;
}
