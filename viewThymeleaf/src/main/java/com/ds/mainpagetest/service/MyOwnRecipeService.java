package com.ds.mainpagetest.service;

import com.ds.mainpagetest.dto.MyOwnRecipeDTO;
import com.ds.mainpagetest.dto.MyOwnRecipePostDTO;
import com.ds.mainpagetest.dto.PageRequestDTO;
import com.ds.mainpagetest.dto.PageResultDTO;
import com.ds.mainpagetest.entity.MyOwnRecipe;

public interface MyOwnRecipeService {
  PageResultDTO<MyOwnRecipeDTO, MyOwnRecipe> getList(PageRequestDTO requestDTO);
  MyOwnRecipeDTO getRecipe(Long id);

  default MyOwnRecipe dtoToEntity(MyOwnRecipeDTO dto) {
    MyOwnRecipe entity = MyOwnRecipe.builder().id(dto.getId())
        .name(dto.getName())
        .category(dto.getCategory())
        .detail(dto.getDetail())
        .calorie(dto.getCalorie())
        .build();

    return entity;
  }

  default MyOwnRecipeDTO entityToDTO(MyOwnRecipe entity) {
    MyOwnRecipeDTO dto = MyOwnRecipeDTO.builder().id(entity.getId())
        .name(entity.getName())
        .category(entity.getCategory())
        .detail(entity.getDetail())
        .calorie(entity.getCalorie())
        .build();
    return dto;
  }

}
