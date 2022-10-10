package com.beonadiet.beonadiet.dto;


import com.beonadiet.beonadiet.entity.Address;
import com.beonadiet.beonadiet.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdrDto {
  
  private Long num;

  // private String address_name;

  // private Long zip_code;
  
  private String address;

  private String receiver_name;

  private String mobile_num;

  private Character default_address;

  private Long mid;
}
