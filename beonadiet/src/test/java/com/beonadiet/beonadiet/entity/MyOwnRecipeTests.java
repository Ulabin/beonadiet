package com.beonadiet.beonadiet.entity;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.beonadiet.beonadiet.entity.recipe.MyOwnRecipe;
import com.beonadiet.beonadiet.repository.recipe.MyOwnRecipeRepository;

@SpringBootTest
public class MyOwnRecipeTests {
  @Autowired
  MyOwnRecipeRepository mRepository;
  
  @Test
  public void insertDummies(){
    IntStream.rangeClosed(1, 10).forEach(new IntConsumer() {
     @Override
     public void accept(int i) {
      MyOwnRecipe mor = MyOwnRecipe.builder()
                      .name("Title..." + i)
                      .category((int)(Math.random()*10)/4)
                      .detail("detail")
                      .calorie((int)(Math.random()*10)*167)
                      .build();
      System.out.println(mRepository.save(mor));

     } 
    });
  }

  @Test
  public void insertDummie(){
    IntStream.rangeClosed(1, 1).forEach(new IntConsumer() {
     @Override
     public void accept(int i) {
      MyOwnRecipe mor = MyOwnRecipe.builder()
                      .name("샐러드" + i)
                      .category(2)
                      .detail(" 닭다리살 : 1.5,  계란 : 1,  양상추 : 1,  올리브 : 1,  할라피뇨 : 1,  방울토마토 : 2,  양파 : 1,  루꼴라 : 1,  라디치오 : 1,  케일 : 1,  렌치소스")
                      .calorie((int)(Math.random()*10)*167)
                      .build();
      System.out.println(mRepository.save(mor));

     } 
    });
  }

  // @Test
  // public void insertDummie(){
  //   IntStream.rangeClosed(1, 1).forEach(new IntConsumer() {
  //    @Override
  //    public void accept(int i) {
  //     MyOwnRecipe mor = MyOwnRecipe.builder()
  //                     .name("샌드위치" + i)
  //                     .category(1)
  //                     .detail("빵:1 케찹:1 마요네즈:1 토마토:1.5 양상추:2 오이:1 햄:3 베이컨:1 올리브:1 피클:1 ")
  //                     .calorie((int)(Math.random()*10)*167)
  //                     .build();
  //     System.out.println(mRepository.save(mor));

  //    } 
  //   });
  // }
}

//  @Override
//  public void accept(int i) {
//   MyOwnRecipe mor = MyOwnRecipe.builder()
//                   .name("Title..." + i)
//                   .explanation("Content" + i)
//                   .views(1)
//                   .likeCount((int)(Math.random()*10)*(int)(Math.random()*10))
//                   .category((int)(Math.random()*10)/4)
//                   .detail("detail")
//                   .build();
//   System.out.println(mRepository.save(mor));

//  } 