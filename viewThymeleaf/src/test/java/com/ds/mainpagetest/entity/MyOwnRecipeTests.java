package com.ds.mainpagetest.entity;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ds.mainpagetest.repositiory.MainpagetestRepository;


public class MyOwnRecipeTests {
  @Autowired
  MainpagetestRepository mRepository;
  
  @Test
  public void insertDummies(){
    IntStream.rangeClosed(1, 100).forEach(new IntConsumer() {
     @Override
     public void accept(int i) {
      MyOwnRecipe mor = MyOwnRecipe.builder()
                      .name("Title..." + i)
                      .explanation("Content" + i)
                      .views(1)
                      .likeCount(1)
                      .category("category" + Math.random()*10)
                      .detail("detail")
                      .build();
      System.out.println(mRepository.save(mor));

     } 
    });
  }
}
