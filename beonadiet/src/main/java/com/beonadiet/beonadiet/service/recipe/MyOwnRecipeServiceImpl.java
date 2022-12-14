package com.beonadiet.beonadiet.service.recipe;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.recipe.MyOwnRecipeDTO;
import com.beonadiet.beonadiet.dto.recipe.PageRequestDTO;
import com.beonadiet.beonadiet.dto.recipe.PageResultDTO;
import com.beonadiet.beonadiet.entity.recipe.MyOwnRecipe;
import com.beonadiet.beonadiet.repository.recipe.MyOwnRecipeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MyOwnRecipeServiceImpl implements MyOwnRecipeService{
  
  private final MyOwnRecipeRepository mRepository;
  
  @Override
  public MyOwnRecipeDTO getRecipe(Long id) { 
    List<Object[]> result = mRepository.getRecipeId(id);
    log.info("id from MyOwnRecipeDTO ServiceImpl......"+id);
    log.info("객체result from MyOwnRecipeDTO ServiceImpl......"+result);
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
