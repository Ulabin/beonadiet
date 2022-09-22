package com.ds.mainpagetest.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ds.mainpagetest.entity.MyOwnRecipe;

public interface MainpagetestRepository extends JpaRepository<MyOwnRecipe, Long>{
  
  @Query("select m from MyOwnRecipe m where id=:id ")
  List<Object[]> getRecipeId(Long id);
}
