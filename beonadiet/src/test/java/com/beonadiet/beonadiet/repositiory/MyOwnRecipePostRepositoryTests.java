package com.beonadiet.beonadiet.repositiory;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.beonadiet.beonadiet.entity.recipe.MyOwnRecipePost;
import com.beonadiet.beonadiet.repository.recipe.MyOwnRecipePostRepository;

@SpringBootTest
public class MyOwnRecipePostRepositoryTests {
  @Autowired
  MyOwnRecipePostRepository mpRepository;
  @Test
  public void insertDummie(){
    IntStream.rangeClosed(1, 1).forEach(new IntConsumer() {
     @Override
     public void accept(int i) {
      MyOwnRecipePost mor = MyOwnRecipePost.builder()
                      .title("샐러드" + i)
                      // .category(2)
                      .detail("양상추:1 샐러리:1 계란:1 플레이크:1 렌치소스:1 콩:1 파프리카:1 양배추:1 방울토마토:2")
                     
                      
                      .build();
      System.out.println(mpRepository.save(mor));

     } 
    });
  }
}
