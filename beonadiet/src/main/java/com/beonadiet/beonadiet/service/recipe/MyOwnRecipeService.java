package com.beonadiet.beonadiet.service.recipe;

import com.beonadiet.beonadiet.dto.recipe.MyOwnRecipeDTO;
import com.beonadiet.beonadiet.dto.recipe.MyOwnRecipePostDTO;
import com.beonadiet.beonadiet.dto.recipe.PageRequestDTO;
import com.beonadiet.beonadiet.dto.recipe.PageResultDTO;
import com.beonadiet.beonadiet.entity.recipe.MyOwnRecipe;

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
