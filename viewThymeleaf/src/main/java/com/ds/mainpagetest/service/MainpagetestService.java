package com.ds.mainpagetest.service;

import com.ds.mainpagetest.dto.MyOwnRecipeDTO;
import com.ds.mainpagetest.dto.PageRequestDTO;
import com.ds.mainpagetest.dto.PageResultDTO;
import com.ds.mainpagetest.entity.MyOwnRecipe;

public interface MainpagetestService {
  PageResultDTO<MyOwnRecipeDTO, MyOwnRecipe> getList(PageRequestDTO requestDTO);
  
  default MyOwnRecipe dtoToEntity(MyOwnRecipeDTO dto) {
    MyOwnRecipe entity = MyOwnRecipe.builder().id(dto.getId())
        .name(dto.getName())
        .explanation(dto.getExplanation())
        .views(dto.getViews())
        .likeCount(dto.getLikeCount())
        .category(dto.getCategory())
        .detail(dto.getDetail())
        .build();

    return entity;
  }

  default MyOwnRecipeDTO entityToDTO(MyOwnRecipe entity) {
    MyOwnRecipeDTO dto = MyOwnRecipeDTO.builder().id(entity.getId())
        .name(entity.getName())
        .explanation(entity.getExplanation())
        .views(entity.getViews())
        .likeCount(entity.getLikeCount())
        .category(entity.getCategory())
        .detail(entity.getDetail())
        .build();

    return dto;
  }

}
