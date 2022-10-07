package com.beonadiet.beonadiet.dto.recipe;


import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyOwnRecipePostDTO {
  private Long id;
  private String title;
  private String explanation;
  private String detail;
  private int category;
  private LocalDateTime regDate, modDate;

  @Builder.Default
  private List<MorImageDTO> imageDTOList = new ArrayList<>();


}
