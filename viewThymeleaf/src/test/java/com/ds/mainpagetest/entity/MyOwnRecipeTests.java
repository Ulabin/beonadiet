package com.ds.mainpagetest.entity;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ds.mainpagetest.repositiory.MainpagetestRepository;

@SpringBootTest
public class MyOwnRecipeTests {
  @Autowired
  MainpagetestRepository mRepository;
  
  @Test
  public void insertDummies(){
    IntStream.rangeClosed(1, 10).forEach(new IntConsumer() {
     @Override
     public void accept(int i) {
      MyOwnRecipe mor = MyOwnRecipe.builder()
                      .name("Title..." + i)
                      .explanation("Content" + i)
                      .views(1)
                      .likeCount((int)(Math.random()*10)*(int)(Math.random()*10))
                      .category((int)(Math.random()*10)/3)
                      .detail("detail")
                      .build();
      System.out.println(mRepository.save(mor));

     } 
    });
  }
}
