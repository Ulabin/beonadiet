package com.beonadiet.beonadiet.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointDTO {
  private Long id;

  private Character earn_use_code;

  private Date point_date;

  private Long before_point;

  private Long after_point;
  
  private Long mid;

  private LocalDateTime regDate;
  private LocalDateTime modDate;
}
