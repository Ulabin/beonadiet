package com.beonadiet.beonadiet.dto.recipe;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResultDTO<DTO, EN> { // EN은 entity, 만들면 두루두루 쓸 페이지 DTO, EN은 이름이 아닌 순서
  private List<DTO> dtoList;

  private int totalPage; //총 페이지수
  private int page;// 현재 페이지
  private int size;//목록 사이즈
  private int start, end;//페이지 시작, 끝 번호
  private boolean prev, next;// 이전, 다음 페이지
  private List<Integer> pageList;// 페이지 번호목록

  // Page<EN> result은 복수개의 데이터가 담김
  public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
    dtoList = result.stream().map(fn).collect(Collectors.toList());
    totalPage = result.getTotalPages();
    makePageList(result.getPageable());
  }

  private void makePageList(Pageable pageable) {
    page = pageable.getPageNumber() + 1; //현재 페이지 번호
    size = pageable.getPageSize();// 페이지 갯수, 사이즈
    int tempEnd = (int) (Math.ceil(page / 10.0)) * 10; // 계산되어 끝나는 페이지
    start = tempEnd - 9; // 시작페이지
    prev = start > 1; //이전 페이지
    end = totalPage > tempEnd ? tempEnd : totalPage; // 실제 끝 페이지
    next = totalPage > tempEnd; //다음 페이지
    //페이지네이션
    pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

  }
}
