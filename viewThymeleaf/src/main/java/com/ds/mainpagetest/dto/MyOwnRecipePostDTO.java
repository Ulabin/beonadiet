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
public class MyOwnRecipePostDTO {
  private Long id;
  private String name;
  private String explanation;
  private int views;
  private int likeCount;
  private int category;
  private String detail;
  private int calorie;
  private String image;
  private LocalDateTime regDate, modDate;
}
