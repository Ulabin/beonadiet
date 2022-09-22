package com.ds.mainpagetest.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ds.mainpagetest.dto.MyOwnRecipeDTO;
import com.ds.mainpagetest.dto.PageRequestDTO;
import com.ds.mainpagetest.dto.PageResultDTO;
import com.ds.mainpagetest.entity.MyOwnRecipe;
import com.ds.mainpagetest.repositiory.MainpagetestRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MainpagetestServiceImpl implements MainpagetestService{
  
  private final MainpagetestRepository mRepository;

  @Override
  public MyOwnRecipeDTO getRecipe(Long id) { 
    List<Object[]> result = mRepository.getRecipeId(id);
    MyOwnRecipe myOwnRecipe = (MyOwnRecipe) result.get(0)[0];
    return entityToDTO(myOwnRecipe);
  }
 @Override
 public PageResultDTO<MyOwnRecipeDTO, MyOwnRecipe> getList(PageRequestDTO requestDTO) {
  Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());
  // BooleanBuilder booleanBuilder = getSearch(requestDTO);
  // Page<MyOwnRecipe> result = gbRepository.findAll(booleanBuilder ,pageable);
  // BooleanBuilder booleanBuilder = getSearch(requestDTO);
  Page<MyOwnRecipe> result = mRepository.findAll(pageable);
  Function<MyOwnRecipe, MyOwnRecipeDTO> fn = new Function<MyOwnRecipe, MyOwnRecipeDTO>() {
    @Override
    public MyOwnRecipeDTO apply(MyOwnRecipe entity) {
      return entityToDTO(entity); // entity를 다시 dto로 만들어 보냄
    }
  };
  return new PageResultDTO<>(result, fn);
 }

}
