package com.beonadiet.beonadiet.dto;


import com.beonadiet.beonadiet.entity.Address;
import com.beonadiet.beonadiet.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdrDto {
  
  private Long num;

  private String address_name;

  private Long zip_code;
  
  private String address;

  private String receiver_name;

  private String mobile_num;

  private Character default_address;

  private Member member;


  public Address toEntity() {        
    Address addr = Address.builder()
              .num(num)
              .address_name(address_name)
              .zip_code(zip_code)
              .address(address)
              .receiver_name(receiver_name)
              .mobile_num(mobile_num)
              .default_address(default_address)
              .member(member)
              .build();        
    return addr;    
  }

  @Builder
  public AdrDto(Long num, String address_name, Long zip_code, String address, String receiver_name,
                String mobile_num, Character default_address, Member member){
    
     this.num = num; this.address_name = address_name; this.zip_code = zip_code; this.address = address;
     this.receiver_name = receiver_name; this.mobile_num = mobile_num; this.default_address = default_address;
     this.member = member;             
  }


}
