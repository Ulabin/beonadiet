package com.beonadiet.beonadiet.dto.recipe;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO { //어떤 페이지를 요청
  private int page;
  private int size;
  
  //검색후 해당 페이지가 유지되기 위한 변수들
  private String type;
  private String keyword;

  public PageRequestDTO(){
    page =1; //기본 첫페이지가 1이라 1로 초기화
    size = 5; //게시물이 다섯개만 나오게
  }
  public Pageable getPageable(Sort sort){
    return PageRequest.of(page-1, size, sort);
  } 
}
