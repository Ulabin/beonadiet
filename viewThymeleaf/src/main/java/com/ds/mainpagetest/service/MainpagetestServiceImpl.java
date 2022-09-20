package com.ds.mainpagetest.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ds.mainpagetest.dto.MyOwnRecipeDTO;
import com.ds.mainpagetest.dto.PageRequestDTO;
import com.ds.mainpagetest.dto.PageResultDTO;
import com.ds.mainpagetest.entity.MyOwnRecipe;
import com.ds.mainpagetest.repositiory.MainpagetestRepository;

public class MainpagetestServiceImpl implements MainpagetestService{
  @Autowired
  MainpagetestRepository mRepository;
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
