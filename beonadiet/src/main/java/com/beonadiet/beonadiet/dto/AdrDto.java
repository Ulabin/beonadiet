package com.beonadiet.beonadiet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdrDto {
  
  private Long num;

  private String address;

  private String receiver_name;

  private String mobile_num;

  private Character default_address;

  private Long mid;
}
