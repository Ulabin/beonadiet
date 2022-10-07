package com.ds.mainpagetest.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyOwnRecipeDTO {
  private Long id;
  private String name;
  private int category;
  private String detail;
  private int calorie;
  private LocalDateTime regDate, modDate;

}
