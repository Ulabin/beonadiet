package com.beonadiet.beonadiet.dto;

import com.beonadiet.beonadiet.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdrDto {
  
  private String address_name;

  private Long zip_code;
  
  private String address;

  private String receiver_name;

  private String mobile_num;

  private Character default_address;

  private Member member;

}
