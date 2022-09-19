package com.ds.mainpagetest.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.mainpagetest.entity.MyOwnRecipe;

public interface MainpagetestRepository extends JpaRepository<MyOwnRecipe, Long>{
  
}
