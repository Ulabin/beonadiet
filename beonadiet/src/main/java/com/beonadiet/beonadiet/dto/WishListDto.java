package com.beonadiet.beonadiet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WishListDto {

  private Long num;

  private String combination_content;
  
  private Long carbs_amount;

  private Long protein_amount;

  private Long fat_amount;

  private Long calorie;

  private Long mid;

  // private Long pid;

}
