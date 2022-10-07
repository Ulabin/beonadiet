package com.beonadiet.beonadiet.repository.recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beonadiet.beonadiet.entity.recipe.MyOwnRecipe;

public interface MyOwnRecipeRepository extends JpaRepository<MyOwnRecipe, Long>{
  
  @Query("select m from MyOwnRecipe m where id=:idm ")
  List<Object[]> getRecipeId(Long idm);
}
